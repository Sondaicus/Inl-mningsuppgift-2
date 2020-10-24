import java.time.*;

public interface StringToLocalDate
{
	static LocalDate converter(String date_String)
	{
		LocalDate date_LocalDate;
		
		date_LocalDate = LocalDate.parse(date_String);
		
		return date_LocalDate;
	}
}
