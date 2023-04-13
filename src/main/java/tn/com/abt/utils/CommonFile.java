package tn.com.abt.utils;

/**
 * <p>Titre : Client Web</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2017</p>
 * @author Ammar Meher
 * @version 1.0
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class CommonFile {

	public static File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	public static String createFilePath(String filePath) throws Exception {
		String fileDestination = "";
		for (int i = 0; i < filePath.length(); i++) {
			if (filePath.charAt(i) == 92) {
				fileDestination = fileDestination + "\\\\";
			} else {
				fileDestination = fileDestination + filePath.charAt(i);
			}
		}
		File fileDirectory = new File(fileDestination);
		// if the directory does not exist, create it
		if (!fileDirectory.exists()) {
			fileDirectory.mkdir();
		}
		return fileDestination;
	}

	public static void copyFile(String filePath, String fileName, InputStream src) throws Exception {
		File file = new File(filePath + "\\" + fileName);
		BufferedInputStream in = new BufferedInputStream(src);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		byte[] read = new byte[4096];
		int len = 128;
		while ((len = in.read(read)) > 0) {
			out.write(read, 0, len);
		}
		out.flush();
		out.close();
		in.close();
	}

	public static void copyFile(File file, InputStream src) throws Exception {
		BufferedInputStream in = new BufferedInputStream(src);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		byte[] read = new byte[4096];
		int len = 128;
		while ((len = in.read(read)) > 0) {
			out.write(read, 0, len);
		}
		out.flush();
		out.close();
		in.close();
	}

	public static boolean isFileCopied(String filePath, String fileName) throws Exception {
		@SuppressWarnings({ "unused", "resource" })
		InputStream is = new FileInputStream(filePath + "" + fileName);
		return true;
	}

	public static void deleteFile(String filePath, String fileName) throws Exception {
		File file = new File(filePath + "" + fileName);
		file.delete();
	}

	public static String getDocumentNameFromFileName(String fileName) throws Exception {
		String documentName = "";
		int i = fileName.length() - 1;
		while (fileName.charAt(i) != '.') {
			i--;
		}
		for (int j = 0; j < i; j++) {
			documentName = documentName + fileName.charAt(j);
		}
		return documentName;
	}

	public static String getFileExtensionFromFileName(String fileName) throws Exception {
		String extension = "";
		int i = fileName.length() - 1;
		while (fileName.charAt(i) != '.') {
			extension = fileName.charAt(i) + extension;
			i--;
		}
		return extension;
	}

	public static void downloadDesktopFileByFilePath(String contentType, String filePath, String fileName) throws Exception {

	}

	public static void downloadDesktopFileByInputStream(String contentType, String fileName, InputStream is) throws Exception {

	}

	public static void main(String[] args) throws Exception {
		System.out.println(CommonFile.getDocumentNameFromFileName("5._PK_Expressions_utiles.pdf"));
	}

}
