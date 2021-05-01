
package paying;

// LAB 7: PayableInterfaceTest.java

// This code tests the interface Payable.

public class PayableInterfaceTest  {
public static void main(String[] args) {

// TO DO: IN THIS PORTION OF THE CODE, SEVERAL CHANGES SHOULD BE MADE:
// TO DO: CREATE SIX-ELEMENTS Payable array HERE */

//START CODE 

	
	Invoice invoice1 = new Invoice("45343", "break", 3, 350);
	Invoice invoice2 = new Invoice("85634 ", "pedal", 5, 60.99);
	SalariedWaiter salariedWaiter = new SalariedWaiter("Ada", "Chukwu", "345-67-8901", 610);
	HourlyWaiter hourlyWaiter = new HourlyWaiter("Blessing", "Oluwa", "234-56-7890", 18.95, 40);
	CommissionWaiter commissionWaiter = new CommissionWaiter("Peter ", "John", "123-45-6789", 275000.00, 0.44);
	BasePlusCommissionWaiter basePlusCommissionWaiter = new BasePlusCommissionWaiter("Itunu", "Ebere", "102-34-5678", 2500, 0.04, 720);
	
	
//END CODE
 
// TO DO: POULATE THE ARRAY YOU CREATED WITH OBJECTS THAT IMPLEMENT Payable
//CHECK THE OUTPUT FILE AND REUSE EXACTLY THE DETAILS PROVIDED SUCH AS FIRST NAME
// LAST NAME, SOCIAL INSURANCE NUMBER, ETC.

 // START CODE
	
	Payable payableObjects[] = {invoice1,invoice2,salariedWaiter,hourlyWaiter,
			commissionWaiter,basePlusCommissionWaiter};
		
// END CODE

 System.out.println(
    "Invoices and Waiters are processed polymorphically:\n"); 

 // generically process each element in array payableObjects
 for (Payable currentPayable : payableObjects) {
    // output currentPayable and its appropriate payment amount
    System.out.printf("%s \n", currentPayable.toString()); 
       
    if (currentPayable instanceof BasePlusCommissionWaiter) {
       // downcast Payable reference to 
       // BasePlusCommissionWaiter reference
       BasePlusCommissionWaiter waiter = 
          (BasePlusCommissionWaiter) currentPayable;

       double oldBaseSalary = waiter.getBaseSalary();
       waiter.setBaseSalary(1.10 * oldBaseSalary);
       System.out.printf(
          "new base salary with 10%% increase is: $%,.2f\n",
          waiter.getBaseSalary());
    } 

// TO DO: INSERT YOUR PRINT STATEMENT HERE: ENSURE THAT YOUR 
// OUTPUT FOLLOWS THE OUTPUT SAMPLE PROVIDED

         
    System.out.printf("payment due: $%,.2f%n%n",currentPayable.getPaymentAmount());
    
    
// START CODE 

// END CODE

    
 }
}
}


