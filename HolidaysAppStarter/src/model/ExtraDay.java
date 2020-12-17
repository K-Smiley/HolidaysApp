package model;

import java.util.Calendar;

/**
 *
 * @author mga
 */
public class ExtraDay extends Holiday {
    private String justification;
    
    /**
     *
     * @param startDate
     * @param noOfDays
     * @param justification
     */
    public ExtraDay(Calendar startDate, int noOfDays, String justification) {
        super(startDate, noOfDays);
        this.justification = justification;
    }
    
    /**
     *
     * @return
     */
    public String getJustification() {
        return this.justification;
    }
    
    /**
     *
     * @param justification
     */
    public void setJustification(String justification) {
        this.justification = justification;
    }
    
    // Complete this method
    @Override
    public String toString() {
        String str= super.toString() + " Justification: " + this.justification + "\n";
        return str;
    }  
}
