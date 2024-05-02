import java.util.ArrayList;
import java.util.List;

public class GraphAlgorithms {

    public static <V> int[] shortestPathWeights(Graph<V> graph, V v) {

        List<Integer> exploredVertexIndexes = new ArrayList<>();
        int[] cost = new int[graph.getSize()];

        int sourceVertexIndex = graph.getIndex(v);
        for (int i = 0; i < cost.length; i++) {
            if (i == sourceVertexIndex)
                cost[i] = 0;
            else
                cost[i] = Integer.MAX_VALUE;
        }

        while (exploredVertexIndexes.size() < graph.getSize()) {
            int minCostVertexIndex = -1;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < cost.length; i++) {
                if (!exploredVertexIndexes.contains(i) && cost[i] < minCost) {
                    minCost = cost[i];
                    minCostVertexIndex = i;
                }
            }

            List<Edge> neighbors = graph.getIncidentEdges(graph.getVertex(minCostVertexIndex));
            for (Edge edge : neighbors) {
                int neighborIndex = edge.getEndVertexIndex();
                int newCost = cost[minCostVertexIndex] + edge.getWeight();
                if (newCost < cost[neighborIndex]) {
                    cost[neighborIndex] = newCost;
                }
            }

            exploredVertexIndexes.add(minCostVertexIndex);
        }

        return cost;
    }
}