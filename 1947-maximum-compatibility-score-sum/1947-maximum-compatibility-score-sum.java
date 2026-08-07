class Solution {
    int ans = 0;
    public void f(int index,int score,HashSet<Integer> hs,int[][] students,int[][]mentors){
        if(index == students.length){
            ans = Math.max(ans,score);
            return;
        }

        for(int i =0;i<students.length;i++){
            if(!hs.contains(i)){
                int sc = 0;
                for(int j=0;j<students[0].length;j++){
                    if(students[index][j]==mentors[i][j]){
                        sc+=1;
                    }
                }
                hs.add(i);
                f(index+1,score+sc,hs,students,mentors);
                hs.remove(i);
            }

        }
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        HashSet<Integer> hs = new HashSet<>();
        f(0,0,hs,students,mentors);
        return ans;
    }
}