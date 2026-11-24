    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            int r = grid.length,c=grid[0].length;
            int top = 0,bottom=r-1,left =0,right=c-1;
            int times = Math.min(r/2,c/2);
            while(times-->0){
                ArrayList<Integer>arr = new ArrayList<>();
                for(int i =left;i<=right;i++)arr.add(grid[top][i]);
                for(int i =top+1;i<=bottom;i++)arr.add(grid[i][right]);
                for(int i =right-1;i>=left;i--)arr.add(grid[bottom][i]);
                for(int i =bottom-1;i>top;i--)arr.add(grid[i][left]);
                int t = k%arr.size();
                int st = t;
                for(int i =left;i<=right;i++)grid[top][i] = arr.get(st++ % arr.size());
                for(int i =top+1;i<=bottom;i++)grid[i][right] = arr.get(st++ % arr.size());
                for(int i =right-1;i>=left;i--)grid[bottom][i] = arr.get(st++ % arr.size());
                for(int i =bottom-1;i>top;i--)grid[i][left] = arr.get(st++ % arr.size());
                top++;bottom--;left++;right--;
            }
            return grid;
        }
    }