
package paying;

//CHANGES ARE REQUIRED IN THIS FILE!!!!

// THIS FILE WAS USED IN LAB 6 AND WILL BE REUSED NOW IN LAB 7

//LAB 7 - CST8284
//LAB 7  SOLUTION: CommissionWaiter.java
//CommissionWaiter class extends Waiter.

public class CommissionWaiter extends Waiter  {
private double grossSales; // gross weekly sales
private double commissionRate; // commission percentage

//constructor
public CommissionWaiter(String firstName, String lastName, 
 String socialSecurityNumber, double grossSales, 
 double commissionRate) {
 super(firstName, lastName, socialSecurityNumber);

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

//set gross sales amount
public void setGrossSales(double grossSales) {
 if (grossSales < 0.0) { // validate
    throw new IllegalArgumentException("Gross sales must be >= 0.0");
 }

 this.grossSales = grossSales;
} 

//return gross sales amount
public double getGrossSales() {
 return grossSales;
} 

//set commission rate
public void setCommissionRate(double commissionRate) {
 if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
    throw new IllegalArgumentException(
       "Commission rate must be > 0.0 and < 1.0");
 }

 this.commissionRate = commissionRate;
} 

//return commission rate
public double getCommissionRate() {
 return commissionRate;
} 

//calculate earnings; override abstract method earnings in Waiter
@Override                                                           
public double getPaymentAmount() {                                            
 return getCommissionRate() * getGrossSales();                    
}                                             

//return String representation of CommissionWaiter object
@Override                                                   
public String toString() {                                    
 return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",    
    "commission waiter", super.toString(),              
    "gross sales", getGrossSales(),                       
    "commission rate", getCommissionRate());             
} 
}


