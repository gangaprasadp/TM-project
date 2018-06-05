package com.tm;

import java.io.File;

public class DeleteFile {

	public static void deleteFilefromDirectory(String fileName) {
		try {

			File file = new File(fileName);

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
