import java.io.*;
import java.time.*;
import java.util.*;

public interface findCustomer
{
	/*Methodes where name is used to find customer.*/
		static String getCustomerFromName(String x) throws IOException
		{
			String
				customer,
				returner;
			
			customer = tryCustomerFromName(x);
			
			if(customer.equals(""))
			{
				returner = customerNotFoundByName(x);
			}
			else
			{
				returner = customerFound(customer);
			}
			
			return returner;
		}
		
	
		static String tryCustomerFromName(String x) throws IOException
		{
			ArrayList <String> allCustomers = new ArrayList<String>();
			
			String individualSearchedFor = "";
			
			allCustomers = GetCustomerFromCustomFile.getAllCustomers();
			
			int customer = 0;
			
			
			
			long[]
				OVERLOADCHECKER1;
			
			int
				OVERLOADCHECKER2;
			
			
			
			OVERLOADCHECKER1 = new long[1000000];
			OVERLOADCHECKER2 = 1;
			for(String name : allCustomers)
			{
				int clip1 = name.indexOf("_") + 1;
				int clip2 = name.lastIndexOf("_");
				
				String clipper1 = name.substring(0, clip1);
				String clipper2 = name.substring(clip2);
				
				String fullInfo = clipper1 + x + clipper2;
				
				if(fullInfo.equals(name))
				{
					return allCustomers.get(customer);
				}
				
				++customer;
				
				OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
				OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
			}
			
			return individualSearchedFor;
		}
	
	
		static String customerNotFoundByName(String x)
		{
			String personalMessage = "En person med namnet " + x + " kunde inte hittas i systemet.";
			return personalMessage;
		}
	
		
	
	/*Methods were personal number is used to find customer*/
		static String getCustomerFromPersonalnumber(String x) throws IOException
		{
			String
			customer,
			returner;
			
			customer = tryCustomerFromPersonalnumber(x);
			
			if(customer.equals(""))
			{
				returner = customerNotFoundByPersonalnumber(x);
			}
			else
			{
				returner = customerFound(customer);
			}
			
			return returner;
			
		}


		static String tryCustomerFromPersonalnumber(String x) throws IOException
		{
			ArrayList<String> allCustomers = new ArrayList<String>();
			
			String individualSearchedFor = "";
			
			allCustomers = GetCustomerFromCustomFile.getAllCustomers();
			
			int customer = 0;
			
			
			
			long[]
				OVERLOADCHECKER1;
			
			int
				OVERLOADCHECKER2;
			
			
			
			OVERLOADCHECKER1 = new long[1000000];
			OVERLOADCHECKER2 = 1;
			for(String personalnumber : allCustomers)
			{
				int clip1 = personalnumber.indexOf("_");
				
				String clipper1 = personalnumber.substring(clip1);
				
				String fullInfo = x + clipper1;
				
				if(fullInfo.equals(personalnumber))
				{
					return allCustomers.get(customer);
				}
				
				++customer;
				
				OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
				OVERLOADCHECKER2 = OVERLOADCHECKER2 +1;
			}
			
			return individualSearchedFor;
		}


		static String customerNotFoundByPersonalnumber(String x)
		{
			String personalMessage = "En person med personnummret " + x + " kunde inte hittas i systemet.";
			return personalMessage;
		}
	
	
	
	/*Method where the searched for customer is succesfully found by the system.*/
		static String customerFound(String x) throws IOException
		{
			boolean
				stillMember;
			
			String
				personalNumber ,
				name ,
				joinDateString ,
				writeToFileLatestDate ,
				dataBaseFileOverWriter;
			
			int
				clip1 ,
				clip2;
			
			LocalDate
				joinDateLD ,
				currentDate;
			
			Period
				membershipRemaining;
			
			
			clip1 = x.indexOf("_");
			personalNumber = x.substring(0, clip1);
			
			clip2 = x.lastIndexOf("_");
			name = x.substring(clip1 + 1, clip2);
			
			joinDateString = x.substring(clip2 + 1);
			
			
			String
				personalMessage1 ,
				personalMessage2 ,
				personalMessage3;
			
			personalMessage1 = "Användaren " + name + " hittades i systemet. Hen har personnumret " + personalNumber + " " +
			                   "och har betalat medlemskap senast " + joinDateString + ".";
			
			joinDateLD = LocalDate.parse(joinDateString);
			currentDate = GetCurrentLocalTime.getTime();
			
			membershipRemaining = Period.between(currentDate, joinDateLD);
			
			
			if(membershipRemaining.getYears() <= -2)
			{
				stillMember = false;
			}
			
			else if(membershipRemaining.getYears() <= -1)
			{
				if(membershipRemaining.getDays() <= -1)
				{
					stillMember = false;
				}
				
				else if(membershipRemaining.getMonths() <= -1)
				{
					stillMember = false;
				}
				
				else
				{
					stillMember = true;
				}
				
			}
			
			else
			{
				stillMember = true;
			}
			
			
			if(stillMember)
			{
				
				
				personalMessage2 = "Användarens medlemskap gäller fortfarande, och tiden för dagens datum registeras.";
				
				writeToFileLatestDate = RegisterCustomerVisit.start(x);
				
				
				if(writeToFileLatestDate.equals(""))
				{}
				
				else if(writeToFileLatestDate.equals(String.valueOf(GetCurrentLocalTime.getTime())))
				{
					dataBaseFileOverWriter = personalNumber + "_" + name + "_" + writeToFileLatestDate;
					
				
					RegisterCustomerVisit.correctInformation(dataBaseFileOverWriter);
					
				}
				
				else
				{
					personalMessage2 += " Datumet för användarens senaste besök till gymmet var " + writeToFileLatestDate + ".";
					
					
					dataBaseFileOverWriter = personalNumber + "_" + name + "_" + writeToFileLatestDate;
					
				
					RegisterCustomerVisit.correctInformation(dataBaseFileOverWriter);
					
				}
				
				
			}
			
			else
			{
				personalMessage2 = "Användarens medlemskap har gått ut.";
			}
			
			personalMessage3 = personalMessage1 + "\n" + personalMessage2;
			
			
			return personalMessage3;
		}

}