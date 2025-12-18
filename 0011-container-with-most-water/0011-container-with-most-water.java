class Solution {
    public int maxArea(int[] height) {
        int ptr1 = 0;
        int ptr2 = height.length-1;
        int area = 0;
        while (ptr1 < ptr2){
            int temp = (ptr2 - ptr1) * Math.min(height[ptr1], height[ptr2]);
            area = Math.max(temp,area);
            if (height[ptr1] < height[ptr2]) {
                ptr1++;
            } else {
                ptr2--;
            }
        }
        return area;
        
    }
}