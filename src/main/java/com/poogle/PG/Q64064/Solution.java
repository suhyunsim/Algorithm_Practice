package main.java.com.poogle.PG.Q64064;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {

    private static Set<Set<String>> result;

    public static void main(String[] args) {
        System.out.println(
            solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(
            new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[]{"*rodo", "*rodo", "******"}
        ));
        System.out.println(solution(
            new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[]{"fr*d*", "*rodo", "******", "******"}
        ));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return result.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length) {
            if (isBanned(set, banned_id)) {
                result.add(new HashSet<>(set));
            }
            return;
        }
        for (String user : user_id) {
            if (!set.contains(user)) {
                set.add(user);
                dfs(user_id, banned_id, set);
                set.remove(user);
            }
        }
    }

    private static boolean isBanned(Set<String> set, String[] banned_id) {
        int i = 0;
        for (String user : set) {
            if (!isSameString(user, banned_id[i++])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameString(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            }
            if (user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
