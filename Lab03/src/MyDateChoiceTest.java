// Program that tests MyDateChoice class
// You are NOT required to modify any part of this code.
import java.util.Scanner;

public class MyDateChoiceTest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      int choice = getMenuChoice();
      
      while (choice != 4) {
         int month; // month of year
         int day; // day of month or day of year
         int year; // year
         String monthName; // name of month
         MyDateChoice date = new MyDateChoice(); // the date object
         
         
         switch (choice) {
            case 1:
               // format: MM/DD/YYYY
               System.out.print("Enter Month (1-12): ");
               month = input.nextInt();
               System.out.print("Enter Day of Month: ");
               day = input.nextInt();
               System.out.print("Enter Year: ");
               year = input.nextInt();
               
               date = new MyDateChoice(month, day, year);
               break;

            case 2:
               // format: Month DD, YYYY
               System.out.print("Enter Month Name: ");
               monthName = input.next();
               System.out.print("Enter Day of Month: ");
               day = input.nextInt();
               System.out.print("Enter Year: ");
               year = input.nextInt();
               
               date = new MyDateChoice(monthName, day, year);
               break;

            case 3:
               // format: DDD YYYY
               System.out.print("Enter Day of Year: ");
               day = input.nextInt();
               System.out.print("Enter Year: ");
               year = input.nextInt();
               
               date = new MyDateChoice(day, year);
               break;
         } 
         
         System.out.printf("%n%s: %s%n%s: %s%n%s: %s%n%n",
            "MM/DD/YYYY", date.toString(),
            "Month DD, YYYY", date.toMonthNameDateString(),
            "DDD YYYY", date.toDayDateString());
         
         choice = getMenuChoice();
      }
   }

   // get user choice
   private static int  getMenuChoice() {
      Scanner input = new Scanner(System.in);
      System.out.println("Click 1 for format: MM/DD/YYYY");
      System.out.println("Click 2 for format: Month DD, YYYY");
      System.out.println("Click 3 for format: DDD YYYY");
      System.out.println("Click 4 to exit");
      System.out.print("At last you can choose your own date. Select your choice of date format: ");
      int selection = input.nextInt();
      input.nextLine(); // clear newline from input
      return selection;
   }
}
