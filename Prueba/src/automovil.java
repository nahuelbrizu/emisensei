// paradigma de programación que usa objetos para crear aplicaciones.
// Está basada en tres pilares fundamentales: herencia, polimorfismo(l polimorfismo se refiere a la propiedad por la que es posible enviar mensajes sintácticamente iguales a objetos de tipos distintos.)
// , encapsulación.

//VENTAJAS DE LA PROGRAMACIÓN ORIENTADA A OBJETOS
//1 Fomenta la reutilización y ampliación del código.
//2 Permite crear sistemas más complejos.
//3La programación se asemeja al mundo real.
//4 Agiliza el desarrollo de software.
//5 Facilita el trabajo en equipo.
//
// Lo interesante de la POO es que proporciona conceptos y herramientas
// con las cuales se modela y representa el mundo real tan fielmente como sea posible.
//
//Para entender este modelo vamos a revisar 2 conceptos fundamentales:
//1.0 - clases
// plantilla generica para un conjunto de objetos de similares caracteristicas

//2.0 - Objetos
//  interaccion de los componentes entre sí,

public  class automovil {
    public static void main (String[] args){

    }

}


class Automovil {

    // VARIABLES DE CLASE Declaradas como private
    private String marca;
    private String modelo;
    private String color;
    private String velocidadMaxima;
    // CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE

    public Automovil(String marca, String modelo, String color, String velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidadMaxima = velocidadMaxima;
    }
    // Encapsulacion (se denomina encapsulamiento al ocultamiento de los datos de un objeto)
    // METODOS GETTER Y SETTERrr accedemos a las variables y podemos
    // RECUPERAR O CAMBIAR LOS DATOS DE LAS VARIABLES DE CLASE
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(String velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }



}