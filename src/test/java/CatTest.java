package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;
    @Mock
    private Feline feline;

    @Before
    public void createNewObj() {
        cat = new Cat(feline);
    }

    @Test
    public void retrieveGetSound() {
        String expected = "Мяу";
        Assert.assertEquals(expected, cat.getSound());
    }

    @Test
    public void retrieveGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, cat.getFood());
    }
}

