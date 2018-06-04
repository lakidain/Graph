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
import java.util.stream.Collectors;

public class Graph {

    private Set<Vertex> vertices;   //Tenemos una estructura auxiliar que contendra todos los Vertex
    private Set<Edge> edges;    //Tenemos una estructura auxiliar que contendra todos los Edges
    private Map<Vertex, Set<Edge>> adjList; //El mapa asocia una key (Vertex) a valores, en nuestro caso va a ser una lista de Edges, no puede tener dos claves iguales

    public Graph() {    //Cuando inicializas un grafo vamos a inicializar todos los atributos que habiamos creado
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjList = new HashMap<>();//Nuestro mapa no tiene un orden especifico al insertar al ser HashMap. Podriamos haber puesto TreeMap (ordena por orden natural) y LinkedHashMap (orden de insercion)
    }

    public boolean addVertex(int label) {   //Añade un vertice pasando un identificador, crea el vertice con la etiqueta y despues lo añade
        return vertices.add(new Vertex(label));
    }

    public boolean addVertex(Vertex v) {    //Añade un vertice ya creado anteriormente
        return vertices.add(v);
    }

    public boolean addVertices(Collection<Vertex> vertices) {   //Puedes pasarle una coleccion de vertices y los añade al grafo
        return this.vertices.addAll(vertices);
    }

    public boolean removeVertex(int label) {    //Crea un vertice con el label que le identifica y lo borra
        return vertices.remove(new Vertex(label));
    }

    public boolean removeVertex(Vertex v) { //Pasamos un vertice y lo borra
        return vertices.remove(v);
    }

    public boolean addEdge(Edge e) {    //Añadimos un arco
        if (!edges.add(e)) {    //Si no se puede añadir el arco, porque esta repetido por ejemplo devolvera un false
            return false;
        }

        adjList.putIfAbsent(e.getSource(), new HashSet<>());   //Si el vertice1 no esta en el mapa todavia lo añadiremos, para ello lo asociaremos con una estructura HashSet donde estaran sus Edges
        adjList.putIfAbsent(e.getDestination(), new HashSet<>());   //

        adjList.get(e.getSource()).add(e); //Obtenemos el Vertice 1 del mapa y le añadimos el Edge a la estructura HashSet que creamos
        adjList.get(e.getDestination()).add(e); //Obtenemos el Vertice 2 del mapa y le añadimos el Edge a la estructura HashSet que creamos

        return true;
    }

    public boolean addEdge(int vertexLabel1, int vertexLabel2) {    //Pasamos dos enteros como parametro para crear dos vertices
        return addEdge(new Edge(new Vertex(vertexLabel1), new Vertex(vertexLabel2)));   //Va a crear un Edge entre los dos Vertex que le pasamos como parametro y despues llamara al metodo addEdge(Edge e)
    }

    public boolean removeEdge(Edge e) { //El Edge que queremos eliminar
        if (!edges.remove(e)) { //Si no ha podido eliminar el Edge devuelve un false, puede ser que no este en la coleccion
            return false;
        }

        Set<Edge> edgesOfV1 = adjList.get(e.getSource());
        Set<Edge> edgesOfV2 = adjList.get(e.getDestination());

        if (edgesOfV1 != null) {
            edgesOfV1.remove(e);
        }
        if (edgesOfV2 != null) {
            edgesOfV2.remove(e);
        }

        return true;
    }

    public boolean removeEdge(int vertexLabel1, int vertexLabel2) {
        return removeEdge(new Edge(new Vertex(vertexLabel1), new Vertex(vertexLabel2)));    //Va a crear un Edge entre los dos Vertex que le pasamos como parametro y despues llamara al metodo removeEdge(Edge e)
    }

    public Set<Vertex> getAdjVertices(Vertex v) {
        Set<Vertex> devolver = new HashSet<Vertex>();   //Estructura temporal
        devolver = adjList.get(v).stream().map(e -> e.getSource().equals(v) ? e.getSource() : e.getSource()).collect(Collectors.toSet());   //Pasandole un vertice añade a un HashSet las ciudades que tengan el source del edge a las que se asocia. El collectors acumula en un set
        devolver.addAll(adjList.get(v).stream().map(e -> e.getDestination().equals(v) ? e.getDestination() : e.getDestination()).collect(Collectors.toSet()));  //Esto filtra y pasandole un vertice añade a. El evalua el equals si se verifica hace ?(if) si no :(else) y le asigna a e lo que haya detras de cada expresion (: o ?) 
        return devolver;    //Como es igual a las que llega que las que le llegan podriamos quitar una linea
    }

    public Set<Vertex> getVertices() {
        return Collections.unmodifiableSet(vertices);   //Devuelve una coleccion de los vertices que sera solo de lectura, no se podra modificar 
    }

    public Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges);  //Devuelve una coleccion de los Edges que sera solo de lectura, no se podra modificar
    }

    public Map<Vertex, Set<Edge>> getAdjList() {
        return Collections.unmodifiableMap(adjList);    //Devuelve una coleccion del mapa que sera solo de lectura, no se podra modificar
    }
}
