import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FelineParamsTest {
    private final int kittensCount;
    private final int expected;

    public FelineParamsTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensByCountData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    @Test
    public void getCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);

        assertEquals(expected, actual);
    }
}