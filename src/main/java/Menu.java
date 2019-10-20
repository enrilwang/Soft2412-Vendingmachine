import java.util.Scanner;


public class Menu {
  private VendingMachine vendingMachine;

  public Menu(){
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
      String input = scan.nextLine();
      vendingMachine.buy(input);
    }
    int i = scan.nextInt();
  }

}
