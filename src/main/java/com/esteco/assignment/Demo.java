package com.esteco.assignment;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String num =  "1\n2,3";
        String num2 =  "175.2,\n35";

        String delimiter = ",";

        String[] numbers = num2 .split("[," + delimiter + "\n]");

        int sum = 0;
        List<String> negativeNums = new ArrayList<>();
        for(String numb: numbers){
            if(!numb.isEmpty()){
                try{
                    int n = Integer.parseInt(numb);
                    if(n<0){
                        negativeNums.add(numb);
                        continue;
                    }
                    sum += n;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }
        }

        if(!negativeNums.isEmpty()){

        }

    }
}
