import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;



@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String validGender = "Самец";
    @Mock
    private Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(validGender, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(validGender, feline);
        boolean actual = lion.doesHaveMane();

        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(validGender, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expected, actual);
    }


}