/**
 * Name: Kevin Chu
 * Date: 7/21/19
 * Project: CIS 18A Final Project
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
//imports packages needed to streamline the project.
public class SubCost
{
  public static void main (String [] args)
  {
    //Create a Scanner object to read input
    Scanner type = new Scanner (System.in);

    //Create a Random object for the order number at checkout
    Random num = new Random();

    //Create an instance of a Sub
    Sub order = new Sub();

    final double TAX_RATE = .10;//sales tax rate
    double tax; //amount of tax
    char choice; //users choice
    String input; //user input
    String extras = "";//list of extras
    int numberOfextras = 0; //number of extras
    String Code;//discount code
    String Name; //user's first and last name
    boolean discount = false;//defaults discount to false.
    int inches; //size of the sub
    char breadType; //type of bread selected
    double cost; //cost of the sub

    System.out.println("Welcome to Joe's World Famous Sub Emporium");
    System.out.print("Enter your first and last name: ");
    Name = type.nextLine();//allows user to type their name.

    System.out.print("Please enter a discount code if you have one, otherwise press ENTER: ");
    Code = type.nextLine();

    //give discounts to employees
    if (  (Code.equalsIgnoreCase("employee")) || (Code.equalsIgnoreCase("brokestudent")) || (Code.equalsIgnoreCase("CIS-18A"))  )
    {
      discount = true;
      System.out.print("Valid discount code entered, press ENTER to continue with your order. ");
    }
    else{
      System.out.println("Invalid code entered, press ENTER to continue with your order.");
    }
    type.nextLine();

    //prompt user and get sub size choice
    System.out.println("Sub Size (inches) Cost");
    System.out.println(" 6 $4.99");
    System.out.println(" 8 $5.99");
    System.out.println(" 10 $6.99");
    System.out.println(" 12 $7.99");
    System.out.println("What size sub would you like?");
    System.out.print("6, 8, 10, or 12 : ");
    inches = type.nextInt();

    //set custom prices for sub depending on the size that is ordered
    if (inches == 8){
      order.setSize(8);
      order.setCost(1);
    }
    else if (inches == 10){
      order.setSize(10);
      order.setCost(2);
    }
    else if (inches == 12){
      order.setSize(12);
      order.setCost(3);
    }
    else{
      System.out.println("Invalid input: Defaulting to 6 inch sub");
    }

    type.nextLine();
    //prompt user and get bread choice
    System.out.println("Choose from the following bread:");

    for(int i=0; i<3; i++){
      String[] bread = new String[3];//creates a string array with 3 elements
      bread[0] = "(I) Italian";
      bread[1] = "(W) Whole-Grain";
      bread[2] = "(H) Honey Wheat";
      System.out.println(bread[i]+ ",");
    }
    System.out.print("(Enter I, W, or H): ");

    input = type.nextLine();
    breadType = Character.toUpperCase(input.charAt(0));

    switch (breadType)
    {
      case 'I': order.setBread("Italian");
      break;
      case 'W': order.setBread("Whole-Grain");
      break;
      case 'H': order.setBread("Honey Wheat");
      break;
      default: order.setBread("Invalid selection: Using Italian Bread");
      break;
    }

    //prompt user and get add on choices one at a time
    System.out.println("All subs come with Black Forest Ham.");
    System.out.println("Additional extras are $0.50 each, choose from: ");
    System.out.println("Red Onions, Lettuce, Olives, Tomato");

    //if a extra is desired, add it to extra list and number of extras
    System.out.print("Do you want Red Onions? (Y/N): ");
    input = type.nextLine();
    choice = Character.toUpperCase(input.charAt(0));
    if (choice == 'Y')
    {
      numberOfextras += 1;
      extras = extras + "Red Onions || ";
    }

    System.out.print("Do you want Lettuce? (Y/N): ");
    input = type.nextLine();
    choice = Character.toUpperCase(input.charAt(0));
    if (choice == 'Y')
    {
      numberOfextras += 1;
      extras = extras + "Lettuce || ";
    }
    System.out.print("Do you want Olives? (Y/N): ");
    input = type.nextLine();
    choice = Character.toUpperCase(input.charAt(0));
    if (choice == 'Y')
    {
      numberOfextras += 1;
      extras = extras + "Olives || ";
    }
    System.out.print("Do you want Tomato? (Y/N): ");
    input = type.nextLine();
    choice = Character.toUpperCase(input.charAt(0));
    if (choice == 'Y')
    {
      numberOfextras += 1;
      extras = extras + "Tomato. ";
    }
    //set number of extras and extra list on sub ordered
    order.setNumextras(numberOfextras);
    order.setextraList(extras);

    //add additional extras cost to cost of sub
    order.setCost(0.50*numberOfextras);

    System.out.println();
    System.out.println("Thank you " + Name + " for choosing Joe's!");
    System.out.println("Your order is as follows: ");
    System.out.println(order.getSize() + " inch sub");
    System.out.println(order.getBread() + " bread");
    System.out.println("Extras: " + order.getextraList());
    //display cost of sub
    cost = order.getCost();

    if (discount == true)
    {
      System.out.println("You get a $2 discount!");
      order.setCost((-2));
      cost = order.getCost();
    }

    //Creates format that truncates double values for price to stay at 2 decimal places
    DecimalFormat df = new DecimalFormat("##.00");


    System.out.println("The cost of your order is: $" + df.format(cost));
    tax = (cost * TAX_RATE);
    System.out.println("The tax is: $" + df.format(tax));
    System.out.println("The total due is: $" + df.format((tax+cost)));
    System.out.println("Your order number is " + num.nextInt(100)+  " and will be called for pickup shortly.");
    System.out.println("Condiments are avaiable at every table and use as much as you need.");
    System.out.println("Have a great day!");
  }
}
