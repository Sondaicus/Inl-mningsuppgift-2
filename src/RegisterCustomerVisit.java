import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public interface RegisterCustomerVisit
{
	static String start(String x) throws IOException
	{
		ArrayList <String> allLines = new ArrayList<String>();
		
		String
			filePath ,
			returner;
		
		
		filePath = correctInformation(x);
		
		returner = compareFiles(filePath, x);
		
		
		return returner;
	}
	
	
	
	static String correctInformation(String x) throws IOException
	{
		ArrayList <String> allLines = new ArrayList<String>();
		
		String
			writeToFile1 ,
			writeToFile2 ,
			writeToFile3 ,
			writeToFile4 ,
			writeToFile5 ,
			writeToFile6 ,
			filePath;
		
		
		writeToFile1 = AdaptFileFormatForCustomers.writeToFile(x);
		filePath = UserOptionsClass.getCustomUserVisitsFileToWrite();
		WriteToCustomFile.writeToFile(filePath, writeToFile1, true);
		writeToFile2 = ReadFromAnyFile.readFileString(filePath);
		allLines = CorrectCustomFileContent.removeBlankLines(writeToFile2);
		writeToFile3 = AdaptFileFormatForCustomers.arrayListToString(allLines);
		allLines = CorrectCustomFileContent.removeBlankLines(writeToFile3);
		writeToFile4 = AdaptFileFormatForCustomers.arrayListToString(allLines);
		allLines = AdaptFileFormatForCustomers.readFromFile(writeToFile4);
		allLines = CorrectCustomFileContent.removeDuplicateLines(allLines, 1);
		writeToFile5 =  AdaptFileFormatForCustomers.arrayListToString(allLines);
		writeToFile6 = AdaptFileFormatForCustomers.writeToFile(writeToFile5);
		WriteToCustomFile.writeToFile(filePath, writeToFile6, false);
		
		
		return filePath;
		
	}
	
	
	
	static String findLatsetVisit(String x, ArrayList <String> importedLines) throws IOException
	{
		LocalDate
			latestVisit ,
			visitComparitor ,
			minDate;
		
		Period
			differentCheckInTimes;
		
		String
			fileReturner ,
			fileComparison ,
			fileHolderAll ,
			fileHolderPersonalInfo ,
			fileHolderDate ,
			dateComparitor;
		
		int
			dateBreaker ,
			counter;
		
		
		
		//minDate = LocalDate.of(0, 1,1);
		minDate = GetCurrentLocalTime.getTime();
		dateComparitor = minDate.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
		dateComparitor = dateComparitor.replace(':' , '-');
		
		
		visitComparitor = LocalDate.parse(dateComparitor);
		
		
		dateBreaker = x.lastIndexOf("_");
		fileComparison = x.substring(0, dateBreaker);
	
		
		
		counter = 0;
		fileReturner = "";
	
		
		for(String index : importedLines)
		{
			fileHolderAll = importedLines.get(counter);
			
			dateBreaker = fileHolderAll.lastIndexOf("_");
			
			fileHolderPersonalInfo = fileHolderAll.substring(0, dateBreaker);
			
			fileHolderDate =  fileHolderAll.substring(dateBreaker + 1);
			
			
			if(fileComparison.equals(fileHolderPersonalInfo))
			{
				
				latestVisit = LocalDate.parse(fileHolderDate);
				differentCheckInTimes = Period.between(latestVisit, visitComparitor);
				
				
				if(differentCheckInTimes.getYears() >= 1)
				{
					fileReturner =  String.valueOf(visitComparitor);
					visitComparitor = latestVisit;
					
				}
				
				else if(differentCheckInTimes.getYears() == 0 && differentCheckInTimes.getMonths() >= 1)
				{
					fileReturner =  String.valueOf(visitComparitor);
					visitComparitor = latestVisit;
					
				}
				
				else if(differentCheckInTimes.getYears() == 0 && differentCheckInTimes.getMonths() == 0 && differentCheckInTimes.getDays() >= 1)
				{
					fileReturner = String.valueOf(visitComparitor);
					visitComparitor = latestVisit;
					
				}
				
			}
			
			++counter;
			
		}
		
		return fileReturner;
		
	}
	
	
	
	static String compareFiles(String filePath, String x) throws IOException
	{
		ArrayList <String> allLines = new ArrayList<String>();
		
		String
			compareFiles ,
			returner;
		
		
		compareFiles = ReadFromAnyFile.readFileString(filePath);
		allLines = AdaptFileFormatForCustomers.readFromFile(compareFiles);
		returner = findLatsetVisit(x, allLines);
		
		return returner;
		
	}
	
}