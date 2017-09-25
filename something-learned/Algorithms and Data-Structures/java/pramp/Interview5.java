package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Split the words in a given string and print all of them in the descending
 * order of their occurences count.
 *
 * @author: shivam.maharshi
 */
class Interview5 {

  // 1. Parse the doc and figure out words split by space, punctuations or both.
  // 2. Store them in a HasHMap and keep occurrences count.
  // 3. Traverse HashMap keyset and sort it.
  // 4. Time: O(nLog(n)): where n are the words. Space: O(n)

  public static void getCount(String s) {
    if (s == null || s.length() == 0)
      return;
    // This returns only words as array from s.
    // String[] words = s.split("\\W+");
    Map<String, Integer> m = new HashMap<>();
    s = s.toLowerCase();
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (isWordChar(c))
        sb.append(c);
      else if (sb.length() == 0)
        addWord(m, sb);
      i++;
    }
    if (sb.length() == 0)
      addWord(m, sb);
    System.out.println(m.toString());
  }

  public static boolean isWordChar(char c) {
    return (c <= '9' && c >= '0') || (c <= 'z' && c >= 'a');
  }

  public static void addWord(Map<String, Integer> m, StringBuilder sb) {
    String word = sb.toString();
    if (m.containsKey(word))
      m.put(word, m.get(word) + 1);
    else
      m.put(word, 1);
    sb = new StringBuilder();
  }

}
