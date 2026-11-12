import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private IVista vista;
    private Modelo modelo;

    public Controlador(IVista vista, Modelo modelo) {
        this.vista = vista;
        vista.setActionListener(this);

        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String evento = actionEvent.getActionCommand();
        if(evento.equals("CLICK_TABLERO")){
            // --- Actualiza vista ---
            int turnoAct = modelo.getTurnoAct();
            String textoBoton = (turnoAct == Modelo.CRUZ) ? "X" : "0";
            BotonTablero botonClickeado = (BotonTablero) actionEvent.getSource();
            botonClickeado.setText(textoBoton);
            botonClickeado.setEnabled(false);

            // --- Actualiza modelo ---
            modelo.poneSimbolo(botonClickeado.getI(), botonClickeado.getJ(), turnoAct);

            // --- Checkea victoria ---
            if (modelo.checkVictoria(turnoAct)){
                this.vista.setTextoTurno("¡" + textoBoton + " ganó!");
                int reinicio = this.vista.mostrarDialogoFinJuego();
                if (reinicio == JOptionPane.YES_OPTION){
                    this.modelo = new Modelo();
                    this.vista.iniciaVista();
                }
                return;
            }

            // --- Checkea empate ---
            if(modelo.checkEmpate()){
                this.vista.setTextoTurno("¡Empate!");
                int reinicio = this.vista.mostrarDialogoFinJuego();
                if (reinicio == JOptionPane.YES_OPTION){
                    this.modelo = new Modelo();
                    this.vista.iniciaVista();
                }
                return;
            }

            // --- Cambio de turno si no hubo victoria ni empate---
            modelo.cambiaTurno();
            textoBoton = (turnoAct == Modelo.CRUZ) ? "0" : "X";
            this.vista.setTextoTurno("Turno de " + textoBoton);
        }
    }
}
