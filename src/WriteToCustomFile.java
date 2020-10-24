import java.io.*;

public interface WriteToCustomFile
{
	static void writeToFile(String fullPath, String customer, boolean append) throws IOException
	{
		PrintWriter outStream = new PrintWriter (new BufferedWriter(new FileWriter(fullPath, append)));
		
		outStream.println(customer);
		
		outStream.close();
		
	}
	
}