/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Jan
 */
public class EnglishOpener {

	public static void open(Class clazz, String fileName) {

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = clazz.getClassLoader().getResourceAsStream("resources/files/" + fileName);
			
			File tempFile = File.createTempFile("english_temp", getFileExtension(fileName));
			tempFile.deleteOnExit();
			outputStream = new FileOutputStream(tempFile);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			System.out.println(tempFile.getAbsolutePath());
			System.out.println("Done!");
			launch(tempFile);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	
	private static void launch(File file){
		
		if (!Desktop.isDesktopSupported()) {
			System.err.println("Desktop not supported");
			openFileUsingRuntime(file.getAbsolutePath());
			return;
		}

		Desktop desktop = Desktop.getDesktop();
		if (!desktop.isSupported(Desktop.Action.OPEN)) {
			System.err.println("OPEN not supported");
			openFileUsingRuntime(file.getAbsolutePath());
			return;
		}

		try {
			desktop.open(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	private static void openFileUsingRuntime(String path) {

		try {
			Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	public static String getFileExtension(String name) {
		
		int lastIndexOf = name.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return ""; // empty extension
		}
		return name.substring(lastIndexOf);
	}
}
