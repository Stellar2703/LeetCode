class MinStack {

    class Pair {
        int ele;
        int min;

        Pair(int ele, int min) {
            this.ele = ele;
            this.min = min;
        }
    }

    ArrayList<Pair> st;

    public MinStack() {
        st = new ArrayList<>();
    }

    public void push(int val) {

        if (st.isEmpty()) {
            st.add(new Pair(val, val));
        } else {

            int currentMin = Math.min(val, st.get(st.size() - 1).min);

            st.add(new Pair(val, currentMin));
        }
    }

    public void pop() {
        st.remove(st.size() - 1);
    }

    public int top() {
        return st.get(st.size() - 1).ele;
    }

    public int getMin() {
        return st.get(st.size() - 1).min;
    }
}