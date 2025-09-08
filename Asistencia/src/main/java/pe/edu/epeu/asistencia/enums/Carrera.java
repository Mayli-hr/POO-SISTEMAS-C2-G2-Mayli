package pe.edu.epeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum Carrera {
    SISTEMAS(Faculdad.FIA,"Sistemas"),

    CIVIL(Faculdad.FIA,"Civil"),

    ADMINISTRACION(Faculdad.FCE,"Administracion"),

    NUTRICION(Faculdad.FCS,"Nutricion"),

    EDUCACION(Faculdad.FACIHED,"Educacion"),

    General(Faculdad.GENERAL,"General");

    private Faculdad faculdad;
    private String descripcion;
}
