package cn.com.cootoo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author system
 * @create 2019/6/10
 **/
public class Solution_2 {


    public static void main1(String[] args) {
        String s = "pwwkew";
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        StringBuffer sbf = new StringBuffer();
        for (Character c : set) {
            sbf.append(c);
        }
        System.out.println(ans + ":" + sbf.toString());
    }


    public static void main(String[] args) {
        String s = "pwwkew";
        int n = s.length(), ans = 0;
        // current index of character
        StringBuffer sbf = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            sbf.append(s.charAt(j));
        }
        System.out.println(ans);
        System.out.println(JSON.toJSONString(map));
        System.out.println(sbf.toString());
    }


    public static void main3(String[] args) {
        String s = "pwwkew";
        int ans = 0, i = 0, j = 0;
        System.out.println(s.length());
        System.out.println(s.charAt(i++));
        System.out.println(s.charAt(i++));
    }

}
