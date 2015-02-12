package edu.uj.pdpum.dynprog.ssspp;

import java.util.HashSet;
import java.util.Set;

public class SimpleGraph {

    private final Integer[][] adjacencyMatrix;
    private final String[] vertices;

    public SimpleGraph(int vertexCount) {
        adjacencyMatrix = new Integer[vertexCount][vertexCount];
        vertices = new String[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = "";
            for (int k = 0; k < vertexCount; k++) {
                adjacencyMatrix[i][k] = null;
            }
        }
    }

    public Integer getEdge(int a, int b) {
        return adjacencyMatrix[a][b];
    }

    public boolean isEdge(int a, int b) {
        return (adjacencyMatrix[a][b] != null);
    }

    public void setEdge(int a, int b, int value) {
        adjacencyMatrix[a][b] = value;
        adjacencyMatrix[b][a] = value;
    }

    public void removeEdge(int a, int b) {
        adjacencyMatrix[a][b] = null;
        adjacencyMatrix[b][a] = null;
    }

    public String getVertex(int v) {
        return vertices[v];
    }

    public int getDegree(int v) {
        int dg = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (adjacencyMatrix[v][i] != null) {
                dg++;
            }
        }
        return dg;
    }

    public Set<Integer> getAdjacentVertices(int v) {
        Set<Integer> r = new HashSet<Integer>();
        for (int i = 0; i < vertices.length; i++) {
            if (adjacencyMatrix[v][i] != null) {
                r.add(i);
            }
        }
        return r;
    }

}
