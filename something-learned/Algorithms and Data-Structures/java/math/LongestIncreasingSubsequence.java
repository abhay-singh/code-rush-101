package math;

/**
 * Find the length of the longest increasing sub sequence. The idea is a greedy
 * approach. Given an index i, if for any index j less than i, has longest
 * increasing subsequence of length N, then the longest increasing subsequence
 * of i will at least be length of the subsequence till j plus one, if a[i] >
 * a[j].
 *
 * @author shivam.maharshi
 */
public class LongestIncreasingSubsequence {

	// Find out the longest common subsequence in an int array.
	public static int longIncreasingSequence(int[] arr) {
		int len = arr.length;
		int[] dp = new int[len];
		int maxSubLen = 0;
		for (int i = 0; i < len; i++) {
			int subLen = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					subLen = Math.max(subLen, dp[j] + 1);
				}
			}
			dp[i] = subLen;
		}
		for (int i = 0; i < len; i++) {
			maxSubLen = Math.max(maxSubLen, dp[i]);
		}
		return maxSubLen;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 6, 3, 4, 1, 2, 9, 5, 8 };
		System.out.println(LongestIncreasingSubsequence.longIncreasingSequence(arr));
	}

}
