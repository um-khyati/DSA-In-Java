class Solution {

    private int nodes;
    private int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                nodes = 0;
                degreeSum = 0;

                dfs(i, graph, visited);

                int edgeCount = degreeSum / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs(int node,
                     List<Integer>[] graph,
                     boolean[] visited) {

        visited[node] = true;
        nodes++;

        degreeSum += graph[node].size();

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}