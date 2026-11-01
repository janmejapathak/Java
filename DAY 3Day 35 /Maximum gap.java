// Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

// You must write an algorithm that runs in linear time and uses linear extra space.

 

// Example 1:

// Input: nums = [3,6,9,1]
// Output: 3
// Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
// Example 2:

// Input: nums = [10]
// Output: 0
// Explanation: The array contains less than 2 elements, therefore return 0.
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109





class Solution {
    public int maximumGap(int[] nums) {

        int n = nums.length;

        if (n < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (min == max) {
            return 0;
        }

        int gap = (max - min + n - 2) / (n - 1);

        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        boolean[] used = new boolean[n - 1];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            int index = (num - min) / gap;

            if (index == n - 1) {
                index--;
            }

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
            used[index] = true;
        }

        int ans = 0;
        int prev = min;

        for (int i = 0; i < n - 1; i++) {
            if (used[i]) {
                ans = Math.max(ans, bucketMin[i] - prev);
                prev = bucketMax[i];
            }
        }

        return ans;
    }
}
