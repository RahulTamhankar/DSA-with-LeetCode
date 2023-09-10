class RandomizedSet {

    Map<Integer,Integer> map=null;
    List<Integer> arrayList=null;
    Random rand=null;
    
    public RandomizedSet() {
        map=new HashMap<>();
        arrayList=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,arrayList.size());
            arrayList.add(val);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            // replace from last always


            Integer lastNodeVal = arrayList.get(arrayList.size()-1);

            if(lastNodeVal== val){
                arrayList.remove(arrayList.size()-1);
                map.remove(new Integer(val));
                return true;
            }
            int indexOfVal = map.get(val);
            arrayList.set(indexOfVal, lastNodeVal);
            map.put(lastNodeVal, indexOfVal);
            arrayList.remove(arrayList.size()-1);
            map.remove(new Integer(val));
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int size=arrayList.size();
        int index=rand.nextInt(size);
        return arrayList.get(index);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */