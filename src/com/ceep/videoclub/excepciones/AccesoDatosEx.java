
package com.ceep.videoclub.excepciones;
//1er paso

public class AccesoDatosEx extends Exception {//muy importante poner extends Exception
    //las excepeciones que genera aqui se generaran en datos
    public AccesoDatosEx(String mensaje) {
        super(mensaje);
    }
    
}
