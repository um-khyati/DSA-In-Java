class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) return 0;

        int[] head = new int[n];
        Arrays.fill(head, -1);
        int m = edges.length;
        int[] to = new int[m];
        int[] weight = new int[m];
        int[] next = new int[m];

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            to[i] = v;
            weight[i] = w;
            next[i] = head[u];
            head[u] = i;
        }

        byte[] L = labels.getBytes();

        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[] minC = new int[n];
        Arrays.fill(minC, k + 1);

        MinHeap heap = new MinHeap(Math.max(128, m));
        dist[0][1] = 0;

        heap.push(((long) 0 << 22) | ((long) 1 << 16) | 0);

        while (!heap.isEmpty()) {
            long state = heap.pop();
            int d = (int) (state >>> 22);
            int c = (int) ((state >>> 16) & 0x3F);
            int u = (int) (state & 0xFFFF);

            if (u == n - 1) return d;

            if (c >= minC[u]) continue;
            minC[u] = c;

            int edgeIdx = head[u];
            byte charU = L[u];

            while (edgeIdx != -1) {
                int v = to[edgeIdx];
                int w = weight[edgeIdx];

                int nxtC = (charU == L[v]) ? c + 1 : 1;

                if (nxtC <= k) {
                    int nxtD = d + w;
                    if (nxtD < dist[v][nxtC]) {
                        dist[v][nxtC] = nxtD;
                        heap.push(((long) nxtD << 22) | ((long) nxtC << 16) | (long) v);
                    }
                }
                edgeIdx = next[edgeIdx];
            }
        }

        return -1;
    }

    class MinHeap {
        long[] data;
        int size;

        public MinHeap(int capacity) {
            data = new long[capacity];
            size = 0;
        }

        public void push(long val) {
            if (size == data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            int i = size++;
            while (i > 0) {
                int p = (i - 1) >>> 1;
                if (data[p] <= val) break;
                data[i] = data[p];
                i = p;
            }
            data[i] = val;
        }

        public long pop() {
            long ret = data[0];
            long val = data[--size];
            int i = 0;
            while ((i << 1) + 1 < size) {
                int left = (i << 1) + 1;
                int right = left + 1;
                int min = left;
                if (right < size && data[right] < data[left]) {
                    min = right;
                }
                if (val <= data[min]) break;
                data[i] = data[min];
                i = min;
            }
            data[i] = val;
            return ret;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}