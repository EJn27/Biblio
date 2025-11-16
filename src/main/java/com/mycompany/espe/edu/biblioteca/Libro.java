/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.espe.edu.biblioteca;

/**
 *
 * @author ejn
 */
public class Libro {
    
    private String ISBN;
    private String titulo;
    private String autor; 
    private int añoPublicacion;
    private boolean disponibilidad;
    
    //Constructor
    public Libro(String ISBN,String titulo, String autor, int añoPublicacion )
    {
        this.ISBN=ISBN;
        this.titulo=titulo;
        this.autor=autor;
        this.añoPublicacion=añoPublicacion;
        this.disponibilidad=true;
    }
    
    //Getters y Setters
    public String getISBN()
    {
        return ISBN;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public String getAutor()
    {
        return autor; 
    }
    public int getañoPublicacion()
    {
        return añoPublicacion;
    }
    public boolean isDisponibilidad()
    {
        return disponibilidad; 
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo=titulo;
    }
    public void setAutor(String autor)
    {
        this.autor=autor;
    }
    public void setañoPublicacion(int añoPublicacion)
    {
        this.añoPublicacion=añoPublicacion;
    }
    public void setDisponibilidad(boolean disponibilidad)
    {
        this.disponibilidad=disponibilidad;
    }
    
    //Metodo para mostrar información
    
    public void mostrarInformacion()
    {
        System.out.println("ISBN: "+ISBN);
        System.out.println("Titulo: "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("Año: "+añoPublicacion);
        System.out.println("Disponibilidad: "+disponibilidad);
        
    }
}
