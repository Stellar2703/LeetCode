class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 1;

        // 1️⃣ strictly increasing
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        if (i == 1 || i == n) return false; // no increase or ended too early

        // 2️⃣ strictly decreasing
        int decStart = i;
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }
        if (i == decStart || i == n) return false; // no decrease or no third phase

        // 3️⃣ strictly increasing again
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n; // must consume entire array
    }
}




// class Solution {
//     public boolean isTrionic(int[] nums) {
//         int n = nums.length;
//         int i = 1;
//         while (i < n) {
//             if (nums[i - 1] < nums[i]) {
//                 while (i < n && nums[i - 1] < nums[i])
//                     i++;
//                 if (i < n && nums[i - 1] > nums[i]) {
//                     while (i < n && nums[i - 1] > nums[i])
//                         i++;

//                     if (i < n && nums[i - 1] < nums[i]) {
//                         while (i < n && nums[i - 1] < nums[i])
//                             i++;
//                     } else {
//                         return false;
//                     }
//                 } else {
//                     return false;
//                 }
//             } 
//             else {
//                 return false;
//             }
//         }
//         return true;
//     }
// }