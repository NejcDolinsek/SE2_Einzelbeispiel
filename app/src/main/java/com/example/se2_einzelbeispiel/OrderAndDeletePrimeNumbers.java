package com.example.se2_einzelbeispiel;

import android.widget.EditText;

import java.util.Arrays;

public class OrderAndDeletePrimeNumbers {

    //This method gives back the prime numbers in the given String
    public static String matNumberWithOutPrimeNumbers(EditText Matrikelnummer){

        //Converts the EditText to String
        String matNumber = Matrikelnummer.getText().toString();
        //Converts the String to Array
        int [] matrikelnummerArray = StringToArray(matNumber);
        //Sorts the Array
        ArraySorter(matrikelnummerArray);

        StringBuilder a = new StringBuilder();

        for (int j : matrikelnummerArray) {
            if (!isPrime(j)) {
                a.append(j);
            }
        }
        return a.toString();
    }

    //It checks if the given number is a prime number
    public static boolean isPrime(Integer integer){
        boolean isPrime = false;
        int i = (int) Math.ceil(Math.sqrt(integer));
        if (i > 1) {
            do {
                if ((integer != i) && (integer % i == 0)) {
                    isPrime = false;
                    break;
                } else if (!isPrime)
                    isPrime = true;
                --i;
            } while (i > 1);
        }
        return isPrime;
    }

    // Coverts the String of MatNumbers to an Array
    public static int[] StringToArray(String x){
        String[] arr = x.split("");

        int [] arrayint = new int[arr.length];

        for (int i = 0; i < arrayint.length; i++) {
            arrayint[i] = Integer.parseInt(arr[i]);
        }
        return arrayint;
    }

    //This methode sorts the matNumber ascended
    public static String ArraySorter (int [] matNumber){
        Arrays.sort(matNumber);
        return Arrays.toString(matNumber);
    }




}
