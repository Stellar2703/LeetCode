class LockingTree {
    int [] locked;
    int[] parent;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public boolean descendants(int num){

        for(int child : adj.get(num)){
            if(locked[child]!=-1) return true;
            if(descendants(child)){
                return true;
            }
        }
        return false;
    }

    public boolean ancestors(int num){
        if(parent[num] == -1) return true;
        if(locked[parent[num]] != -1) return false;
        if(ancestors(parent[num])) return true;
        return false;
        
    }

    public void unlockdes(int num){
        for(int child : adj.get(num)){
            locked[child] = -1;
            unlockdes(child);
        }
    }
    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        locked = new int[n];
        Arrays.fill(locked,-1);
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int i =1;i<n;i++) adj.get(parent[i]).add(i);

    }
    
    public boolean lock(int num, int user) {
        if(locked[num]==-1) {
            locked[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(locked[num]==user){
            locked[num] = -1;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked[num]==-1 && ancestors(num) && descendants(num)){
            unlockdes(num);
            locked[num] = user;
            return true;
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */