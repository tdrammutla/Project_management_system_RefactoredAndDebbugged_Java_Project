/*
 *Person Class
 * @author Tebogo Rammutla
 */

/**
  * Person Class
  */
public class Person 
{   
    private Customer customer;
    private Architect architect;
    private Contractor contractor;
    
    /**
     * Constructor of Person Class
     * @param customer the customer to set
     * @param architect the architect to set
     * @param contractor the contractor to set
     */
    public Person(Customer customer,Architect architect,Contractor contractor)
    {
        this.customer = customer;
        this.contractor = contractor;
        this.architect = architect;
    }
    

    /**
     * @return contractor the contractor
     */
    public Contractor getContractor() {
        return contractor;
    }

    /**
     * @param contractor the contractor to set
     */
    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    /**
     * @return Architect the architect
     */
    public Architect getArchitect() {
        return architect;
    }

    /**
     * @param architect the architect to set
     */
    public void setArchitect(Architect architect) {
        this.architect = architect;
    }

    /**
     * @return Customer the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    
  
         
}
