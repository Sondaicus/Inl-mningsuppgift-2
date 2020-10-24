import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

public class Tests
{
	@Test
	void allTests() throws IOException
	{
		checkBaseFileContent();
		adaptionOfStringConvertionCorrect();
		removeCustomUser1();
		removeCustomUser2();

	}


	@Test
	void checkBaseFileContent() throws IOException
	{
		String baseFileContent =
					 "7603021234, Alhambra Aromes\n" + "2019-07-01\n" +
		             "8104021234, Bear Belle\n" + "2018-12-02\n" +
		             "8512021234, Chamade Coriola\n" + "2017-03-12\n" +
		             "7608021234, Diamanda Djedi\n" + "2020-01-30\n" +
		             "7605021234, Elmer Ekorrsson\n" + "2010-04-07\n" +
					 "7911061234, Fritjoff Flacon\n" + "1999-12-16\n" +
		             "7512166544, Greger Ganache\n" + "2020-03-23\n" +
		             "5711121234, Hilmer Heur\n" + "2019-08-18\n" +
		             "8906138493, Ida Idylle\n" + "2017-03-07\n" +
		             "9902149834, Jicky Juul\n" + "2018-09-27\n" +
		             "4604151234, Kadine Karlsson\n" + "2018-01-09\n" +
		             "9110261234, Liu Lingren\n" + "2018-02-15\n" +
		             "7907281234, Mitsuko Mayotte\n" + "2018-12-22\n" +
		             "7805211234, Nahema Ninsson\n" + "2020-08-04\n";
		
		
		assertTrue(CreateInitiationOfCustomFile.readBaseFile().equals(baseFileContent));
		
	}
	
	
	
	@Test
	void adaptionOfStringConvertionCorrect() throws IOException
	{
		int counter;
		
		String baseFileContent;
		
		String compareFileString;
		
		ArrayList <String> compareFileAL = new ArrayList <String>(14);
		
		
		/*Part 1*/
			baseFileContent =
						"7603021234_Alhambra Aromes_2019-07-01\n" +
						"8104021234_Bear Belle_2018-12-02\n" +
						"8512021234_Chamade Coriola_2017-03-12\n" +
						"7608021234_Diamanda Djedi_2020-01-30\n" +
						"7605021234_Elmer Ekorrsson_2010-04-07\n" +
						"7911061234_Fritjoff Flacon_1999-12-16\n" +
						"7512166544_Greger Ganache_2020-03-23\n" +
						"5711121234_Hilmer Heur_2019-08-18\n" +
						"8906138493_Ida Idylle_2017-03-07\n" +
						"9902149834_Jicky Juul_2018-09-27\n" +
						"4604151234_Kadine Karlsson_2018-01-09\n" +
						"9110261234_Liu Lingren_2018-02-15\n" +
						"7907281234_Mitsuko Mayotte_2018-12-22\n" +
						"7805211234_Nahema Ninsson_2020-08-04\n";
			
			
			compareFileString = CreateInitiationOfCustomFile.readBaseFile();
			compareFileAL = AdaptFileFormatForCustomers.readFromFile(compareFileString);
			
			
			compareFileString = "";
			counter = 0;
			
			for(String lines : compareFileAL)
			{
				compareFileString += compareFileAL.get(counter);
				compareFileString += "\n";
				++counter;
				
			}
			
			
			assertTrue(compareFileString.equals(baseFileContent));
		
		
		
		/*Part 2*/
			baseFileContent =
						"7603021234, Alhambra Aromes\n" + "2019-07-01\n" +
						"8104021234, Bear Belle\n" + "2018-12-02\n" +
						"8512021234, Chamade Coriola\n" + "2017-03-12\n" +
						"7608021234, Diamanda Djedi\n" + "2020-01-30\n" +
						"7605021234, Elmer Ekorrsson\n" + "2010-04-07\n" +
						"7911061234, Fritjoff Flacon\n" + "1999-12-16\n" +
						"7512166544, Greger Ganache\n" + "2020-03-23\n" +
						"5711121234, Hilmer Heur\n" + "2019-08-18\n" +
						"8906138493, Ida Idylle\n" + "2017-03-07\n" +
						"9902149834, Jicky Juul\n" + "2018-09-27\n" +
						"4604151234, Kadine Karlsson\n" + "2018-01-09\n" +
						"9110261234, Liu Lingren\n" + "2018-02-15\n" +
						"7907281234, Mitsuko Mayotte\n" + "2018-12-22\n" +
						"7805211234, Nahema Ninsson\n" + "2020-08-04\n";
		
		
			compareFileString = CreateInitiationOfCustomFile.readBaseFile();
			
			
			assertTrue(compareFileString.equals(baseFileContent));
		
	}
	
	
	
	@Test
	void removeCustomUser1()
	{
		String
			baseFileContent1 ,
			baseFileContent2 ,
			baseFileContentHolder ,
			comparer ,
			userName ,
			userNumber;
		
		ArrayList <String> compareFileAL = new ArrayList <String>(14);
		
		
		baseFileContent1 =
			"7603021234_Alhambra Aromes_2019-07-01\n" +
			"8104021234_Bear Belle_2018-12-02\n" +
			"8512021234_Chamade Coriola_2017-03-12\n" +
			"7608021234_Diamanda Djedi_2020-01-30\n" +
			"7605021234_Elmer Ekorrsson_2010-04-07\n" +
			"7911061234_Fritjoff Flacon_1999-12-16\n" +
			"7512166544_Greger Ganache_2020-03-23\n" +
			"5711121234_Hilmer Heur_2019-08-18\n" +
			"8906138493_Ida Idylle_2017-03-07\n" +
			"9902149834_Jicky Juul_2018-09-27\n" +
			"4604151234_Kadine Karlsson_2018-01-09\n" +
			"9110261234_Liu Lingren_2018-02-15\n" +
			"7907281234_Mitsuko Mayotte_2018-12-22\n" +
			"7805211234_Nahema Ninsson_2020-08-04\n";
		
		baseFileContent2 =
			"7603021234_Alhambra Aromes_2019-07-01\n" +
			"8104021234_Bear Belle_2018-12-02\n" +
			"8512021234_Chamade Coriola_2017-03-12\n" +
			"7608021234_Diamanda Djedi_2020-01-30\n" +
			"7605021234_Elmer Ekorrsson_2010-04-07\n" +
			"7512166544_Greger Ganache_2020-03-23\n" +
			"5711121234_Hilmer Heur_2019-08-18\n" +
			"8906138493_Ida Idylle_2017-03-07\n" +
			"9902149834_Jicky Juul_2018-09-27\n" +
			"4604151234_Kadine Karlsson_2018-01-09\n" +
			"9110261234_Liu Lingren_2018-02-15\n" +
			"7907281234_Mitsuko Mayotte_2018-12-22\n" +
			"7805211234_Nahema Ninsson_2020-08-04";
		
		userName =
			"Fritjoff Flacon";
		
		userNumber =
			"7911061234";
		
		
		baseFileContentHolder = AdaptFileFormatForCustomers.writeToFile(baseFileContent1);
		compareFileAL = AdaptFileFormatForCustomers.readFromFile(baseFileContentHolder);
		compareFileAL = removeFromFile.breakUpAndReassembleFile(compareFileAL, userName, 0);
		compareFileAL.remove(1);
		comparer = AdaptFileFormatForCustomers.arrayListToString(compareFileAL);
		assertTrue(comparer.equals(baseFileContent2));


		
		baseFileContentHolder = AdaptFileFormatForCustomers.writeToFile(baseFileContent1);
		compareFileAL = AdaptFileFormatForCustomers.readFromFile(baseFileContentHolder);
		compareFileAL = removeFromFile.breakUpAndReassembleFile(compareFileAL, userNumber, 1);
		compareFileAL.remove(1);
		comparer = AdaptFileFormatForCustomers.arrayListToString(compareFileAL);
		
		
		assertTrue(comparer.equals(baseFileContent2));
		
	}
	
	
	
	@Test
	void removeCustomUser2()
	{
		String
			baseFileContent1 ,
			baseFileContent2 ,
			baseFileContentHolder ,
			comparer ,
			userName ,
			userNumber;
		
		ArrayList <String> compareFileAL = new ArrayList <String>(14);
		
		
		baseFileContent1 =
			"7603021234_Alhambra Aromes_2019-07-01\n" +
			"8104021234_Bear Belle_2018-12-02\n" +
			"8512021234_Chamade Coriola_2017-03-12\n" +
			"7608021234_Diamanda Djedi_2020-01-30\n" +
			"7605021234_Elmer Ekorrsson_2010-04-07\n" +
			"7911061234_Fritjoff Flacon_1999-12-16\n" +
			"7512166544_Greger Ganache_2020-03-23\n" +
			"5711121234_Hilmer Heur_2019-08-18\n" +
			"8906138493_Ida Idylle_2017-03-07\n" +
			"9902149834_Jicky Juul_2018-09-27\n" +
			"4604151234_Kadine Karlsson_2018-01-09\n" +
			"9110261234_Liu Lingren_2018-02-15\n" +
			"7907281234_Mitsuko Mayotte_2018-12-22\n" +
			"7805211234_Nahema Ninsson_2020-08-04\n";
		
		baseFileContent2 =
			"7603021234_Alhambra Aromes_2019-07-01\n" +
			"8104021234_Bear Belle_2018-12-02\n" +
			"8512021234_Chamade Coriola_2017-03-12\n" +
			"7608021234_Diamanda Djedi_2020-01-30\n" +
			"7605021234_Elmer Ekorrsson_2010-04-07\n" +
			"7911061234_Fritjoff Flacon_1999-12-16\n" +
			"7512166544_Greger Ganache_2020-03-23\n" +
			"5711121234_Hilmer Heur_2019-08-18\n" +
			"8906138493_Ida Idylle_2017-03-07\n" +
			"4604151234_Kadine Karlsson_2018-01-09\n" +
			"9110261234_Liu Lingren_2018-02-15\n" +
			"7907281234_Mitsuko Mayotte_2018-12-22\n" +
			"7805211234_Nahema Ninsson_2020-08-04";
		
		userName =
			"Jicky Juul";
		
		userNumber =
			"9902149834";
		
		
		baseFileContentHolder = AdaptFileFormatForCustomers.writeToFile(baseFileContent1);
		compareFileAL = AdaptFileFormatForCustomers.readFromFile(baseFileContentHolder);
		compareFileAL = removeFromFile.breakUpAndReassembleFile(compareFileAL, userName, 0);
		compareFileAL.remove(1);
		comparer = AdaptFileFormatForCustomers.arrayListToString(compareFileAL);
		
		
		assertTrue(comparer.equals(baseFileContent2));
		
		
		
		baseFileContentHolder = AdaptFileFormatForCustomers.writeToFile(baseFileContent1);
		compareFileAL = AdaptFileFormatForCustomers.readFromFile(baseFileContentHolder);
		compareFileAL = removeFromFile.breakUpAndReassembleFile(compareFileAL, userNumber, 1);
		compareFileAL.remove(1);
		comparer = AdaptFileFormatForCustomers.arrayListToString(compareFileAL);
		
		
		assertTrue(comparer.equals(baseFileContent2));
		
	}
	
}