
package com.ceep.videoclub.datos;
import com.ceep.videoclub.dominio.*;
import com.ceep.videoclub.excepciones.*;

import java.util.List;
//4to paso, me defino la interfaz
//el unico fin de esto es de leer los ficheros para acceder a las peliculas
public interface IAccesoDatos {//tengo que poner en esta interfaz si los metodos tienen alguna excepcion
    //comprueba si el archivo existe o no
    //aqui necesito una excepcion de acceso a datos
    public boolean existe(String nombreArchivo);
    
     //Lista todas las peliculas contenidas en el archivo nombreArchivo
    public List<Pelicula> listar(String nombreArchivo) throws ExLectura;
    
    //Escribe una nueva pelicula en el archivo nombreArchivo
    //con el parametro anexar podemos indicar si queremos agregar la pelicula o sobreescribir
    public void escribir(Pelicula pelicula,String nombreArchivo,boolean anexar) throws ExEscritura;
    
    //busca la expresion de buscar en el archivo nombreArchivo
    //y nos muestra un mensaje en caso de que lo encuentre o no
    public String buscar(String nombreArchivo,String buscar) throws ExLectura;
    
    //crea el archivo
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    
    //borra el archivo
    public void borrar(String nombreArchivo);
    
    
}
