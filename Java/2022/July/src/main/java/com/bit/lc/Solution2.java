package com.bit.lc;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val:nums) {
            if(!set.add(val)) {
                return true;
            }
        }
        return false;
    }

}
