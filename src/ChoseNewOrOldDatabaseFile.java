import javax.swing.*;

public interface ChoseNewOrOldDatabaseFile
{
	String[]
		choices = { "Välj en existerande fil" , "Skapa en ny fil" };
	
	String
		message0 = "När du först startar programmet får du välja om du vill använda en tidigare existerande fil" +
	          " som databas för kundlista eller om du vill skapa en ny. Välj vilket alternativ du föredrar." ,
	
		message1 = "Nu får du välja om du vill skapa en ny fil eller använda en gammal för att hålla reda på när " +
		           "personer kommer och går till gymet. Om personen är giltig meddlem så registeras dennes närvaro i " +
		           "denna fil. Använd inte samma fil som kunderna finns sparade i!" ,
	
		title = "Ny fil eller gammal";
	
	
	
	static int start(int fileType)
	{
		int chosenOption;
		
		String messageToUser;
		
		if(fileType == 0)
		{
			messageToUser = message0;
		}
		
		else if(fileType == 1)
		
		{
			messageToUser = message1;
		}
		
		else
		{
			messageToUser = "";
		}
		
		
		chosenOption = JOptionPane.showOptionDialog(
		
			null ,
		
			messageToUser ,
			
			title ,
			
			2 ,
			
			JOptionPane.QUESTION_MESSAGE ,
			
			null ,
			
			choices ,
			
			null
		
		);
		
		
		if(chosenOption == 0 )
		{}
		else if(chosenOption == 1)
		{}
		else
		{
			IterationAndSelectionUserChoices.errorAbortInterface();
		}
		
		return chosenOption;
		
	}
}
