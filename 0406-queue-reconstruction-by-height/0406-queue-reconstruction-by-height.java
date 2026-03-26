class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            temp.add(people[i][1], people[i]); // insert at index k
        }

        for (int i = 0; i < people.length; i++) {
            people[i] = temp.get(i);
        }
        return people;
    }
}