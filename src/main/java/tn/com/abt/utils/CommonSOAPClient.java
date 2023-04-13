package tn.com.abt.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

/**
 * 
 * @author AMMAR.MAHER
 * @version 1.0
 */
public class CommonSOAPClient {

	public static String getUrlProtocol(String url) {
		String result = "";
		int i = 0;
		if (url != null && url.length() > 0) {
			while (i < url.length() && url.charAt(i) != 58) {
				result = result + url.charAt(i);
				i++;
			}
			result = result.toLowerCase();
		}
		return result;
	}

	public static SOAPMessage invokeAction(SOAPConnection soapConnection, String securityProtocol, String namespacePrefix, String url,
			String serverURI, String operationName, Map<String, String> bindVars) throws SOAPException,
			KeyManagementException, NoSuchAlgorithmException, IOException {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(namespacePrefix, serverURI);
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");

		soapMessage = createClientLoginRequest(soapMessage, namespacePrefix, bindVars, serverURI, operationName);

		String protocol = getUrlProtocol(url);
		if (protocol.equals("https")) {
			doTrustToCertificates(securityProtocol);
		}

		soapMessage.saveChanges();

		return soapConnection.call(soapMessage, url);
	}

	public static SOAPMessage createClientLoginRequest(SOAPMessage soapMessage, String namespacePrefix,
			Map<String, String> bindVars, String serverURI, String operationName) throws SOAPException,
			KeyManagementException, NoSuchAlgorithmException, IOException {
		SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement(operationName, namespacePrefix);

		SOAPElement soapElem = null;
		for (Map.Entry<String, String> entry : bindVars.entrySet()) {
			soapElem = soapBodyElem.addChildElement(entry.getKey());
			soapElem.addTextNode(entry.getValue());
		}

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + operationName);
		headers.addHeader("Content-Type", "text/xml");
		return soapMessage;
	}

	public static String getAuthToken(SOAPMessage soapResponse)
			throws SOAPException, TransformerException {
		printResponse(soapResponse);
		return soapResponse.getSOAPPart().getChildNodes().item(0).getTextContent();
	}

	public static void printResponse(SOAPMessage soapResponse)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, SOAPException,
			TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(baos);
		StreamResult result = new StreamResult(bos);
		transformer.transform(sourceContent, result);
		System.out.println("\nResponse SOAP Message = " + new String(baos.toByteArray()));
	}

	public static void doTrustToCertificates(String securityProtocol) throws NoSuchAlgorithmException,
			KeyManagementException {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) throws CertificateException {
				return;
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) throws CertificateException {
				return;
			}
		} };

		SSLContext sc = SSLContext.getInstance(securityProtocol);
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
					return false;
				}
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

}
