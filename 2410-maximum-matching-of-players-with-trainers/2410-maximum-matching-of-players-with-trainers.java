class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = 0,t=0,count=0;
        while(p<players.length && t<trainers.length){
            if(players[p]>trainers[t]){
                t++;
            }
            else{
                p++;
                t++;
                count++;
            }
        }
        return count;
    }
}