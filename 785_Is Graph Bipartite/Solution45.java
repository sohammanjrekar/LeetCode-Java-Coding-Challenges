class Solution45 {
    // Main method to determine if the graph is bipartite
    public boolean isBipartite(int[][] graph) {
        int numNodes = graph.length; // Number of nodes in the graph
        int[] colors = new int[numNodes]; // Array to store the color of each node, initialized to 0 (uncolored)

        // Iterate through each node to ensure all components are checked
        for (int node = 0; node < numNodes; node++) {
            // If the node is uncolored, perform a DFS to check bipartiteness
            if (colors[node] == 0 && !dfsCheck(graph, colors, node, 1)) {
                return false; // If the DFS check fails, the graph is not bipartite
            }
        }
        return true; // If all nodes and their components are bipartite, return true
    }

    // Helper method to perform DFS and check bipartiteness
    private boolean dfsCheck(int[][] graph, int[] colors, int node, int color) {
        // If the node is already colored, check if it has the expected color
        if (colors[node] != 0) {
            return colors[node] == color; // Return true if it matches the expected color, false otherwise
        }

        colors[node] = color; // Color the current node with the given color

        // Iterate through all neighbors of the current node
        for (int neighbor : graph[node]) {
            // Perform DFS on the neighbor with the opposite color (-color)
            if (!dfsCheck(graph, colors, neighbor, -color)) {
                return false; // If the DFS check fails for any neighbor, return false
            }
        }
        return true; // If all neighbors are successfully colored, return true
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution45 sol = new Solution45();
        
        // Example graphs
        int[][] graph1 = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        
        int[][] graph2 = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        
        System.out.println(sol.isBipartite(graph1)); // Output: true
        System.out.println(sol.isBipartite(graph2)); // Output: false
    }
}
