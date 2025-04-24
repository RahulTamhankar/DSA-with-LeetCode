class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
           HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    for( int num: nums1){
        map.put(num,map.getOrDefault(num, 0) + 1);

    }
    for(int num: nums2){
        if(map.getOrDefault(num, 0) > 0){
            list.add(num);
            map.put(num, map.get(num)-1);
            
        }
    }

    int res[] = new int[list.size()];
    int i = 0;
    for(int num: list){
        res[i++] = num;
    }
    return res;
    
    }
}