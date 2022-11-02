/*
 *TestingUserInput Class
 * @author Tebogo Rammutla
 */

// Importing necessary classes to help with project
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Testing user input Class
 */
public class TestingUserInput 
{
	/**
	 * TestingUserInput
	 * @param format the string date format
	 * @param value the string date format
	 * @param locale the locale
	 * @return boolean boolean of whether input entered is valid date format
	 */ 
	public static boolean isValidFormat(String format, String value, Locale locale) 
    	{
			LocalDateTime ldt = null;
			DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);
			try 
				{
					ldt = LocalDateTime.parse(value, fomatter);
					String result = ldt.format(fomatter);
					return result.equals(value);
				}
			catch (DateTimeParseException e) 
				{
					try 
						{
							LocalDate ld = LocalDate.parse(value, fomatter);
							String result = ld.format(fomatter);
							return result.equals(value);
						} 
					catch (DateTimeParseException exp)
						{
							try 
								{
									LocalTime lt = LocalTime.parse(value, fomatter);
									String result = lt.format(fomatter);
									return result.equals(value);
								} 
							catch (DateTimeParseException e2) 
								{
								}
						}
				}
			return false;
    	}
	
	
	  /**
     * IsNumeric
     * @param string the string to test if its numeric
     * @return boolean boolean of whether input entered is numeric
     */ 
    public static boolean isNumeric(String string) 
    {
        Double doubleValue;	 
        try
        {
            // If what the user has entered as a number can be converted to be an integer,return true
            doubleValue = Double.parseDouble(string);
            return true;
        } 
        catch (NumberFormatException e) 
        {
            // If what the user has typed as a number cannot be converted to integer,display a message
            System.out.println(string + " is invalid,either you have put a currecy symbol or not supplied a valid number!! ");
        }
        // Return false if what the user has entered cannot be converted to an integer
        return false; 
    }

}
