package controlador;

import modelo.Contador;
import vista.IVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private IVista vista; // La vista abstracta permite implementar varias vistas diferentes y usarlas intercambiablemente
    private Contador modelo; // El controlador conoce a la vista y al modelo

    public Controlador(IVista vista, Contador modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this); // Creo que pone al controlador como listener de la vista.
        this.vista.setValor(this.modelo.getValor()); // Actualiza el valor de la vista con el valor del modelo, inicialmente 0.
    }

    /**
     * Cascada horrible de if-else
     * @param e Evento a procesar.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("INCREMENTAR")) {
            this.modelo.incrementar();
        } else if(e.getActionCommand().equals("DECREMENTAR")) {
            this.modelo.decrementar();
        }
        this.vista.setValor(this.modelo.getValor()); // Actualiza el valor del JLabel despues de incrementar o decrementar
    }
}

