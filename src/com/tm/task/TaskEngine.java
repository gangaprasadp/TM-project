package com.tm.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskEngine {

	public static void assignTeamTaskfairly() {
		Map<String, ArrayList<String>> taskMap = TaskEngineHelper.teamSkillMap();
		
		Map<String, ArrayList<String>> skillMap = TaskEngineHelper.taskSkillMap();
		
		
		Map<String, ArrayList<String>> teamTaskMap = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> arraylist = new ArrayList<String>();
		
				for (Map.Entry<String, ArrayList<String>> teamEntry : taskMap.entrySet())
				{
					
					for (Map.Entry<String, ArrayList<String>> skillEntry : skillMap.entrySet()){
						
						for(String str :skillEntry.getValue()){
							
						if(teamEntry.getValue().contains(str)){
								arraylist = teamTaskMap.get(teamEntry.getKey());
								arraylist.add(teamEntry.getKey());
							}else{
								arraylist = new ArrayList<String>();
								arraylist.add(str);
								teamTaskMap.put(teamEntry.getKey(), arraylist);
						}
						}
					}
					
				}
				
				System.out.println(teamTaskMap.size());
	}

}
