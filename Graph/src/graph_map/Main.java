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

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Vertex, Set<Edge>> impresion = new HashMap<>();
        Collection adyacentes = new LinkedList();
        Collection algoritmo = new LinkedList();

        Graph España = new Graph(); //Inicializacion del grafo

        //Lista de 31 ciudades españolas
        Vertex Cadiz = new Vertex(0, "Cadiz");  //Creamos los Vertex, el label es unico y les identifica
        Vertex Málaga = new Vertex(1, "Málaga");
        Vertex Almería = new Vertex(2, "Almeria");
        Vertex Huelva = new Vertex(3, "Huelva");
        Vertex Sevilla = new Vertex(4, "Sevilla");
        Vertex Granada = new Vertex(5, "Granada");
        Vertex Cordoba = new Vertex(6, "Cordoba");
        Vertex Jaen = new Vertex(7, "Jaen");
        Vertex Murcia = new Vertex(8, "Murcia");
        Vertex Badajoz = new Vertex(9, "Badajoz");
        Vertex Ciudad_Real = new Vertex(10, "Ciudad Real");
        Vertex Albacete = new Vertex(11, "Albacete");
        Vertex Alicante = new Vertex(12, "Alicante");
        Vertex Caceres = new Vertex(13, "Caceres");
        Vertex Toledo = new Vertex(14, "Toledo");
        Vertex Salamanca = new Vertex(15, "Salamanca");
        Vertex Madrid = new Vertex(16, "Madrid");
        Vertex Cuenca = new Vertex(17, "Cuenca");
        Vertex Valencia = new Vertex(18, "Valencia");
        Vertex Zamora = new Vertex(19, "Zamora");
        Vertex Valladolid = new Vertex(20, "Valladolid");
        Vertex Segovia = new Vertex(21, "Segovia");
        Vertex Guadalajara = new Vertex(22, "Guadalajara");
        Vertex Teruel = new Vertex(23, "Teruel");
        Vertex Castellon = new Vertex(24, "Castellon");
        Vertex Pontevedra = new Vertex(25, "Pontevedra");
        Vertex Orense = new Vertex(26, "Orense");
        Vertex Burgos = new Vertex(27, "Burgos");
        Vertex Soria = new Vertex(28, "Soria");
        Vertex Zaragoza = new Vertex(29, "Zaragoza");
        Vertex Tarragona = new Vertex(30, "Tarragona");

        //Arcos entre esas ciudades españolas, para aplicar Dijkstra necesitamos que sea direccional, vamos a considerar las mismas distancias en ida y vuelta
        //Las distancias estan en Km, fuente https://cloud10.todocoleccion.online/calendarios-antiguos/tc/2015/04/16/17/48903475.jpg    
        //Lista de los Edges para unir las ciudades españolas
        Edge Cadiz_Malaga = new Edge(Cadiz, Málaga, 265);  //Creamos los Edges y sus carreteras al reves para poder ir desde cualquier sitio a cualquiera
        Edge Malaga_Cadiz = new Edge(Málaga, Cadiz, 265);
        Edge Cadiz_Sevilla = new Edge(Cadiz, Sevilla, 125);
        Edge Sevilla_Cadiz = new Edge(Sevilla, Cadiz, 125);
        Edge Malaga_Sevilla = new Edge(Málaga, Sevilla, 219);
        Edge Sevilla_Malaga = new Edge(Sevilla, Málaga, 219);
        Edge Huelva_Sevilla = new Edge(Huelva, Sevilla, 94);
        Edge Sevilla_Huelva = new Edge(Sevilla, Huelva, 94);
        Edge Malaga_Granada = new Edge(Málaga, Granada, 129);
        Edge Granada_Malaga = new Edge(Granada, Málaga, 129);
        Edge Granada_Almeria = new Edge(Granada, Almería, 166);
        Edge Almeria_Granada = new Edge(Almería, Granada, 166);
        Edge Sevilla_Cordoba = new Edge(Sevilla, Cordoba, 138);
        Edge Cordoba_Sevilla = new Edge(Cordoba, Sevilla, 138);
        Edge Malaga_Cordoba = new Edge(Málaga, Cordoba, 187);
        Edge Cordoba_Malaga = new Edge(Cordoba, Málaga, 187);
        Edge Huelva_Badajoz = new Edge(Huelva, Badajoz, 251);
        Edge Badajoz_Huelva = new Edge(Badajoz, Huelva, 251);
        Edge Cordoba_Granada = new Edge(Cordoba, Granada, 166);
        Edge Granada_Cordoba = new Edge(Granada, Cordoba, 166);
        Edge Granada_Jaen = new Edge(Granada, Jaen, 99);
        Edge Jaen_Granada = new Edge(Jaen, Granada, 99);
        Edge Cordoba_Jaen = new Edge(Cordoba, Jaen, 104);
        Edge Jaen_Cordoba = new Edge(Jaen, Cordoba, 104);
        Edge Badajoz_Cordoba = new Edge(Badajoz, Cordoba, 272);
        Edge Cordoba_Badajoz = new Edge(Cordoba, Badajoz, 272);
        Edge Badajoz_Caceres = new Edge(Badajoz, Caceres, 89);
        Edge Caceres_Badajoz = new Edge(Caceres, Badajoz, 89);
        Edge Jaen_Albacete = new Edge(Jaen, Albacete, 264);
        Edge Albacete_Jaen = new Edge(Albacete, Jaen, 264);
        Edge Almeria_Murcia = new Edge(Almería, Murcia, 219);
        Edge Murcia_Almeria = new Edge(Murcia, Almería, 219);
        Edge Murcia_Albacete = new Edge(Murcia, Albacete, 150);
        Edge Albacete_Murcia = new Edge(Albacete, Murcia, 150);
        Edge Murcia_Alicante = new Edge(Murcia, Alicante, 75);
        Edge Alicante_Murcia = new Edge(Alicante, Murcia, 75);
        Edge Albacete_Alicante = new Edge(Albacete, Alicante, 166);
        Edge Alicante_Albacete = new Edge(Alicante, Albacete, 166);
        Edge Valencia_Alicante = new Edge(Valencia, Alicante, 166);
        Edge Alicante_Valencia = new Edge(Alicante, Valencia, 166);
        Edge Cordoba_Toledo = new Edge(Cordoba, Toledo, 320);
        Edge Toledo_Cordoba = new Edge(Toledo, Cordoba, 320);
        Edge Jaen_CiudadReal = new Edge(Jaen, Ciudad_Real, 179);
        Edge CiudadReal_Jaen = new Edge(Ciudad_Real, Jaen, 179);
        Edge CiudadReal_Toledo = new Edge(Ciudad_Real, Toledo, 119);
        Edge Toledo_CiudadReal = new Edge(Toledo, Ciudad_Real, 119);
        Edge Caceres_Toledo = new Edge(Caceres, Toledo, 264);
        Edge Toledo_Caceres = new Edge(Toledo, Caceres, 264);
        Edge Albacete_Valencia = new Edge(Albacete, Valencia, 191);
        Edge Valencia_Albacete = new Edge(Valencia, Albacete, 191);
        Edge Albacete_Madrid = new Edge(Albacete, Madrid, 251);
        Edge Madrid_Albacete = new Edge(Madrid, Albacete, 251);
        Edge Toledo_Madrid = new Edge(Toledo, Madrid, 71);
        Edge Madrid_Toledo = new Edge(Madrid, Toledo, 71);
        Edge Caceres_Madrid = new Edge(Caceres, Madrid, 297);
        Edge Madrid_Caceres = new Edge(Madrid, Caceres, 297);
        Edge Madrid_Cuenca = new Edge(Madrid, Cuenca, 168);
        Edge Cuenca_Madrid = new Edge(Cuenca, Madrid, 168);
        Edge Cuenca_Valencia = new Edge(Cuenca, Valencia, 352);
        Edge Valencia_Cuenca = new Edge(Valencia, Cuenca, 352);
        Edge Caceres_Salamanca = new Edge(Caceres, Salamanca, 210);
        Edge Salamanca_Caceres = new Edge(Salamanca, Caceres, 210);
        Edge Salamanca_Zamora = new Edge(Salamanca, Zamora, 62);
        Edge Zamora_Salamanca = new Edge(Zamora, Salamanca, 62);
        Edge Zamora_Madrid = new Edge(Zamora, Madrid, 248);
        Edge Madrid_Zamora = new Edge(Madrid, Zamora, 248);
        Edge Zamora_Orense = new Edge(Zamora, Orense, 284);
        Edge Orense_Zamora = new Edge(Orense, Zamora, 284);
        Edge Orense_Pontevedra = new Edge(Orense, Pontevedra, 102);
        Edge Pontevedra_Orense = new Edge(Pontevedra, Orense, 102);
        Edge Zamora_Valladolid = new Edge(Zamora, Valladolid, 96);
        Edge Valladolid_Zamora = new Edge(Valladolid, Zamora, 96);
        Edge Valladolid_Segovia = new Edge(Valladolid, Segovia, 111);
        Edge Segovia_Valladolid = new Edge(Segovia, Valladolid, 111);
        Edge Madrid_Segovia = new Edge(Madrid, Segovia, 87);
        Edge Segovia_Madrid = new Edge(Segovia, Madrid, 87);
        Edge Segovia_Burgos = new Edge(Segovia, Burgos, 197);
        Edge Burgos_Segovia = new Edge(Burgos, Segovia, 197);
        Edge Madrid_Soria = new Edge(Madrid, Soria, 231);
        Edge Soria_Madrid = new Edge(Soria, Madrid, 231);
        Edge Madrid_Gualajara = new Edge(Madrid, Guadalajara, 60);
        Edge Guadalajara_Madrid = new Edge(Guadalajara, Madrid, 60);
        Edge Gualajara_Zaragoza = new Edge(Guadalajara, Zaragoza, 325);
        Edge Zaragoza_Guadalajara = new Edge(Zaragoza, Guadalajara, 325);
        Edge Valencia_Teruel = new Edge(Valencia, Teruel, 145);
        Edge Teruel_Valencia = new Edge(Teruel, Valencia, 145);
        Edge Teruel_Zaragoza = new Edge(Teruel, Zaragoza, 181);
        Edge Zaragoza_Teruel = new Edge(Zaragoza, Teruel, 181);
        Edge Valencia_Castellon = new Edge(Valencia, Castellon, 65);
        Edge Castellon_Valencia = new Edge(Castellon, Valencia, 65);
        Edge Castellon_Tarragona = new Edge(Castellon, Tarragona, 186);
        Edge Tarragona_Castellon = new Edge(Tarragona, Castellon, 186);

        España.addVertex(Cadiz);    //Añadimos los Vertex correspondientes a cada ciudad
        España.addVertex(Málaga);
        España.addVertex(Almería);
        España.addVertex(Huelva);
        España.addVertex(Sevilla);
        España.addVertex(Granada);
        España.addVertex(Cordoba);
        España.addVertex(Jaen);
        España.addVertex(Murcia);
        España.addVertex(Badajoz);
        España.addVertex(Ciudad_Real);
        España.addVertex(Albacete);
        España.addVertex(Alicante);
        España.addVertex(Caceres);
        España.addVertex(Toledo);
        España.addVertex(Salamanca);
        España.addVertex(Madrid);
        España.addVertex(Cuenca);
        España.addVertex(Valencia);
        España.addVertex(Zamora);
        España.addVertex(Valladolid);
        España.addVertex(Segovia);
        España.addVertex(Guadalajara);
        España.addVertex(Teruel);
        España.addVertex(Castellon);
        España.addVertex(Pontevedra);
        España.addVertex(Orense);
        España.addVertex(Burgos);
        España.addVertex(Soria);
        España.addVertex(Zaragoza);
        España.addVertex(Tarragona);

        España.addEdge(Cadiz_Malaga); //Añadimos los Edges entre ciudades, tanto de ida como vuelta
        España.addEdge(Malaga_Cadiz);
        España.addEdge(Cadiz_Sevilla);
        España.addEdge(Sevilla_Cadiz);
        España.addEdge(Malaga_Sevilla);
        España.addEdge(Sevilla_Malaga);
        España.addEdge(Huelva_Sevilla);
        España.addEdge(Sevilla_Huelva);
        España.addEdge(Malaga_Granada);
        España.addEdge(Granada_Malaga);
        España.addEdge(Granada_Almeria);
        España.addEdge(Almeria_Granada);
        España.addEdge(Sevilla_Cordoba);
        España.addEdge(Cordoba_Sevilla);
        España.addEdge(Malaga_Cordoba);
        España.addEdge(Cordoba_Malaga);
        España.addEdge(Huelva_Badajoz);
        España.addEdge(Badajoz_Huelva);
        España.addEdge(Cordoba_Granada);
        España.addEdge(Granada_Cordoba);
        España.addEdge(Granada_Jaen);
        España.addEdge(Jaen_Granada);
        España.addEdge(Cordoba_Jaen);
        España.addEdge(Jaen_Cordoba);
        España.addEdge(Badajoz_Cordoba);
        España.addEdge(Cordoba_Badajoz);
        España.addEdge(Badajoz_Caceres);
        España.addEdge(Caceres_Badajoz);
        España.addEdge(Jaen_Albacete);
        España.addEdge(Albacete_Jaen);
        España.addEdge(Almeria_Murcia);
        España.addEdge(Murcia_Almeria);
        España.addEdge(Murcia_Alicante);
        España.addEdge(Alicante_Murcia);
        España.addEdge(Albacete_Alicante);
        España.addEdge(Alicante_Albacete);
        España.addEdge(Valencia_Alicante);
        España.addEdge(Alicante_Valencia);
        España.addEdge(Cordoba_Toledo);
        España.addEdge(Toledo_Cordoba);
        España.addEdge(Jaen_CiudadReal);
        España.addEdge(CiudadReal_Jaen);
        España.addEdge(Murcia_Albacete);
        España.addEdge(Albacete_Murcia);
        España.addEdge(CiudadReal_Toledo);
        España.addEdge(Toledo_CiudadReal);
        España.addEdge(Caceres_Toledo);
        España.addEdge(Toledo_Caceres);
        España.addEdge(Albacete_Valencia);
        España.addEdge(Valencia_Albacete);
        España.addEdge(Albacete_Madrid);
        España.addEdge(Madrid_Albacete);
        España.addEdge(Toledo_Madrid);
        España.addEdge(Madrid_Toledo);
        España.addEdge(Caceres_Madrid);
        España.addEdge(Madrid_Caceres);
        España.addEdge(Madrid_Cuenca);
        España.addEdge(Cuenca_Madrid);
        España.addEdge(Cuenca_Valencia);
        España.addEdge(Valencia_Cuenca);
        España.addEdge(Caceres_Salamanca);
        España.addEdge(Salamanca_Caceres);
        España.addEdge(Salamanca_Zamora);
        España.addEdge(Zamora_Salamanca);
        España.addEdge(Zamora_Madrid);
        España.addEdge(Madrid_Zamora);
        España.addEdge(Zamora_Orense);
        España.addEdge(Orense_Zamora);
        España.addEdge(Orense_Pontevedra);
        España.addEdge(Pontevedra_Orense);
        España.addEdge(Zamora_Valladolid);
        España.addEdge(Valladolid_Zamora);
        España.addEdge(Valladolid_Segovia);
        España.addEdge(Segovia_Valladolid);
        España.addEdge(Madrid_Segovia);
        España.addEdge(Segovia_Madrid);
        España.addEdge(Segovia_Burgos);
        España.addEdge(Burgos_Segovia);
        España.addEdge(Madrid_Soria);
        España.addEdge(Soria_Madrid);
        España.addEdge(Madrid_Gualajara);
        España.addEdge(Guadalajara_Madrid);
        España.addEdge(Gualajara_Zaragoza);
        España.addEdge(Zaragoza_Guadalajara);
        España.addEdge(Valencia_Teruel);
        España.addEdge(Teruel_Valencia);
        España.addEdge(Teruel_Zaragoza);
        España.addEdge(Zaragoza_Teruel);
        España.addEdge(Valencia_Castellon);
        España.addEdge(Castellon_Valencia);
        España.addEdge(Castellon_Tarragona);
        España.addEdge(Tarragona_Castellon);

        /*impresion adyacentes = España.getAdjList();

        for (Map.Entry entry : impresion.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        adyacentes = España.getAdjVertices(Cadiz);
        Iterator c = adyacentes.iterator();

        while (c.hasNext()) {
            System.out.print(" " + c.next());
        }*/
        Vertex ciudad_inicio = Sevilla;    //Si al poner algunas ciudades de las que se adjuntan da error es porque me habré dejado/equivocado en algún Edge
        Vertex ciudad_fin = Valencia;

        Dijkstra test = new Dijkstra(España);
        test.execute(ciudad_inicio);    //Aqui introducimos la ciudad de origen
        algoritmo = test.getPath(ciudad_fin); //Aqui introducimos la ciudad destino
        Iterator alg = algoritmo.iterator();

        System.out.println("Trayecto para llegar desde " + ciudad_inicio + " hasta " + ciudad_fin);
        while (alg.hasNext()) {
            System.out.print(" ---> " + alg.next());
        }

        System.out.print("\n Distancia estimada de recorrido: " + test.getDistance(ciudad_fin) + " Km   ");
        
       España.getAdjVertices(Valencia);
    }

}
