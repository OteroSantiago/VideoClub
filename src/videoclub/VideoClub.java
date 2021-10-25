
package videoclub;
//6to paso
//si aqui quiero listar las peliculas de la capa de negocio y catalogo de peliculas

import com.ceep.videoclub.dominio.*;
import com.ceep.videoclub.excepciones.ExLectura;
import com.ceep.videoclub.negocio.*;
import java.util.Scanner;

//aquí llamamos al listar de la capa de negocio, al listar de acceso a datos

public class VideoClub {
    //esta capa se comunica con la capa comuniacion, es decir crearme un objeto de clase catalogo pelicula

    public static void main(String[] args) {
    var opcion = -1;    
    var nombrePeli= "";
    var lectura= new Scanner(System.in);
    var nombreCatalogo = " VideoClub.txt";
    ICatalogoPeliculas catalogo = new CatalogoPeliculas();
    
    while(opcion != 0){
        System.out.println("Elige una de las opciones: \n"
                +"1. -Iniciar catálogo de peliculas. \n"
                +"2. -Agregar pelicula. \n"
                +"3. -Listar pelicula. \n"
                +"4.- Buscar pelicula. \n"
                +"0.- Salir \n" );
            //Leemos la opción de la consola
            opcion = Integer.parseInt(lectura.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    System.out.println("Catalogo iniciado...");
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula a agregar: ");
                    nombrePeli= lectura.nextLine();
                    catalogo.agregarPeliculas(nombrePeli, nombreCatalogo);
                    System.out.println("Se ha agregado la "+nombrePeli+ " al catalogo");
                case 3:
                    catalogo.listarPeliculas(nombreCatalogo);
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula que quieres buscar: ");
                    nombrePeli = lectura.nextLine();
                    catalogo.buscarPeliculas(nombreCatalogo, nombrePeli);
                    break;
                case 0:
                    System.out.println("Adios y hasta pronto");
                    break;    
                default:
                    System.out.println("Opción desconocida");
            }
        
    }
    }
    //catalogo.agregarPeliculas("Matrix",nombreCatalogo);
}

     
    
    

   
    

