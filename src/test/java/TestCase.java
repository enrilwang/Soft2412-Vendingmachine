import org.junit.Assert;
import org.junit.Test;
import snacks.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCase {
    @Test
    public void TestSetAndGetSnakePrice() {
        Snack test = new Snack() {
            @Override
            public void setPrice(double price) {
                super.setPrice(1.0);
            }

        };
        test.setPrice(1.0);
        Assert.assertEquals(1.0, test.getPrice(), 0.01);
    }

    @Test
    public void TestSetAndGetSnakeName() {
        Snack test = new Snack() {
            @Override
            public void setName(String name) {
                super.setName("aaa");
            }

        };
        test.setName("aaa");
        Assert.assertEquals("aaa", test.getName());
    }

    @Test
    public void TestSetAndGetSnakeCode() {
        Snack test = new Snack() {
            @Override
            public void setCode(int code) {
                super.setCode(1);
            }

        };
        test.setCode(1);
        Assert.assertEquals(1, test.getCode());
    }

    @Test
    public void TestSnacks() {
        BBQChips test = new BBQChips();
        Assert.assertEquals(2.5, test.getPrice(), 0.01);
        Assert.assertEquals(1, test.getCode());
        Assert.assertEquals("BBQChips", test.getName());
        Jellybeans test2 = new Jellybeans();
        Assert.assertEquals(2.2, test2.getPrice(), 0.01);
        Assert.assertEquals(2, test2.getCode());
        Assert.assertEquals("Jellybeans", test2.getName());
        Juice test3 = new Juice();
        Assert.assertEquals(3.2, test3.getPrice(), 0.01);
        Assert.assertEquals(3, test3.getCode());
        Assert.assertEquals("Juice", test3.getName());
        Lollies test4 = new Lollies();
        Assert.assertEquals(1.5, test4.getPrice(), 0.01);
        Assert.assertEquals(4, test4.getCode());
        Assert.assertEquals("Lollies", test4.getName());
        Mars test5 = new Mars();
        Assert.assertEquals(3, test5.getPrice(), 0.01);
        Assert.assertEquals(5, test5.getCode());
        Assert.assertEquals("Mars", test5.getName());
        OriginalChips test6 = new OriginalChips();
        Assert.assertEquals(3.2, test6.getPrice(), 0.01);
        Assert.assertEquals(6, test6.getCode());
        Assert.assertEquals("OriginalChips", test6.getName());
        Sneakers test7 = new Sneakers();
        Assert.assertEquals(3.5, test7.getPrice(), 0.01);
        Assert.assertEquals(7, test7.getCode());
        Assert.assertEquals("Sneakers", test7.getName());
        SourWorms test8 = new SourWorms();
        Assert.assertEquals(2, test8.getPrice(), 0.01);
        Assert.assertEquals(8, test8.getCode());
        Assert.assertEquals("SourWorms", test8.getName());
        Water test9 = new Water();
        Assert.assertEquals(4.5, test9.getPrice(), 0.01);
        Assert.assertEquals(9, test9.getCode());
        Assert.assertEquals("Water", test9.getName());

    }

    @Test
    public void TestCheckIsNumeric() {
        VendingMachine test = new VendingMachine();
        boolean flag = test.isNumeric("1");
        Assert.assertTrue(flag);
        VendingMachine test1 = new VendingMachine();
        boolean flag1 = test.isNumeric("abc");
        Assert.assertFalse(flag1);
    }

    @Test
    public void TestGetStock() {
        VendingMachine test = new VendingMachine();
        test.fill();
        Map<String, Integer> map = new HashMap<>();
        map.put("BBQChips", 10);
        map.put("Jellybeans", 10);
        map.put("Juice", 10);
        map.put("Lollies", 10);
        map.put("Mars", 10);
        map.put("OriginalChips", 10);
        map.put("Sneakers", 10);
        map.put("SourWorms", 10);
        map.put("Water", 10);
        assertThat(test.getStock(), is(map));


    }

    @Test
    public void TestShowStock() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.fill();
        test.showStock();
        Assert.assertEquals("Product: Water\t\t\tquantity: 10\n" +
                "Product: Mars\t\t\tquantity: 10\n" +
                "Product: Sneakers\t\t\tquantity: 10\n" +
                "Product: BBQChips\t\t\tquantity: 10\n" +
                "Product: SourWorms\t\t\tquantity: 10\n" +
                "Product: OriginalChips\t\t\tquantity: 10\n" +
                "Product: Juice\t\t\tquantity: 10\n" +
                "Product: Jellybeans\t\t\tquantity: 10\n" +
                "Product: Lollies\t\t\tquantity: 10\n", out.toString());

    }

    @Test
    public void TestBuy() {
        VendingMachine test = new VendingMachine();
        boolean flag = test.buy("1", 2);
        boolean flag2 = test.buy("2", 1);
        boolean flag3 = test.buy("3", 1);
        boolean flag4 = test.buy("4", 1);
        boolean flag5 = test.buy("5", 1);
        boolean flag6 = test.buy("6", 1);
        boolean flag7 = test.buy("7", 1);
        boolean flag8 = test.buy("8", 1);
        boolean flag9 = test.buy("9", 1);
        test.buy("BBQChips", 1);
        test.buy("Jellybeans", 1);
        test.buy("Juice", 1);
        test.buy("Lollies", 1);
        test.buy("Mars", 1);
        test.buy("OriginalChips", 1);
        test.buy("Sneakers", 1);
        test.buy("SourWorms", 1);
        test.buy("Water", 1);
//        Map<String, Integer> map = new HashMap<>();
//        map.put("BBQChips", 2);
//        map.put("Jellybeans", 2);
//        map.put("Juice", 2);
//        map.put("Lollies", 2);
//        map.put("Mars", 2);
//        map.put("OriginalChips",2);
//        map.put("Sneakers", 2);
//        map.put("Sourworms", 2);
//        map.put("Water", 2);
//        assertThat(test.getPurchaseList(), is(map));
        Assert.assertTrue(flag&flag2&flag3&flag4&flag5&flag6&flag7&flag8&flag9);
    }




    @Test
    public void TestGetTotalPrice() {
        VendingMachine test = new VendingMachine();
        test.buy("1", 1);
        test.buy("2", 1);
        Assert.assertEquals(4.7, test.getTotalPrice(), 0.01);

    }

    @Test
    public void TestSuccessfulBuy() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.buy("1", 1);
        test.successfulBuy();
        test.showStock();
        Assert.assertEquals("Product: Water\t\t\tquantity: 10\n" +
                "Product: Mars\t\t\tquantity: 10\n" +
                "Product: Sneakers\t\t\tquantity: 10\n" +
                "Product: BBQChips\t\t\tquantity: 9\n" +
                "Product: SourWorms\t\t\tquantity: 10\n" +
                "Product: OriginalChips\t\t\tquantity: 10\n" +
                "Product: Juice\t\t\tquantity: 10\n" +
                "Product: Jellybeans\t\t\tquantity: 10\n" +
                "Product: Lollies\t\t\tquantity: 10\n", out.toString());

    }

    //    Test PrintPurchaseList function
    @Test
    public void TestPrintPurchaseList() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.buy("1", 1);
        test.printPurchaseList();
        Assert.assertEquals("Purchase list:\n" +
                "                                BBQChips                    1 \n", out.toString());


    }
    @Test
    public void TestValidStaff(){
        ByteArrayInputStream in = new ByteArrayInputStream("1\n0000\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Staff test = new Staff();
        test.ValidStaff();
        Assert.assertEquals("Please type you ID: \n" +
                "Please type you password: \n"
                ,out.toString());

    }
    @Test
    public void TestInValidStaff(){
        ByteArrayInputStream in = new ByteArrayInputStream("1\n00\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Staff test = new Staff();
        test.ValidStaff();
        Assert.assertEquals("Please type you ID: \n" +
                        "Please type you password: \n"
                ,out.toString());

    }
    @Test
    public void TestPrintStock(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.PrintStock();

        Assert.assertEquals("{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());

    }
    @Test
    public void TestStockAvailable(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.buy("1",11);
        Assert.assertEquals("You cannot purchase 11 BBQChips because there are only 10 BBQChips left in the vending machine.\n",out.toString());

        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        VendingMachine test2 = new VendingMachine();
        test2.buy("2",11);
        Assert.assertEquals("You cannot purchase 11 Jellybeans because there are only 10 Jellybeans left in the vending machine.\n",out2.toString());

        ByteArrayOutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        VendingMachine test3 = new VendingMachine();
        test3.buy("3",11);
        Assert.assertEquals("You cannot purchase 11 Juice because there are only 10 Juice left in the vending machine.\n",out3.toString());

        ByteArrayOutputStream out4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out4));
        VendingMachine test4 = new VendingMachine();
        test4.buy("4",11);
        Assert.assertEquals("You cannot purchase 11 Lollies because there are only 10 Lollies left in the vending machine.\n",out4.toString());

        ByteArrayOutputStream out5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out5));
        VendingMachine test5 = new VendingMachine();
        test5.buy("5",11);
        Assert.assertEquals("You cannot purchase 11 Mars because there are only 10 Mars left in the vending machine.\n",out5.toString());

        ByteArrayOutputStream out6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out6));
        VendingMachine test6 = new VendingMachine();
        test6.buy("6",11);
        Assert.assertEquals("You cannot purchase 11 OriginalChips because there are only 10 OriginalChips left in the vending machine.\n",out6.toString());

        ByteArrayOutputStream out7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out7));
        VendingMachine test7 = new VendingMachine();
        test7.buy("7",11);
        Assert.assertEquals("You cannot purchase 11 Sneakers because there are only 10 Sneakers left in the vending machine.\n",out7.toString());

        ByteArrayOutputStream out8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out8));
        VendingMachine test8 = new VendingMachine();
        test8.buy("8",11);
        Assert.assertEquals("You cannot purchase 11 SourWorms because there are only 10 SourWorms left in the vending machine.\n",out8.toString());

        ByteArrayOutputStream out9 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out9));
        VendingMachine test9 = new VendingMachine();
        test9.buy("9",11);
        Assert.assertEquals("You cannot purchase 11 Water because there are only 10 Water left in the vending machine.\n",out9.toString());

    }
    @Test
    public void TestStockAvailable2(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.buy("BBQchips",11);
        Assert.assertEquals("You cannot purchase 11 BBQChips because there are only 10 BBQChips left in the vending machine.\n",out.toString());

        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        VendingMachine test2 = new VendingMachine();
        test2.buy("Jellybeans",11);
        Assert.assertEquals("You cannot purchase 11 Jellybeans because there are only 10 Jellybeans left in the vending machine.\n",out2.toString());

        ByteArrayOutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        VendingMachine test3 = new VendingMachine();
        test3.buy("Juice",11);
        Assert.assertEquals("You cannot purchase 11 Juice because there are only 10 Juice left in the vending machine.\n",out3.toString());

        ByteArrayOutputStream out4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out4));
        VendingMachine test4 = new VendingMachine();
        test4.buy("Lollies",11);
        Assert.assertEquals("You cannot purchase 11 Lollies because there are only 10 Lollies left in the vending machine.\n",out4.toString());

        ByteArrayOutputStream out5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out5));
        VendingMachine test5 = new VendingMachine();
        test5.buy("Mars",11);
        Assert.assertEquals("You cannot purchase 11 Mars because there are only 10 Mars left in the vending machine.\n",out5.toString());

        ByteArrayOutputStream out6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out6));
        VendingMachine test6 = new VendingMachine();
        test6.buy("OriginalChips",11);
        Assert.assertEquals("You cannot purchase 11 OriginalChips because there are only 10 OriginalChips left in the vending machine.\n",out6.toString());

        ByteArrayOutputStream out7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out7));
        VendingMachine test7 = new VendingMachine();
        test7.buy("Sneakers",11);
        Assert.assertEquals("You cannot purchase 11 Sneakers because there are only 10 Sneakers left in the vending machine.\n",out7.toString());

        ByteArrayOutputStream out8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out8));
        VendingMachine test8 = new VendingMachine();
        test8.buy("SourWorms",11);
        Assert.assertEquals("You cannot purchase 11 SourWorms because there are only 10 SourWorms left in the vending machine.\n",out8.toString());

        ByteArrayOutputStream out9 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out9));
        VendingMachine test9 = new VendingMachine();
        test9.buy("Water",11);
        Assert.assertEquals("You cannot purchase 11 Water because there are only 10 Water left in the vending machine.\n",out9.toString());

    }
    @Test
    public void TestChangePrice(){

        ByteArrayInputStream in = new ByteArrayInputStream("1\n3\n10\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Staff test = new Staff();
        test.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());


        ByteArrayInputStream in2 = new ByteArrayInputStream("2\n3\n10\n".getBytes());
        System.setIn(in2);
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        Staff test2 = new Staff();
        test2.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in3 = new ByteArrayInputStream("3\n3\n10\n".getBytes());
        System.setIn(in3);
        ByteArrayOutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        Staff test3 = new Staff();
        test3.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in4 = new ByteArrayInputStream("4\n3\n10\n".getBytes());
        System.setIn(in4);
        ByteArrayOutputStream out4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out4));
        Staff test4 = new Staff();
        test4.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in5 = new ByteArrayInputStream("5\n3\n10\n".getBytes());
        System.setIn(in5);
        ByteArrayOutputStream out5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out5));
        Staff test5 = new Staff();
        test5.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in6 = new ByteArrayInputStream("6\n3\n10\n".getBytes());
        System.setIn(in6);
        ByteArrayOutputStream out6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out6));
        Staff test6 = new Staff();
        test6.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in7 = new ByteArrayInputStream("7\n3\n10\n".getBytes());
        System.setIn(in7);
        ByteArrayOutputStream out7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out7));
        Staff test7 = new Staff();
        test7.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in8 = new ByteArrayInputStream("8\n3\n10\n".getBytes());
        System.setIn(in8);
        ByteArrayOutputStream out8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out8));
        Staff test8 = new Staff();
        test8.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());

        ByteArrayInputStream in9 = new ByteArrayInputStream("9\n3\n10\n".getBytes());
        System.setIn(in9);
        ByteArrayOutputStream out9 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out9));
        Staff test9 = new Staff();
        test9.changePrice();
        Assert.assertEquals("which one do you want to change price, type Code\n" +
                "How much do you want to set\n",out.toString());
    }
    @Test
    public void TestStartMenu(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.StartMenu();
        Assert.assertEquals("               BBQChips - Name: BBQChips           Price:$2.5     Code:1  stock 10 \n" +
                "           Jellybeans - Name: Jellybeans           Price:$2.2     Code:2  stock 10 \n" +
                "                     Juice - Name: Juice           Price:$3.2     Code:3  stock 10 \n" +
                "                 Lollies - Name: Lollies           Price:$1.5     Code:4  stock 10 \n" +
                "                       Mars - Name: Mars           Price:$3.0     Code:5  stock 10 \n" +
                "     OriginalChips - Name: OriginalChips           Price:$3.2     Code:6  stock 10 \n" +
                "               Sneakers - Name: Sneakers           Price:$3.5     Code:7  stock 10 \n" +
                "             SourWorms - Name: SourWorms           Price:$2.0     Code:8  stock 10 \n" +
                "                     Water - Name: Water           Price:$4.5     Code:9  stock 10 \n" +
                "\n" +
                "At any point during the purchase, type cancel to cancel transaction.\n" +
                "\n" +
                "Please input the product name or code of snack you wish to purchase.\n" +
                "\n" +
                "If you are a staff, please type 11 \n",out.toString());

    }
    @Test
    public void TestPayMethod(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        test.PayMethod();
        Assert.assertEquals("Please pay with coins (10c, 20c, 50c, $1, $2) and notes ($5, $10, $20)\n" +
                "You have to pay with currency values listed above. To pay with dollars, just enter the amount. To pay with cents, enter the amount and add the character c at the end.\n" +
                "To cancel transaction, type in cancel.\n",out.toString());

    }
    @Test
    public void TestAddVolume(){
        ByteArrayInputStream in = new ByteArrayInputStream("1\n0\n10\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Staff test = new Staff();
        test.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in2 = new ByteArrayInputStream("2\n3\n10\n".getBytes());
        System.setIn(in2);
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        Staff test2 = new Staff();
        test2.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in3 = new ByteArrayInputStream("3\n3\n10\n".getBytes());
        System.setIn(in3);
        ByteArrayOutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        Staff test3 = new Staff();
        test3.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in4 = new ByteArrayInputStream("4\n3\n10\n".getBytes());
        System.setIn(in4);
        ByteArrayOutputStream out4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out4));
        Staff test4 = new Staff();
        test4.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in5 = new ByteArrayInputStream("5\n3\n10\n".getBytes());
        System.setIn(in5);
        ByteArrayOutputStream out5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out5));
        Staff test5 = new Staff();
        test5.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in6 = new ByteArrayInputStream("6\n3\n10\n".getBytes());
        System.setIn(in6);
        ByteArrayOutputStream out6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out6));
        Staff test6 = new Staff();
        test6.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in7 = new ByteArrayInputStream("7\n3\n10\n".getBytes());
        System.setIn(in7);
        ByteArrayOutputStream out7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out7));
        Staff test7 = new Staff();
        test7.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
//
        ByteArrayInputStream in8 = new ByteArrayInputStream("8\n3\n10\n".getBytes());
        System.setIn(in8);
        ByteArrayOutputStream out8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out8));
        Staff test8 = new Staff();
        test8.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());

        ByteArrayInputStream in9 = new ByteArrayInputStream("9\n3\n10\n".getBytes());
        System.setIn(in9);
        ByteArrayOutputStream out9 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out9));
        Staff test9 = new Staff();
        test9.addVolume();
        Assert.assertEquals("which one do you want to add volume, type Code\n" +
                "How many do you want to add, you can only add 0 items\n" +
                "{Water=10, Mars=10, Sneakers=10, BBQChips=10, SourWorms=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());
    }

    @Test
    public void  TestCashChange(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine<>();
        test.cashChange(-5);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "$5 ",out.toString());
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        VendingMachine test2 = new VendingMachine<>();
        test2.cashChange(-20);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "$20 " ,out2.toString());
        ByteArrayOutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        VendingMachine test3 = new VendingMachine<>();
        test3.cashChange(-10);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "$10 ",out3.toString());

        ByteArrayOutputStream out4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out4));
        VendingMachine test4 = new VendingMachine<>();
        test4.cashChange(-2);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "$2 ",out4.toString());

        ByteArrayOutputStream out5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out5));
        VendingMachine test5 = new VendingMachine<>();
        test5.cashChange(-1);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "$1 ",out5.toString());

        ByteArrayOutputStream out6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out6));
        VendingMachine test6 = new VendingMachine<>();
        test6.cashChange(-0.5);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "50c ",out6.toString());

        ByteArrayOutputStream out7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out7));
        VendingMachine test7 = new VendingMachine<>();
        test7.cashChange(-0.2);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "20c ",out7.toString());

        ByteArrayOutputStream out8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out8));
        VendingMachine test8 = new VendingMachine<>();
        test8.cashChange(-0.1);
        Assert.assertEquals("Purchase successful. Here is your change of \n" +
                "10c ",out8.toString());


    }
    @Test
    public void TestResetPurchaseList(){
        VendingMachine test = new VendingMachine();
        test.resetPurchase();
        Map<String, Integer> map = new HashMap<>();
        assertThat(test.getPurchaseList(), is(map));
    }
}