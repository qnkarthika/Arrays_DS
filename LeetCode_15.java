3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Solution:

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> res=new LinkedList<>();
       for(int i=0;i<nums.length-2;i++){
        if(i==0 || (i>0 && nums[i]!=nums[i-1])){
        int sum=0-nums[i];
        int low=i+1;
        int high=nums.length-1;
        while(low<high){
            if(nums[low]+nums[high]==sum) {
                res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                while(low<high && nums[low]==nums[low+1]) low++;
                while(low<high && nums[high]==nums[high-1]) high--;
                low++;
                high--;
            }
            else if(nums[low]+nums[high]>sum){
                high--;
            }
            else if(nums[low]+nums[high]<sum){
                low++;
            }
        }
        }
       }
       return res;
    }
}
