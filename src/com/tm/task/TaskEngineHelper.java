package com.tm.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskEngineHelper {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "password";
	
	static Connection conn = null;
	static Statement stmt = null;
	
	public static Map<String, ArrayList<String>> teamSkillMap() {
		Map<String, ArrayList<String>> teamSkillMap = new HashMap<String, ArrayList<String>>();
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String teamSkill = "select team.team_id,skill.skill from Team team "
					+ "left join team_skill skill on skill.team_id = team.team_id order by team_id";
			ResultSet rs = stmt.executeQuery(teamSkill);

			ArrayList<String> arraylist = null;

			while (rs.next()) {

				if (teamSkillMap.containsKey(rs.getString(1))) {
					arraylist = teamSkillMap.get(rs.getString(1));
					arraylist.add(rs.getString(2));
				} else {
					arraylist = new ArrayList<String>();
					arraylist.add(rs.getString(2));
					teamSkillMap.put(rs.getString(1), arraylist);

				}

				System.out.println("team_id :" + rs.getString(1) + " skill :"
						+ rs.getString(2));

			}

			System.out.println("TeamSkillMap :" + teamSkillMap.values());


		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return teamSkillMap;
		
	}
	
	public static  Map<String, ArrayList<String>> taskSkillMap() {
		
		Map<String, ArrayList<String>> taskSkillMap = new HashMap<String, ArrayList<String>>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String taskSkill = "select task.task_id,task.skill from Task task ";
			ResultSet rs = stmt.executeQuery(taskSkill);

			
			ArrayList<String> taskArraylist = null;

			while (rs.next()) {

				if (taskSkillMap.containsKey(rs.getString(1))) {
					taskArraylist = taskSkillMap.get(rs.getString(1));
					taskArraylist.add(rs.getString(2));
				} else {
					taskArraylist = new ArrayList<String>();
					taskArraylist.add(rs.getString(2));
					taskSkillMap.put(rs.getString(1), taskArraylist);

				}

				System.out.println("task_id :" + rs.getString(1) + " skill :"
						+ rs.getString(2));

			}

			System.out.println("TaskSkillMap :" + taskSkillMap.values());

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return taskSkillMap;
	
		
	}
	
	public static int getTotalTaskCount(){
		
		int totalTaskCount = 0;
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String taskSkill = "select count(*) from Task";
			ResultSet rs = stmt.executeQuery(taskSkill);

			while (rs.next()) {

				System.out.println("totalTaskCount :" + rs.getString(1));
				
				totalTaskCount = rs.getInt(1);

			}


		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		 return totalTaskCount;
	}
	
	public static int getTotalTeamCount(){
		int totalTeamCount = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String taskSkill = "select count(*) from Team";
			ResultSet rs = stmt.executeQuery(taskSkill);

			while (rs.next()) {

				System.out.println("totalTeamCount :" + rs.getString(1));
				totalTeamCount = rs.getInt(1);

			}


		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		 return totalTeamCount;
	}
	
	

	/*
	 * public static void mapTaskToTeam() { Connection conn = null; Statement
	 * stmt = null; try { Class.forName(JDBC_DRIVER);
	 * 
	 * conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 * 
	 * stmt = conn.createStatement();
	 * 
	 * String teamSkill = "select team.team_id,skill.skill from Team team " +
	 * "left join team_skill skill on skill.team_id = team.team_id order by team_id"
	 * ; ResultSet rs = stmt.executeQuery(teamSkill);
	 * 
	 * Map<String, ArrayList<String>> teamSkillMap = new HashMap<String,
	 * ArrayList<String>>(); ArrayList<String> arraylist = null;
	 * 
	 * while (rs.next()) {
	 * 
	 * if (teamSkillMap.containsKey(rs.getString(1))) { arraylist =
	 * teamSkillMap.get(rs.getString(1)); arraylist.add(rs.getString(2)); } else
	 * { arraylist = new ArrayList<String>(); arraylist.add(rs.getString(2));
	 * teamSkillMap.put(rs.getString(1), arraylist);
	 * 
	 * }
	 * 
	 * System.out.println("team_id :" + rs.getString(1) + " skill :" +
	 * rs.getString(2));
	 * 
	 * }
	 * 
	 * System.out.println("TeamSkillMap :" + teamSkillMap.values());
	 * 
	 * String taskSkill = "select task.task_id,task.skill from Task task "; rs =
	 * stmt.executeQuery(taskSkill);
	 * 
	 * Map<String, ArrayList<String>> taskSkillMap = new HashMap<String,
	 * ArrayList<String>>(); ArrayList<String> taskArraylist = null;
	 * 
	 * while (rs.next()) {
	 * 
	 * if (taskSkillMap.containsKey(rs.getString(1))) { taskArraylist =
	 * taskSkillMap.get(rs.getString(1)); taskArraylist.add(rs.getString(2)); }
	 * else { taskArraylist = new ArrayList<String>();
	 * taskArraylist.add(rs.getString(2)); taskSkillMap.put(rs.getString(1),
	 * taskArraylist);
	 * 
	 * }
	 * 
	 * System.out.println("task_id :" + rs.getString(1) + " skill :" +
	 * rs.getString(2));
	 * 
	 * }
	 * 
	 * System.out.println("TaskSkillMap :" + taskSkillMap.values());
	 * 
	 * } catch (SQLException se) { se.printStackTrace(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { try { if (stmt != null) conn.close(); }
	 * catch (SQLException se) { } try { if (conn != null) conn.close(); } catch
	 * (SQLException se) { se.printStackTrace(); } }
	 * System.out.println("Goodbye!"); }
	 */
}
