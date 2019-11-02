import java.util.ArrayList;
import java.util.Scanner;
import snacks.Snack;


public class Staff {
  private int staffID;
  private int passward;

  public Staff(){
    this.staffID = 1;
    this.passward = 0000;

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
