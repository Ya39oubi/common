package tn.com.abt.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import tn.com.abt.smw.enumeration.MsgHeaderEnum;

/**
 * 
 * @author AMMAR.MAHER
 *
 */
public class CommonSharePointDocument {

	// 0000 : File is copied (new file created or overwritten)
	// Other : Problem while copying file
	public static String putDocument(String serverAddress, Integer port, String domain, String userName, String password, String filePath,
			String fileName, File inputFile) {
		String result = null;
		try {
			CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(userName, password, "", domain));

			HttpHost target = new HttpHost(serverAddress, port, "http");
			HttpClientContext context = HttpClientContext.create();
			context.setCredentialsProvider(credsProvider);

			HttpPut request = new HttpPut(filePath + fileName); // target
			request.setEntity(new FileEntity(inputFile)); // source

			CloseableHttpResponse response = null;

			try {
				response = httpClient.execute(target, request, context);
				EntityUtils.consume(response.getEntity());
				int rc = response.getStatusLine().getStatusCode();
				String reason = response.getStatusLine().getReasonPhrase();

				if (rc == HttpStatus.SC_CREATED || rc == HttpStatus.SC_OK) {
					result = MsgHeaderEnum.MSG_0000.getId();
				} else {
					result = "SharePoint connexion : " + rc + " - " + reason;
				}

			} finally {
				if (response != null) {
					response.close();
				}
			}

		} catch (Exception e) {
			result = "SharePoint connexion : " + e.getMessage() + "";
		}

		return result;
	}

	// null : Problem while getting file
	// Other : OK, getting file
	public static byte[] getDocument(String serverAddress, Integer port, String domain, String userName, String password,
			String filePath,
			String fileName) {
		byte[] result = null;
		try {
			CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(userName, password, "", domain));

			HttpHost target = new HttpHost(serverAddress, port, "http");
			HttpClientContext context = HttpClientContext.create();
			context.setCredentialsProvider(credsProvider);

			String path = "http://" + serverAddress + ":" + port + filePath + fileName; // source
			HttpGet request = new HttpGet(path);
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(target, request, context);
				HttpEntity entity = response.getEntity();
				int rc = response.getStatusLine().getStatusCode();
				if (rc == HttpStatus.SC_OK) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len;
					while ((len = entity.getContent().read(buffer)) > -1) {
						baos.write(buffer, 0, len);
					}
					baos.flush();
					result = baos.toByteArray();
				} else {
					result = null;
				}
			} finally {
				if (response != null) {
					response.close();
				}
			}

		} catch (Exception e) {
			result = null;
		}

		return result;
	}

	// null : Problem while getting file
	// Other : OK, getting file
	public static InputStream getDocumentAsInputStream(String serverAddress, Integer port, String domain, String userName, String password,
			String filePath,
			String fileName) {
		InputStream result = null;
		try {
			CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(userName, password, "", domain));

			HttpHost target = new HttpHost(serverAddress, port, "http");
			HttpClientContext context = HttpClientContext.create();
			context.setCredentialsProvider(credsProvider);

			String path = "http://" + serverAddress + ":" + port + filePath + fileName; // source
			HttpGet request = new HttpGet(path);
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(target, request, context);
				HttpEntity entity = response.getEntity();
				int rc = response.getStatusLine().getStatusCode();
				if (rc == HttpStatus.SC_OK) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len;
					while ((len = entity.getContent().read(buffer)) > -1) {
						baos.write(buffer, 0, len);
					}
					baos.flush();
					result = new ByteArrayInputStream(baos.toByteArray());
				} else {
					result = null;
				}
			} finally {
				if (response != null) {
					response.close();
				}
			}

		} catch (Exception e) {
			result = null;
		}

		return result;
	}

	// 0000 : File is copied (new file created)
	// Other : Problem while copying file
	public static String deleteDocument(String serverAddress, Integer port, String domain, String userName, String password,
			String filePath,
			String fileName) {
		String result = "0000";
		try {
			CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(userName, password, "", domain));

			HttpHost target = new HttpHost(serverAddress, port, "http");
			HttpClientContext context = HttpClientContext.create();
			context.setCredentialsProvider(credsProvider);

			String path = filePath + fileName;
			HttpDelete request2 = new HttpDelete(path); // target
			CloseableHttpResponse resp = httpClient.execute(target, request2, context);
			resp.close();

		} catch (Exception e) {
			e.printStackTrace();
			result = "SharePoint connexion : " + e.getMessage() + "";
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {

		File inputFile = new File("D:/partage/document-transfert-cpt.pdf");

		// URL Plateforme 2007 : OK
		String result = "";
		String srvUrl = "web-editique";
		String pathUrl = "/sites/G1/9000/Documents/ABTProcess_Docs_Recette/RECLAMATIONS_MONETIQUES/";

		// URL Plateforme 2019 : OK
		srvUrl = "srv-p-spapp01";
		pathUrl = "/sites/G1/9000/Documents%20partages/ABT_Process_Docs_Recette/RECLAMATIONS_MONETIQUES/";

		result = CommonSharePointDocument.putDocument(srvUrl, 80, "bank-sud.tn", "PortailABT", "Portail**ABT", pathUrl,
				"006001000000006429012018092619.pdf", inputFile);

		/*
		 * result = CommonSharePointDocument.deleteDocument(srvUrl, 80, "bank-sud.tn", "PortailABT", "Portail**ABT", pathUrl,
		 * "006001000000006429012018092617.pdf");
		 */

		/*
		 * byte[] fileByte = CommonSharePointDocument.getDocument(srvUrl, 80, "bank-sud.tn", "PortailABT", "Portail**ABT", pathUrl,
		 * "006001000000006429012018092617.pdf");
		 * System.out.println(fileByte.length);
		 */

		System.out.println(result);
		System.out.println(inputFile.getName());
	}

}
