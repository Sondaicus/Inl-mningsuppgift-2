import java.util.*;
import javax.swing.*;

public interface AdaptFileFormatForCustomers
{
	static ArrayList<String> readFromFile(String inputData)
	{
		String
			fileRemainder ,
			fileInitilizer;
		
		int
			totalCustomers;

		boolean
			breaker;


		
		long[]
			OVERLOADCHECKER1;
		
		int
			OVERLOADCHECKER2;
		
		
		
		fileRemainder = inputData;
		totalCustomers = 0;

		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		while(true)
		{
			breaker = false;

			int clip1;
			int clip2;
			
			
			clip1 = fileRemainder.indexOf("\n");
			clip2 = fileRemainder.indexOf("\n" , clip1 + 1);
			fileRemainder = fileRemainder.substring(clip2 + 1);
			
			
			if(fileRemainder.equals(""))
			{
				breaker = true;

			}
			
			else if(fileRemainder.equals("\n"))
			{
				breaker = true;

			}
			
			else if(fileRemainder.length() == 0 )
			{
				breaker = true;

			}

			else if(clip2 == -1)
			{
				breaker = true;

			}
			

			if(breaker)
			{
				break;

			}
			
			
			++totalCustomers;
			
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}

		
		ArrayList <String> outputData = new ArrayList <String>(totalCustomers);


		fileRemainder = inputData;
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(int i = 0; i < totalCustomers + 1; i++)
		{
			int clip1 = fileRemainder.indexOf("\n");
			int clip2 = fileRemainder.indexOf("\n" , clip1 + 1);
			
			
			if(clip2 == -1)
			{
				fileInitilizer = fileRemainder.substring(0 , clip2 + 1);
			}
			else
			{
				fileInitilizer = fileRemainder.substring(0 , clip2);
			}
			
			fileRemainder = fileRemainder.substring(clip2 + 1);
			
			
			outputData.add(fileInitilizer);
			
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		
		int iterationCounter = 0;
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(int i = 0; i < totalCustomers + 1; i++)
		{
			boolean
				successReadingUser ,
				noNewLine ,
				userEndsWithoutNewLine;
			
			int
				clipNewLine ,
				clip1 ,
				clip2 ,
				clip3;
			
			String
				clipper1 ,
				clipper2 ,
				clipper3;
			
			
			fileInitilizer = outputData.get(i);


			clipNewLine = fileInitilizer.indexOf("\n");

			fileInitilizer = fileInitilizer.replace('\n' , ' ');


			if(clipNewLine == -1)
			{
				noNewLine = true;

				if(fileInitilizer.length() > 0)
				{
					userEndsWithoutNewLine = true;

				}

				else
				{
					userEndsWithoutNewLine = false;
				}
			}

			else
			{
				noNewLine = false;
				userEndsWithoutNewLine = false;
			}


			if(!userEndsWithoutNewLine && !noNewLine)
			{
				clip1 = fileInitilizer.indexOf(",");
				clip2 = fileInitilizer.indexOf(" ");
				clip3 = fileInitilizer.lastIndexOf(" ");

			}

			else if(userEndsWithoutNewLine)
			{
				clip1 = fileInitilizer.indexOf(",");
				clip2 = fileInitilizer.indexOf(" ");
				clip3 = fileInitilizer.lastIndexOf(" ");
			}



			clip1 = fileInitilizer.indexOf(",");
			clip2 = fileInitilizer.indexOf(" ");
			clip3 = fileInitilizer.lastIndexOf(" ");


			successReadingUser = true;
			
			try
			{
				clipper1 = fileInitilizer.substring(0 , clip1);
			}
			
			catch(StringIndexOutOfBoundsException e1)
			{
				clipper1 = "";
				successReadingUser = false;

				//System.out.println("e1, AdaptFileFormatForCustomers.readFromFile: " + e1);

			}
			
			try
			{
				clipper2 = fileInitilizer.substring(clip2 + 1 , clip3);
			}
			
			catch(StringIndexOutOfBoundsException e2)
			{
				clipper2 = "";
				successReadingUser = false;

				//System.out.println("e2, AdaptFileFormatForCustomers.readFromFile: " + e2);

			}
			
			try
			{
				clipper3 = fileInitilizer.substring(clip3 + 1);;
			}
			
			catch(StringIndexOutOfBoundsException e3)
			{
				clipper3 = "";
				successReadingUser = false;

				//System.out.println("e3, AdaptFileFormatForCustomers.readFromFile: " + e3);

			}
			
			
			fileInitilizer = clipper1 + "_" + clipper2 + "_" + clipper3;
			
			
			if(successReadingUser)
			{
				outputData.set(iterationCounter, fileInitilizer);
				++iterationCounter;
				
			}
			
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		return outputData;
		
	}
	
	
	
	static String writeToFile(String customerIn)
	{
		String
			customerOut ,
			fileInitilizer ,
			fileRemovedLines ,
			clipper1 ,
			clipper2 ,
			clipper3;
		
		int
			clip1 ,
			clip2 ,
			clip3 ,
			clip4;

		boolean
			successReadingUser ,
			noNewLine ,
			userEndsWithoutNewLine;
		
		
		
		long[]
		OVERLOADCHECKER1;
		
		int
		OVERLOADCHECKER2;
		
		
		
		fileInitilizer = customerIn;
		customerOut = "";
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		while(true)
		{
			successReadingUser = true;
			
			
			clip1 = fileInitilizer.indexOf("_");
			
			
			try
			{
				clipper1 = fileInitilizer.substring(0 , clip1);
				clipper1 += ", ";
				
			}
			
			catch(StringIndexOutOfBoundsException e1)
			{
				clipper1 = "";
				successReadingUser = false;

				//System.out.println("e1, AdaptFileFormatForCustomers.writeToFile: " + e1);
				
			}
			
			
			clip2 = fileInitilizer.indexOf("_" , clip1 + 1);
			
			
			try
			{
				clipper2 = fileInitilizer.substring(clip1 + 1 , clip2);
				clipper2 += "\n";

				
			}
			
			catch(StringIndexOutOfBoundsException e2)
			{
				clipper2 = "";
				successReadingUser = false;

				//System.out.println("e2, AdaptFileFormatForCustomers.writeToFile: " + e2);
				
			}
			
			
			clip3 = fileInitilizer.indexOf("\n");
			
			
			
			if(clip3 != -1)
			{
				try
				{
					clipper3 = fileInitilizer.substring(clip2 + 1 , clip3);
					clipper3 += "\n";
					
				}
				
				catch(StringIndexOutOfBoundsException e3)
				{
					clipper3 = "";
					successReadingUser = false;

					//System.out.println("e3, AdaptFileFormatForCustomers.writeToFile: " + e3);
					
				}
			}
			
			else
			{
				try
				{
					clipper3 = fileInitilizer.substring(clip2 + 1);
					
				}
				
				catch(StringIndexOutOfBoundsException e4)
				{
					clipper3 = "";
					successReadingUser = false;

					//System.out.println("e4, AdaptFileFormatForCustomers.writeToFile: " + e4);
					
				}
				
			}
			
			
			if(successReadingUser)
			{
				fileRemovedLines = clipper1 + clipper2 + clipper3;
				clip4 = fileRemovedLines.length();
				fileInitilizer = fileInitilizer.substring(clip4 - 1);
				customerOut += fileRemovedLines;
				
			}
			
			else
			{
				break;
				
			}
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		customerOut = removeExcessFinalNewLine(customerOut);
		
		
		return customerOut;
		
	}
	
	
	
	static ArrayList<String> printToUser(String customer)
	{
		ArrayList <String> sections = new ArrayList<String>(3);
		
		String
			clipper1 ,
			clipper2 ,
			clipper3;
		
		int
			clip1 ,
			clip2;
			
		
		clip1 = customer.indexOf("_");
		clip2 = customer.lastIndexOf("_");
		
	
		clipper1 = customer.substring(0 , clip1);
		clipper2 = customer.substring(clip1 + 1 , clip2);
		clipper3 = customer.substring(clip2 + 1);
		
		
		sections.add(0 , clipper1);
		sections.add(1 , clipper2);
		sections.add(2 , clipper3);
	
		
		return sections;
		
	}
	
	
	
	static String arrayListToString(ArrayList<String> inputData)
	{
		String
			fullFile,
			lineHolder;
		
		int
			counterLaps ,
			newLine1 ,
			newLine2 ,
			newLine3;
		
		
		
		long[]
			OVERLOADCHECKER1;
		
		int
			OVERLOADCHECKER2;
		
		
		
		fullFile = "";
		counterLaps = 0;
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		for(String line : inputData)
		{
			lineHolder = inputData.get(counterLaps);
			fullFile += lineHolder;
			fullFile += "\n";
			
			
			++counterLaps;
			
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
		}
		
		
		newLine1 = fullFile.indexOf("_");
		newLine2 = fullFile.indexOf(",");
		
		if(newLine1 != -1 && newLine2 == -1)
		{
			if(fullFile.endsWith("\n"))
			{
				newLine3 = fullFile.lastIndexOf("\n");
				fullFile = fullFile.substring(0 , newLine3);
				
			}
			
		}
		
		return fullFile;
		
	}
	
	
	
	static String removeExcessFinalNewLine(String inputData)
	{
		String
			outputData ,
			lastCharacter;
		
		boolean
			excessFinalNewLine1 ,
			excessFinalNewLine2;
		
		int
			lastLine ,
			lastLineSafe;
		
		
		outputData = inputData;
		excessFinalNewLine1 = outputData.endsWith("\n");

		if(excessFinalNewLine1)
		{
			lastLineSafe = outputData.lastIndexOf("\n");
			lastCharacter = outputData.substring(0, lastLineSafe);

			lastLine = lastCharacter.lastIndexOf("\n");
			lastCharacter = lastCharacter.substring(0, lastLine);


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
			lastLine = outputData.lastIndexOf("\n");
			outputData = outputData.substring(0, lastLine);
			
		}
		
		
		return outputData;
		
	}
	
}