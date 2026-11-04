package vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements IVista{
    private JLabel labelValor;
    private JButton botonInc;
    private JButton botonDec;

    public Ventana(){
        super("Contador Test MVC");

        // --- LABEL DEL VALOR ---
        this.labelValor = new JLabel("0", SwingConstants.CENTER); // Supongo que crea un label y lo pone en medio de la pantalla.
        this.labelValor.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));

        // --- BOTON DE INCREMENTO ---
        this.botonInc = new JButton("Incrementar");
        this.botonInc.setActionCommand("INCREMENTAR"); // Action command que "arroja" al ser clickeado.
        this.botonInc.setPreferredSize(new Dimension(0, 150));

        // --- BOTON DE DECREMENTO ---
        this.botonDec = new JButton("Decrementar");
        this.botonDec.setActionCommand("DECREMENTAR");
        this.botonDec.setPreferredSize(new Dimension(0, 120));

        // --- PANEL DE LOS BOTONES ---
        JPanel panelBotones = new JPanel(new GridLayout(1,2)); // un panel con 1 fila y 2 columnas
        panelBotones.setPreferredSize(new Dimension(0, 150));
        panelBotones.add(botonInc); // agrego los botones al panel.
        panelBotones.add(botonDec);

        // --- LAYOUT GENERAL DE LOS ELEMENTOS DE LA VENTANA ---
        this.setLayout(new BorderLayout());
        this.add(this.labelValor, BorderLayout.CENTER); // pone el label del valor en medio de la pantalla
        this.add(panelBotones, BorderLayout.SOUTH); // pone el panel que contiene los botones al sur de la pantalla.

        this.setSize(600, 450);
        this.setLocationRelativeTo(null); // Abre la ventana en el medio de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // visibiliza la ventan.
    }

    /**
     * Actualiza el valor del JLabel con el valor que recibe desde el controlador.
     */
    @Override
    public void setValor(int valor){
        this.labelValor.setText(String.valueOf(valor));
    }

    /**
     * Linkea los botones del panel con el listener que recibe del controlador
     */
    @Override
    public void setActionListener(ActionListener listener){
        this.botonInc.addActionListener(listener);
        this.botonDec.addActionListener(listener);
    }
}
