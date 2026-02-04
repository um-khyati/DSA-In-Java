class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int count = 0, idx = 0, n = apples.length;

        while (idx < n || !minHeap.isEmpty()) {

            if (idx < n && apples[idx] > 0) minHeap.offer(new int[]{idx + days[idx], apples[idx]});

            while (!minHeap.isEmpty() && minHeap.peek()[0] <= idx) minHeap.poll();

            if (!minHeap.isEmpty()) {
                if(--minHeap.peek()[1] == 0) minHeap.poll();
                count++;
            }

            idx++;
        }

        return count;
    }

}