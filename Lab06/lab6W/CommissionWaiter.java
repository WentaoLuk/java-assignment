
package lab6W;

/** CommissionWaiter.java
* CommissionWaiter class extends Waiter.
* You do not have to modify this file.
* You need to understand this file to be able to complete your tasks.
*/

public class CommissionWaiter extends Waiter { 
private double grossSales; // gross weekly sales
private double commissionRate; // commission percentage

// constructor
public CommissionWaiter(String firstName, String lastName, 
   String socialSecurityNumber, int month, int day, int year, 
   double grossSales, double commissionRate) {
   super(firstName, lastName, socialSecurityNumber, month, day, year);

   if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
      throw new IllegalArgumentException(
         "Commission rate must be > 0.0 and < 1.0");
   }

   if (grossSales < 0.0) { // validate
      throw new IllegalArgumentException("Gross sales must be >= 0.0");
   }

   this.grossSales = grossSales;
   this.commissionRate = commissionRate;
} 

// set gross sales amount on the treatment of patients
public void setGrossSales(double grossSales) {
   if (grossSales < 0.0) { // validate
      throw new IllegalArgumentException("Gross sales must be >= 0.0");
   }

   this.grossSales = grossSales;
} 

// return gross sales amount on patient's treatment
public double getGrossSales() {
   return grossSales;
} 

// set commission rate
public void setCommissionRate(double commissionRate) {
   if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
      throw new IllegalArgumentException(
         "Commission rate must be > 0.0 and < 1.0");
   }

   this.commissionRate = commissionRate;
} 

// return commission rate
public double getCommissionRate() {
   return commissionRate;
} 

// calculate earnings; override abstract method earnings in Waiter
@Override                                                           
public double earnings() {                                            
   return getCommissionRate() * getGrossSales();                    
}                                             

// return String representation of CommissionWaiter object
@Override                                                   
public String toString() {                                    
   return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",    
      "commission Waiter", super.toString(),              
      "gross sales", getGrossSales(),                       
      "commission rate", getCommissionRate());             
} 
}
