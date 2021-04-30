
package lab6W;

/**
*SalariedWaiter concrete class extends abstract class Waiter.
* You do not need to modify this file.
* You need to understand how the code here works to be able to complete your tasks. 
*/

public class SalariedWaiter extends Waiter {
private double weeklySalary;

// constructor
public SalariedWaiter(String firstName, String lastName, 
   String socialSecurityNumber, int month, int day, int year, 
   double weeklySalary) {
   super(firstName, lastName, socialSecurityNumber, month, day, year); 

   if (weeklySalary < 0.0) {
      throw new IllegalArgumentException( //reporting error message with modified content
         "Weekly salary must be >= 0.0");
   }

   this.weeklySalary = weeklySalary;
} 

// set salary
public void setWeeklySalary(double weeklySalary) {
   if (weeklySalary < 0.0) {
      throw new IllegalArgumentException(
         "Weekly salary must be >= 0.0");
   }

   this.weeklySalary = weeklySalary;
} 

// return salary
public double getWeeklySalary() {
   return weeklySalary;
} 

// calculate earnings; override abstract method earnings in Waiter
@Override                                                           
public double earnings() {                                          
   return getWeeklySalary();                                        
}                                             

// return String representation of SalariedWaiter object   
@Override                                                    
public String toString() {                                     
   return String.format("salaried Waiter: %s%n%s: $%,.2f",
      super.toString(), "weekly salary", getWeeklySalary());
} 
}
