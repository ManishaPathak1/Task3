import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static int[] maxSumIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = Arrays.copyOf(arr, n);
        int maxSum = dp[0];
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                    if (dp[i] > maxSum) {
                        maxSum = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        int[] result = new int[endIndex + 1];
        int currSum = maxSum;
        for (int i = endIndex; i >= 0; i--) {
            if (dp[i] == currSum) {
                result[i] = arr[i];
                currSum -= arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        int[] result = maxSumIncreasingSubsequence(arr);
        System.out.println("Maximum Sum Increasing Subsequence: " + Arrays.toString(result));
    }
}