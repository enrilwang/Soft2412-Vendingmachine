import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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

public class VendingMachine {
  private Transaction transaction;
  private HashMap<Snack, Integer> purchaseList;
  private HashMap<String, Integer> stock = new HashMap<>();
  private BBQChips bbq;
  private Jellybeans jelly;
  private Juice juice;
  private Lollies lollies;
  private Mars mars;
  private OriginalChips ochip;
  private Sneakers sneakers;
  private SourWorms sourWorms;
  private Water water;

  public VendingMachine() {
    //transaction = new Transaction();
    purchaseList = new HashMap<>();
    bbq = new BBQChips();
    jelly = new Jellybeans();
    juice = new Juice();
    lollies = new Lollies();
    mars = new Mars();
    ochip = new OriginalChips();
    sneakers = new Sneakers();
    sourWorms = new SourWorms();
    water = new Water();
    fill();
  }
  public void StartMenu(){
    System.out.printf("%40s %20s %20s %n","BBQChips - Name: BBQChips","Price:$"+ bbq.getPrice() ,"Code:1");
    System.out.printf("%40s %20s %20s %n","Jellybeans - Name: Jellybeans","Price:$"+jelly.getPrice(), "Code:2");
    System.out.printf("%40s %20s %20s %n","Juice - Name: Juice", "Price:$"+juice.getPrice(), "Code:3");
    System.out.printf("%40s %20s %20s %n","Lollies - Name: Lollies","Price:$"+lollies.getPrice(), "Code:4");
    System.out.printf("%40s %20s %20s %n","Mars - Name: Mars","Price:$"+mars.getPrice(), "Code:5");
    System.out.printf("%40s %20s %20s %n","OriginalChips - Name: OriginalChips", "Price:$"+ochip.getPrice(),"Code:6");
    System.out.printf("%40s %20s %20s %n","Sneakers - Name: Sneakers","Price:$"+sneakers.getPrice(), "Code:7");
    System.out.printf("%40s %20s %20s %n","SourWorms - Name: SourWorms","Price:$"+sourWorms.getPrice(), "Code:8");
    System.out.printf("%40s %20s %20s %n","Water - Name: Water", "Price:$"+water.getPrice(),"Code:9");

    System.out.println("\nAt any point during the purchase, type cancel to cancel transaction.");

    System.out.println("\nPlease input the product name or code of snack you wish to purchase.");

    System.out.println("\nIf you are a staff, please type 11 ");

    System.out.println("\nIf you want to see stock, please type 12 ");

  }

  // checks if there is stock available for the item to be purchased.
  // if the amount of stock after purchase will be negative, then return false.
  public boolean stockAvailable(String snack, Integer amount) {
    for (String stockSnack : stock.keySet()) {
      if (snack.equals(stockSnack)) {
        if (stock.get(stockSnack) - amount < 0) {
          System.out.println(
              "You cannot purchase "
                  + amount
                  + " "
                  + snack
                  + " because there are only "
                  + stock.get(stockSnack)
                  + " "
                  + snack
                  + " left in the vending machine.");
        }
        return true;
      }
    }
    return true;
  }

  // puts item in purchase list, not yet confirmed.
  // if no stock available, then return false.
  public boolean buy(String input, int quantity) {
    if (isNumeric(input)) {
      int i = Integer.parseInt(input);
      if (i == 1) {
        if (stockAvailable("BBQChips", quantity)) {
          purchaseList.put(new BBQChips(), quantity);
          return true;
        }
      } else if (i == 2) {
        if (stockAvailable("Jellybeans", quantity)) {
          purchaseList.put(new Jellybeans(), quantity);
          return true;
        }
      } else if (i == 3) {
        if (stockAvailable("Juice", quantity)) {
          purchaseList.put(new Juice(), quantity);
          return true;
        }
      } else if (i == 4) {
        if (stockAvailable("Lollies", quantity)) {
          purchaseList.put(new Lollies(), quantity);
          return true;
        }
      } else if (i == 5) {
        if (stockAvailable("Mars", quantity)) {
          purchaseList.put(new Mars(), quantity);
          return true;
        }
      } else if (i == 6) {
        if (stockAvailable("OriginalChips", quantity)) {
          purchaseList.put(new OriginalChips(), quantity);
          return true;
        }
      } else if (i == 7) {
        if (stockAvailable("Sneakers", quantity)) {
          purchaseList.put(new Sneakers(), quantity);
          return true;
        }
      } else if (i == 8) {
        if (stockAvailable("SourWorms", quantity)) {
          purchaseList.put(new SourWorms(), quantity);
          return true;
        }
      } else if (i == 9) {
        if (stockAvailable("Water", quantity)) {
          purchaseList.put(new Water(), quantity);
          return true;
        }
      }
    } else {
      String s = input.toLowerCase();
      if (s.equals("bbqchips")) {
        if (stockAvailable("BBQChips", quantity)) {
          purchaseList.put(new BBQChips(), quantity);
          return true;
        }
      } else if (s.equals("jellybeans")) {
        if (stockAvailable("Jellybeans", quantity)) {
          purchaseList.put(new Jellybeans(), quantity);
          return true;
        }
      } else if (s.equals("juice")) {
        if (stockAvailable("Juice", quantity)) {
          purchaseList.put(new Juice(), quantity);
          return true;
        }
      } else if (s.equals("lollies")) {
        if (stockAvailable("Lollies", quantity)) {
          purchaseList.put(new Lollies(), quantity);
          return true;
        }
      } else if (s.equals("mars")) {
        if (stockAvailable("Mars", quantity)) {
          purchaseList.put(new Mars(), quantity);
          return true;
        }
      } else if (s.equals("originalchips")) {
        if (stockAvailable("OriginalChips", quantity)) {
          purchaseList.put(new OriginalChips(), quantity);
          return true;
        }
      } else if (s.equals("sneakers")) {
        if (stockAvailable("Sneakers", quantity)) {
          purchaseList.put(new Sneakers(), quantity);
          return true;
        }
      } else if (s.equals("sourworms")) {
        if (stockAvailable("SourWorms", quantity)) {
          purchaseList.put(new SourWorms(), quantity);
          return true;
        }
      } else if (s.equals("water")) {
        if (stockAvailable("Water", quantity)) {
          purchaseList.put(new Water(), quantity);
          return true;
        }
      }
    }
    return false;
  }

  // when purchase is successful, reduce stock by the amount.
  public void successfulBuy() {
    for (Snack snack : purchaseList.keySet()) {
      for (String stockSnack : stock.keySet()) {
        if (snack.getName().equals(stockSnack)) {
          stock.put(stockSnack, stock.get(stockSnack) - purchaseList.get(snack));
        }
      }
    }
  }

  public boolean isNumeric(String input) {
    for (char i : input.toCharArray()) {
      if (!Character.isDigit(i)) return false;
    }
    return true;
  }

  public double getTotalPrice() {
    double total = 0.0;
    for (Snack i : purchaseList.keySet()) {
      total += i.getPrice() * purchaseList.get(i);
    }
    return total;
  }

  /// resets the purchase list between customers.
  public void resetPurchase() {
    purchaseList = new HashMap<>();
  }

  /// fills the quantity of snacks at 10 per item, vending machine starts off filled.
  public void fill() {
    stock.put("BBQChips", 10);
    stock.put("Jellybeans", 10);
    stock.put("Juice", 10);
    stock.put("Lollies", 10);
    stock.put("Mars", 10);
    stock.put("OriginalChips", 10);
    stock.put("Sneakers", 10);
    stock.put("Sourworms", 10);
    stock.put("Water", 10);
  }

  // shows the amount of each item left in vending machine.
  public void showStock() {
    for (Entry<String, Integer> i : stock.entrySet()) {
      String s = i.getKey();
      int quantity = i.getValue();
      System.out.println("Product: " + s + "\t\t\tquantity: " + quantity);
    }
  }

  public HashMap<String, Integer> getStock() {
    return this.stock;
  }


  //prints the purchase list to menu.
  public void printPurchaseList() {
    System.out.println("Purchase list:");
    for (Map.Entry<Snack, Integer> set : purchaseList.entrySet()) {
      String name = set.getKey().getName();
      int amount = set.getValue();
      System.out.printf("%40s %20s %n", name, Integer.toString(amount));
    }
  }

  public HashMap<Snack, Integer> getPurchaseList() {
    return this.purchaseList;
  }

  public void setPurchaseList(HashMap<Snack, Integer> purchaseList) {
    this.purchaseList = purchaseList;
  }

  public void PrintStock(){
    System.out.println(this.stock);
  }


}
