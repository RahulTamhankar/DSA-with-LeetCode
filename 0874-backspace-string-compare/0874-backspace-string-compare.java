class Solution {
    public boolean backspaceCompare(String s, String t) {
       int ps=s.length()-1;
       int pt=t.length()-1;

       while(ps>=0 || pt>=0){
        ps=get_next_valid_char_index(s,ps);
        pt=get_next_valid_char_index(t,pt);
        if(ps<0 && pt<0){
            return true;
        }
        if(ps<0 || pt<0){
            return false;
        }else if(s.charAt(ps)!=t.charAt(pt)){
            return false;
        }
        ps--;
        pt--;
       }
        return true;
    }

    public int get_next_valid_char_index(String str,int end){
        int backspace_count=0;
        while(end>=0){
            if(str.charAt(end)=='#'){
                backspace_count++;
            }else if(backspace_count>0){
                backspace_count--;  // skip this char
            }else{
                break; // this is the next valid char

            }
            end--;
        }
        return end;
    }
}


// but we are anyways returning end and not backspace_count right


// ChatGPT said:
// You're absolutely right to notice that we return end, not backspace_count — and that’s by design.

// Let me walk you through why backspace_count is needed, even though the method ultimately just returns the end pointer.

// \U0001f9e0 Think of backspace_count as a filter
// We're scanning the string from right to left, and we want to skip all characters that are logically deleted by backspaces (#).

// We use backspace_count to track how many deletions are pending, so we know whether to skip a character or return its index.