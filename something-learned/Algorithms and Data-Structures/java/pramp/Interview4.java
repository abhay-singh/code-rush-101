package pramp;

import java.util.Arrays;

/**
 * Given an array representing budget figure out a new maximum cap on a single
 * budget such that the total of the array is less than or equal to the given
 * budget. To achieve this you must affect only the minimum number of highest
 * budget values.
 *
 * @author: shivam.maharshi
 */
class Interview4 {

  // 1, 3, 7, 8, 10 S = 29, b = 25
  // 1, 3, 7, 7, 7 S = 25
  // 0, 0, 0, 1, 1
  // 1, 4, 11, 19, 29
  // (25 - 19) / 1 = 6
  // (25 - 11) / 2 = 7 > a[2]
  // 1, 2, 7, 8, 10 S = 28, b = 25
  // 1, 3, 10, 18, 28
  // 1 S = (25 - 18) / 1 = 7
  // 1, S = (25 - 10) / 2 = 7.5
  // Time Complexity: O(n Log(n) + n)

  public static float minCuts(int[] g, int b) {
    if (g == null || g.length == 0)
      return -1;
    Arrays.sort(g);
    int sum = 0;
    int[] dp = new int[g.length];
    dp[0] = g[0];
    for (int i = 1; i < g.length; i++) {
      dp[i] += dp[i - 1] + g[i];
      sum += g[i];
    }
    if (sum < b)
      return g[g.length - 1];
    for (int i = g.length - 1; i > 0; i++) {
      float v = (b - dp[i - 1]) / (g.length - i);
      if (g[i - 1] <= v)
        return v;
    }
    return b;
  }

}
