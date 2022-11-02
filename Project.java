/*
 *Project Class
 * @author Tebogo Rammutla
 */

/**
  * Project Class
  */
public class Project 
{
    //Properties of Project class
    private String projectNumber;
    private String projectName;
    private String buildingType;
    private String physicalAddress;
    private String erfNumber;
    private String projectTotalFee;
    private String totalAmountPaidToDate;
    private String projectDeadlineDate; 
    
    /**
     * Constructor of Project Class
     * @param projectNumber the project number to set
     * @param projectName the project name to set
     * @param buildingType the project building type to set
     * @param physicalAddress the architect project physical address to set
     * @param erfNumber the architect erf number to set
     * @param projectTotalFee the project total fee to set
     * @param totalAmountPaidToDate the project total amount paid to date to set
     * @param projectDeadlineDate the project deadline date to set
     
     */
    public  Project(String projectNumber,String projectName,String buildingType,String physicalAddress,String erfNumber,String projectTotalFee,String totalAmountPaidToDate,String projectDeadlineDate)
    {
                ////Projec_Details class 's constructor initialising class properties
                this.setProjectNumber(projectNumber);
                this.projectName = projectName;
                this.buildingType = buildingType;
                this.physicalAddress = physicalAddress;
                this.erfNumber = erfNumber;
                this.projectTotalFee = projectTotalFee;
                this.totalAmountPaidToDate = totalAmountPaidToDate;
                this.projectDeadlineDate = projectDeadlineDate; 
    }

    /**
     * @return total the otalAmountPaidToDate 
     */
    public double getTotalAmountPaidToDate() {
    	double totalAmountPaid = Double.parseDouble(totalAmountPaidToDate);
        return totalAmountPaid;
    }
    
    /**
     * @return totalProjectFee the totalProjectFee 
     */
    public double getProjectTotalFee() {
    	double totalProjectFee = Double.parseDouble(this.projectTotalFee);
        return totalProjectFee;
    }

    /**
     * @param totalAmountPaidToDate totalAmountPaidToDate to set
     */
    public void setTotalAmountPaidToDate(String totalAmountPaidToDate) {
        this.totalAmountPaidToDate = totalAmountPaidToDate;
    }
    /**
     * @return double Total amount Customer Still has To Pay 
     */
    public double getTotalAmountCustomerStillHasToPay() {
        double amountCustomerStillToPay = this.getProjectTotalFee() - this.getTotalAmountPaidToDate();
        return amountCustomerStillToPay;
    }
    
        /**
     * @return projectDeadlineDate return the projectDeadlineDate
     */
    public String getProjectDeadlineDate() {
        return projectDeadlineDate;
    }

    /**
     * @param projectDeadlineDate the projectDeadlineDate to set
     */
    public void setProjectDeadlineDate(String projectDeadlineDate) {
        this.projectDeadlineDate = projectDeadlineDate;
    }
    //toString methods to display object 's data
    /**
     * toString
     * @return String String object
     */ 
    public String toString()
    {
        
        
        String projectDetails;
               projectDetails = "\nProject number : " + getProjectNumber()
                + "\nProject name : " + projectName
                + "\nProject building type : " + buildingType
                + "\nProject pysical address : " + physicalAddress
                + "\nErf number : " + erfNumber 
                + "\nProject total fee : R " + projectTotalFee                
                + "\nTotal amount paid to date : R " + this.totalAmountPaidToDate
                + "\nProject deadline date : " + this.projectDeadlineDate + "\n";  
        
        return projectDetails;
                
    }
   
    /**
     * getProjectName
     * @return String projectName
     */ 
    public String getProjectName()
    {
        return this.projectName;
    }
    
    /**
     * setProjectName
     * @param String projectName
     */ 
    
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

	public String getProjectNumber() {
		return projectNumber;
	}

	private void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
    
}
