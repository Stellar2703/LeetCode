class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : candyType){
            hs.add(ele);
        }

        int size = hs.size();
        int n = candyType.length;
        if(size<n/2){
            return size;
        }
        else{
            return n/2;
        }
    }
}