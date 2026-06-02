import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class RelativeDistance {

    // Adjacency list to represent the undirected graph
    private final Map<String, Set<String>> graph = new HashMap<>();

    RelativeDistance(Map<String, List<String>> familyTree) {
        if (familyTree == null) return;

        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            if (parent == null || children == null) continue;

            // Ensure the parent exists in the graph
            graph.putIfAbsent(parent, new HashSet<>());

            for (int i = 0; i < children.size(); i++) {
                String child1 = children.get(i);
                if (child1 == null) continue;

                // Ensure the child exists in the graph
                graph.putIfAbsent(child1, new HashSet<>());

                // 1. Add Parent <-> Child connection
                graph.get(parent).add(child1);
                graph.get(child1).add(parent);

                // 2. Add Sibling <-> Sibling connections
                for (int j = i + 1; j < children.size(); j++) {
                    String child2 = children.get(j);
                    if (child2 == null) continue;

                    graph.putIfAbsent(child2, new HashSet<>());

                    graph.get(child1).add(child2);
                    graph.get(child2).add(child1);
                }
            }
        }
    }

    int degreeOfSeparation(String personA, String personB) {
        // If either person is not in the tree at all, they aren't connected
        if (personA == null || personB == null || !graph.containsKey(personA) || !graph.containsKey(personB)) {
            return -1;
        }
        
        // Zero degrees of separation if they are the same person
        if (personA.equals(personB)) {
            return 0;
        }

        // Setup BFS traversal
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distances = new HashMap<>();

        queue.add(personA);
        visited.add(personA);
        distances.put(personA, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDist = distances.get(current);

            // Return shortest distance if target is found
            if (current.equals(personB)) {
                return currentDist;
            }

            // Traverse all connected relatives
            for (String neighbor : graph.getOrDefault(current, Collections.emptySet())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distances.put(neighbor, currentDist + 1);
                    queue.add(neighbor);
                }
            }
        }

        // Exhausted graph, no path exists
        return -1;
    }
}