import org.junit.Assert;
import org.junit.Test;

public class MainClassTest  {

    MainClass number = new MainClass();
    @Test
    public void testGetLocalNumber() {
        if (number.getLocalNumber() == 14)
        {
            System.out.println("Метод возвращает верное число!");
        }
        else
        {
            Assert.fail("Метод возвращает неверное число!");
        }
    }
}