class Pair{
    int pos;
    int hel;
    char dir;
    int index;
    Pair(int pos,int hel,char dir,int index){
        this.pos =pos;
        this.hel = hel;
        this.dir= dir;
        this.index = index;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Pair[] arr= new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(positions[i],healths[i],directions.charAt(i),i);
        }

        Arrays.sort(arr,(a,b)->a.pos-b.pos);
        Stack<Pair> st = new Stack();
        for(int i =0;i<n;i++){
            st.push(new Pair(arr[i].pos,arr[i].hel,arr[i].dir,arr[i].index));
            while(st.size()>1){
                Pair p = st.pop();
                if(st.peek().dir == 'R' && p.dir == 'L'){
                    if(p.hel>st.peek().hel){
                        st.pop();
                        p.hel-=1;
                        st.push(p);
                    }
                    else if (p.hel<st.peek().hel){
                        Pair p1 = st.pop();
                        p1.hel-=1;
                        st.push(p1);
                    }
                    else{
                        st.pop();
                    }
                }
                else{
                    st.push(p);
                    break;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        Pair[] fin = new Pair[st.size()];
        int idx = 0;
        while(!st.isEmpty()){
            fin[idx++] = st.pop();
        }
        Arrays.sort(fin,(a,b)->a.index-b.index);
        for(Pair a : fin){
            ans.add(a.hel);
        }
        return ans;
    }
}