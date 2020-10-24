import javax.swing.*;
import java.io.*;


public interface CreateInitiationOfCustomFile
{
	String baseFile = "customers.txt";
	
	
	static String start() throws IOException
	{
		String
			fullReadBaseFile ,
			customFileToWrite;
		
		fullReadBaseFile = readBaseFile();
		customFileToWrite = selectWriteToFileBase();
		WriteToCustomFile.writeToFile(customFileToWrite, fullReadBaseFile, true);
		
		
		return customFileToWrite;
		
	}
	
	
	static String readBaseFile() throws IOException
	{
		String
			filePathBase ,
			fullFile;
		
		filePathBase = ReadFromAnyFile.findFile(baseFile);
		fullFile = ReadFromAnyFile.readFileString(filePathBase);
		
		return fullFile;
		
	}
	
	
	static String selectWriteToFileBase()
	{
		String
			choseLocationAndName = null ,
			fileType;
		
		int
			chooseFile ,
			clip;
		
		JFileChooser fileLocation1 = new JFileChooser();
		
			chooseFile = fileLocation1.showOpenDialog(null);
			
			if(chooseFile == JFileChooser.APPROVE_OPTION)
			{
				choseLocationAndName = fileLocation1.getSelectedFile().getAbsolutePath();
				
				clip =choseLocationAndName.lastIndexOf(".");
				
				if(clip != -1)
				{
					fileType = choseLocationAndName.substring(clip);
					
					if(fileType.equals(".txt"))
					{}
					else
					{
						choseLocationAndName += ".txt";
						
					}
				}
				
				else
				{
					choseLocationAndName += ".txt";
					
				}
				
			}
			
			else
			{
				IterationAndSelectionUserChoices.errorAbortInterface();
				
			}
			
		return choseLocationAndName;
		
	}
	
}