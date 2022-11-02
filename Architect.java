/*
 *Project Architect Class
 * @author Tebogo Rammutla
 */

/**
  * Architect Class
  */
public class Architect 
{
    //Properties of Architect class
    private String name;
    private String surname;
    private String telephoneNumber;
    private String emailAddress;
    private String physicalAddress;
    
    /**
     * Constructor of Architect Class
     * @param name the architect name to set
     * @param surname the architect surname to set
     * @param telephoneNumber the architect telephoneNumber to set
     * @param emailAddress the architect email address to set
     * @param physicalAddress the architect physical address to set
     */
    public Architect(String name,String surname,String telephoneNumber,String emailAddress,String physicalAddress )
    {        
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;   
    
    }  
    
        /**
         * toString
         * @return customer string object
         */ 
    public String toString()
    {
        
        String customer = "\nArchitect name : " + name
                + "\nArchitect surname : " + surname
                + "\nArchitect telephone number : " + telephoneNumber
                + "\nArchitect email_address : "  + emailAddress
                + "\nArchitect physical_address : " + physicalAddress + "\n";
        return customer;
    } 
}
