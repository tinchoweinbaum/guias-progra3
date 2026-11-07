package vista;

import javax.swing.JButton;

/**
 * Clase que va a componer la matriz del buscaminas principal. Se va a encargar de mandar los eventos al modelo de que apretaron un botón.
 */
public class BotonCasilla extends JButton {
    private int fila;
    private int columna;

    public BotonCasilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}