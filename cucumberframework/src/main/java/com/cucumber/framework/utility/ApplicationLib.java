package com.cucumber.framework.utility;

import java.util.List;

import org.testng.Assert;

public class ApplicationLib {
	
	public static boolean campareStringLists(List<String> expListValues,List<String> actListValues)
	{
		boolean flag=false;
		List<String> resultList = null;
		try
		{
			if(expListValues.size()!=actListValues.size())
				return flag;
			
			for(int i=0;i<expListValues.size();i++)
			{
				if(!(expListValues.get(i).trim().equals((actListValues).get(i).trim())))
						{
							resultList.add(expListValues.get(i));
						}
				else
					flag=true;
			}
		}
		
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
	
	public static boolean verifyHeader(String actTxt,String expTxt)
	{
		boolean flag=false;
		try
		{
			if(actTxt.toLowerCase().contains(expTxt.toLowerCase()))
			return true;
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
	

}
