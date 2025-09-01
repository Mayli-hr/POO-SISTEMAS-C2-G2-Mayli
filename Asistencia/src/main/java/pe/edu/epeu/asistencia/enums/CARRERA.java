package pe.edu.epeu.asistencia.enums;

import lombok.Getter;

public enum CARRERA {
    Sistemas(FACULTAD.FIA),

    Civil(FACULTAD.FIA),

    Administracion(FACULTAD.FCE),

    Nutrion(FACULTAD.FCS),

    Educacion(FACULTAD.FACIHED),

    General(FACULTAD.GENERAL);

    private FACULTAD facultad;

    private CARRERA(FACULTAD facultad) {
        this.facultad = facultad;
    }
    public FACULTAD getFacultad() {return facultad;}
}
