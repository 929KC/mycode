package com.bit.sort;

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
import static com.bit.sort.SortUtils.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-17 07:56
 */

public class SortTest {
    @Test
    public void testInsertSort(){
        int [] array = {2,4,6,8,3,9,10,15,17};
        insertSort(array);
        System.out.println("插入排序:"+Arrays.toString(array));
    }

    @Test
    public void testShellSort(){
        int [] array=new int[]{1,5,4,6,0,3};
        shellSort(array);
        System.out.println("希尔排序:"+Arrays.toString(array));
    }


    @Test
    public void testSelectSort1(){
        int [] array=new int[100];
        randomNum(array);
        selectOneSort(array);
        System.out.println("选择排序1:"+Arrays.toString(array));
    }
    @Test
    public void testSelectSort2(){
        int [] array=new int[]{18,3,10,2,7};
        selectTwoSort(array);
        System.out.println("选择排序2:"+Arrays.toString(array));
    }
    @Test
    public void testHeapSort(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20,100,45,78,320};
        heapSort(array);
        System.out.println("堆排序:"+Arrays.toString(array));
    }
    @Test
    public void testQuickSort(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20};
        quickSort(array);
        System.out.println("快速排序:"+Arrays.toString(array));
    }
    @Test
    public void testBulletSort(){
        int [] array = {12,4,100,8,3,9,10,15,17};
        bubbleSort(array);
        System.out.println("冒泡排序:"+Arrays.toString(array));
    }
    @Test
    public void testHoleQuickSort(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testPointerQuickSort(){
//        int [] array=new int[10_00000];
//        randomNum(array);
        int [] array={12,45,78,89,56,231,0,23};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void randomNum(int [] array){
        Random rand = new Random();
        for(int i=0;i<array.length;i++){
            array[i] = rand.nextInt(100);
        }
    }

    public static void traverseArray(int [] array){
        for (int i =0;i<array.length;i++){
            array[i]=i;
        }
    }

    /**
     * 非递归
     */
    @Test
    public void testHoleQuick2Sort(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20};
        quickSort2(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testMerger(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20};
        mergerSort(array);
        System.out.println("归并排序:"+Arrays.toString(array));
    }
    @Test
    public void testMergerSort2(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20};
        mergerSort2(array);
        System.out.println("递归版归并排序:"+Arrays.toString(array));
    }

    @Test
    public void testCountSort(){
        int [] array=new int[]{1,5,4,6,0,3};
        countSort(array);
        System.out.println("计数排序:"+Arrays.toString(array));
    }
    @Test
    public void testBucketSort(){
        int [] array=new int[]{18,3,10,2,7,45,47,89,20};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }
}
