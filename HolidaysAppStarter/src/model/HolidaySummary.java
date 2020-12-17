package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author mga
 */
public class HolidaySummary {
    final private int employeeId;
    private int holidayAllowance;
    private int holidaysLeft;
    private List<Holiday> employeeHolidays;
    
    /**
     *
     * @param employeeId
     * @param holidayAllowance
     */
    public HolidaySummary(int employeeId, int holidayAllowance) {
        this.employeeId = employeeId;
        this.holidayAllowance = holidayAllowance;
        this.holidaysLeft = holidayAllowance;
        this.employeeHolidays = new ArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    /**
     *
     * @return
     */
    public int getHolidayAllowance() {
        return this.holidayAllowance;
    }
    
    /**
     *
     * @param holidayAllowance
     */
    public void setHolidayAllowance(int holidayAllowance) {
        this.holidayAllowance = holidayAllowance;
    }
    
    /**
     *
     * @return
     */
    public int getHolidaysLeft() {
        return this.holidaysLeft;
    }
    
    /**
     *
     * @param holidaysLeft
     */
    public void setHolidaysLeft(int holidaysLeft) {
        this.holidaysLeft = holidaysLeft;
    }
    
    /**
     *
     * @return
     */
    public List<Holiday> getEmployeeHolidays() {
        return this.employeeHolidays;
    }
    
    /**
     *
     * @param startDate
     * @param noOfDays
     */
    public void bookHoliday(Calendar startDate, int noOfDays) {
        if (noOfDays <= this.holidaysLeft) {
            this.employeeHolidays.add(new Holiday(startDate, noOfDays));
            this.holidaysLeft -= noOfDays;
        }
    }

    /**
     *
     * @param startDate
     * @param noOfDays
     * @param justification
     */
    public void bookHoliday(Calendar startDate, int noOfDays, String justification) {
        if (noOfDays <= this.holidaysLeft)      
            this.employeeHolidays.add(new ExtraDay(startDate, noOfDays, justification));    
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "Employee Id: " + Integer.toString(this.employeeId) +
                     " Holiday Allowance: " + Integer.toString(this.holidayAllowance) +
                     " Holidays Left: " + Integer.toString(this.holidaysLeft) + "\n";
        for (Holiday holiday : this.employeeHolidays)
            str += holiday.toString();
        return str;
    }
}
