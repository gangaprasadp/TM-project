package com.tm;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.SQLException;

import com.tm.task.TaskEngine;

public class MonitorDirectory {

	private static String csvFile = "D:/TMDirectory/";
	public static void main(String[] args) throws IOException,
			InterruptedException {

		Path faxFolder = Paths.get("D:/TMDirectory");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

		boolean valid = true;
		do {
			WatchKey watchKey = watchService.take();

			for (WatchEvent event : watchKey.pollEvents()) {
				WatchEvent.Kind kind = event.kind();
				if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					String fileName = event.context().toString();
					System.out.println("File Created:" + fileName);
					if(fileName.equals("task.csv")){
						try {
							CsvToOracle.insertIntoTask(csvFile+fileName);
							// Delete file after process
							DeleteFile.deleteFilefromDirectory(csvFile+fileName);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}else if(fileName.equals("team.csv")){
						try {
							CsvToOracle.insertIntoTeam(csvFile+fileName);
							// Delete file after process
							DeleteFile.deleteFilefromDirectory(csvFile+fileName);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}else if(fileName.equals("team_skill.csv")){
						try {
							CsvToOracle.insertIntoTeamSkill(csvFile+fileName);
							// Delete file after process
							DeleteFile.deleteFilefromDirectory(csvFile+fileName);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
				}
				
				// assigning task to team
				TaskEngine.assignTeamTaskfairly();
				
			}
			valid = watchKey.reset();

		} while (valid);

	}
}
