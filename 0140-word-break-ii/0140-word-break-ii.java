    class Solution {
        public void f(int index,String s,List<String> words, StringBuilder temp, List<String> ans){
            if(index == s.length()){
                ans.add(temp.toString().trim());
                return;
            }
            for(String word : words){
                if(index+word.length()<=s.length() && s.substring(index,index+word.length()).equals(word)){
                    temp.append(s.substring(index,index+word.length()));
                    temp.append(" ");
                    f(index+word.length(),s,words,temp,ans);
                    temp.setLength(temp.length()-word.length()-1);
                }
            }
        }
        public List<String> wordBreak(String s, List<String> wordDict) {
            StringBuilder temp = new StringBuilder();
            List<String> ans = new ArrayList<>();
            f(0,s,wordDict,temp,ans);
            return ans;
        }
    }