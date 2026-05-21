class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        for (int num : arr1) {
            while (num > 0) {
                hs.add(num);
                num /= 10;
            }
        }
        for (int num : arr2) {
            while (num > 0) {
                if (hs.contains(num))
                    max = Math.max(max, (int)Math.log10(num) + 1);
                num /= 10;
            }
        }
        return max;
    }
}