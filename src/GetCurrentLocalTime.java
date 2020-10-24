import java.time.format.DateTimeFormatter;
import java.time.*;

public interface GetCurrentLocalTime
{
	static LocalDate getTime()
	{
		ZonedDateTime time1ZDT = ZonedDateTime.now(ZoneId.of("Europe/Stockholm"));
		
		String time2S = time1ZDT.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
		time2S = time2S.replace(':' , '-');
		
		LocalDate time3LD = LocalDate.parse(time2S);
		
		return time3LD;
		
	}
	
}