import java.util.ArrayList;
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
  private ArrayList<Snack> snacks;

  public void buy(String input){
    if(isNumeric(input)){
      switch(Integer.parseInt(input)){
        case 1:
          snacks.add(new BBQChips());
        case 2:
          snacks.add(new Jellybeans());
        case 3:
          snacks.add(new Juice());
        case 4:
          snacks.add(new Lollies());
        case 5:
          snacks.add(new Mars());
        case 6:
          snacks.add(new OriginalChips());
        case 7:
          snacks.add(new Sneakers());
        case 8:
          snacks.add(new SourWorms());
        case 9:
          snacks.add(new Water());
      }
    }
    else{
      String s=input.toLowerCase();
      if(s.equals("bbqchips")){
        snacks.add(new BBQChips());
      }else if(s.equals("jellybeans")){
        snacks.add(new Jellybeans());
      }else if(s.equals("juice")){
        snacks.add(new Juice());
      }else if(s.equals("lollies")){
        snacks.add(new Lollies());
      }else if(s.equals("mars")){
        snacks.add(new Mars());
      }else if(s.equals("originalchips")){
        snacks.add(new OriginalChips());
      }else if(s.equals("sneakers")){
        snacks.add(new Sneakers());
      }else if(s.equals("sourworms")){
        snacks.add(new SourWorms());
      }else if(s.equals("water")){
        snacks.add(new Water());
      }
    }
  }

  public boolean isNumeric(String input) {
    for (char i : input.toCharArray()) {
      if (!Character.isDigit(i)) return false;
    }
    return true;
  }


}
