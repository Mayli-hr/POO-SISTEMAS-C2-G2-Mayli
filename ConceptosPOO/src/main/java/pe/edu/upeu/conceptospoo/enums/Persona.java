package pe.edu.upeu.conceptospoo.enums;
enum GENERO{M,F}
    enum NACIONALIDAD{Peruana,Venezolan,Boliviana}

public class Persona {
        static String nombre;
    static GENERO genero=GENERO.F;
    static NACIONALIDAD nacionalidad=NACIONALIDAD.Peruana;
    public static void main(String[] args) {
        nombre="Mayli";
        System.out.println(nombre+"es"+nacionalidad+"y tiene el genero"+genero);
        for(GENERO xx:GENERO.values()){
            System.out.println(xx);
        }
        for (NACIONALIDAD x:NACIONALIDAD.values()) {
            System.out.println(x);
        }
    }
}
