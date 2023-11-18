package com.pictian.services;

import com.pictian.models.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioOpt {
    public Answer portfolioOperation(List<String[]> input){
        int[] ans = new int[input.size()];
        int k=0;
        for(String[] strArray:input){
            ans[k]=0;
            int[] lenArray = method(strArray[0]);
            int[] arrayA = method(strArray[1]);
            int[] arrayB = method(strArray[2]);
            int lenA = lenArray[0];
            int lenB = lenArray[1];
            int maxSum = lenArray[2];
            int i=0,j=0;
            int count=0;
            int sum=0;
            while(i<lenA || j<lenB){
                if(i<lenA && j<lenB){
                    if(arrayA[i]<arrayB[j]){
                        sum+=arrayA[i];
                        if(sum>maxSum) {
                            sum -= arrayA[i];
                            break;
                        }
                        i++;
                    }else{
                        sum+=arrayB[j];
                        if(sum>maxSum){
                            sum -= arrayB[j];
                            break;
                        }
                        j++;
                    }
                }else if(i<lenA){
                    sum+=arrayA[i];
                    if(sum>maxSum) {
                        sum -= arrayA[i];
                        break;
                    }
                    i++;
                }else{
                    sum+=arrayB[j];
                    if(sum>maxSum){
                        sum -= arrayB[j];
                        break;
                    }
                    j++;
                }
                count++;
            }
            ans[k] = count;
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
