package main;

import Vistas.CargarTemperatura;
import controlador.Controlador;

public class Main {

    public static void main(String[] args) {
        Controlador controlador= new Controlador();
        CargarTemperatura ventana = new CargarTemperatura(controlador);
    }
}
