/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.espe.edu.biblioteca;

/**
 *
 * @author ejn
 */
import java.util.ArrayList;

public class Usuario {
    
    private final String ID;
    private String nombre;
    private String carrera;
    private final ArrayList<Libro> librosPrestados;
    
    //Constructor
    
    public Usuario(String ID, String nombre, String carrera)
    {
     this.ID=ID;
     this.nombre=nombre;
     this.carrera=carrera; 
     this.librosPrestados= new ArrayList<>();
    }
    
    //Getters y Setters 
    
    public String getID()
    {
        return ID;
    }
    public String getNombre()
    {
        return nombre; 
    }
    public String getCarrera()
    {
        return carrera; 
    }
    public ArrayList<Libro> getLibrosPrestados()
    {
        return librosPrestados; 
    }
    
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public void setCarrera(String carrera)
    {
        this.carrera = carrera; 
    }
   
    //Metodo para prestar Libro
    
    public boolean prestarLibro(Libro libro)
    {
        if (librosPrestados.size() < 3 && libro.isDisponibilidad())
        {
            librosPrestados.add(libro);
            libro.setDisponibilidad(false);
            return true;
        }
        return false; 
    }
    
    public boolean devolverLibro (String ISBN)
    {
        for (int i=0; i<librosPrestados.size();i++)
        {
            if (librosPrestados.get(i).getISBN().equals(ISBN))
            {
                librosPrestados.get(i).setDisponibilidad(true);
                librosPrestados.remove(i);
                return true;
            }
        }
        return false; 
    }
}
