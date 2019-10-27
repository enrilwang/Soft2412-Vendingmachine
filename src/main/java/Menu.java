import java.text.DecimalFormat;
import java.util.Scanner;


public class Menu {
  private VendingMachine vendingMachine;

  public Menu(){
    vendingMachine=new VendingMachine();
    start();
  }

  private void start(){
    Scanner scan = new Scanner(System.in);
    while(true){
      System.out.println("BBQChips - Name: BBQChips\t\t\tCode:1");
      System.out.println("Jellybeans - Name: Jellybeans\t\t\tCode:2");
      System.out.println("Juice - Name: Juice\t\t\tCode:3");
      System.out.println("Lollies - Name: Lollies\t\t\tCode:4");
      System.out.println("Mars - Name: Mars\t\t\tCode:5");
      System.out.println("OriginalChips - Name: OriginalChips\t\t\tCode:6");
      System.out.println("Sneakers - Name: Sneakers\t\t\tCode:7");
      System.out.println("SourWorms - Name: SourWorms\t\t\tCode:8");
      System.out.println("Water - Name: Water\t\t\tCode:9\n");

      System.out.println("Please input the product name or code of snack.");

      //ask customer what items they want to buy.
      while(true){
        String input = scan.nextLine();
        vendingMachine.buy(input);
        System.out.println("Do you want to add another item? Type 0 for yes, 1 for no");
        String s = scan.nextLine();
        if(s.equals("1")){
          break;
        }
        System.out.println("Please input the product name or code of snack.");
      }

      //ask customer to pay. If paying with cents, divide double by 100.
      double price=vendingMachine.getTotalPrice();
      System.out.println("The total price is $"+String.format("%.2f",price));
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
          System.out.println(totalPaid);
        }else if(input.length()==2 ||input.length()==1){
          double amountPaid=Double.parseDouble(input);
          totalPaid+=amountPaid;
        }else if(input.toLowerCase().equals("cancel")){
          System.out.println("Here is your money back.");
          break;
        }else{
          System.out.println("You have to pay with currency values listed above.");
        }
        DecimalFormat rounding=new DecimalFormat("#.00");
        double remainingAmount=Double.parseDouble(rounding.format(price-totalPaid));
        System.out.println("The remaining amount to be paid is: $"+remainingAmount);
        if(remainingAmount==0.0){
          System.out.println("Finished paying. Enjoy your snack.");
          break;
        }
      }

      //Moves on to the next customer if exit is typed.
//      String input = scan.nextLine();
//      if(input.toLowerCase().equals("exit")){
        System.out.println("\n\nNext customer.");
//        continue;
//      }
    }
  }

}
