import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import snacks.BBQChips;
import snacks.Cancel;
import snacks.Jellybeans;
import snacks.Juice;
import snacks.Lollies;
import snacks.Mars;
import snacks.OriginalChips;
import snacks.Snack;
import snacks.Sneakers;
import snacks.SourWorms;
import snacks.Water;

import java.math.BigDecimal;

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
  private HashMap<Integer, HashMap<Snack,Integer>> tran;
  private int i = 0;
  private Cancel cancel;
  private  ArrayList<Double>  cash1  = new ArrayList<>();
  private  ArrayList<String> cash = new ArrayList<>();

  public Menu() {
    vendingMachine = new VendingMachine();
    vendingMachine.fill();
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
    cancel = new Cancel();
    tran = new HashMap<Integer, HashMap<Snack,Integer>>();
    cash1.add(20.00);
    cash1.add(10.00);
    cash1.add(5.00);
    cash1.add(2.00);
    cash1.add(1.00);
    cash1.add(0.5);
    cash1.add(0.2);
    cash1.add(0.1);
    cash.add("20");
    cash.add("10");
    cash.add("5");
    cash.add("2");
    cash.add("1");
    cash.add("50c");
    cash.add("20c");
    cash.add("10c");

    start();
  }

  public void start() {

    Scanner scan = new Scanner(System.in);
    //vendingMachine.showStock();
    vendingMachine.resetPurchase();
    while (true) {
      System.out
          .printf("%40s %20s %20s %n", "BBQChips - Name: BBQChips", "Price:$" + bbq.getPrice(),
              "Code:1 "+ " stock " + VendingMachine.stock.get("BBQChips"));
      System.out.printf("%40s %20s %20s %n", "Jellybeans - Name: Jellybeans",
          "Price:$" + jelly.getPrice(), "Code:2 " + " stock "+VendingMachine.stock.get("Jellybeans"));
      System.out.printf("%40s %20s %20s %n", "Juice - Name: Juice", "Price:$" + juice.getPrice(),
          "Code:3 "+ " stock " +VendingMachine.stock.get("Juice"));
      System.out
          .printf("%40s %20s %20s %n", "Lollies - Name: Lollies", "Price:$" + lollies.getPrice(),
              "Code:4 " + " stock "+ VendingMachine.stock.get("Lollies"));
      System.out
          .printf("%40s %20s %20s %n", "Mars - Name: Mars", "Price:$" + mars.getPrice(), "Code:5 "+ " stock "+ VendingMachine.stock.get("Mars"));
      System.out.printf("%40s %20s %20s %n", "OriginalChips - Name: OriginalChips",
          "Price:$" + ochip.getPrice(), "Code:6 "+ " stock "+ VendingMachine.stock.get("OriginalChips"));
      System.out
          .printf("%40s %20s %20s %n", "Sneakers - Name: Sneakers", "Price:$" + sneakers.getPrice(),
              "Code:7 "+ " stock "+ VendingMachine.stock.get("Sneakers"));
      System.out.printf("%40s %20s %20s %n", "SourWorms - Name: SourWorms",
          "Price:$" + sourWorms.getPrice(), "Code:8 "+ " stock "+ VendingMachine.stock.get("Sourworms"));
      System.out.printf("%40s %20s %20s %n", "Water - Name: Water", "Price:$" + water.getPrice(),
          "Code:9 "+ " stock "+ VendingMachine.stock.get("Water"));

      System.out.println("\nAt any point during the purchase, type cancel to cancel transaction.");

      System.out.println("\nPlease input the product name or code of snack you wish to purchase.");

      System.out.println("\nIf you are a staff, please type 11 ");

      System.out.println("\nIf you want to see stock, please type 12 ");
      //ask customer what items they want to buy.
      while (true) {

        String input = scan.nextLine();
        cancelCheck(input);
        if (input.equals("12")) {
          vendingMachine.PrintStock();
          System.out.println("continue buy ? type 0 to continue, 1 for cancel");
          String in = scan.nextLine();

          if (in.equals("0")) {
            start();
          } else {
            cancelCheck("cancel");
          }
        }
        if (input.equals("11")) {
          if (staff.ValidStaff()) {
            while(true) {
              System.out.println(
                  "Do you want to change the price, 0 for yes, 1 for add volume, 2 for look the transcation, any other number for quit");
              String inn = scan.nextLine();
              if(inn.equals("0")) {
                changePrice();
              }
              else if(inn.equals("1")){
                addVolume();
              }else if(inn.equals("2")){
                printTran();
              }
              else {
                start();
              }
            }

          } else {
            System.out.println("\nYou are not staff\n");
            start();
          }

        }
        System.out.println("Please input the quantity you wish to purchase.");
        String quantity = scan.nextLine();
        cancelCheck(quantity);
        if (!vendingMachine.buy(input, Integer.parseInt(quantity))) {
          System.out
              .println("\nPlease input the product name or code of snack you wish to purchase.");
          continue;
        }
        System.out.println("Do you want to add another item? Type 1 for no, others for yes,");
        String s = scan.nextLine();
        cancelCheck(s);
        if (s.equals("1")) {
          break;
        }
        System.out.println("Please input the product name or code of snack you wish to purchase.");
      }

      //ask customer to pay. If paying with cents, divide double by 100.

      double price = Double
          .parseDouble(new DecimalFormat("#.##").format(vendingMachine.getTotalPrice()));
      vendingMachine.printPurchaseList();
      System.out.println("\n\nThe total price is $" + String.format("%.2f", price));
      System.out.println("Please pay with coins (10c, 20c, 50c, $1, $2) and notes ($5, $10, $20)");
      System.out.println(
          "You have to pay with currency values listed above. To pay with dollars, just enter the amount. To pay with cents, enter the amount and add the character c at the end.");
      System.out.println("To cancel transaction, type in cancel.");
      //Each time after customer enters money, it will show how much is left to be paid. If amount left is 0, it will break the loop.
      double totalPaid = 0.0;

      while (scan.hasNext()) {
        String input = scan.nextLine();
        boolean flag = false;
        for (String i : cash) {
          if (i.equals(input)) {
            System.out.println("cash accepted");
            flag = true;
          }
        }
        if (input.length() == 3 && flag) {
          double amountPaid = Double.parseDouble(input.substring(0, 2));
          totalPaid += amountPaid / 100;
        } else if (input.length() == 2 && flag || input.length() == 1 && flag) {
          double amountPaid = Double.parseDouble(input);
          totalPaid += amountPaid;
        } else if (input.toLowerCase().equals("cancel")) {
          HashMap<Snack, Integer> a = new HashMap<>();
          a.put(new Cancel(), 0);
          tran.put(i, a);
          System.out.println("Here is your money back.\n\n\nNext customer.");
          i += 1;
          start();
        } else {
          System.out.println("You have to pay with currency values listed above.");
        }
        DecimalFormat rounding = new DecimalFormat("#.00");
        double remainingAmount = Double.parseDouble(rounding.format(price - totalPaid));
        System.out.println("The remaining amount to be paid is: $" + remainingAmount);
        if (remainingAmount == 0.0) {
          System.out.println("Finished paying. Enjoy your snack.");
          vendingMachine.successfulBuy();
          tran.put(i, vendingMachine.getPurchaseList());
          System.out.println("\n\nNext customer.");
          i += 1;
          start();
        }
        if (remainingAmount < 0.0) {
          double change = Math.abs(remainingAmount);
//          ArrayList<String> l = new ArrayList<>();
          ArrayList<Double> n = new ArrayList<>();

          BigDecimal b1 = new BigDecimal(Double.toString(change));

//            for (Double i : cash1) {
//              BigDecimal b2 = new BigDecimal(Double.toString(i));
//              if (b1.compareTo(b2) == 1 || b1.compareTo(b2) == 0) {
//                System.out.println(b1);
//                n.add(i);
//                b1 = b1.subtract(b2);
//
//              }
//            }

          for(int i = 0; i < cash1.size(); i++){
            BigDecimal b2 = new BigDecimal(Double.toString(cash1.get(i)));
            if (b1.compareTo(b2) == 1 || b1.compareTo(b2) == 0) {
              // System.out.println(b1);
              n.add(cash1.get(i));
              b1 = b1.subtract(b2);
              i = 0;
            }
          }
          System.out.println(
              "Purchase successful. Here is your change of "
          );
          for(Double i : n){
            if(i == 20){
              System.out.print("$20 ");
            }
            if(i == 10){
              System.out.print("$10 ");
            }
            if(i == 5){
              System.out.print("$5 ");
            }
            if(i == 2){
              System.out.print("$2 ");
            }
            if(i == 1){
              System.out.print("$1 ");
            }
            if(i == 0.5){
              System.out.print("50c ");
            }
            if(i == 0.2){
              System.out.print("20c ");
            }
            if(i == 0.1){
              System.out.print("10c ");
            }



          }
          vendingMachine.successfulBuy();
          tran.put(i, vendingMachine.getPurchaseList());
          System.out.println("\n\nNext customer.");
          i++;
          start();
        }
      }

    }
  }

  //each input is checked to see if it is cancel, if so, move on to next customer (call start()).
  private void cancelCheck(String input) {
    if (input.toLowerCase().equals("cancel")) {
      HashMap<Snack,Integer> a = new HashMap<>();
      a.put(new Cancel(),0);
      tran.put(i,a);
      System.out.println("\n\nNext customer.");
      i++;
      start();
    }
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


  public void printTran(){
    Set<Integer> abc = tran.keySet();
    for (Integer bb : abc){
      System.out.println(bb);
      HashMap<Snack,Integer> valaue = tran.get(bb);
      Set<Snack> v = valaue.keySet();
      for(Snack a : v){
        Integer k = valaue.get(a);
        System.out.println("\t" + a.getName() + "___" + k);
      }
    }
  }





}

