package com.tm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import au.com.bytecode.opencsv.CSVReader;

public class CsvToOracle {

	public static void insertIntoTask(String inputCSVFile)
			throws ClassNotFoundException, SQLException, FileNotFoundException,
			IOException {
		/* Create Connection objects */
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", "postgres",
				"password");
		PreparedStatement sql_statement = null;
		/* Create the insert statement */
		String jdbc_insert_sql = "INSERT INTO TASK" + "(TASK_ID, SKILL) VALUES"
				+ "(?,?)";
		sql_statement = conn.prepareStatement(jdbc_insert_sql);
		/* Read CSV file in OpenCSV */
		// String inputCSVFile = "D:/csv_files/task.csv";
		CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
		/* Variables to loop through the CSV File */
		String[] nextLine; /* for every line in the file */
		int lnNum = 0; /* line number */
		while ((nextLine = reader.readNext()) != null) {
			lnNum++;
			/* Bind CSV file input to table columns */
			sql_statement.setString(1, nextLine[0]);
			/* Bind Age as double */
			/* Need to convert string to double here */
			sql_statement.setString(2, nextLine[1]);
			/* execute the insert statement */
			sql_statement.executeUpdate();
		}
		/* Close prepared statement */
		sql_statement.close();
		/* COMMIT transaction */
		// conn.commit();
		/* Close connection */
		conn.close();
	}

	public static void insertIntoTeamSkill(String inputCSVFile)
			throws ClassNotFoundException, SQLException, FileNotFoundException,
			IOException {
		/* Create Connection objects */
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", "postgres",
				"password");
		PreparedStatement sql_statement = null;
		/* Create the insert statement */
		String jdbc_insert_sql = "INSERT INTO TEAM_SKILL" + "(TEAM_ID, SKILL) VALUES"
				+ "(?,?)";
		sql_statement = conn.prepareStatement(jdbc_insert_sql);
		/* Read CSV file in OpenCSV */
//		String inputCSVFile = "D:/csv_files/task.csv";
		CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
		/* Variables to loop through the CSV File */
		String[] nextLine; /* for every line in the file */
		int lnNum = 0; /* line number */
		while ((nextLine = reader.readNext()) != null) {
			lnNum++;
			/* Bind CSV file input to table columns */
			sql_statement.setString(1, nextLine[0]);
			/* Bind Age as double */
			/* Need to convert string to double here */
			sql_statement.setString(2, nextLine[1]);
			/* execute the insert statement */
			sql_statement.executeUpdate();
		}
		/* Close prepared statement */
		sql_statement.close();
		/* COMMIT transaction */
		// conn.commit();
		/* Close connection */
		conn.close();
	}

	public static void insertIntoTeam(String inputCSVFile)
			throws ClassNotFoundException, SQLException, FileNotFoundException,
			IOException {
		/* Create Connection objects */
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", "postgres",
				"password");
		PreparedStatement sql_statement = null;
		/* Create the insert statement */
		String jdbc_insert_sql = "INSERT INTO TEAM" + "(TEAM_ID) VALUES"
				+ "(?)";
		sql_statement = conn.prepareStatement(jdbc_insert_sql);
		/* Read CSV file in OpenCSV */
		// String inputCSVFile = "D:/csv_files/task.csv";
		CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
		/* Variables to loop through the CSV File */
		String[] nextLine; /* for every line in the file */
		int lnNum = 0; /* line number */
		while ((nextLine = reader.readNext()) != null) {
			lnNum++;
			/* Bind CSV file input to table columns */
			sql_statement.setString(1, nextLine[0]);
			/* Bind Age as double */
			/* Need to convert string to double here */
//			sql_statement.setString(2, nextLine[1]);
			/* execute the insert statement */
			sql_statement.executeUpdate();
		}
		/* Close prepared statement */
		sql_statement.close();
		/* COMMIT transaction */
		// conn.commit();
		/* Close connection */
		conn.close();
	}
}
