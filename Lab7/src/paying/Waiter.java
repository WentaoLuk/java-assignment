
package paying;

// LAB 7 - CST8284 - Waiter superclass - Waiter.java
//Waiter abstract superclass implements Payable.

// TO DO: CHECK TO SEE THE COMMENTED PORTION OF THIS CODE TO UPDATE THEM.

public abstract class Waiter implements Payable {
private String firstName;
private String lastName;
private String socialSecurityNumber;

//three-argument constructor
public Waiter(String first, String last, String ssn) {
 firstName = first;
 lastName = last;
 socialSecurityNumber = ssn;
}

/** CHANGES ARE REQUIRED IN THIS SECTION. 
* THINK OF THE BEST WAY TO ACCESS PRIVATE VARIABLES.
* IN THIS PORTION OF YOUR CODE INCLUDE ALL OF SUCH THAT APPLIES.
*/

//START CODE
public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getSocialSecurityNumber() {
	return socialSecurityNumber;
}

public void setSocialSecurityNumber(String socialSecurityNumber) {
	this.socialSecurityNumber = socialSecurityNumber;
}






// END CODE

//return String representation of Waiter object
@Override
public String toString() {
 return String.format("%s %s\nsocial security number: %s", 
    getFirstName(), getLastName(), getSocialSecurityNumber());
}


//Note: We do not implement Payable method getPaymentAmount here so  
//this class must be declared abstract to avoid a compilation error.
} 

