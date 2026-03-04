class Disjoint{
    int[] rank;
    int[] parent;
    Disjoint(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int findUPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findUPar(parent[n]);
    }

    public void unionByRank(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v  =findUPar(v);
        if(ulp_v == ulp_u) return;
        if(rank[ulp_v]>rank[ulp_u]){
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v]<rank[ulp_u]){
            parent[ulp_v] = ulp_u;
        }
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> mp  = new HashMap<>();
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        for(int i=0;i<n;i++){
            for(int j=1 ; j<accounts.get(i).size();j++){
                if(mp.containsKey(accounts.get(i).get(j))){
                    ds.unionByRank(i,mp.get(accounts.get(i).get(j)));
                }
                mp.put(accounts.get(i).get(j),i);
            }
        }
        HashMap<Integer,List<String>> res =  new HashMap<>();
        for(Map.Entry<String,Integer> entry : mp.entrySet()){
            String s = entry.getKey();
            int index = ds.findUPar(entry.getValue());
            res.putIfAbsent(index, new ArrayList<>());
            res.get(index).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : res.entrySet()){
            int index = entry.getKey();
            List<String> temp = new ArrayList<>();
            List<String> temp1 = entry.getValue();
            Collections.sort(temp1);
            temp.add(accounts.get(index).get(0));
            temp.addAll(temp1);
            ans.add(temp);
        }
        return ans;
        }
    }
