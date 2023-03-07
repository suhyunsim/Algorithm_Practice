package main.java.com.poogle.cracking.Ch4TreesGraphs.Q1;

import java.util.LinkedList;

public class Problem {
    public static void main(String[] args) {
        Graph graph = create();
        Node[] node = graph.getNodes();
        Node start = node[3];
        Node end = node[5];
        System.out.println(search(graph, start, end));
    }

    private static boolean search(Graph graph, Node start, Node end) {
        LinkedList<Node> queue = new LinkedList<>();
        for (Node u : graph.getNodes()) {
            u.state = State.UNVISITED;
        }
        start.state = State.VISITING;
        queue.add(start);
        Node u;
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.UNVISITED) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.VISITING;
                            queue.add(v);
                        }
                    }
                }
                u.state = State.VISITED;
            }
        }
        return false;
    }

    private static Graph create() {
        Graph graph = new Graph();
        Node[] temp = new Node[6];
        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            graph.addNode(temp[i]);
        }
        return graph;
    }

    static class Graph {
        int MAX_VERTEXES = 6;
        private Node vertexes[];
        public int count;

        public Graph() {
            vertexes = new Node[MAX_VERTEXES];
            count = 0;
        }

        public void addNode(Node node) {
            if (count < vertexes.length) {
                vertexes[count] = node;
                count++;
            } else {
                System.out.println("Graph Full");
            }
        }

        public Node[] getNodes() {
            return vertexes;
        }
    }

    static class Node {

        private Node adjacent[];
        public int adjacentCnt;
        private String vertex;
        public State state;

        public Node(String vertex, int adjacentLength) {
            this.adjacentCnt = 0;
            this.vertex = vertex;
            this.adjacent = new Node[adjacentLength];
        }

        public void addAdjacent(Node node) {
            if (adjacentCnt < adjacent.length) {
                this.adjacent[adjacentCnt] = node;
                adjacentCnt++;
            } else {
                System.out.println("stop");
            }
        }

        public Node[] getAdjacent() {
            return adjacent;
        }

        public String getVertex() {
            return vertex;
        }
    }

    enum State {
        UNVISITED, VISITED, VISITING
    }

}
