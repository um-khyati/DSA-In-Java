class Solution {
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;
        int m = n + 1;

        int[] s = new int[m];

        for (int i = 0; i < n; i++) {
            s[i] = nums[i] + 1;
        }

        int[] sa = new int[m];
        int[] rank = new int[m];
        int[] temp = new int[m];

        int max = Math.max(m, 100002);
        int[] count = new int[max];

        for (int x : s) {
            count[x]++;
        }

        int sum = 0;

        for (int i = 0; i < max; i++) {
            int c = count[i];
            count[i] = sum;
            sum += c;
        }

        for (int i = 0; i < m; i++) {
            sa[count[s[i]]++] = i;
        }

        int classes = 1;
        rank[sa[0]] = 0;

        for (int i = 1; i < m; i++) {
            if (s[sa[i]] != s[sa[i - 1]]) {
                classes++;
            }
            rank[sa[i]] = classes - 1;
        }

        for (int len = 1; len < m; len <<= 1) {

            for (int i = 0; i < m; i++) {
                temp[i] = sa[i] - len;
                if (temp[i] < 0) {
                    temp[i] += m;
                }
            }

            Arrays.fill(count, 0, classes, 0);

            for (int i = 0; i < m; i++) {
                count[rank[temp[i]]]++;
            }

            for (int i = 1; i < classes; i++) {
                count[i] += count[i - 1];
            }

            for (int i = m - 1; i >= 0; i--) {
                int x = temp[i];
                sa[--count[rank[x]]] = x;
            }

            int[] newRank = new int[m];
            int newClasses = 1;

            newRank[sa[0]] = 0;

            for (int i = 1; i < m; i++) {

                int cur = sa[i];
                int prev = sa[i - 1];

                if (rank[cur] != rank[prev] ||
                        rank[(cur + len) % m] != rank[(prev + len) % m]) {
                    newClasses++;
                }

                newRank[cur] = newClasses - 1;
            }

            rank = newRank;
            classes = newClasses;

            if (classes == m) {
                break;
            }
        }

        int[] lcp = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i + 1]] = i;
        }

        int k = 0;

        for (int i = 0; i < n; i++) {

            int r = pos[i];

            if (r == 0) {
                k = 0;
                continue;
            }

            int j = sa[r];

            while (i + k < n && j + k < n &&
                    nums[i + k] == nums[j + k]) {
                k++;
            }

            lcp[r] = k;

            if (k > 0) {
                k--;
            }
        }

        int answer = n;

        for (int i = 0; i < n; i++) {

            int longest = lcp[i];

            if (i + 1 < n) {
                longest = Math.max(longest, lcp[i + 1]);
            }

            int required = longest + 1;

            if (required <= n - sa[i + 1]) {
                answer = Math.min(answer, required);
            }
        }

        return answer;
    }
}