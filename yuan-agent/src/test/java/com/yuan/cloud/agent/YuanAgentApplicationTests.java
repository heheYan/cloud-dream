package com.yuan.cloud.agent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SpringBootTest
class YuanAgentApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 有效的括号
     */
    @Test
    void validParentheses() {
        String s = "(()[]({}";
        boolean isValid = isValid(s);
        System.out.println(isValid);

    }

    private static boolean isValid(String s) {
        // 字符串为空或长度为奇数，则匹配失败
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        // 定义括号对应map，做匹配
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 如果map不包含key，说明是左括号，则入栈
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                // 如果栈空，则匹配失败
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            }
        }
        // 最终的栈为空，则匹配成功
        return stack.isEmpty();
    }

    @Test
    void test() {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left = 0;
        int right = nums.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(nums[left], nums[right]));
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxArea);
    }

}