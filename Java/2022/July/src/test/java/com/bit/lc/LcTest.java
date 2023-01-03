package com.bit.lc;

import org.junit.Test;

import java.util.*;

import static com.bit.lc.Solution2.containsDuplicate;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-11 20:00
 */

public class LcTest {
    @Test
    public void truncateSentence(){
        String s="Hello how are you Contestant";
        String [] arr=s.split(" ");
        int k=4;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=k-1;i++){
            sb.append(arr[i]+" ");
        }
        String ret=sb.substring(0,sb.length()-1);
        System.out.println(ret.toString());
    }

    @Test
    public void tset(){
        int x=0;
        int y=0;
        int k=0;
        for(int z=0;z<5;z++){
            if((++x>2)&&(++y>2)&&(k++)>2){
                x++;
                ++y;
                k++;
            }
        }
        System.out.println(x + "" + y + "" + k);
    }

    @Test
    public void test1(){
        Double o1= true?new Integer(1): new Double(2.0);
        Object o2;
        if(true){
            o2=new Integer(1);
        }else{
            o2=new Double(2.0);
        }
        System.out.println(o1);
        System.out.println(" ");
        System.out.println(o2);
        System.out.println(14^3);
    }
    @Test
    public void test2(){
        List<Integer> list=new ArrayList<Integer>();
        list.add(0,1);
        list.add(0,2);
        System.out.println(list);
    }

    @Test
    public  void testContainsDuplicate(){
        int [] nums = new int[]{1,2,3,1};
        containsDuplicate(nums);
    }

}
