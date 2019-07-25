/**
 * Name: Kevin Chu
 * Date: 7/21/19
 * Project: CIS 18A Final Project
 */
public class Sub implements SubInfo
{
  private double cost; //the cost of the pizza
  private String bread; //the type of bread
  private int size; //the length of sub in inches
  private int numextras; //the number of extras
  private String extraList; //a list of the extras

//Constructor creates a standard 6" Sub
  public Sub()
  {
    cost = 4.99;
    bread = "Italian";
    numextras = 0;
    extraList = null;
    size = 6;

  }
//adds the parameter amount to the cost
  public void setCost (double amount)
  {
    this.cost += amount;
  }

//sets the crust type
  public void setBread (String bread)
  {
    this.bread = bread;
  }

//changes the size of the sub in inches
  public void setSize (int size)
  {
    this.size = size;
  }

//sets the number of extras to the parameter number
  public void setNumextras(int numextras)
  {
    this.numextras = numextras;
  }

//sets the list of extras
  public void setextraList (String extraList)
  {
    this.extraList = extraList;
  }

//returns the cost of the pizza
  public double getCost()
  {
    return cost;
  }

//returns the bread type
  public String getBread()
  {
    return bread;
  }

//returns the size of the pizza
  public int getSize()
  {
    return size;
  }

//returns the number of extras
  public int getNumextras()
  {
    return numextras;
  }

//returns the list of add ons
  public String getextraList()
  {
    return extraList;
  }
}
