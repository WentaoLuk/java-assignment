
package paying;


//CHANGES ARE REQUIRED IN THIS FILE!!!!
 
//THIS FILE WAS FIRST USED IN LAB 6 AND NOW REUSED IN LAB 7.

// LAB 7 - CST8284
// LAB 7: BasePlusCommissionWaiter.java
//BasePlusCommissionWaiter class extends CommissionWaiter.

public class BasePlusCommissionWaiter extends CommissionWaiter {
private double baseSalary; // base salary per week

//constructor
public BasePlusCommissionWaiter(String firstName, String lastName, 
String socialSecurityNumber, double grossSales,
double commissionRate, double baseSalary) {
super(firstName, lastName, socialSecurityNumber, 
   grossSales, commissionRate);

if (baseSalary < 0.0) { // validate baseSalary                  
   throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
}

//set base salary
public void setBaseSalary(double baseSalary) {
if (baseSalary < 0.0) { // validate baseSalary                  
   throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
} 

//return base salary
public double getBaseSalary() {
return baseSalary;
}

//calculate earnings; override method earnings in CommissionWaiter
@Override                                                            
public double getPaymentAmount() {                                           
return getBaseSalary() + super.getPaymentAmount();                        
} 

//return String representation of BasePlusCommissionWaiter object
@Override                                                           
public String toString() {                                            
return String.format("%s %s; %s: $%,.2f",                       
   "base-salaried", super.toString(),                            
   "base salary", getBaseSalary());                             
} 
}

