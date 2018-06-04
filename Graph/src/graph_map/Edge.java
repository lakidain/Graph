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
public class Edge { //Arcos de los grafos, sera bidireccional porque puedes pasar al reves los mismos Nodos y crearas una asociacion en sentido contrario de peso

    private static final int DEFAULT_WEIGHT = 1;    //Este va a ser nuestro peso por defecto si no tenemos ninguno

    private Vertex source, destination;  //Vertices a los que se unira el Edge, v1 sera source y v2 destination
    private int weight; //En nuestro caso el peso va a ser un entero, queremos saber la distancia entre dos Vertex en cada arco

    public Edge(Vertex v1, Vertex v2) { //Metodo constructor, el peso del arco si no ponemos ningun peso va a ser 1
        this(v1, v2, DEFAULT_WEIGHT);
    }

    public Edge(Vertex v1, Vertex v2, int weight) { //Metodo constructor con peso, el peso seran las distancias 
        super();
        this.source = v1;
        this.destination = v2;
        this.weight = weight;
    }

    public boolean equals(Object obj) { //Metodo equals basado en el origen,destino y peso
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Edge)) {
            return false;
        }

        Edge _obj = (Edge) obj;
        return _obj.source.equals(source) && _obj.destination.equals(destination) && _obj.weight == weight;
    }

    public int hashCode() { //El Hashcode es lo primero que se va a usar para comparar estructuras de una forma rapida en las estructuras Hash, por eso tiene que estar bien definido. Si dos Hash son iguales entonces se irá al metodo equals para verificarlo
        int result = source.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + weight;
        return result;
    }

    public int getWeight() {    //Metodo getter para el peso
        return this.weight;
    }

    public void setWeight(int weight) { //Metodo setter para el peso
        this.weight = weight;
    }

    public Vertex getSource() {    //Metodo getter para el vertice 1
        return this.source;
    }

    public void setSource(Vertex vertex1) {    //Metodo setter para el vertice 1
        this.source = vertex1;
    }

    public Vertex getDestination() {    //Metodo getter para el vertice 2
        return this.destination;
    }

    public void setDestination(Vertex vertex2) {    //Metodo getter para el vertice 2
        this.destination = vertex2;
    }

    public String toString() {
        String mensaje;
        mensaje = "ARCO ENTRE CIUDADES: Primera " + this.source + " Segunda " + this.destination + " Distancia entre ellas: " + this.weight;
        return mensaje; //To change body of generated methods, choose Tools | Templates.
    }

}
