
package com.ceep.videoclub.excepciones;
//2 paso despues de la clase padre AccesoDatosEx

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ExLectura extends AccesoDatosEx{//devuelve el mensaje de la excepcion,un super del mensaje que le voy a pasar
    //la lectura es un acceso a acceso a datos

    public ExLectura(String mensaje) {
        super(mensaje);
    }
    
}
