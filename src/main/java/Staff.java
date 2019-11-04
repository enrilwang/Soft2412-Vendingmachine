import java.util.ArrayList;
import java.util.Scanner;
import snacks.BBQChips;
import snacks.Jellybeans;
import snacks.Juice;
import snacks.Lollies;
import snacks.Mars;
import snacks.OriginalChips;
import snacks.Snack;
import snacks.Sneakers;
import snacks.SourWorms;
import snacks.Water;


public class Staff {
  private int staffID;
  private int password;
  private BBQChips bbq;
  private Jellybeans jelly;
  private Juice juice;
  private Lollies lollies;
  private Mars mars;
  private OriginalChips ochip;
  private Sneakers sneakers;
  private SourWorms sourWorms;
  private Water water;

  public Staff(){
    this.staffID = 1;
    this.password = 0000;
    bbq = new BBQChips();
    jelly = new Jellybeans();
    juice = new Juice();
    lollies = new Lollies();
    mars = new Mars();
    ochip = new OriginalChips();
    sneakers = new Sneakers();
    sourWorms = new SourWorms();
    water = new Water();

  }
  public void changePrice() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      System.out.println("Do you want to change the price, 0 for yes, any number for quit");

      String in = scan.nextLine();
      if (in.equals("0")) {
        System.out.println("which one do you want to change price, type Code");
        String input = scan.nextLine();
        if (input.equals("1")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          bbq.setPrice(value);
        } else if (input.equals("2")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          jelly.setPrice(value);
        } else if (input.equals("3")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          juice.setPrice(value);
        } else if (input.equals("4")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          lollies.setPrice(value);
        } else if (input.equals("5")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          mars.setPrice(value);
        } else if (input.equals("6")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          ochip.setPrice(value);
        } else if (input.equals("7")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          sneakers.setPrice(value);
        } else if (input.equals("8")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());

          sourWorms.setPrice(value);
        } else if (input.equals("9")) {
          System.out.println("How much do you want to set");
          String input1 = scan.nextLine();
          double value = Double.valueOf(input1.toString());
          water.setPrice(value);

        }
      } else {
        break;
      }
    }
  }

  public boolean ValidStaff(){

    Scanner scan = new Scanner(System.in);
    System.out.println("Please type you ID: ");

    String input = scan.nextLine();
    if(input.equals("1")){
      System.out.println("Please type you password: ");
      String pass = scan.nextLine();
      if(pass.equals("0000")){
        return true;
      }
    }
    return false;
  }


}
