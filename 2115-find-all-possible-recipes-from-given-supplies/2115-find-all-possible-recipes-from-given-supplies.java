class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> mp = new HashMap<>();
        HashMap<String,Integer> indeg  = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        for(int i=0;i<supplies.length;i++){
            q.offer(supplies[i]);
            indeg.put(supplies[i],0);
            mp.putIfAbsent(supplies[i],new ArrayList<>());
        }
        for(int i = 0;i<recipes.length;i++){
            for(String s : ingredients.get(i) ){
                mp.putIfAbsent(s, new ArrayList<>());
                mp.get(s).add(recipes[i]);  
                indeg.put(recipes[i],indeg.getOrDefault(recipes[i],0)+1);
            }
        }

        while(!q.isEmpty()){
            String node =  q.poll();
            if(!mp.containsKey(node)) continue;
            for(String s : mp.get(node)){
                indeg.put(s,indeg.get(s)-1);
                if(indeg.get(s)==0){
                    q.offer(s);
                }
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<recipes.length;i++){
            if(indeg.get(recipes[i])==0) ans.add(recipes[i]);
        }
        return ans;
    }
}