import com.example.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Cat cat;

    @Test
    public void retrieveGetSound() {
        cat.getSound();
        Mockito.verify(cat, Mockito.times(1)).getSound();
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        String expected = "Мяу";
        Assert.assertEquals(expected, cat.getSound());
    }

    @Test
    public void retrieveGetFood() throws Exception {
        cat.getFood();
        Mockito.verify(cat, Mockito.times(1)).getFood();
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
    //тест
}

