package model;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Activator {

	public static boolean activate(String key) throws IOException {

		URL url = new URL("http://beta.anglictina-vyukovy-program.cz/api/licence/?key=" + key);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCode = http.getResponseCode();

		if (statusCode == 202) {
			File licenceDir = new File(getLicenceDirPath());
			if (!licenceDir.isDirectory()) {
				licenceDir.mkdir();
				hideFile(licenceDir);
			}
			File licenceFile = new File(getLicenceFilePath());
			if (!licenceFile.isFile()) {
				licenceFile.createNewFile();
				hideFile(licenceFile);
			}
			http.disconnect();
			return true;
		}
		http.disconnect();
		return false;
	}

	public static boolean isActivated() {

		File file = new File(getLicenceFilePath());
		return (file.isFile() && !file.isDirectory());
	}

	public static String getLicenceDirPath() {

		return AppDataHelper.defaultDirectory() + File.separator + "SoftwareData";
	}

	public static String getLicenceFilePath() {

		return getLicenceDirPath() + File.separator + ".licence.txt";
	}

	public static void hideFile(File src) {
		// win32 command line variant
		String OS = System.getProperty("os.name").toUpperCase();
		if (OS.contains("WIN")) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("attrib +h " + src.getPath());
				p.waitFor(); // p.waitFor() important, so that the file really appears as hidden immediately after function exit.
			} catch (IOException ex) {
				Logger.getLogger(Activator.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InterruptedException ex) {
				Logger.getLogger(Activator.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
