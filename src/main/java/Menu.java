import java.text.DecimalFormat;
import java.util.Scanner;


public class Menu {
  private VendingMachine vendingMachine;

  public Menu(){
    vendingMachine=new VendingMachine();
    start();
  }

  public void start(){
    Scanner scan = new Scanner(System.in);
//    vendingMachine.showStock();
    vendingMachine.resetPurchase();
    while(true){
      System.out.printf("%40s %20s %20s,%n","BBQChips - Name: BBQChips", "Code:1", "Price:$2.5");
      System.out.printf("%40s %20s %20s,%n","Jellybeans - Name: Jellybeans", "Code:2", "Price:$2.2");
      System.out.printf("%40s %20s %20s,%n","Juice - Name: Juice", "Code:3", "Price:$3.2");
      System.out.printf("%40s %20s %20s,%n","Lollies - Name: Lollies", "Code:4", "Price:$1.5");
      System.out.printf("%40s %20s %20s,%n","Mars - Name: Mars", "Code:5", "Price:$3.0");
      System.out.printf("%40s %20s %20s,%n","OriginalChips - Name: OriginalChips", "Code:6", "Price:$3.2");
      System.out.printf("%40s %20s %20s,%n","Sneakers - Name: Sneakers", "Code:7", "Price:$3.5");
      System.out.printf("%40s %20s %20s,%n","SourWorms - Name: SourWorms", "Code:8", "Price:$2.0");
      System.out.printf("%40s %20s %20s,%n","Water - Name: Water", "Code:9", "Price:$4.5");

      System.out.println("\nAt any point during the purchase, type cancel to cancel transaction.");

      System.out.println("\nPlease input the product name or code of snack you wish to purchase.");

      //ask customer what items they want to buy.
      while(true){
        String input = scan.nextLine();
        cancelCheck(input);
        System.out.println("Please input the quantity you wish to purchase.");
        String quantity = scan.nextLine();
        cancelCheck(quantity);
        vendingMachine.buy(input, Integer.parseInt(quantity));
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
      System.out.println("Please pay with coins (10c, 20c, 50c, $1, $2) and notes ($5, $10, $20)");
      System.out.println("You have to pay with currency values listed above. To pay with dollars, just enter the amount. To pay with cents, enter the amount and add the character c at the end.");
      System.out.println("To cancel transaction, type in cancel.");
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
