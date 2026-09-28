class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> first = new HashSet<>();
        first.add('q');
        first.add('w');
        first.add('e');
        first.add('r');
        first.add('t');
        first.add('y');
        first.add('u');
        first.add('i');
        first.add('o');
        first.add('p');
    
        List<String> temp = new ArrayList<>();

        HashSet<Character> second = new HashSet<>(
            Arrays.asList('a','s','d','f','g','h','j','k','l')
        );
        HashSet<Character> third = new HashSet<>(
            Arrays.asList('z','x','c','v','b','n','m')
        );

        for(String word :words){
            boolean f = false, s = false, t = false;
            int len = word.length();
            for(int i =0;i<len;i++){
                char c = word.charAt(i);

                if(c>='A' && c<='Z'){
                    c = (char)(c-'A'+'a');
                }

                if(first.contains(c)) f = true;
                if(second.contains(c))s = true;
                if(third.contains(c))t = true;
            }

            if((!f && !s) || (!s && !t) || (!f && !t)){
                temp.add(word);
            }
        }
        int size = temp.size();

        String[] ans = new String[size];

        for(int i = 0;i<size;i++){
            ans[i] = temp.get(i);
        }

        return ans;

    }
}