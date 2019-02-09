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


        System.out.println("On " + date + " the day was: " + days[ZellerAlgorithm(date)]);


    }

    public static String askDate()
    {
        System.out.println("Give the date using DD/MM/YYYY format");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        return date;
    }

    public static int ZellerAlgorithm(String date)
    {
        //TODO: FIX THIS!!! YOU CANNOT CONVERT INTO INT USING CHARAT FUNCTION. PLEASE CHECK FOR THE PROPER FUNCTION
        //Saving the parts of the date for Zeller's algorithm
        int day = date.charAt(0) + date.charAt(1);
        int month = date.charAt(2) + date.charAt(3);
        int yearTwoFirst = date.charAt(4) + date.charAt(5);
        int yearTwoLast = date.charAt(6) + date.charAt(7);

        System.out.println(day + " " + month + " " + yearTwoFirst + " " + yearTwoLast);

       /* //Here we check if the first digit of the date is '0'
        if(Integer.parseInt(Integer.toString(day).substring(0, 1)) == 0)
        {
            day = Integer.parseInt(Integer.toString(day).substring(0, 2));
        }


        //Here we check if the first digit of the month is '0'
        if(Integer.parseInt(Integer.toString(month).substring(0, 1)) == 0)
        {
            day = Integer.parseInt(Integer.toString(month).substring(0, 2));
        }*/

       if(month == 1)
           month = 13;

       if(month == 2)
           month = 14;

        int dateIndex = (
                (day + ((((month+1)*26))/10)
                + yearTwoLast
                + (yearTwoLast/4)
                + (yearTwoFirst/4)
                - 2*yearTwoFirst)%7
                        );

        return dateIndex;
    }
}
