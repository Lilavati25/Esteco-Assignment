package com.esteco.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddCalculator {
    private static final String DEFAULT_DELIMITER = ",";
    private static final String BLANK_SPACE = "";

    public static String add(String... numbersStrList){
        StringBuffer result = new StringBuffer(BLANK_SPACE);

        for(String numberStr: numbersStrList){
            if(numberStr.trim().isEmpty()){
                result.append("0\n");
                continue;
            }

            String delimiter = DEFAULT_DELIMITER;
            String actualNumStr = numberStr;

            if (numberStr.startsWith("//")){
                actualNumStr = numberStr.substring(numberStr.indexOf("\n")+1);
                delimiter = numberStr.substring(2, numberStr.indexOf("\n"));
            }

             if(actualNumStr.endsWith(delimiter)){
                 result.append("Number expected but EOF found\n");
                 continue;
             }

            String regex = Pattern.quote(delimiter) + "|\\n|, ";
            String[] numbers = actualNumStr.split(regex);

            int sum = 0;
            boolean negativeNumPresent = false;

             for(int i=0; i< numbers.length; i++){
                 if(!numbers[i].trim().isEmpty()){
                     try{
                         int n = Integer.parseInt(numbers[i].trim());
                         if(n<0){
                             result.append("Negative numbers not allowed : ").append(n).append("\n");
                             negativeNumPresent = true;
                             continue;
                         }
                         sum += n;
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                 }else{
                     result.append("Number expected but '").append(delimiter).append("' found at position ").append(i).append("\n");
                 }
             }
             if(!negativeNumPresent){
                 result.append(sum).append("\n");
             }
        }

        if(result.toString().endsWith("\n"))
            result = new StringBuffer(result.substring(0, result.lastIndexOf("\n")));
        return result.toString();
    }
}
