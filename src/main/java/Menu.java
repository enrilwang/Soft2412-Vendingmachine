import java.util.Scanner;


public class Menu {
  private VendingMachine vendingMachine;

  public Menu(){
    vendingMachine=new VendingMachine();
    start();
  }

  private void start(){
    Scanner scan = new Scanner(System.in);
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
    while(scan.hasNext()){
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
      double price=vendingMachine.getTotalPrice();
      System.out.println("The total price is $"+String.format("%.2f",price));
      System.out.println("Please pay with coins (10c, 20c, 50c, $1, $2) and notes ($5, $10, $20)");
      String input = scan.nextLine();
      if(input.toLowerCase().equals("exit")){
        System.exit(1);
      }
    }
    int i = scan.nextInt();
  }

}
