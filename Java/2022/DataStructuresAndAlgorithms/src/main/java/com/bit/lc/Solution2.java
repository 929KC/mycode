package com.bit.lc;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int data:nums) {
            if(!set.add(data)) {
                return true;
            }
        }
        return false;
    }

}
