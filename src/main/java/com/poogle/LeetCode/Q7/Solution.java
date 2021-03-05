package main.java.com.poogle.LeetCode.Q7;

public class Solution {
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;

        int result = 0;
        int cnt = 0;

        while (x != 0) {
            cnt++;
            result = result * 10 + x % 10;
            x /= 10;

            if (cnt == 9 && x != 0) {
                int cmp = Integer.MAX_VALUE / 10;
                if (result > 0) {
                    if ((result - cmp) > 0) {
                        result = 0;
                        break;
                    }
                } else {
                    if ((result + cmp) < 0) {
                        result = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
