package utils;

import java.io.File;

public class ProjectUtils {

	/*Get latest downloaded file from downlod location  */
	
	public static File getLatestFilefromDir(String downloadPath) {
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	/* Validate with recently downloaded file name */
	
	public static boolean verifyDownloadedFileName(String downloadPath, String fileName) {
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String FileName = getLatestFile.getName();
		if (FileName.contains(fileName)) {
			return true;
		}
		return false;
	}
}
