/**
 * @author Lilavati Shivaji Mhaske
 */

package com.esteco.assignment;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class MultiplyCalculator {
    private static final String DEFAULT_DELIMITER = ",";
    private static final String BLANK_SPACE = "";

    public static String multiply(String... numbersStrList){
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

            double product = 1;
            boolean negativeNumPresent = false;

             for(int i=0; i< numbers.length; i++){
                 if(!numbers[i].trim().isEmpty()){
                     try{
                         double n = Double.parseDouble(numbers[i].trim());
                         DecimalFormat decimalFormat = new DecimalFormat(n % 1 == 0 ? "0" : "0.###");
                         String formattedNumber = decimalFormat.format(n);

                         if(n<0){
                             result.append("Negative numbers not allowed : ").append(formattedNumber).append("\n");
                             negativeNumPresent = true;
                             continue;
                         }
                         product *= n;
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                 }else{
                     result.append("Number expected but '").append(delimiter).append("' found at position ").append(i).append("\n");
                 }
             }
             if(!negativeNumPresent){
                 DecimalFormat decimalFormat = new DecimalFormat(product % 1 == 0 ? "0" : "0.###");
                 String formattedSum = decimalFormat.format(product);
                 result.append(formattedSum).append("\n");
             }
        }

        if(result.toString().endsWith("\n"))
            result = new StringBuffer(result.substring(0, result.lastIndexOf("\n")));
        return result.toString();
    }
}
