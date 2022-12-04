/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DAOs.*;
import dominio.Habitat;

/**
 *
 * @author MoonA
 */
public class Principal {
    public static void main(String[] args) {
        IConexionDB conexion = new ConexionDB();
        HabitatContinenteDAO hCDAO = new HabitatContinenteDAO(conexion);
        Habitat habitatY = new Habitat(1, " a", "d ", " s");
        hCDAO.agregar(0, habitatY, 1);
    }
}
