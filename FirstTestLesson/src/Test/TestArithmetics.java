package Test;
import org.junit.*;
import Calculation.Arithmetics;

public class TestArithmetics{
    private static Arithmetics arithmetics;
    @BeforeClass
    public static void initTestObject(){
        arithmetics = new Arithmetics();
    }

    @AfterClass
    public static void deinitTestObject(){
        arithmetics = null;
    }

    @Test
    public void testAdd(){
        double res = arithmetics.add(3, 7);
        if (res != 10) Assert.fail();
    }

    @Test
    public void testMult(){
        double res = arithmetics.mult(3, 7);
        if (res != 21) Assert.fail();
    }

    @Ignore
    @Test
    public void testdeduct(){
        double res = arithmetics.deduct(3, 7);
        Assert.assertTrue(res == -4);
    }

    @Test
    public void testDiv(){
        double res = arithmetics.div(10, 2);
        Assert.assertTrue(res == 5);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivException(){
        arithmetics.div(10, 0);
    }

}
