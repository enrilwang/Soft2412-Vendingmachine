
import java.util.ArrayList;
import java.util.HashMap;
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
  private ArrayList<Snack> purchaseList;
  private HashMap<String, Integer> stock=new HashMap<>();

  public VendingMachine(){
    transaction=new Transaction();
    purchaseList=new ArrayList<>();
    fill();
  }

  //puts item in purchase list, quantity of item - 1, but have to account for cancels.
  public void buy(String input){
    if (isNumeric(input)) {
      int i = Integer.parseInt(input);
      if (i == 1) {
        purchaseList.add(new BBQChips());
        stock.put("bbqchips", stock.get("bbqchips")-1);
      } else if (i == 2) {
        purchaseList.add(new Jellybeans());
        stock.put("jellybeans", stock.get("jellybeans")-1);
      } else if (i == 3) {
        purchaseList.add(new Juice());
        stock.put("juice", stock.get("juice")-1);
      } else if (i == 4) {
        purchaseList.add(new Lollies());
        stock.put("lollies", stock.get("lollies")-1);
      } else if (i == 5) {
        purchaseList.add(new Mars());
        stock.put("mars", stock.get("mars")-1);
      } else if (i == 6) {
        purchaseList.add(new OriginalChips());
        stock.put("originalchips", stock.get("originalchips")-1);
      } else if (i == 7) {
        purchaseList.add(new Sneakers());
        stock.put("sneakers", stock.get("sneakers")-1);
      } else if (i == 8) {
        purchaseList.add(new SourWorms());
        stock.put("sourworms", stock.get("sourworms")-1);
      } else if (i == 9) {
        purchaseList.add(new Water());
        stock.put("water", stock.get("water")-1);
      }
    }
    else{
      String s=input.toLowerCase();
      if(s.equals("bbqchips")){
        purchaseList.add(new BBQChips());
        stock.put("bbqchips", stock.get("bbqchips")-1);
      }else if(s.equals("jellybeans")){
        purchaseList.add(new Jellybeans());
        stock.put("jellybeans", stock.get("jellybeans")-1);
      }else if(s.equals("juice")){
        purchaseList.add(new Juice());
        stock.put("juice", stock.get("juice")-1);
      }else if(s.equals("lollies")){
        purchaseList.add(new Lollies());
        stock.put("lollies", stock.get("lollies")-1);
      }else if(s.equals("mars")){
        purchaseList.add(new Mars());
        stock.put("mars", stock.get("mars")-1);
      }else if(s.equals("originalchips")){
        purchaseList.add(new OriginalChips());
        stock.put("originalchips", stock.get("originalchips")-1);
      }else if(s.equals("sneakers")){
        purchaseList.add(new Sneakers());
        stock.put("sneakers", stock.get("sneakers")-1);
      }else if(s.equals("sourworms")){
        purchaseList.add(new SourWorms());
        stock.put("sourworms", stock.get("sourworms")-1);
      }else if(s.equals("water")){
        purchaseList.add(new Water());
        stock.put("water", stock.get("water")-1);
      }
    }
  }

  public boolean isNumeric(String input) {
    for (char i : input.toCharArray()) {
      if (!Character.isDigit(i)) return false;
    }
    return true;
  }

  public double getTotalPrice(){
    double total=0.0;
    for(Snack i:purchaseList){
      total+=i.getPrice();
    }
    return total;
  }

  ///resets the purchase list between customers.
  public void resetPurchase(){
    purchaseList=new ArrayList<>();
  }

  ///fills the quantity of snacks at 10 per item, vending machine starts off filled.
  public void fill(){
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

  //shows the amount of each item left in vending machine.
  public void showStock(){
    for(Entry<String, Integer> i:stock.entrySet()){
      String s=i.getKey();
      int quantity=i.getValue();
      System.out.println("Product: "+s+"\t\t\tquantity: "+quantity);
    }
  }




}
