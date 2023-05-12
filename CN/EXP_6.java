//Sliding window
/*
ALGORITHM
QUES: find the largest sum of K consecutive entries, given an array of size N. 
1. Add the first K components together and save the result in the currentSum variable.
Because this is the first sum, it is also the current maximum; thus, save it in the variable maximumSum.
2. As the window size is K, we move the window one place to the right and compute the sum of the items in the window.
3. Update the maximum if the currentSum is greater than the maximumSum, and repeat step 2.
*/

package EXP_6;

public class sender {

    static int maxSum(int[] arr,int k){
        //length of the array
        int n=arr.length;

        //length of array(n) must be greater than window size(k)
        if(n<k){
            System.out.println("Invalid");
            return -1;
        }

        //sum of first k(window size) elements
        int window_sum=0;
        for(int i=0;i<k;i++) window_sum+=arr[i];

        int max_sum=window_sum;

        //Calculating sums of remaining windows by
        //removing first element of previous window
        //and adding last element of current window
        //this way our window moves forward.

        //Also updating the maximum sum to current window sum
        // if the current window sum is greater
        // than existing maximum sum.
        for(int i=k;i<n;i++){
            window_sum+=(arr[i]-arr[i-k]);
            max_sum=Math.max(window_sum,max_sum);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        //window size
        int k=3;
        int[] arr={16, 12, 9, 19, 11, 8};
        System.out.println(maxSum(arr,k));
    }


}
