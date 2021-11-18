package TrabajoPracticoIntegrador;

import java.time.LocalDate;

class Signo {


    private LocalDate inicio;
    private LocalDate termino;
    private String nombre;

    public Signo(LocalDate inicio, LocalDate termino, String nombre) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.termino = termino;
    }

    public boolean obtenerSigno(LocalDate fechaNac)
    {
        boolean inicios = fechaNac.isAfter(inicio);
        boolean terminar = fechaNac.isBefore(termino);
        return inicios && terminar;
    }

    /*-------------Getters y Setters-------------*/


    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
