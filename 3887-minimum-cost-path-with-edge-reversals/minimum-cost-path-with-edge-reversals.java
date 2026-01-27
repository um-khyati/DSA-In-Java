class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, 2*w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[0] = 0;

        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int from = edge[0];
            int cost = edge[1];
            
            if(from == n - 1) return cost;
            if(minCost[from] < cost) continue;

            for(int[] neighbor : adj.get(from)) {
                int to = neighbor[0];
                int toCost = neighbor[1];

                if(minCost[from] + toCost < minCost[to]) {
                    minCost[to] = minCost[from] + toCost;
                    pq.add(new int[]{to, minCost[to]});
                }
            }
        }
        return minCost[n-1] == Integer.MAX_VALUE ? -1 : minCost[n-1];
    }
}