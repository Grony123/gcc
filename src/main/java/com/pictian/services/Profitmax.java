package com.pictian.services;

import com.pictian.models.Answer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

@Service
public class Profitmax {
    public Answer profitMaximization(String[] inputArray){
        List<int[]> array = new ArrayList<>();
        for(String s:inputArray){
            array.add(method(s));
        }
        int[] ans = new int[inputArray.length];
        int k=0;
        for(int[] a:array){
            int min = Integer.MAX_VALUE;
            int diff = 0;
            for(int i=1; i<a.length; i++){
                if(a[i]<min){
                    min = a[i];
                }else{
                    diff = max(diff,a[i]-min);
                }
            }
            ans[k] = diff;
            k++;
        }
        Answer answer = new Answer();
        answer.setAnswer(ans);
        return answer;
    }

    static int[] method(String str)
    {

        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];

        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }
}
