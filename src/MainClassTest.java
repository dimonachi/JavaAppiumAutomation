import org.junit.Assert;
import org.junit.Test;

public class MainClassTest  {

    MainClass number = new MainClass();
    @Test
    public void testGetClassNumber() {
        if (number.getClassNumber() > 45)
        {
            System.out.println("Метод возвращает верное значение!");
        }
        else
        {
            Assert.fail("Метод возвращает неверное значение!");
        }
    }
}