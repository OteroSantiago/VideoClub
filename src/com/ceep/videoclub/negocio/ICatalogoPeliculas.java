
package com.ceep.videoclub.negocio;
//5to paso
//aqui se tienen acceso a los objetos
public interface ICatalogoPeliculas {
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo);
    //aquí recibimos un archivo, este metodo tienen relacion con el metodo listar de 
    //la capa de dominio
    //muestra todas las peliculas del catalogo
    public void listarPeliculas(String nombreCatalogo);//aqui voy a llamar al metodo de acceso de datos
    //busca la pelicula "buscar" en nuestro catálogo
    public void buscarPeliculas(String nombreCatalogo, String buscar);
    //nos inicia nuestro catálogo
    public void iniciarCatalogo(String nombreCatalogo);
}
