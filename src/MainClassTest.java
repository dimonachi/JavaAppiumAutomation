import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass test_string = new MainClass();
    String word_1 = "Hello";
    String word_2 = "hello";
    @Test
    public void testGetClassString() {

        if (test_string.getClassString().contains(word_1) ||
                test_string.getClassString().contains(word_2))
        {
            System.out.println("В строке присутствует " + word_1 + " или " + word_2);
        }
        else
        {
            Assert.fail("В строке отсутствует " + word_1 + " или " + word_2);
        }
    }
}