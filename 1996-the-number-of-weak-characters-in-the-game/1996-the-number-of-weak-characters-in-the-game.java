class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b) ->{
            if(a[0] != b[0]){
               return a[0] - b[0];
            }
            else{
               return b[1] - a[1];
            }
        });
        int count =0;
        int max = -1;
        for(int i=properties.length-1;i>=0;i--){
            if(properties[i][1]>=max){
                max = properties[i][1];
            }
            else{
                count+=1;
            }
        }
        return count;
    }
}