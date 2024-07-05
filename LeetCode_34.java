Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:


Solution:

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[]=new int[2];
        arr[0]=isFirstPosition(nums,target);
        arr[1]=isLastPosition(nums,target);
        return arr;
    }
    public static int isFirstPosition(int nums[],int target){
        int l=0;
        int r=nums.length-1;
        int firstIndex=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                firstIndex=mid;
                r=mid-1;
            }
            else if(target>nums[mid]){
                 l=mid+1;
            }
            else if(target<nums[mid]){
                r=mid-1;
            }
        }
        return firstIndex;
    }

    public static int isLastPosition(int nums[],int target){
        int l=0;
        int r=nums.length-1;
        int lastIndex=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                lastIndex=mid;
                l=mid+1;
            }
            else if(target>nums[mid]){
                 l=mid+1;
            }
            else if(target<nums[mid]){
                r=mid-1;
            }
        }
        return lastIndex;
    }
}
