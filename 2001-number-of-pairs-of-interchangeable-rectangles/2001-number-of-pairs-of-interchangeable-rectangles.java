class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Integer> mp = new HashMap<>();
        long count = 0;
        int n = rectangles.length;
        for (int i = 0;i< n;i++){
            double number = (double)rectangles[i][0]/(double)rectangles[i][1];
            if (mp.containsKey(number)){
                count += mp.get(number);
            }
            mp.put(number,mp.getOrDefault(number,0)+1);
        }
        return count;
    }
}