import java.text.DecimalFormat;
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


public class Menu {
  private VendingMachine vendingMachine;
  private Staff staff;
  private BBQChips bbq;
  private Jellybeans jelly;
  private Juice juice;
  private Lollies lollies;
  private Mars mars;
  private OriginalChips ochip;
  private Sneakers sneakers;
  private SourWorms sourWorms;
  private Water water;


  public Menu(){
    vendingMachine = new VendingMachine();
    staff = new Staff();
    bbq = new BBQChips();
    jelly = new Jellybeans();
    juice = new Juice();
    lollies = new Lollies();
    mars = new Mars();
    ochip = new OriginalChips();
    sneakers = new Sneakers();
    sourWorms = new SourWorms();
    water = new Water();

    start();
  }

  public void start(){

    Scanner scan = new Scanner(System.in);
    vendingMachine.showStock();
    vendingMachine.resetPurchase();
    while(true){
      vendingMachine.StartMenu();

      while(true){

        String input = scan.nextLine();
        cancelCheck(input);
        if(input.equals("12")){
          vendingMachine.PrintStock();
          System.out.println("continue buy ? type 0 to continue, 1 for cancel");
          String in = scan.nextLine();

          if(in.equals("0")){
            start();
          }else{
            cancelCheck("cancel");
          }
        }
        if(input.equals("11")){
          if(staff.ValidStaff()){
            staff.changePrice();

            start();
          }else{
            System.out.println("\nYou are not staff\n");
            start();
          }

        }
        System.out.println("Please input the quantity you wish to purchase.");
        String quantity = scan.nextLine();
        cancelCheck(quantity);
        if(!vendingMachine.buy(input, Integer.parseInt(quantity))){
          System.out.println("\nPlease input the product name or code of snack you wish to purchase.");
          continue;
        }
        System.out.println("Do you want to add another item? Type 0 for yes, 1 for no");
        String s = scan.nextLine();
        cancelCheck(s);
        if(s.equals("1")){
          break;
        }
        System.out.println("Please input the product name or code of snack you wish to purchase.");
      }

      //ask customer to pay. If paying with cents, divide double by 100.

      double price=Double.parseDouble(new DecimalFormat("#.##").format(vendingMachine.getTotalPrice()));
      vendingMachine.printPurchaseList();
      System.out.println("\n\nThe total price is $"+String.format("%.2f",price));
      vendingMachine.PayMethod();
      //Each time after customer enters money, it will show how much is left to be paid. If amount left is 0, it will break the loop.
      double totalPaid=0.0;
      while(scan.hasNext()){
        String input = scan.nextLine();
        if(input.length()==3){
          double amountPaid=Double.parseDouble(input.substring(0,2));
          totalPaid+=amountPaid/100;
        }else if(input.length()==2 ||input.length()==1){
          double amountPaid=Double.parseDouble(input);
          totalPaid+=amountPaid;
        }else if(input.toLowerCase().equals("cancel")){
          System.out.println("Here is your money back.\n\n\nNext customer.");
          start();
        }else{
          System.out.println("You have to pay with currency values listed above.");
        }
        DecimalFormat rounding=new DecimalFormat("#.00");
        double remainingAmount=Double.parseDouble(rounding.format(price-totalPaid));
        System.out.println("The remaining amount to be paid is: $"+remainingAmount);
        if(remainingAmount==0.0){
          System.out.println("Finished paying. Enjoy your snack.");
          vendingMachine.successfulBuy();
          System.out.println("\n\nNext customer.");
          start();
        }
        if(remainingAmount<0.0){
          System.out.println("Purchase successful. Here is your change of $"+Math.abs(remainingAmount)+" back.");
          vendingMachine.successfulBuy();
          System.out.println("\n\nNext customer.");
          start();
        }
      }

    }
  }

  //each input is checked to see if it is cancel, if so, move on to next customer (call start()).
  private void cancelCheck(String input){
    if(input.toLowerCase().equals("cancel")){
      System.out.println("\n\nNext customer.");
      start();
    }
  }











}
