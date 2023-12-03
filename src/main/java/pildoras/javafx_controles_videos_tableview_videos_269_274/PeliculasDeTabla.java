/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.javafx_controles_videos_tableview_videos_269_274;

/**
 *
 * @author Pedro
 */
public class PeliculasDeTabla {
    private String titulo;
    private int año;
    private double precio;

    public PeliculasDeTabla() {
    }

    
    public PeliculasDeTabla(String titulo, int año, double precio) {
        this.titulo = titulo;
        this.año = año;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
