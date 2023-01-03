package com.offer.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * dp求解步骤
 * 1.定义转态
 * 2.编写状态转移方程
 * 3.设置初始值
 */
public class FibonacciSequence {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        FibonacciSequence f = new FibonacciSequence();
        int fib = fib(6);
        System.out.println(fib);
        int val = f.Fibonacci(5);
        System.out.println(val);
    }

    /**
     * 菲波那切数列
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        // 0 1 1  2  3 5 6
        if (n == 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        int third = 1;
        final int MOD = 1000000007;
        while (n > 2) {
            third = (first + second) % MOD;
            first = second;
            second = third;
            n--;
        }
        return third;
    }

    /**
     * map剪枝
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        if (map.containsKey(n - 1)) {
            pre = map.get(n - 1);
        } else {
            pre = Fibonacci(n - 1);
            map.put(n - 1, pre);
        }
        int ppre = 0;
        if (map.containsKey(n - 2)) {
            ppre = map.get(n - 2);
        } else {
            ppre = Fibonacci(n - 2);
            map.put(n - 2, ppre);
        }
        return ppre + pre;
    }

    /**
     * 青蛙跳台阶
     *
     * @param number
     * @return
     */
    int jumpFloor(int number) {
        int[] dp = new int[number + 1];
        dp[0] = 1;
        dp[1] = 1;
        //f(n) = f(n-1)+f(n-2);
        //f(0) = 0
        //f(1) = 1
        //f(2) = 1
        if (number == 0) {
            return 0;
        }
        if (number <= 2) {
            return number;
        }
        for (int i = 2; i <= number; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) / 1000000007;
        }
        return dp[number];
    }

    /**
     * 矩形覆盖
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target < 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;

        // 计算到达每一层台阶的最小费用
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }
}
