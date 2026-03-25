class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        arr.get(0).add(1);
        for(int i =0;i<numRows-1;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i+1;j++){
                temp.add((arr.get(i).get(j-1))+(arr.get(i).get(j)));
            }
            temp.add(1);
            arr.add(new ArrayList<>(temp));
        }
        return arr;
    }
}