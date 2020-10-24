import java.io.*;

public interface ReadFromAnyFile
{
	static String findFile(String stringName)
	{
		String fullPath;
		File fileName = new File(stringName);
		
		fullPath = fileName.getAbsolutePath();
		
		return fullPath;
	}
	
	
	static String readFileString(String fullPath) throws IOException
	{
		String fullFile = "";
		String lineBeingRead;
		
		BufferedReader inStream = new BufferedReader(new FileReader(fullPath));
		
		
		
		long[]
			OVERLOADCHECKER1;
		
		int
			OVERLOADCHECKER2;
		
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 1;
		while(true)
		{
			lineBeingRead = inStream.readLine();
			
			if(lineBeingRead == null)
			{
				break;
			}
			
			fullFile += lineBeingRead;
			fullFile += '\n';
			
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		inStream.close();
		
		return fullFile;
		
	}
	
}