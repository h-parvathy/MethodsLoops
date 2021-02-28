import javax.swing.*;
import java.util.Locale;

public class assignment4 {
    /**
     * Validates whether Username or Password correct
     * @param username - the login username given by user
     * @param password - the login password given by user
     * @return -status, boolean
     */
    public static boolean isValid(String username, String password) {
        boolean status = false;
        if (username.equals("willMark101") && password.equals("will12345"))
            status = true;
        return status;
    }

    /**
     * Checks the Schedule of the week
     * @param day - the day of the week
     * @return - schedule of the corresponding day
     */
    public static String schedule(String day) {
        String str;
        switch (day.toLowerCase(Locale.ROOT)) {
            case "monday":
                str = "8-10am";
                break;
            case "tuesday":
                str = "2-4pm";
                break;
            case "wednesday":
                str = "1-3pm";
                break;
            case "thursday":
                str = "No meeting";
                break;
            case "friday":
                str = "8to10am then 5 to 6pm";
                break;
            default:
                str = "Wrong input. Choose between Monday to Friday";
                break;
        }
        return str;
    }

    /**
     * Display the end schedule
     * @param str - schedule for the day
     * @param day - day of the week
     * @param flag - flag value to choose from
     */
    public static void display(String str, String day, int flag) {
        if(flag == 1){
            JFrame dis;
            dis=new JFrame();
            JOptionPane.showMessageDialog(dis,day+ " : " + str);
        }else if(flag == -1){
            JFrame err;
            err = new JFrame();
            JOptionPane.showMessageDialog(err, "You have entered wrong username or password\n" +
                    "Please try again", "Alert", JOptionPane.WARNING_MESSAGE);
        }else{
            JFrame err;
            err = new JFrame();
            JOptionPane.showMessageDialog(err, "You have entered wrong credentials \n" +
                    "EXITING SYSTEM.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int flag = 0;
        int count = 2;
        while (count > 0) {

            JFrame fname;
            fname = new JFrame();
            String name = JOptionPane.showInputDialog(fname, "Enter Username");
            String password = JOptionPane.showInputDialog(fname, "Enter Password");

            if (isValid(name, password)) {
                count = 0;
                flag = 1;
                JFrame sche;
                sche = new JFrame();
                String day = JOptionPane.showInputDialog(sche, "Enter the weekday ");
                String resSchedule = schedule(day);
                display(resSchedule, day, flag);
                break;
            } else {
                count -= 1;
                flag -= 1;
                display("Error", "error", flag);
            }

        }

    }
}
