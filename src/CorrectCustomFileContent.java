import java.util.*;
import java.io.*;

public interface CorrectCustomFileContent
{
	static void start(int fileType, int overWriteType) throws IOException
	{
		ArrayList<String> allLines = new ArrayList<String>();
		
		String
			filePath ,
			fullFile;
		
		if(fileType == 0)
		{
			filePath = getFilePathForSavedCustomers();
		}
		
		else if(fileType == 1)
		{
			filePath = getFilePathForVisits();
		}
		
		else
		{
			filePath = "";
		}
		
		
		fullFile = ReadFromAnyFile.readFileString(filePath);
		allLines = removeBlankLines(fullFile);
		fullFile = AdaptFileFormatForCustomers.arrayListToString(allLines);
		allLines = AdaptFileFormatForCustomers.readFromFile(fullFile);
		allLines = removeDuplicateLines(allLines, overWriteType);
		fullFile = AdaptFileFormatForCustomers.arrayListToString(allLines);
		fullFile = AdaptFileFormatForCustomers.writeToFile(fullFile);
		WriteToCustomFile.writeToFile(filePath, fullFile, false);
		
	}
	
	
	
	static String getFilePathForSavedCustomers() throws IOException
	{
		String
			filePath;
		
		filePath = UserOptionsClass.getCustomFileToWrite();
		
		return filePath;
		
	}
	
	
	
	static String getFilePathForVisits() throws IOException
	{
		String
			filePath;
		
		filePath = UserOptionsClass.getCustomUserVisitsFileToWrite();
		
		return filePath;
		
	}
	
	
	
	static ArrayList<String> removeBlankLines(String fullFile)
	{
		ArrayList<String> allLines = new ArrayList<String>();
		
		String
			lineBeingChecked;
		
		int
			clip ,
			counts;
		
		
		
		long[]
		OVERLOADCHECKER1;
		
		int
		OVERLOADCHECKER2;
		
		
		
		counts = 0;
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		while(true)
		{
			clip = fullFile.indexOf("\n");
			
			if(clip != -1)
			{
				lineBeingChecked = fullFile.substring(0 , clip);
				
				
				try
				{
					fullFile = fullFile.substring(clip + 1);
					
				}
				
				catch(StringIndexOutOfBoundsException e)
				{
					break;
					
				}
				
			}
			
			else
			{
				break;
				
			}
			
			
			if(lineBeingChecked.equals("") || lineBeingChecked.equals("\n"))
			{}
			
			else
			{
				allLines.add(counts, lineBeingChecked);
				++counts;
				
			}
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		return allLines;
		
	}
	
	
	
	static ArrayList<String> removeDuplicateLines(ArrayList<String> fullList, int type)
	{
		ArrayList<String> allLines = new ArrayList<String>();
		
		String
			listBeingCheckedNew1_1 ,
			listBeingCheckedNew1_2 ,
			listBeingCheckedNew2_1 ,
			listBeingCheckedNew2_2 ,
			listBeingCheckedOld1_1 ,
			listBeingCheckedOld1_2 ,
			listBeingCheckedOld2_1 ,
			listBeingCheckedOld2_2;
		
		int
			countsLaps ,
			countsIndex ,
			clip1 ,
			clip2;
		
		boolean
			duplicate;
		
		long[]
			OVERLOADCHECKER1 ,
			OVERLOADCHECKER3;
		
		int
			OVERLOADCHECKER2 ,
			OVERLOADCHECKER4;
		
		
		countsLaps = 0;
		countsIndex = 0;
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(String line : fullList)
		{
			duplicate = false;
			
			
			listBeingCheckedNew1_1 = fullList.get(countsLaps);
			clip1 = listBeingCheckedNew1_1.indexOf("_");
			
			try
			{
				listBeingCheckedNew1_2 = listBeingCheckedNew1_1.substring(0 , clip1);
			}
			
			catch(StringIndexOutOfBoundsException e)
			{
				break;
			}
			
			
			listBeingCheckedNew2_1 = fullList.get(countsLaps);
			clip2 = listBeingCheckedNew2_1.lastIndexOf("_");
			
			try
			{
				listBeingCheckedNew2_2 = listBeingCheckedNew2_1.substring(clip1 + 1 , clip2);
			}
			
			catch(StringIndexOutOfBoundsException e)
			{
				break;
			}
			
			
			OVERLOADCHECKER3 = new long[1000000];
			OVERLOADCHECKER4 = 1;
			for(int i = 0; i < countsLaps; i++)
			{
				listBeingCheckedOld1_1 = allLines.get(i);
				clip1 = listBeingCheckedOld1_1.indexOf("_");
				listBeingCheckedOld1_2 = listBeingCheckedOld1_1.substring(0, clip1);
				
				listBeingCheckedOld2_1 = allLines.get(i);
				clip2 = listBeingCheckedOld2_1.lastIndexOf("_");
				listBeingCheckedOld2_2 = listBeingCheckedOld2_1.substring(clip1 + 1, clip2);
				
				
				if(type == 0)
				{
					if(listBeingCheckedNew1_2.equals(listBeingCheckedOld1_2))
					{
						duplicate = true;
						break;
						
					}
					
					else if(listBeingCheckedNew2_2.equals(listBeingCheckedOld2_2))
					{
						duplicate = true;
						break;
						
					}
					
				}
				
				else
				{
					if(listBeingCheckedNew1_1.equals(listBeingCheckedOld2_1))
					{
						duplicate = true;
						break;
					}
					
				}
				
				
				OVERLOADCHECKER3[OVERLOADCHECKER4] = OVERLOADCHECKER4;
				OVERLOADCHECKER4 = OVERLOADCHECKER4 +1;
			}
			
			
			if(!duplicate)
			{
				allLines.add(countsIndex, fullList.get(countsLaps));
				++countsIndex;
				
			}
			
			++countsLaps;
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		return allLines;
		
	}
	
}