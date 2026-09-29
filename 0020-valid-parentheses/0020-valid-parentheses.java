class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put('[', ']');
        mp.put('{', '}');
        mp.put('(', ')');
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (mp.containsKey(c)) {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                if(c!= mp.get(st.pop())) return false;
            }           
        }
         if (st.isEmpty()) {
                return true;
            } else {
                return false;
            }
    }
}
