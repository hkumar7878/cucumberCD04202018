package com.cucumber.framework.utility;

import java.util.List;

public class ApplicationLib {
	
	public static boolean campareStringLists(List<String> expListValues,List<String> actListValues)
	{
		boolean flag=false;
		try
		{
			if(expListValues.size()!=actListValues.size())
				return flag;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
	
	
	

}
