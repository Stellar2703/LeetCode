class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int stone :stones) arr.add(stone);
        while(arr.size()>=2){
            Collections.sort(arr);
            int y = arr.get(arr.size()-1);
            int x = arr.get(arr.size()-2);
            arr.remove(arr.size()-1);
            arr.remove(arr.size()-1);
            if(x!=y)arr.add(y-x);
        }
        if(arr.size()==1) return arr.get(0);
        else return 0;
    }
}