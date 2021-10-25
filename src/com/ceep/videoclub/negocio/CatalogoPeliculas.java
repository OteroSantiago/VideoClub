
package com.ceep.videoclub.negocio;
//5to paso, despues de la interfaz
import com.ceep.videoclub.datos.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosEx;
import com.ceep.videoclub.excepciones.ExEscritura;
import com.ceep.videoclub.excepciones.ExLectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class CatalogoPeliculas implements ICatalogoPeliculas{
    //estoy declarando una variable de la interfaz de la capa de videoclub.datos
    private final IAccesoDatos datos;
    //constructor
    public CatalogoPeliculas(){
        //tenemos que instanciar un objetos asociado a la variable datos de arriba
        this.datos = new AccesoDatos();
    }
    
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreCatalogo) {
        //tengo que crear un objeto de clase pelicula
        //tengo que llamar otra vez al atrubito datos que me permite acceder a su operacion en la capa de datos
        try {
            if(this.datos.existe(nombreCatalogo)){//metodo de la clase, Catalogo Peliculas
                //creamos el objeto de la clase si existe
                this.datos.escribir(new Pelicula(nombrePelicula), nombreCatalogo,true);
            }else{
                System.out.println("Catalogo no inicializado");
            }
            } catch (ExEscritura e) {
                System.out.println("Erroe el escribir en el catálogo");
                e.printStackTrace(System.out);
        }
    }
    
    @Override
    public void listarPeliculas(String nombreCatalogo) {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            peliculas = this.datos.listar(nombreCatalogo);
            peliculas.forEach(pelicula -> {//recorremos el array
                //aqui quiero imprimir la pelicula por la pantalla
                System.out.println(pelicula.getNombre());//aqui me muestra el nombre de la peli
            });
        } catch (ExLectura ex) {
            System.out.println("Error leyendo el catálogo");
            ex.printStackTrace(System.out);
        }
    }

        
       
    
    @Override
    public void buscarPeliculas(String nombreCatalogo, String buscar) {//este invoca a this.datos buscar
        //aqui no tenemos que instanciar objetos de tipo fichero, porque el que accede al fichero es buscar 
        //llamamos a buscar de la capa de acceso a datos 
        //la logica de buscar se reduce a llamar al metodo que accede al fichero de la capa de  acceso a datos para ver si lo encuentra
        //el de la capa de datos le pasa un string que nos dice si si o no, el mensaje es este u otro 
        try {
            //quiero imprimir el string que me da el metodo buscar de la capa de acceso a datos
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
            
        } catch (ExLectura e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Override
    public void iniciarCatalogo(String nombreCatalogo) {
        try {
            if(this.datos.existe(nombreCatalogo)){//le estoy pasando a existe, para ue me devuelva un booleano
                this.datos.borrar(nombreCatalogo);//si existe lo borro porque quiero uno nuevo
                this.datos.crear(nombreCatalogo);
            }else{
                this.datos.crear(nombreCatalogo);
            }
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
            System.out.println("Error al inicializar el catálogo de peliculas");
        }
        
        
        
    }
    
}
