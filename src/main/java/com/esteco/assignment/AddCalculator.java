package com.esteco.assignment;

import java.security.PublicKey;

/**
 * The AddCalculator class provides functionality to perform addition operations on numbers.
 * It supports variable arguments and returns the sum as a string.
 *
 * @Author: Lilavati Shivaji Mhaske
 */
public class AddCalculator {
    public static String add(String... numberStrings){
        String result;
        String delimiter;
        String numbers;
        String[] numbersArray;

       for(String numberString: numberStrings){
            if(numberString.startsWith("//")){
                // System.out.println("delimiter: "+number.substring(2, number.indexOf("\n")));
                numbers = numberString.substring(numberString.indexOf("\n"));
                delimiter = numberString.substring(2, numberString.indexOf("\n"));

                numbersArray = numbers.split(delimiter);
                for (int i=0; i<numbersArray.length;i++){
                    if(numbersArray[i] == "")
                        System.out.print("BLANK2");
                    System.out.print(numbersArray[i]+" ");
                }
            }else{

            }
       }
       return "";
    }

    public static String addNums(String[] nums){
        int sum = 0;

        // Please handle negative number and missing number issue
        for(int i=0; i<nums.length; i++){
            sum += Integer.parseInt(nums[i]);
        }
        return ""+sum;
    }

    public static void main(String[] args) {
        add("//;\n1;2;;3;4;");
    }
}