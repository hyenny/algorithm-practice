package com.algorithm.queuestack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(baseballGame.solve(strs));
    }

    public int solve(String[] strs) {
        Stack<Integer> stack = new Stack<>();
        for (String str : strs) {
            if (str.equals("C")) {
                stack.pop();
                continue;
            }

            if (str.equals("D")) {
                stack.push(stack.peek() * 2);
                continue;
            }

            if (str.equals("+")) {
                int size = stack.size();
                if (size > 2) {
                    stack.push(stack.get(size - 1) + stack.get(size - 2));
                }
                continue;
            }
            stack.push(Integer.parseInt(str));
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
