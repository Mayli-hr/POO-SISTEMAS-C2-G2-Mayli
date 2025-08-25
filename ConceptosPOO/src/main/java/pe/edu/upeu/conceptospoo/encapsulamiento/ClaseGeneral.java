package pe.edu.upeu.conceptospoo.encapsulamiento;

public class ClaseGeneral {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("melani");
        persona.setEdad(17);
        System.out.println("Nombre:" + persona.getNombre());
        System.out.println("Edad:" + persona.getEdad());
        persona.saludar();
    }
}
