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
public class Vertex {   //Nodos del grafo

    private int uniqueLabel;    //Vamos a identificar cada ciudad con un numero unico
    String nombre;

    public Vertex(int uniqueLabel) {    //Constructor del vertice, este constructor lo usaremos para cuando queremos eliminar Vertex del grafo
        this.uniqueLabel = uniqueLabel;
    }

    public Vertex(int uniqueLabel, String nombre) {    //Constructor del vertice
        this.uniqueLabel = uniqueLabel;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) { //Metodo equals para un vertice, con las label
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vertex)) {
            return false;
        }

        Vertex _obj = (Vertex) obj;
        return _obj.uniqueLabel == uniqueLabel;
    }

    public int hashCode() { //hascode con las label
        return uniqueLabel;
    }

    public int getLabel() { //Metodo getter
        return uniqueLabel;
    }

    public void setLabel(int uniqueLabel) { //Metodo setter
        this.uniqueLabel = uniqueLabel;
    }

    public String toString() {  //Metodo toString
        String mensaje;
        if (this.nombre != null) {
            mensaje = "" + this.nombre; //Se imprime el nombre
        } else {
            mensaje = "" + this.uniqueLabel;    //En un principio no deberia llegar a imprimirse algo sin nombre, porque no tiene sentido pero si llega a pasar se imprimira el label
        }
        return mensaje; //To change body of generated methods, choose Tools | Templates.
    }

}
