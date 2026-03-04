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

    public int findUpar(int node){
        if(parent[node]==node) return node;
        return parent[node] = findUpar(parent[node]);
    }

    public Boolean UnionByRank(int u, int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) return true;

        if(rank[ulp_u]>rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }
        else if (rank[ulp_v]>rank[ulp_u]){
            parent[ulp_u] = ulp_v;
        }
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Disjoint ds = new Disjoint(edges.length+1);
        int []  ans = new int[2];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(ds.UnionByRank(u,v)){
                    ans[0] = u;
                    ans[1] = v;
                }
        }
    return ans;
    }
}