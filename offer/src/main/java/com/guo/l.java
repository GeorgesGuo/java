package com.guo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class l {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(n, n, "", res);
        return res;
    }

    public static void dfs(int left, int right, String prefix, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(prefix);
        }
        if (left > 0) {
            dfs(left - 1, right, prefix + "(", res);
        }
        if (left < right) {
            dfs(left, right - 1, prefix + ")", res);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            List<String> ans = new ArrayList<String>();
            ans = generateParenthesis(n);
            System.out.println(ans);
        }
    }

}
