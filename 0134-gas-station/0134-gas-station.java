class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int  start = 0;
        int calc = 0;
        int total_cost = 0;
        int total_gas = 0;
        for (int i=0;i<gas.length;i++){
            total_cost+=cost[i];
            total_gas+=gas[i];
        }
        if (total_cost > total_gas){
            return -1;
        }
        for (int i = 0;i< gas.length;i++){
            calc+= (gas[i]-cost[i]);
            if (calc<0){
                calc = 0;
                start = i+1;
            }
        }
        return start;   
    }
}