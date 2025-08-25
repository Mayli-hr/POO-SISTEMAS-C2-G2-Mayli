package pe.edu.upeu.conceptospoo.herencia;

public class Carro extends Vehiculo {
    String color = "blanco";
    String modelo = "hilux";

    void caracteristicas() {
        marca = "toyota";
        System.out.println("el vehiculo tiene las siguientes caracteristicas:");
        System.out.println("marca:" + marca);
        System.out.println("modelo:" + modelo);
        System.out.println("color:" + color);
        System.out.println("y emite el siguiente sonido" + sonido());

    }

    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.caracteristicas();

    }
}
