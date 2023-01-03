package com.bit.lc;


import java.util.*;
import java.util.List;

/**
 * 前k个高频词
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            int count= map.getOrDefault(word,0)+1;
            map.put(word,count);
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            ret.add(entry.getKey());
        }

        Collections.sort(ret, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1)==map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1);
            }
        });
        return ret.subList(0, k);
    }
}