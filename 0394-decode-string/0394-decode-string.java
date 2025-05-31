class Solution {
    public String decodeString(String s) {

    Stack<Integer> numStack = new Stack<>();
    Stack<String> stringStack = new Stack<>();
    int k = 0;

    for (char c : s.toCharArray()) {

      if (Character.isDigit(c)) {
        k = (k * 10) + (c - '0');
        continue;
      }

      if (c == '[') {
        numStack.push(k);
        k = 0;
        stringStack.push(String.valueOf(c));
        continue;
      }

      if (c != ']') {
        stringStack.push(String.valueOf(c));
        continue;
      }

      StringBuilder temp = new StringBuilder();
      while (!stringStack.peek().equals("["))
        temp.insert(0, stringStack.pop());

      // remove the "["
      stringStack.pop();

      // Get the new string
      StringBuilder replacement = new StringBuilder();
      int count = numStack.pop();
      for (int i = 0; i < count; i++)
        replacement.append(temp);

      // Add it to the stack
      stringStack.push(replacement.toString());
    }

    StringBuilder result = new StringBuilder();
    while (!stringStack.empty()) {
      result.insert(0, stringStack.pop());
    }
    return result.toString();
  }
}

//  Why temp.insert(0, stringStack.pop());
// \U0001f539 The line:
// java
// Copy
// Edit
// temp.insert(0, stringStack.pop());
// \U0001f539 What it does:
// This prepends each character to the temp string.

// ❓ Why insert at index 0?
// Stacks are Last-In-First-Out (LIFO). When we're popping characters from stringStack, the last character we pushed is the first to come out, but we want to rebuild the string in the correct original order.

// \U0001f4a1 Example:
// Suppose inside brackets we have "abc":

// We push:

// cpp
// Copy
// Edit
// stack.push("a");
// stack.push("b");
// stack.push("c");
// Then we pop:

// perl
// Copy
// Edit
// pop() → "c"
// pop() → "b"
// pop() → "a"
// If we do:

// java
// Copy
// Edit
// temp.append(stringStack.pop());  // gives "cba"
// But we want "abc", so we use:

// java
// Copy
// Edit
// temp.insert(0, stringStack.pop());  // builds it in reverse order of popping
// Result:

// After "c": temp = "c"

// After "b": temp = "bc"

// After "a": temp = "abc" ✅

// ✅ What does k = (k * 10) + (c - '0') do?
// \U0001f539 Purpose:
// Builds multi-digit numbers from characters, like '1', '2' → 12

// \U0001f538 (c - '0') explanation:
// Characters in Java have ASCII values.

// '0' is 48, '1' is 49, ..., '9' is 57.

// '2' - '0' = 50 - 48 = 2 → converts the char '2' to integer 2.

// \U0001f539 Why multiply by 10?
// This builds numbers digit-by-digit. Example:

// java
// Copy
// Edit
// String s = "12[a]";
// Iteration over '1':

// java
// Copy
// Edit
// k = 0 * 10 + (1) = 1
// Then over '2':

// java
// Copy
// Edit
// k = 1 * 10 + (2) = 12
// So k = 12 — we now know we need to repeat "a" 12 times.

// ✅ Summary
// Code	Meaning
// temp.insert(0, ...)	Reverses LIFO pop to preserve order
// k = (k * 10) + (c - '0')	Builds multi-digit numbers

// Let me know if you want a visual walkthrough with example input like "12[ab]"!






// You said:
// how  (1) in k = 0 * 10 + (1) = 1 


// ChatGPT said:
// Great follow-up! Let's clarify this:

// You're referring to this line in the expression:

// java
// Copy
// Edit
// k = (k * 10) + (c - '0');
// When I said:

// java
// Copy
// Edit
// k = 0 * 10 + (1) = 1
// The (1) part comes from:

// java
// Copy
// Edit
// (c - '0')
// Let’s break it down properly with an example:

// \U0001f539 Suppose the character c = '1'
// What is c - '0'?
// Java treats characters as integers when doing math:

// '1' has ASCII value 49

// '0' has ASCII value 48

// So:

// java
// Copy
// Edit
// '1' - '0' = 49 - 48 = 1
// Therefore:

// java
// Copy
// Edit
// k = (0 * 10) + 1 = 1
// \U0001f539 Then, next character c = '2'
// Same logic:

// '2' = 50

// '0' = 48

// '2' - '0' = 2

// So:

// java
// Copy
// Edit
// k = (1 * 10) + 2 = 12
// ✅ Why do we subtract '0'?
// This is a common trick to convert a character digit '1' to the int value 1.

// Character	ASCII	'c' - '0'
// '0'	48	0
// '1'	49	1
// '2'	50	2
// ...	...	...
// '9'	57	9

// So when you see:

// java
// Copy
// Edit
// (c - '0')
// It’s converting char '1' to int 1, '2' to 2, etc.