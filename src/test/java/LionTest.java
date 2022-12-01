package com.example;

import java.util.List;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Lion lion;
    private static final String validGender = "Самец";
    private static final String invalidGender = "Undefined";
    private static final String exceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
    @Mock
    private Feline feline;

    @Rule
    public final ExpectedException except = ExpectedException.none();

    @Before
    public void createNewObj() throws Exception {
        lion = new Lion(validGender, feline);
    }

    @Test
    public void getKittens() throws Exception {

        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {

        boolean actual = lion.doesHaveMane();

        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exceptNullPointerException() {
        except.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void expectExceptionMessage() throws Exception  {
        except.expectMessage(exceptionMessage);
        Lion lion = new Lion(invalidGender,feline);


    }
}




