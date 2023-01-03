class Solution {
    public static void main(String[] args) {
        int [] nums = new int []{0,1,2,2,3,0,4,2};
        removeElement(nums,2);
    }
    public static int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}