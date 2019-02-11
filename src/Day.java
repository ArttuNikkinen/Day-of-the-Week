import java.util.Scanner;

public class Day
{
    public static void main (String [] args)
    {
        String[] days = {"saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"};
        String date = askDate();

        //Checking if the given date is proper length
        if(date.length() > 8)
        {
            System.out.println("The date you gave was too long. Try again");
            date = askDate();
        }

        if(date.length() < 8)
        {
            System.out.println("The date you gave was too short. Try again");
            date = askDate();
        }


        System.out.println("On " + dateFormat(date) + " the day was: " + days[ZellerAlgorithm(date)]);


    }

    public static String askDate()
    {
        System.out.println("Give the date using DD/MM/YYYY format. Please don't use '.' or '/' to separate parts of the date");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        return date;
    }

    public static int ZellerAlgorithm(String date)
    {
        //Saving the parts of the date for Zeller's algorithm
        String d = String.valueOf(date.charAt(0) + String.valueOf(date.charAt(1)));
        String m = String.valueOf(date.charAt(2) + String.valueOf(date.charAt(3)));
        String y1 = String.valueOf(date.charAt(4) + String.valueOf(date.charAt(5)));
        String y2 = String.valueOf(date.charAt(6) + String.valueOf(date.charAt(7)));

        int day = Integer.parseInt(d);
        int month = Integer.parseInt(m);
        int yearTwoFirst = Integer.parseInt(y1);
        int yearTwoLast = Integer.parseInt(y2);
        
        //Zeller's algorithm counts january and february as 13th and 14th month of the previous year
       if(month == 1)
           month = 13;

       if(month == 2)
           month = 14;

       //This is the Zeller's congruence. For more information visit: https://en.wikipedia.org/wiki/Zeller%27s_congruence
        int dateIndex = (
                (day + ((((month+1)*26))/10)
                + yearTwoLast
                + (yearTwoLast/4)
                + (yearTwoFirst/4)
                - 2*yearTwoFirst)%7
                        );

        //For some reason when the month is either january or february the dateIndex variable
        //seems to be one (1) too high. This if-clause is used to fix the issue for the time being
        if (month == 13 || month == 14)
            dateIndex = dateIndex - 1;

       return dateIndex;

    }

    public static String dateFormat(String date)
    {
        String d = String.valueOf(date.charAt(0) + String.valueOf(date.charAt(1)));
        String m = String.valueOf(date.charAt(2) + String.valueOf(date.charAt(3)));
        String y1 = String.valueOf(date.charAt(4) + String.valueOf(date.charAt(5)));
        String y2 = String.valueOf(date.charAt(6) + String.valueOf(date.charAt(7)));

        return d + "." + m + "." + y1 + y2;
    }
}
