package com.random;

import java.util.*;

public class AmzTest {

    List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude) {

        String[] splitArray = literatureText.replace("'"," ").toLowerCase().replace("'"," ").trim().split("[^\\p{L}0-9']+");
        HashMap<String, Integer> occurrences = new HashMap<String, Integer>();
        for (String word : splitArray) {
            if (!wordsToExclude.contains(word.toLowerCase())) {
                int val = 0;
                if (occurrences.containsKey(word)) {
                    val = occurrences.get(word);
                }
                occurrences.put(word, val + 1);
            }
        }
        int maxFreq = occurrences.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get().getValue();
        List<String> res = new ArrayList<>();
        for(String s:occurrences.keySet() ){
            Integer i = occurrences.get(s);
            if(i == maxFreq){
                res.add(s);
            }
        }
        System.out.println(res);
        return res;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        AmzTest amz = new AmzTest();
        List<String> exc = new ArrayList<>();
        exc.add("and");
        exc.add("he");
        exc.add("to");
        exc.add("the");
        exc.add("is");
        exc.add("jack");
        exc.add("jill");
        String text = "Jack and jill went to the market to buy bread and cheese.cheese is Jack's and Jill's favourite food";
        amz.retrieveMostFrequentlyUsedWords(text, exc);
    }
}
