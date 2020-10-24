import java.io.*;

public class UserOptionsClass
implements
IterationAndSelectionUserChoices , CreateInitiationOfCustomFile, ChoseNewOrOldDatabaseFile
{
	private static String customBaseFileToWrite;
	private static String customUserVisitsFileToWrite;
	
	
	public static void start() throws IOException
	{
		int choice;
		
		choice = ChoseNewOrOldDatabaseFile.start(0);
		
		if(choice == 0)
		{
			customBaseFileToWrite = CreateInitiationOfCustomFile.selectWriteToFileBase();
			
		}
		
		else if(choice == 1)
		{
			customBaseFileToWrite = CreateInitiationOfCustomFile.start();
			
		}
		
		
		CorrectCustomFileContent.start(0, 0);
		
		
		
		ChoseNewOrOldDatabaseFile.start(1);
		
		
		customUserVisitsFileToWrite = CreateInitiationOfCustomFile.selectWriteToFileBase();
		WriteToCustomFile.writeToFile(customUserVisitsFileToWrite, "", true);
		
		
		
		CorrectCustomFileContent.start(1, 1);
		
		
		while(true)
		{
			IterationAndSelectionUserChoices.mainMenu();
			
		}
		
	}
	
	
	public static String getCustomFileToWrite()
	{
		return customBaseFileToWrite;
		
	}
	
	public static String getCustomUserVisitsFileToWrite()
	{
		return customUserVisitsFileToWrite;
		
	}
	
}