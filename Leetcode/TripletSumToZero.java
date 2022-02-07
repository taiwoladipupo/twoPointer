package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    /*
        if the array is unsorted, we have to sort the arraY
        so x + Y  +z = 0
        x + Y = -z
     */
    public static List<List<Integer>>searchTriplets(int [] arr){
        //sort the array
        Arrays.sort(arr);
        //cretae a return list
        List<List<Integer>>triplets = new ArrayList<>();
        //iterate through the array
        for (int i = 0; i < arr.length; i++){
            //skip same element to avoid duplicate triplets
            if (i > 0 && arr[i] == arr[i - 1]){
                continue;
            }
            searchPair(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets){
        int right = arr.length - 1;
        while ( left < right){
            int currSum = arr[left] + arr[right];
            if (currSum == targetSum){
                //found triplets
                //add it to the list
                triplets.add(Arrays.asList(-targetSum,arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left -1]){
                    //skip the same element to avoid duplicates
                    left++;
                }

                while (left < right && arr[right] == arr[right + 1]){
                    right--;
                }
            }else if(targetSum > currSum){
                left++;
            }else {
                right--;
            }
        }
    }
}
