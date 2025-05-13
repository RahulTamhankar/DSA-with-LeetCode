class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails=new HashSet<>();

        for(String email:emails){
            String[] parts=email.split("@");
            String local=parts[0];
            String domain=parts[1];

            local=local.split("\\+")[0];
            local=local.replace(".","");

            uniqueEmails.add(local+"@"+domain);
        }
        return uniqueEmails.size();
    }
}

// \U0001f538 WRONG: This won't compile
// java
// Copy
// Edit
// s.split("+");
// \U0001f534 This causes a regex error, because + is a special character in regular expressions and must be escaped.

// ✅ CORRECT: Escape + with a backslash
// java
// Copy
// Edit
// s.split("\\+");
// ✔️ Here's why:

// We want a literal + in the regex.

// In regex, that's written as \+.

// In a Java string, we write that as "\\+".


// ✅ Why . does not need to be escaped here:
// java
// Copy
// Edit
// local.replace(".", "")
// This uses String.replace(CharSequence target, CharSequence replacement), not regex. It treats "." as a literal dot, not a special character.

// You don’t need to escape the dot in:

// java
// Copy
// Edit
// local.replace(".", "")
// because replace() is not using regex — it's just replacing literal characters.
