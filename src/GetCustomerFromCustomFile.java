import java.io.*;
import java.util.*;

public interface GetCustomerFromCustomFile
{
	static ArrayList<String> getAllCustomers() throws IOException
	{
		ArrayList<String> allCustomers = new ArrayList<String>();
		
		String
			filePath ,
			fullFileString;
		
		
		filePath = UserOptionsClass.getCustomFileToWrite();
		fullFileString = ReadFromAnyFile.readFileString(filePath);
		
		allCustomers = AdaptFileFormatForCustomers.readFromFile(fullFileString);
		
		
		return allCustomers;
		
	}
	
}