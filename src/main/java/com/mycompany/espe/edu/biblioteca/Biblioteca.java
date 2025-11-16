/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.espe.edu.biblioteca;

/**
 *
 * @author ejn
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Biblioteca {

    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private Scanner scanner;
    
    public Biblioteca()
    {
        listaLibros = new ArrayList<>();
        listaUsuarios= new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void menuPrincipal()
    {
        int opcion;
        do{
            System.out.println("\n=== SISTEMA BIBLIOTECA UNIVERSITARIA ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libro");
            System.out.println("6. Mostrar todos los libros");
            System.out.println("7. Salir");
            System.out.println("Selecciones una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion)
            {
                case 1 -> registrarLibro();
                case 2 -> registrarUsuario();
                case 3 -> realizarPrestamo();
                case 4 -> procesarDevolucion();
                case 5 -> buscarLibro();
                case 6 -> mostrarLibros();
                case 7 -> System.out.println("Hasta pronto.");
                default -> System.out.println("Opcion invalida");
            }
        } 
        while (opcion !=7);
    }
    
    private void registrarLibro()
    {
        System.out.println("\n ---REGISTRAR NUEVO LIBRO ---");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año de publicacion: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        
        Libro libro = new Libro (isbn, titulo, autor, año);
        listaLibros.add(libro);
        System.out.println("Libro registrado satisfactoriamente");
    }
    
    private void registrarUsuario()
        {
            System.out.println("\n --- REGISTRAR NUEVO USUARIO ---");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Carrera: ");
            String carrera = scanner.nextLine();
            
            Usuario usuario = new Usuario(id, nombre, carrera);
            listaUsuarios.add(usuario);
            System.out.println("Usuario registrado satisfactoriamente");
        }
    
    private void realizarPrestamo()
    {
        System.out.println("\n --- PRESTAR LIBRO ---");
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();
        
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibroPorISBN(isbn);
        
        if (usuario !=null && libro !=null)
        {
            if ( usuario.prestarLibro(libro))
            {
                System.out.println("Prestamo realizada satisfactoriamente");
            }
            else 
            {
                System.out.println("No se pudo realizar el prestamo. Verifique la disponibilidad o el limite de libros.");
            }
        }
        else
        {
            System.out.println("Usuario o libro no encontrado.");
        }
    }
    
    private void procesarDevolucion()
    {
        System.out.println("\n ---DEVOUCION DE LIBROS---");
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.println("ISBN del libro: ");
        String isbn = scanner.nextLine();
        
        Usuario usuario = buscarUsuario(idUsuario);
        if ( usuario !=null)
        {
            if (usuario.devolverLibro(isbn))
            {
                System.out.println("Devolucion realizada satisfactoriamente");
            }
            else 
            {
                System.out.println("El usuario no tiene prestado este libro");
            }
        }
        else
        {
            System.out.println("Usuario no encontrado");
        }
    }
    
    private void buscarLibro()
    {
        System.out.print("\nIngrese ISBN o titulo a buscar: ");
        String busqueda = scanner.nextLine();
        
        boolean encontrado = false; 
        for(Libro libro : listaLibros)
        {
            if ( libro.getISBN().equals(busqueda) || libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase()))
            {
                libro.mostrarInformacion();
                encontrado = true; 
            }
        }
        if (!encontrado)
        {
            System.out.println("No se encontraron libros con esa informacion.");
        }
    }
    
    private void mostrarLibros()
    {
        System.out.println("\n --- LISTA DE TODOS LOS LIBROS ---");
        if ( listaLibros.isEmpty())
        {
            System.out.println("No hay libros registrados.");
        }
        else
        {
            for (Libro libro : listaLibros)
            {
                libro.mostrarInformacion();
            }
        }
    }
    
    private Libro buscarLibroPorISBN (String isbn)
    {
        for(Libro libro : listaLibros)
        {
            if (libro.getISBN().equals(isbn))
            {
                return libro; 
            }
        }
        return null;
    }
    
    private Usuario buscarUsuario(String id)
    {
        for(Usuario usuario : listaUsuarios)
        {
            if(usuario.getID().equals(id))
            {
                return usuario; 
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    biblioteca.menuPrincipal();
    }
}
