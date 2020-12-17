package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author mga
 */
public class Holiday {

    /**
     *
     */
    protected Calendar startDate;

    /**
     *
     */
    protected int noOfDays;
    
    /**
     *
     * @param startDate
     * @param noOfDays
     */
    public Holiday(Calendar startDate, int noOfDays) {
        this.startDate = startDate;
        this.noOfDays = noOfDays;
    }
    
    /**
     *
     * @return
     */
    public Calendar getStartDate() {
        return this.startDate;
    }
    
    /**
     *
     * @param startDate
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
    
    /**
     *
     * @return
     */
    public int getNoOfDays() {
        return this.noOfDays;
    }
    
    /**
     *
     * @param noOfDays
     */
    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }
    
    /**
     *
     * @return
     */
    protected String getFormattedStartDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.startDate.getTime());
        return dateString;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Start Date: " + getFormattedStartDate() +
               " Days: " + Integer.toString(this.noOfDays) + "\n";
    }
}
