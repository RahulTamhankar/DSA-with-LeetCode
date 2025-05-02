class Solution {
    public String removeDuplicates(String s) {
             // Create an empty stack.
        Stack <Character> stack = new Stack<>();

        // Iterare over the string
        for (char c: s.toCharArray()) {
            // If stack has at least one character and
            // stack's top character is same as the string's character.
            if (!stack.isEmpty() && stack.peek() == c) {
                // Pop a character from the stack.
                stack.pop();
            } else {
                // Otherwise, push that character onto the stack.
                stack.push(c);
            }
        }

        // Initialize a StringBuilder to construct the result string
        StringBuilder result = new StringBuilder();
        // Pop all characters from the stack and append them to the 
        // StringBuilder
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Since the characters were added in reverse order, 
        // reverse the StringBuilder to get the final result
        return result.reverse().toString();
    }
}