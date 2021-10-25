
package com.ceep.videoclub.datos;
import com.ceep.videoclub.dominio.*;
import com.ceep.videoclub.excepciones.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

//4to paso, después de definir la interfaz
//aqui meto los try catch relacionados con las excepciones

public class AccesoDatos implements IAccesoDatos {//tengo que hacer un throw new de la excepcion, para mostrar un mensaje en concreto 

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws ExLectura {
        var archivo = new File(nombreArchivo);
        Pelicula pelicula= null;
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            //entrada descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));//BufferReader paara leer /File reader permite leer todo el conjunto de lineas completas
            //la entrada la tenemos que inicializar con algo
            //nos devuelve una linea de nuestro archivo
            var lectura = entrada.readLine();//esto nos obliga a tener otro catch
            while(lectura != null){//lectura hasta que sea null,si tenemos una pelicula tenemos que crear el objeto
                //creamos un objeto con cada linea del archivo
                pelicula = new Pelicula(lectura);//aqui se me crea un objeto de tipo pelicula que contiene el nombre de tipo pelicula
                peliculas.add(pelicula);
                //avanzamos lectura
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {//tenemos que hacer un while para que el descriptor vaya leyendo mientras hay contenido y lineas
             e.printStackTrace(System.out);
             throw new ExLectura("Error de lectura listando peliculas");
        }catch(IOException e){
             e.printStackTrace(System.out);
             throw new ExLectura("Error de lectura listando peliculas");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo,boolean anexar) throws ExEscritura {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println();
            salida.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new ExEscritura("Excepcion al escribir en el archivo");
        }
        
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws ExLectura {//recibe el nombre de la pelicula que se busca,este se encarga de acceder al archivo y buscarlo
        //lo tenemos que buscar con while con equals comparando con la busqueda(buscar)//(equalsIgnoreCase, no distingue entre mayusculas y minisculas), hacer un cont= 1 y n readLine()
        //quiero que sea una negacion, con lo cual debo de poner una negacion al principio de el parentesis
        var archivo = new File(nombreArchivo);
        var cont = 1;//variable para que nos vaya contando las lineas cuando va buscando 
        String mensaje = "";//mensaje que nos pondra seguen encontremos o no
        try {
            //entrada descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));//BufferReader paara leer /File reader permite leer todo el conjunto de lineas completas
            //la entrada la tenemos que inicializar con algo
            //nos devuelve una linea de nuestro archivo
            var lectura = entrada.readLine();//esto nos obliga a tener otro catch
            while(lectura != null){//lectura hasta que sea null,si tenemos una pelicula tenemos que crear el objeto
                //creamos un objeto con cada linea del archivo
               if(lectura.equalsIgnoreCase(buscar)){
                   mensaje = "La pelicula" +buscar+ " se encuentra en la linea" + cont+ "del catalogo de películas";
                   break;//meto un break para salir del bucle
               }
                lectura = entrada.readLine();
                cont++;
            }
            if(lectura == null){ 
                mensaje = "La pelicula" + buscar + "no está em el catalogo películas";
            }
            entrada.close();
        } catch (FileNotFoundException e) {//tenemos que hacer un while para que el descriptor vaya leyendo mientras hay contenido y lineas
             e.printStackTrace(System.out);
             throw new ExLectura("Error de lectura listando peliculas");
        }catch(IOException e){
             e.printStackTrace(System.out);
             throw new ExLectura("Error de lectura listando peliculas");
        }
        return mensaje;
     
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Error al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo)  {
    //instanciamos el objeto archivo
        File archivo = new File(nombreArchivo);
        //quiero controlar si el archivo existe
        if (archivo.exists()){//si existe
            archivo.delete();//me lo borra
        }
        System.out.println("Se ha borrado el archivo");
    }   
    
}
