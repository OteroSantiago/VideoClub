/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.videoclub.negocio;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazPelicula {
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo);
    public void listarPeliculas(String nombreArchivo);//aqui voy a llamar al metodo de acceso de datos
    public void buscarPeliculas(String nombreArchivo, String buscar);
    public void inicializarArchivo(String nombreArchivo);
}
