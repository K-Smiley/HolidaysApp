package controllers;

import helpers.InputHelper;
import java.util.Calendar;
import model.HolidaySummary;

/**
 *
 * @author mga
 */
public class Controller {
    private HolidaySummary holidaySummary;
    private InputHelper inputHelper;

    /**
     *
     */
    public Controller() {
        this.inputHelper = new InputHelper();
        this.holidaySummary = loadHolidaySummary();
    }

    private HolidaySummary loadHolidaySummary() {
        int empId = 1;
        int holidayAllowance = 20;
        HolidaySummary holidaySummary = new HolidaySummary(empId, holidayAllowance);
        return holidaySummary;
    }

    /**
     *
     */
    public void run() {
        boolean finished = false;

        do {
            System.out.print("\nA. Book Holiday");
            System.out.print("\tB. Display Holiday Summary");
            System.out.print("\tQ. Quit\n");
            char choice = inputHelper.readCharacter("Enter choice", "ABQ");
            switch (choice) {
                case 'A':
                	bookHoliday();
                    break;
                case 'B':
                	displayHolidaySummary();
                    break;
                case 'Q':
                    finished = true;
            }
        } while (!finished);
    }

    private void bookHoliday() {
        Calendar startDate = inputHelper.readDate("Enter Start Date", "yyyy-MM-dd");
        int noOfDays = inputHelper.readInt("Enter Number Of Days", holidaySummary.getHolidaysLeft(), 1);
        char reply = inputHelper.readCharacter("Extra Day?", "YN");
        if (reply == 'Y') {
            String justification = inputHelper.readString("Enter Justification");
            this.holidaySummary.bookHoliday(startDate, noOfDays, justification);
        }
        else {
            this.holidaySummary.bookHoliday(startDate, noOfDays);
        }
    }

    private void displayHolidaySummary() {
        System.out.println(holidaySummary);
    }
}
