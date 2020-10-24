import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.*;


public interface IterationAndSelectionUserChoices
{
	/*Dialogbox messages.*/
		String message0 =
					"Detta programmet använder ett system för att det enklare skall gå att kolla " +
	                "vilka som inte är medlemar på gymet, " +
	                "vilka som har varit det men inte längre, " +
	                "och vilka som fortfarande får använda gymet. " +
	                "Det är också möjligt att lägga till fler användare." + "\n" +
					"\n" + "Välj nästa steg.";
		
		
		String message1 =
					"Mata in personens fullständiga för och efternamn (teckenkänsligt!).";
	
	
		String message2 =
					"Mata in personens personnummer, 10 siffror utan bindesträck.";
	
	
		String message3 =
					"Välj på vilket sätt du vill välja ut den användare som skall tas bort.";
	
	
		String message4 =
					"Du har valt att avsluta programmet. Programmet avslutas.";
		
		
		String messageResultIndex0_0 =
					"En person med ";
	
		String messageResultIndex0_1 =
					"namnet ";
		
		String messageResultIndex0_2 =
					"personnummret ";
		
		String messageResultIndex0_3 =
					" kunde inte hittas i systemet. Ingen användare har tagits bort.";
	
		
		String messageResultIndex1_0 =
					"Användaren ";
		
		String messageResultIndex1_1 =
					" hittades i systemet. Hen har personnumret ";
	
		String messageResultIndex1_2 =
					" och har betalat medlemskap senast ";
	
		String messageResultIndex1_3 =
					" och har betalat medlemskap senast ";
	
		String messageResultIndex1_4 =
					". Denna användare kommer att tas bort.";
		
		
		
	/*Dialogbox error information.*/
		String errorMessage =
					"Du har inte matat in på ett rätt sätt för att programmet skall kunna fortsätta. Programmet" +
					"kommer att avslutas som default.";
		
		
		String errorTitle =
					"Fel vid inmatning.";
	
	
		
	/*Dialogbox titles.*/
		String title0 =
					"Välj nästa steg.";
		
		
		String title1 =
					"Manuell inmatning";
	
	
		String title2 =
					"Skapande av ny kund.";
	
	
		String title3 =
					"Ta bort en existerande användare.";
		
		
		String title4 =
					"Information om eftersökt användare.";
	
	
		String title5 =
					"Programmet avslutas.";
		
	
	/*Dialogbox selections.*/
		String[] choseOptions0 = {
					"Registrera närvaro för en användare med dess namn." ,
					"Registrera närvaro för en användare med dess personnummer" ,
					"Lägg till en ny användare",
					"Ta bort en användare" ,
					"Avsluta" };
	
	
		String[] choseOptions1 = {
					"Ta bort en användare med dess namn." ,
					"Ta bort en användare med dess personnummer"};
	
	
	
	static void mainMenu() throws IOException
	{
		ArrayList<String> resultArrayList = new ArrayList <String>(2);
		
		String
			userInputFind ,
			userInputCreate1 ,
			userInputCreate2 ,
			userInputCreate3 ,
			resultString ,
			messageToUser;
		
		int
			chosenOption0;
		
		
		chosenOption0 = showOptionDialog(
		
			null ,
			
			message0 ,
		
			title0 ,
			
			2 ,
			
			INFORMATION_MESSAGE ,
			
			null ,
			
			choseOptions0 ,
			
			null
		
		);
		
		
		if(chosenOption0 == 0)
		{
			userInputFind = userInterfaceNoOptionsReturnString(message1, title1, 1);
			resultString = findCustomer.getCustomerFromName(userInputFind);
			
			userInterfaceMessageByBox(resultString, title4, 1);
			
		}
		
		
		else if(chosenOption0 == 1)
		{
			userInputFind = userInterfaceNoOptionsReturnString(message2, title1, 1);
			resultString = findCustomer.getCustomerFromPersonalnumber(userInputFind);
			
			userInterfaceMessageByBox(resultString, title4, 1);
			
		}
		
		
		else if(chosenOption0 == 2)
		{
			userInputCreate1 = userInterfaceNoOptionsReturnString(message2, title2, 1);
			
			userInputCreate2 = userInterfaceNoOptionsReturnString(message1, title2, 1);
			
			userInputCreate3 = String.valueOf(GetCurrentLocalTime.getTime());
			
			
			resultString = userInputCreate1 + "_" + userInputCreate2 + "_" + userInputCreate3;
			
			resultString = AdaptFileFormatForCustomers.writeToFile(resultString);
			
			WriteToCustomFile.writeToFile(UserOptionsClass.getCustomFileToWrite(), resultString, true);
			
			CorrectCustomFileContent.start(0, 0);
			
		}
		
		
		else if(chosenOption0 == 3)
		{
			removeUserInterfaceMain();
			
		}
		
		
		else if(chosenOption0 == 4)
		{
			userInterfaceMessageByBox(message4, title5, 1);
			System.exit(0);
			
		}
		
		
		else
		{
			errorAbortInterface();
			
		}
		
	}
	
	
	
	static void removeUserInterfaceMain() throws IOException
	{
		ArrayList<String> resultArrayList = new ArrayList<String>(3);
		
		int chosenOption;
		
		
		chosenOption = userInterfaceChoseByBox(choseOptions1, message3, title3, 3);
		
		resultArrayList = removeUserInterfaceSelection(chosenOption);
		removeUserInterfaceResult(resultArrayList, chosenOption);
		
	}
	
	
	
	static ArrayList<String> removeUserInterfaceSelection(int chosenOption) throws IOException
	{
		ArrayList<String> resultArrayList = new ArrayList<String>(2);
		ArrayList<String> returnArrayList = new ArrayList<String>(3);
		
		String
			userInputFind ,
			resultStringHolder1 ,
			resultStringHolder2;
		
		
		if(chosenOption == 0)
		{
			userInputFind = userInterfaceNoOptionsReturnString(message1, title3, 1);
			
			resultArrayList  = removeFromFile.start(0, userInputFind);
			
			
		}
		
		else if(chosenOption == 1)
		{
			userInputFind = userInterfaceNoOptionsReturnString(message2, title3, 1);
			
			resultArrayList = removeFromFile.start(1, userInputFind);
			
		}
		
		else
		{
			errorAbortInterface();
			userInputFind = "";
			
		}
		
		
		resultStringHolder1 = resultArrayList.get(0);
		resultStringHolder2 = resultArrayList.get(1);
		returnArrayList.add(0, resultStringHolder1);
		returnArrayList.add(1, resultStringHolder2);
		returnArrayList.add(2, userInputFind);
		
		
		return returnArrayList;
		
	}
	
	
	
	static void removeUserInterfaceResult(ArrayList<String> resultArrayList, int chosenOption) throws IOException
	{
		String
			userInputFind ,
			resultString ,
			messageToUser ,
			choiceOfInfo;
		
		
		userInputFind = resultArrayList.get(2);
		
		
		if(chosenOption == 0)
		{
			choiceOfInfo = messageResultIndex0_1;
		}
		
		else if(chosenOption == 1)
		{
			choiceOfInfo = messageResultIndex0_2;
		}
		
		else
		{
			choiceOfInfo = "";
		}
		
		
		
		
		if(resultArrayList.get(0).equals(""))
		{
			resultString =
			messageResultIndex0_0 + choiceOfInfo + userInputFind + messageResultIndex0_3;
			
			userInterfaceMessageByBox(resultString, title4, 0);
			
		}
		
		else
		{
			resultString = resultArrayList.get(0);
			resultString = AdaptFileFormatForCustomers.writeToFile(resultString);
			
			
			WriteToCustomFile.writeToFile(UserOptionsClass.getCustomFileToWrite(), resultString, false);
			
			
			messageToUser = resultArrayList.get(1);
			
			
			resultArrayList = AdaptFileFormatForCustomers.printToUser(messageToUser);
			
			
			resultString =
			messageResultIndex1_0 +
			
			resultArrayList.get(1) +
			
			messageResultIndex1_1 +
			
			resultArrayList.get(0) +
			
			messageResultIndex1_2 +
			
			resultArrayList.get(2) +
			
			messageResultIndex1_4;
			
			
			
			
			
			userInterfaceMessageByBox(resultString, title4, 1);
			
		}
		
	}
	
	
	
	static String userInterfaceNoOptionsReturnString(String message, String title, int boxType)
	{
		String input;
		
		input = showInputDialog(
		
			null ,
		
			message ,
		
			title ,
		
			boxType
		
		);
		
		
		if(input == null)
		{
			errorAbortInterface();
		}
		
		
		return input;
		
	}
	
	
	
	static int userInterfaceChoseByBox(String[] options, String message, String title, int boxType)
	{
		int choice;
		
		choice = showOptionDialog(
		
			null ,
			
			message ,
			
			title ,
			
			2 ,
			
			boxType ,
			
			null ,
			
			options ,
			
			null
		);
		
		return choice;
		
	}
	
	
	
	static void userInterfaceMessageByBox(String message, String title, int boxType)
	{
		showMessageDialog(
		
			null ,
			
			message ,
			
			title ,
		
			boxType ,
			
			null
		
		);
		
	}
	
	
	
	static void errorAbortInterface()
	{
		showMessageDialog(
		
			null ,
			
			errorMessage ,
			
			errorTitle ,
			
			ERROR_MESSAGE
		
		);
		
		
		System.exit(0);
		
	}
	
}