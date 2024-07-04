Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

Solution:

class Solution {
    public int maxArea(int[] height) {
        int res=0;
        int l=0,r=height.length-1;
        while(l<r){
            int minimum=Math.min(height[l],height[r]);
            res=Math.max(res,minimum*(r-l));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return res;
    }
}
