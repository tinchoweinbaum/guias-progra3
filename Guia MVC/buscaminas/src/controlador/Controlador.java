package controlador;

import modelo.*;
import vista.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


// La clase controlador implementa tanto MouseAdapter como ActionListener para poder manejar clicks en botones normales y los del juego.
public class Controlador extends MouseAdapter implements ActionListener{ // Implementa ActionListener para poder setearlo de listener de los botones.
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
                // Tengo que buscar la manera de ir a la vista del buscaminas ahora.
                vista.iniciarTablero(altoIngresado, anchoIngresado, this, this);

            } catch (ParametroInvalidoException ex){
                System.out.println("Parámetros inválidos para la creación del juego.");
            }
        } else if (e.getActionCommand().equals("CLICK_CASILLA")) {
            // Checkeo de si la casilla era una mina y el jugador perdió
        } else if (e.getActionCommand().equals("PONER_BANDERA")) {
            
        } else if (e.getActionCommand().equals("REINICIAR")) {
            vista.pantallaInicial();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() instanceof BotonCasilla){ // Si lo que se clickeo fue un boton del tablero.
            BotonCasilla botonClickeado = (BotonCasilla) e.getSource(); // getSource devuelve una referencia al objeto que genero el evento
            int fila = botonClickeado.getFila();
            int columna = botonClickeado.getColumna();
            try {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    buscaminas.clickCasilla(fila, columna);

                    if (buscaminas.isMina(fila, columna)){
                        ImageIcon iconoOriginal = new ImageIcon("mina.png");
                        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                                botonClickeado.getWidth(),  // Ancho del botón
                                botonClickeado.getHeight(), // Alto del botón
                                Image.SCALE_SMOOTH        // Algoritmo de suavizado para que se vea bien
                        );
                        botonClickeado.setIcon(new ImageIcon(imagenEscalada));
                        botonClickeado.setEnabled(false);

                        // Cartel de perdiste con boton de reiniciar
                    }
                    else{ // El boton clickeado no es mina
                        botonClickeado.setEnabled(false);
                        int cantMinas = buscaminas.getMinasAdyacentes(fila, columna);
                        botonClickeado.setText(String.valueOf(cantMinas));
                        // cantidad de minas adyacentes.
                    }

                } else if (SwingUtilities.isRightMouseButton(e)) {
                    // Clic Derecho -> Poner/Sacar bandera
                    if (!buscaminas.isClicked(fila, columna)) {
                        if (!buscaminas.isFlagged(fila, columna)) {
                            buscaminas.toggleFlagCasilla(fila, columna);
                            ImageIcon iconoOriginal = new ImageIcon("bandera.png");
                            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                                    botonClickeado.getWidth(),  // Ancho del botón
                                    botonClickeado.getHeight(), // Alto del botón
                                    Image.SCALE_SMOOTH        // Algoritmo de suavizado para que se vea bien
                            );
                            botonClickeado.setIcon(new ImageIcon(imagenEscalada));
                        } else {
                            buscaminas.toggleFlagCasilla(fila, columna);
                            botonClickeado.setIcon(null);
                        }
                    }
                }
            } catch (FueraTableroException ex) {
                System.out.print("como hiciste eso");
            }
        }
    }
}
