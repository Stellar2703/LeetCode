class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();

        for (int[] seat : reservedSeats) {
            mp.putIfAbsent(seat[0], new HashSet<>());
            mp.get(seat[0]).add(seat[1]);
        }

        int ans = (n - mp.size()) * 2;

        for (HashSet<Integer> seats : mp.values()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat : seats) {
                if (seat >= 2 && seat <= 5)
                    left = false;

                if (seat >= 4 && seat <= 7)
                    middle = false;

                if (seat >= 6 && seat <= 9)
                    right = false;
            }

            if (left && right)
                ans += 2;
            else if (left || middle || right)
                ans += 1;
        }

        return ans;
    }
}