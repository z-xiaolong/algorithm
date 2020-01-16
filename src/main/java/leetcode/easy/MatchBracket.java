package leetcode.easy;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author long
 */
public class MatchBracket {
    static Stack<Character> stack = new Stack<>();
    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }


    public static void main(String[] args) {
        MatchBracket bracket = new MatchBracket();
        System.out.println(bracket.isValid("()"));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char currentChar = stack.peek();
                if (c == getOpposite(currentChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public char getOpposite(char c) {
        if (c == '(') {
            return ')';
        } else if (c == '{') {
            return '}';
        } else {
            return ']';
        }
    }


    //最优解
    public boolean isValidOptimal(String s){
        if (s.length()/2 != 0) {
            return false;
        }
        for (Character c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char currentChar = stack.peek();
                if (c == getOpposite(currentChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //骚操作
    public boolean isValidX(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }
}
