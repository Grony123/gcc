package com.pictian.services;

import com.pictian.models.Answer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Fileorganize {
    public Answer fileReorganization(String[] inputArray){
        int[] ans = new int[inputArray.length]; ;
        int k=0;
        for(String str:inputArray){
            Map<Character, Integer> mp = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                int count = mp.getOrDefault(str.charAt(i),0);
                mp.put(str.charAt(i),count+1);
            }
            int len=0;
            boolean oddPresent=false;
            for(int i:mp.values()){
                if(i%2==1){
                    len+=(i-1);
                    oddPresent=true;
                }else{
                    len+=i;
                }
            }
            if(oddPresent) len++;
            ans[k] = len;
            k++;
        }
        Answer answer = new Answer();
        answer.setAnswer(ans);
        return answer;
    }
}
