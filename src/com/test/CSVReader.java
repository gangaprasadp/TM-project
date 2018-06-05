package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	private static String csvFile = "D:/TMDirectory/";


	public static void readTask(String fileName) {
//		String csvFile = "D:/TMDirectory/task.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile+fileName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] task = line.split(cvsSplitBy);

                System.out.println("Task [TASK_ID= " + task[0] + " , SKILL=" + task[1] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public static void readTeamSkill(String fileName) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile+fileName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] teamSkill = line.split(cvsSplitBy);

                System.out.println("TeamSkill [TEAM_ID= " + teamSkill[0] + " , SKILL=" + teamSkill[1] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public static void readTeam(String fileName) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile+fileName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] team = line.split(cvsSplitBy);

                System.out.println("Task [TEAM_ID= " + team[0] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

}
