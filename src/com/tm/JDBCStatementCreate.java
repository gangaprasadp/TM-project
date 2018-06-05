package com.tm;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementCreate {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/postgres";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "password";

	public static void main(String[] argv) {

		try {

			createDbUserTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void createDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String createTaskTableSQL = "CREATE TABLE TASK("
				+ "TASK_ID VARCHAR(20) NOT NULL, "
				+ "SKILL VARCHAR(20) "
				+ ")";
		
//		String createTeamTableSQL = "CREATE TABLE TEAM("
//				+ "TEAM_ID VARCHAR(20) NOT NULL, "+ "PRIMARY KEY (TEAM_ID) "
//				+ ")";
		String createTeamSkillTableSQL = "CREATE TABLE TEAM_SKILL("
				+ "TEAM_ID VARCHAR(20) NOT NULL, "
				+ "SKILL VARCHAR(20) "
				+ ")";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			statement.execute(createTaskTableSQL);
			
//			statement.execute(createTeamTableSQL);
//			
//			statement.execute(createTeamSkillTableSQL);

			System.out.println("Tables created!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
					DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}
