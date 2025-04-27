class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int jewelCount=0;
        HashSet<Character> set=new HashSet<>();

        for(char i:jewels.toCharArray()){
            set.add(i);
        }

        for(char i:stones.toCharArray()){
            if(set.contains(i)){
                jewelCount++;
            }
        }
        return jewelCount;
    }
}