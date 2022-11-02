/*
 *Project Contractor Class
 * @author Tebogo Rammutla
 */

/**
  * Contractor Class
  */
public class Contractor 
{
    // Properties of Contractor class
    private String name;
    private String surname;
    private String telephoneNumber;
    private String emailAddress;
    private String physicalAddress;
    
    /**
     * Constructor of Contractor Class
     * @param name the contractor name to set
     * @param surname the contractor surname to set
     * @param telephoneNumber the contractor telephoneNumber to set
     * @param emailAddress the contractor email address to set
     * @param physicalAddress the contractor physical address to set
     */
    public Contractor(String name,String surname,String telephoneNumber,String emailAddress,String physicalAddress )
    {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;   
    }
    
     /**
     * @return the string emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param string the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return string the telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param string the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    /**
     * toString
     * @return customer string object
     */ 
        public String toString()
    {
        String customer;
                customer = "\nContractor name : " + name
                + "\nContractor surname : " + surname
                + "\nContractor telephone number : " + getTelephoneNumber()
                + "\nContractor email_address : " + getEmailAddress()
                + "\nContractor physical_address : " + physicalAddress + "\n";
        
        return customer;
    }
        
    
}
