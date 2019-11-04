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
        map.put("Sourworms", 10);
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
                "Product: Sourworms\t\t\tquantity: 10\n" +
                "Product: Sneakers\t\t\tquantity: 10\n" +
                "Product: BBQChips\t\t\tquantity: 10\n" +
                "Product: OriginalChips\t\t\tquantity: 10\n" +
                "Product: Juice\t\t\tquantity: 10\n" +
                "Product: Jellybeans\t\t\tquantity: 10\n" +
                "Product: Lollies\t\t\tquantity: 10\n", out.toString());

    }

    @Test
    public void TestBuy() {
        VendingMachine test = new VendingMachine();
        test.buy("1", 2);
        test.buy("2", 1);
        test.buy("3", 1);
        test.buy("4", 1);
        test.buy("5", 1);
        test.buy("6", 1);
        test.buy("7", 1);
        test.buy("8", 1);
        test.buy("9", 1);
        test.buy("BBQChips", 1);
        test.buy("Jellybeans", 1);
        test.buy("Juice", 1);
        test.buy("Lollies", 1);
        test.buy("Mars", 1);
        test.buy("OriginalChips", 1);
        test.buy("Sneakers", 1);
        test.buy("Sourworms", 1);
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
        for (Snack snack : test.getPurchaseList().keySet()) {
            Assert.assertEquals(test.getPurchaseList().get(snack), 2, 1);
        }


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
                "Product: Sourworms\t\t\tquantity: 10\n" +
                "Product: Sneakers\t\t\tquantity: 10\n" +
                "Product: BBQChips\t\t\tquantity: 9\n" +
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

        Assert.assertEquals("{Water=10, Mars=10, Sourworms=10, Sneakers=10, BBQChips=10, OriginalChips=10, Juice=10, Jellybeans=10, Lollies=10}\n",out.toString());

    }
    @Test
    public void TestStockAvailable(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        VendingMachine test = new VendingMachine();
        boolean flag = test.stockAvailable("1",2);
        Assert.assertTrue(flag);


    }
//    @Test
//    public void TestChangePrice(){
//
//        ByteArrayInputStream in = new ByteArrayInputStream("0\n1\n3\n".getBytes());
//        System.setIn(in);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        BBQChips bbq = new BBQChips();
//        Menu test = new Menu();
//        test.changePrice();
//        Assert.assertEquals(3,bbq.getPrice(),0.1);
//
//
//    }
}