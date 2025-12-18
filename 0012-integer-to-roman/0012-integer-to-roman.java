class Solution {
    public String intToRoman(int num) {
        int [] val ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] key = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;
        StringBuilder ans = new StringBuilder();
        while(num>0){
            if (num>=val[i]){
                num=num-val[i];
                ans.append(key[i]);
            }else{
                i++;
            }
        }
        return ans.toString();
    }
}