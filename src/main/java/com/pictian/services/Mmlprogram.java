package com.pictian.services;

import com.pictian.models.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mmlprogram {
    public Answer mmlProgram(List<String[]> input){
        int[] ans = new int[input.size()];
        int k=0;
        for(String[] strArray:input){
            ans[k]=0;
            int cutOff = Integer.parseInt(strArray[0]);
            int len = Integer.parseInt(strArray[1]);
            int[] array = method(strArray[2]);
            for(int i=0; i<len; i++){
                int sum=0;
                for(int j=i; j<len; j++){
                    sum+=array[j];
                    if(sum<cutOff){
                        System.out.println(cutOff);
                        ans[k]++;
                    }
                }
            }
            k++;
        }
        Answer answer = new Answer();
        answer.setAnswer(ans);
        return answer;
    }

    private int[] method(String str)
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
