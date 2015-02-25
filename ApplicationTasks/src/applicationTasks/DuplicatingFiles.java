package applicationTasks;

import java.io.File;

public class DuplicatingFiles {

	public static void main(String[] args) {
		final File folder = new File("D:/work/HackBulgaria/workspace/ApplicationTasks/src");
		if (folder.exists()) {
			listFilesForFolder(folder);
		}

	}

	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

	
}
