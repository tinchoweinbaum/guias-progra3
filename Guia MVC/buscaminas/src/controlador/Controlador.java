package controlador;

import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{ // Implementa ActionListener para poder setearlo de listener de los botones.
    private Buscaminas buscaminas;
    private IVista vista;

    public Controlador(IVista vista) {
        this.vista = vista;

        vista.setActionListener(this); // CONTROLADOR SE SETEA COMO LISTENER DE TODO LO QUE PASA EN LA VISTA. ESTA LÍNEA ES CLAVE.
    }

    public IVista getVista() {
        return vista;
    }

    public Buscaminas getBuscaminas() {
        return buscaminas;
    }

    public boolean valoresTableroValidos(int alto, int ancho, int cantMinas){
        return alto > 0 && ancho > 0 && cantMinas <= alto * ancho;
    }

    /**
     * Cascada horrible de if-else para determinar que botón se apretó.
     *
     *
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("ACEPTAR")){
            int altoIngresado = vista.getAltoTablero();
            int anchoIngresado = vista.getAnchoTablero();
            int cantMinasIngesada = vista.getCantMinas();
            try {
                // --- Instancio el modelo ---
                this.buscaminas = new Buscaminas(altoIngresado, anchoIngresado, cantMinasIngesada);

            } catch (ParametroInvalidoException ex){
                System.out.println("Parámetros inválidos para la creación del juego.");
            }
        } else if (e.getActionCommand().equals("CLICK_CASILLA")) {
            // Checkeo de si la casilla era una mina y el jugador perdió
        } else if (e.getActionCommand().equals("PONER_BANDERA")) {
            
        } else if (e.getActionCommand().equals("REINICIAR")) {
            
        }
    }
}
