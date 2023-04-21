package stack;

public class Parentheses {
    // Note: Static methods - belong to class rather than instance. Method can be called without first creating an object of the class.
    // INTERVIEW QNS: Check if parentheses are balanced
    public static boolean isBalancedParentheses(String parenthesis) {
        Stack2<Character> stack = new Stack2<>();
        
        for (char p: parenthesis.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;   
                }
            } 
        }
        
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s1 = "()()()";
        String s2 = "()(()";
        String s3 = "(()())";
        System.out.println(isBalancedParentheses(s1)); // true
        System.out.println(isBalancedParentheses(s2)); // false
        System.out.println(isBalancedParentheses(s3)); // true
        
        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
        */
    }
    
}
