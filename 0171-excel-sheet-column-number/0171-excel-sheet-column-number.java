class Solution {
    public int titleToNumber(String columnTitle) {
        int result=0;
        for(char c:columnTitle.toCharArray()){
            result=result*26+(c-'A'+1);
        }
        return result;
    }
}

//So we add +1 to shift from 0-based index (programming) to 1-based index (Excel)

