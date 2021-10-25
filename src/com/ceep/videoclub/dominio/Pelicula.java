/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.videoclub.dominio;
//3er paso para crearnos la clase en donde creamos las peliculas asociadas a las excepciones
/**
 *
 * @author Alumno Mañana
 */
public class Pelicula {
    //atributos
    private String nombre;
    //constructores
    public Pelicula(String nombre) {
        this();//para pasarle el nombre
        this.nombre = nombre;
    }
    public Pelicula(String nombre, String nombreCatalogo){
        this.nombre = nombre;
    }
    //vacio
    public Pelicula() {
    }
    //getters and setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //toString
    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + '}';
    }
    
}
