package com.example.se2_einzelbeispiel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.EditText;

public class ExampleUnitTest {

    String Matrikelnummer;
    int[] MatrikelnummerArray;

    @Before
    public void setup(){
        Matrikelnummer = "11704726";
        MatrikelnummerArray = new int[]{1, 1, 7, 0, 4, 7, 2, 6};
    }
    @After
    public void clear(){
        Matrikelnummer = null;
        MatrikelnummerArray = null;
    }
    @Test
    public void TestIsPrime(){
        assertTrue(OrderAndDeletePrimeNumbers.isPrime(7));
    }
    @Test
    public void StringToArray(){
        int [] ArrayMatrikelnummer = {1,1,7,0,4,7,2,6};
        assertArrayEquals(ArrayMatrikelnummer,OrderAndDeletePrimeNumbers.StringToArray(Matrikelnummer));
    }
    @Test
    public void ArraySorter(){
        int [] ArraySortedMatrikelnummer = {0,1,1,2,4,6,7,7};
        assertArrayEquals(ArraySortedMatrikelnummer,MatrikelnummerArray);

    }
}