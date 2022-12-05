package com.example;

import java.util.List;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Lion lion;
    private static final String validGender = "Самец";
    private static final String invalidGender = "Undefined";
    private static final String exceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
    @Mock
    private Feline feline;


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
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, lion.getFood());
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(invalidGender, feline);
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(exceptionMessage));
    }
}