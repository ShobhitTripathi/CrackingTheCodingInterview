package TreesAndGraphs;

import java.util.*;

public class Graph<T> {
    // We use Hashmap to store the edges in the graph
    private Map<T, List<T>> map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex (T vertex) {
        map.put(vertex, new LinkedList<T>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge (T source, T destination, boolean bidirectional) {
        if(!map.containsKey(source))
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true)
            map.get(destination).add(source);
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has " + map.keySet().size() + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirectional) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirectional == true)
            count = count / 2;
        System.out.println("The graph has " + count + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else {
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    public boolean hasRoute(T source, T destination, boolean isDirected) {
        Queue<T> queue = new LinkedList<>();
        boolean[] visited = new boolean[map.keySet().size()];

        visited[(Integer)source] = true;
        queue.add(source);

        Iterator<T> i;
        while (!queue.isEmpty()) {
            source = queue.poll();

            T temp;
            i = map.get(source).listIterator();
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext()) {
                temp = i.next();

                // If this adjacent node is the destination node,
                // then return true
                if (temp == destination)
                    return true;

                // Else, continue to do BFS
                if (!visited[(Integer)temp]) {
                    visited[(Integer) temp] = true;
                    queue.add(temp);
                }
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "map=" + map +
                '}';
    }
}
