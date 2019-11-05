import java.util.HashMap;
import java.util.Set;
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
  private VendingMachine vendingMachine;
  private HashMap<Integer, HashMap<Snack,Integer>> tran;
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
    vendingMachine = new VendingMachine();
    tran = new HashMap<Integer, HashMap<Snack,Integer>>();

  }
  public void changePrice() {
    Scanner scan = new Scanner(System.in);

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



  }
  public void addVolume(){

    Scanner sca = new Scanner(System.in);


    System.out.println("which one do you want to add volume, type Code");
    String input = sca.nextLine();
    if (input.equals("1")) {
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("BBQChips")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("BBQChips");

      vendingMachine.getStock().put("BBQChips", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("2")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Jellybeans")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Jellybeans");

      vendingMachine.getStock().put("Jellybeans", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("3")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Juice")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Juice");

      vendingMachine.getStock().put("Juice", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("4")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Lollies")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Lollies");

      vendingMachine.getStock().put("Lollies", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("5")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Mars")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Mars");

      vendingMachine.getStock().put("Mars", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("6")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("OriginalChips")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("OriginalChips");

      vendingMachine.getStock().put("OriginalChips", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("7")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Sneakers")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Sneakers");

      vendingMachine.getStock().put("Sneakers", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("8")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Sourworms")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Sourworms");

      vendingMachine.getStock().put("Sourworms", value + add);
      vendingMachine.PrintStock();
    }else if(input.equals("9")){
      System.out.println("How many do you want to add, you can only add " + (10 - vendingMachine
              .getStock("Water")) + " items");
      String input1 = sca.nextLine();
      int value = Integer.parseInt(input1);

      int add = vendingMachine.getStock("Water");

      vendingMachine.getStock().put("Water", value + add);
      vendingMachine.PrintStock();
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

