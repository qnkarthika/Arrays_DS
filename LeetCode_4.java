Median_of_Two_Sorted_Arrays
    
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Solution:

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0,k=0;
        int res[]=new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                res[k++]=nums1[i];
                i++;
            }
            else{
                res[k++]=nums2[j];
                j++;
            }
        }
        while(i<m){
            res[k++]=nums1[i];
            i++;
        }
        while(j<n){
            res[k++]=nums2[j];
            j++;
        }

       if((m+n)%2==0){
        int median1=(m+n)/2;
        int median2=(m+n)/2 - 1;
        return (res[median1]+res[median2])/2.0;
       }
       else{
        return res[(m+n)/2];
       }

    }
}
