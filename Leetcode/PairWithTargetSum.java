package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum {
    /*
        Difficulty : Easy
        This problem wants us to return a pair whose sum == target
        Assuming that the array is sorted,
        we can solve this using a two pointer algorithm,
        where the left pointer == 0
        where the right pointer == arr.length - 1
        then we have to test for three scenarios
        if the sum of elements of the two pointers == target
            then we will return the pair of the two indexes
        if the currentSum < target :
            it means that the pair is in the left subArray,
                so we will then increment the left pointer

            else we will decrement the right pointer
            Time Complexity = O(N)
            Space Complexity = O(1)


     */
    public static int [] findPair1(int [] arr, int target){
        int n = arr.length;
        //create two pointers since the array is sorted
        int left = 0, right = arr.length -1;
            //traversing through the arr
        while (left < right){
            int currSum  = arr[left] + arr[right];
            //check if currsum = target
            if (currSum == target){
                return new int[]{left, right};
            } else if (currSum < target){
                left++;
            }else {
                right--;
            }
        }
       return new int[]{-1,-1};

    }
    /*
        we can also use a HashMap to solve this problem :
            implement a Hashmap to store the integer and an indices
            lets say pair0 + arr[i] = target
            then we check if the map contains (target - arr[i])
                if it does, then return pair0, arr[i]
                else,we add the integer and its indices to the map
                Time Complexity = O(n)
                Space Complexity = O(n)
     */
    public static int[] findPair(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int pair0 = target - arr[i];
            if (map.containsKey(pair0)) {
                return new int[]{map.get(pair0), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int s = 6;
        int[] res = findPair(arr, s);
        int [] res2 = findPair1(arr,s);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }
}
