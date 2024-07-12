import java.util.*;

class Solution85 {
    public boolean isBipartite(int[][] graph) {
       // Convert the 2D array to an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < graph.length; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                neighbors.add(graph[i][j]);
            }
            adj.add(neighbors);
        }
        
        // Initialize the visitation and color arrays
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // -1 means uncolored
        
        // Try to color the graph using BFS
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, color, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfsCheck(List<List<Integer>> adj, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Start coloring the first node with color 0
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    // If the neighbor is uncolored, color it with the opposite color
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // If the neighbor has the same color as the current node, the graph is not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }
}