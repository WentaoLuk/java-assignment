package paying;


//LAB 7 - CST 8284
// LAB 7 Solution: SalariedWaiter.java
//SalariedWaiter class extends Waiter, which implements Payable.

//CHANGES ARE REQUIRED IN THIS FILE

public class SalariedWaiter extends Waiter  {
private double weeklySalary;

//four-argument constructor
public SalariedWaiter(String first, String last, String ssn, double salary) {
super(first, last, ssn); // pass to Waiter constructor
setWeeklySalary(salary); // validate and store salary
}

//set salary
public void setWeeklySalary(double salary) {
weeklySalary = salary < 0.0 ? 0.0 : salary;
}

//return salary
public double getWeeklySalary() {
return weeklySalary;
}

//calculate earnings; implement interface Payable method that was
//abstract in superclass Waiter
@Override
public double getPaymentAmount() {
return getWeeklySalary();
}

//return String representation of SalariedWaiter object
@Override
public String toString() {
return String.format("salaried waiter: %s\n%s: $%,.2f", 
   super.toString(), "weekly salary", getWeeklySalary());
}
}

