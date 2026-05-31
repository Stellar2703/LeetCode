class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long comp = mass;
        for(int i =0;i<asteroids.length;i++){
            if(comp>=asteroids[i]){
                comp+=asteroids[i];
            }
            else{
                return false;
            }
        }
        return true;
    }
}