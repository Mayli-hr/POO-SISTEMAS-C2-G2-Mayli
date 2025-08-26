package pe.edu.upeu.conceptospoo.abspolimorfismo;

public class Loro extends Animal {
    public void sonidoLoro(){
        System.out.println("hola como te va");

    }

    @Override
    public void sonidoAnimal() {

    }

    @Override
    public void dormir(){
        System.out.println("no hagas bulla tengo sueño");
    }
}
