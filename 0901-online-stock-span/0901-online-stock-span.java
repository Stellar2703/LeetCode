class StockSpanner {
    class Pair{
        int price;
        int ind;
        Pair(int price,int ind){
            this.price = price;
            this.ind = ind;
        }
    }
    int index = -1;
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        index++;
        while(!st.isEmpty()){
            if(st.peek().price<=price){
                st.pop();
            }
            else{
                break;
            }
        }
        if(st.isEmpty()){
            st.push(new Pair(price,index));
            return index+1;
        }
        else{
            int n = index -st.peek().ind;
            st.push(new Pair(price,index));
            return (n);
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */