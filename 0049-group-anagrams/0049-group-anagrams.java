class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> ans = new HashMap<>();
        for(String s : strs){
            int [] n = new int[26];

            for(char c : s.toCharArray()){
                n[c-'a']++;
            }
            StringBuilder temp = new StringBuilder();
            for(int i =0;i<26;i++){
                temp.append('#');
                temp.append(n[i]);
            }
            if(!ans.containsKey(temp.toString())){
                ans.put(temp.toString(),new ArrayList<>());
            }
            ans.get(temp.toString()).add(s);
        }
        return new ArrayList<>(ans.values());
        }
}