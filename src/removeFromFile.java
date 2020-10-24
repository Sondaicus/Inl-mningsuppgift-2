import java.io.*;
import java.util.*;

public interface removeFromFile
{
	static ArrayList<String> start(int optionType, String inputData) throws IOException
	{
		ArrayList<String> fullFileAL = new ArrayList <String>();
		ArrayList<String> userInformation = new ArrayList <String>(2);
		
		String
			filePath;
		
		
		filePath = getFilePath();
		fullFileAL = readFromFile(filePath);
		userInformation = breakUpAndReassembleFile(fullFileAL, inputData, optionType);
		
		
		return userInformation;

	}
	
	
	
	static String getFilePath()
	{
		String filePath = UserOptionsClass.getCustomFileToWrite();
		
		return filePath;
		
	}
	
	
	
	static ArrayList<String> readFromFile(String filePath) throws IOException
	{
		String fullFile = ReadFromAnyFile.readFileString(filePath);
		
		ArrayList<String> fullFileAdaptedFormat = new ArrayList <String>();
		fullFileAdaptedFormat = AdaptFileFormatForCustomers.readFromFile(fullFile);
		
		return fullFileAdaptedFormat;
		
	}
	
	
	
	static ArrayList<String> breakUpAndReassembleFile(ArrayList<String> fullFile, String inputData, int parameter)
	{
		ArrayList<String> userInformation = new ArrayList <String>(2);
		
		String
			fileSection1 ,
			fileSection2,
			combinedFileSections ,
			userFileSection;

		
		fileSection1 = fileSection1(fullFile, inputData, parameter);
		fileSection2 = fileSection2(fullFile, inputData, parameter);
		userFileSection = fileCustomerSection(fullFile, inputData, parameter);
		
		
		combinedFileSections = fileSection1 + fileSection2;
		
		
		userInformation.add(0, combinedFileSections);
		userInformation.add(1, userFileSection);
		userInformation = lastNewLineCorrection(userInformation);
		
		return userInformation;
		
	}
		
	
	
	static String fileSection1(ArrayList<String> fullFile, String inputData, int parameter)
	{
		int
			customer ,
			clip1 ,
			clip2;
		
		String
			lineBeingRead ,
			comparer,
			fullSectionPartHolder;
		
		
		
		long[]
			OVERLOADCHECKER1;
		
		int
			OVERLOADCHECKER2;
		
		
		
		customer = 0;
		fullSectionPartHolder = "";
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(String line :fullFile)
		{
			lineBeingRead = fullFile.get(customer);
			
			
			if(parameter == 0)
			{
				clip1 = lineBeingRead.indexOf("_");
				clip2 = lineBeingRead.lastIndexOf("_");
				
			}
			
			else if(parameter == 1)
			{
				clip1 = -1;
				clip2 = lineBeingRead.indexOf("_");
				
			}
			
			else
			{
				clip1 = -1;
				clip2 = 0;
				System.exit(0);
				
			}
			
			
			comparer = lineBeingRead.substring(clip1 + 1, clip2);
			
			
			if(comparer.equals(inputData))
			{
				for(int i = 0; i < customer; i++)
				{
					fullSectionPartHolder += fullFile.get(i);
					fullSectionPartHolder += "\n";
				}
				
				break;
			}
			
			++customer;
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		return fullSectionPartHolder;
		
	}
	
	
	
	static String fileSection2(ArrayList<String> fullFile, String inputData, int parameter)
	{
		int
			customer ,
			clip1 ,
			clip2;
		
		String
			lineBeingRead ,
			comparer,
			fullSectionPartHolder;
		
		
		
		long[]
			OVERLOADCHECKER1;
		
		int
			OVERLOADCHECKER2;
		
		
		
		customer = fullFile.size() - 1;
		

		fullSectionPartHolder = "";
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(String line :fullFile)
		{
			lineBeingRead = fullFile.get(customer);



			
			
			if(parameter == 0)
			{
				clip1 = lineBeingRead.indexOf("_");
				clip2 = lineBeingRead.lastIndexOf("_");
			}
			
			else if(parameter == 1)
			{
				clip1 = -1;
				clip2 = lineBeingRead.indexOf("_");
			}
			
			else
			{
				clip1 = -1;
				clip2 = -1;
				System.exit(0);
				
			}


			try
			{
				comparer = lineBeingRead.substring(clip1 + 1 , clip2);
			}

			catch(StringIndexOutOfBoundsException e)
			{
				comparer = lineBeingRead.substring(clip1 + 1 , clip2);
			}


			if(comparer.equals(inputData))
			{
				for(int i = customer + 1; i < fullFile.size(); i++)
				{
					fullSectionPartHolder += fullFile.get(i);
					fullSectionPartHolder += "\n";
				}
				
				break;
			}
			
			--customer;
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		return fullSectionPartHolder;
		
	}
	
	
	static String fileCustomerSection(ArrayList<String> fullFile, String inputData, int parameter)
	{
		int
			customer ,
			clip1 ,
			clip2;
		
		String
			lineBeingRead ,
			comparer,
			fullSectionPartHolder;
		
		long[]
			OVERLOADCHECKER1;
		
		int
			OVERLOADCHECKER2;
		
		
		customer = 0;
		fullSectionPartHolder = "";
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(String line :fullFile)
		{
			lineBeingRead = fullFile.get(customer);
			
			
			if(parameter == 0)
			{
				clip1 = lineBeingRead.indexOf("_");
				clip2 = lineBeingRead.lastIndexOf("_");
			}
			
			else if(parameter == 1)
			{
				clip1 = -1;
				clip2 = lineBeingRead.indexOf("_");
			}
			
			else
			{
				clip1 = -1;
				clip2 = -1;
				System.exit(0);
				
			}
			
			
			comparer = lineBeingRead.substring(clip1 + 1, clip2);
			
			
			if(comparer.equals(inputData))
			{
				
				fullSectionPartHolder = lineBeingRead;
				break;
				
			}
			
			++customer;
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		return fullSectionPartHolder;
		
	}
	
	
	
	static ArrayList<String> lastNewLineCorrection(ArrayList<String> giverIndex0AL)
	{
		ArrayList<String> recieverIndex0 = new ArrayList<String>(2);
		
		String
			giverIndex0S ,
			lastCharacter;;
		
		int
			lastLine ,
			lastLineSafe;

		boolean
			excessFinalNewLine1 ,
			excessFinalNewLine2;
		
		
		giverIndex0S = giverIndex0AL.get(0);
		excessFinalNewLine1 = giverIndex0S.endsWith("\n");


		if(excessFinalNewLine1)
		{
			lastLineSafe = giverIndex0S.lastIndexOf("\n");
			lastCharacter = giverIndex0S.substring(lastLineSafe);

			if(lastCharacter.equals("") || lastCharacter.equals("\n") || lastCharacter.equals(" ") || lastCharacter.equals("	"))
			{
				excessFinalNewLine2 = true;

			}

			else
			{
				excessFinalNewLine2 = false;
			}

		}

		else
		{
			excessFinalNewLine2 = false;

		}

		if(excessFinalNewLine2)
		{
			lastLine = giverIndex0S.lastIndexOf("\n");
			giverIndex0S = giverIndex0S.substring(0, lastLine);

		}
		
		
		recieverIndex0.add(0, giverIndex0S);
		recieverIndex0.add(1, giverIndex0AL.get(1));
		
		
		return recieverIndex0;
		
	}


	
}