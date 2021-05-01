package newTest;

//package lab4;

import java.util.logging.Logger;


/**
   * You just got recruited as a supervisor in a MoneyMart outlet in Kingston, Ontario. Congratulations. 
   * Your money mart totals up sales and computes change due to customers when they come to purchase items.
   * You deal with all kinds of currencies and need to always relate the value of any amount given to different currency values.
   * The code below represents part of your operations.
   * Ensure to review this code to understand it so you can update and learn as required.
   * This class is called MoneyMart.
   * Javadoc style comments have been included in this code file. Do the same for the Test code file.
*/
public class MoneyMart
{
   public static final double POUNDS_VALUE = 0.25;
   public static final double EUROS_VALUE = 0.1;
   public static final double DOLLARS_VALUE = 0.05;
   public static final double NAIRA_VALUE = 0.01;

   private double purchase;
   private double payment;

   /**
      This section of the code constructs money mart with no money in it.
   */
   public MoneyMart()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      This section of the code records the purchase price of an item.
      @param amount the price of the purchased currency
   */
   
   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }
   
   /**
      This section of the code enters the payment received from the customer.
      @param kobo the number of kobo in the payment
      @param pounds the number of pounds in the payment
      @param euros the number of euros in the payment
      @param dollars the number of dollars in the payment
      @param naira the number of naira in the payment
   */
   
   public void receivePayment(int kobo, int pounds, 
         int euros, int dollars, int naira)
   {
      payment = kobo + pounds * POUNDS_VALUE + euros * EUROS_VALUE
            + dollars * DOLLARS_VALUE + naira * NAIRA_VALUE;
   }
   
   /**
      This section of the code calculates the change due (represented in different currencies) and resets the machine for the next customer.
      @return the change due to the customer
   */
   
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }
}

