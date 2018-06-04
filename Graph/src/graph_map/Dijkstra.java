/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_map;

/**
 *
 * @author Ander
 */
import java.util.*;

public class Dijkstra {

    private final List<Vertex> nodes;   //Lista de Vertex que tenemos
    private final List<Edge> edges;     //Lista de Edges
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public Dijkstra(Graph graph) {  //Constructor de Dijkstra
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Vertex>(graph.getVertices());    //Coge la lista de Vertex en el Graph que le pasamos
        this.edges = new ArrayList<Edge>(graph.getEdges());     //Coge la lista de Edges en el Graph que le pasamos
    }

    public void execute(Vertex source) {    //Este es el metodo que inicia todos los parametros desde un Vertex que será desde donde partamos
        settledNodes = new HashSet<Vertex>();   //Se crea un HashSet de Nodos
        unSettledNodes = new HashSet<Vertex>(); //Se crea un HashSet de Nodos
        distance = new HashMap<Vertex, Integer>();  //Se crea un HashSet de distancia
        predecessors = new HashMap<Vertex, Vertex>();   //Se crea un HashSet de distancia
        distance.put(source, 0);    //Metemos en el mapa distancia el vertice origen cuya distancia consigo mismo es 0, las demas de momento lo las sabemos
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node) {    //esta funcion se encarga de rellenar predecessors que tiene una asociacion para saber desde la ciudad en la que estamos a donde ir para llegar a sevilla
        List<Vertex> adjacentNodes = getNeighbors(node);    //carga la lista de nodos adyacentes sacandolos de los vecinos
        for (Vertex target : adjacentNodes) {   //recorre la coleccion entera de nodos adyacentes
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {  //Si la distancia entre el vecino y el target es menor que la que habia antes
                distance.put(target, getShortestDistance(node) + getDistance(node, target));    //asocia el nuevo vecino de menor distia con su distancia
                predecessors.put(target, node); //asociamos el vecino mas cercano con el nodo
                unSettledNodes.add(target); 
            }
        }   //Ejemplo cuando lo haga con Cadiz el adyacente es Malaga, como la distancia cadiz-sevilla es menor que pasando por el nodo no la guardara 

    }

    private int getDistance(Vertex node, Vertex target) {   //Distancia entre dos nodos
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node) {    //devuelve los vecinos del nodo que le pasamos
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {   //si ya estan en settled se ignoran
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {   //le pasas unos vertices y te devuelve el que esta a menos distancia
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public Integer getDistance(Vertex target) { //Metodo para devolver la distancia total hasta el objetivo
        return distance.get(target);    //El get en un  mapa obtiene el valor asociado a una key concreta
    }

    public LinkedList<Vertex> getPath(Vertex target) {  //Funcion para obtener el camino
        LinkedList<Vertex> path = new LinkedList<Vertex>(); //Donde va el camino
        Vertex step = target;   //Partimos desde valladolid
        // check if a path exists
        if (predecessors.get(step) == null) {   //Si no hay siguiente paso sale
            return null;
        }
        path.add(step); //Si hay el primer paso es el mismo nodo que le hemos pasado para llegar (sera el ultimo)
        while (predecessors.get(step) != null) {    //mientras exista camino lo añade
            step = predecessors.get(step);
            path.add(step);
        }

        Collections.reverse(path);  //le da la vuelta a la coleccion para dejarla en orden
        return path;
    }

}
