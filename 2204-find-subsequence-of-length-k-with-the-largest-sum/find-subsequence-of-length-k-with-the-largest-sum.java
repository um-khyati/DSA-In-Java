class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        int T = quickselect(copy, 0, n - 1, n - k);

        int countGreater = 0, countEqual = 0;
        for (int x : nums) {
            if (x > T) countGreater++;
            else if (x == T) countEqual++;
        }
        int needEqual = k - countGreater;

        int[] res = new int[k];
        int idx = 0;
        for (int x : nums) {
            if (x > T) {
                res[idx++] = x;
            } else if (x == T && needEqual-- > 0) {
                res[idx++] = x;
            }
            if (idx == k) break;
        }
        return res;
    }
    private int quickselect(int[] a, int left, int right, int kIndex) {
        if (left == right) return a[left];
        int pivotIndex = partition(a, left, right);
        if (pivotIndex == kIndex) {
            return a[pivotIndex];
        } else if (pivotIndex < kIndex) {
            return quickselect(a, pivotIndex + 1, right, kIndex);
        } else {
            return quickselect(a, left, pivotIndex - 1, kIndex);
        }
    }

    private int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}