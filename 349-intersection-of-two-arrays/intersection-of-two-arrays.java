class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int size = 2048;
        int mask = size - 1;
        int[] table = new int[size];
        boolean[] occupied = new boolean[size];
        for (int num : nums1) {
            int h = Integer.hashCode(num) & mask;
            while (occupied[h] && table[h] != num) {
                h = (h + 1) & mask;
            }
            table[h] = num;
            occupied[h] = true;
        }
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int count = 0;
        boolean[] intersectionSet = new boolean[size];
        for (int num : nums2) {
            int h = Integer.hashCode(num) & mask;
            while (occupied[h]) {
                if (table[h] == num) {
                    if (!intersectionSet[h]) {
                        temp[count++] = num;
                        intersectionSet[h] = true;
                    }
                    break;
                }
                h = (h + 1) & mask;
            }
        }
        int[] result = new int[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }
}