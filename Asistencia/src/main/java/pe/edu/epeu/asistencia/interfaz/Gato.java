package pe.edu.epeu.asistencia.interfaz;

public class Gato implements Animal{
    @Override
    public void emitirSonido() {
        System.out.println("Miuuuuuu");
    }

    @Override
    public void dormir() {
        System.out.println("Zzzzzzzz");
    }
}
