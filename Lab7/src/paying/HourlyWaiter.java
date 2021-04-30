
package paying;


// LAB 7 - CST8284 - HourlyWaiter.java
// HourlyWaiter class extends Waiter.

// SOME MODIFICATIONS ARE REQUIRED IN THIS FILE!!!

public class HourlyWaiter extends Waiter {
private double wage; // wage per hour
private double hours; // hours worked for week

//constructor
public HourlyWaiter(String firstName, String lastName,
 String socialSecurityNumber, double wage, double hours) {
 super(firstName, lastName, socialSecurityNumber);

 if (wage < 0.0) { // validate wage
    throw new IllegalArgumentException(
       "Hourly wage must be >= 0.0");
 }

 if ((hours < 0.0) || (hours > 168.0)) { // validate hours
    throw new IllegalArgumentException(
       "Hours worked must be >= 0.0 and <= 168.0");
 }

 this.wage = wage;
 this.hours = hours;
} 

//set wage
public void setWage(double wage) {
 if (wage < 0.0) { // validate wage
    throw new IllegalArgumentException(
       "Hourly wage must be >= 0.0");
 }

 this.wage = wage;
} 

//return wage
public double getWage() {
 return wage;
} 

//set hours worked
public void setHours(double hours) {
 if ((hours < 0.0) || (hours > 168.0)) { // validate hours
    throw new IllegalArgumentException(
       "Hours worked must be >= 0.0 and <= 168.0");
 }

 this.hours = hours;
} 

//return hours worked
public double getHours() {
 return hours;
} 

//calculate earnings; override abstract method earnings in Waiter
@Override                                                           
public double getPaymentAmount() {                                          
 if (getHours() <= 40) { // no overtime                           
    return getWage() * getHours();     
 }
 else {                                                             
    return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
 }
}                                          

//return String representation of HourlyWaiter object              
@Override                                                             
public String toString() {
 return String.format("hourly waiter: %s%n%s: $%,.2f; %s: %,.2f",
    super.toString(), "hourly wage", getWage(),                     
    "hours worked", getHours());                                   
}                                    
}


