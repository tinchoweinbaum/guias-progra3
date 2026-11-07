package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame implements IVista{
    // --- Elementos de la pantalla de inicio ---
    private JTextField campoAltoTablero;
    private JLabel labelAltoTablero;

    private JTextField campoAnchoTablero;
    private JLabel labelAnchoTablero;

    private JTextField campoCantMinas;
    private JLabel labelCantMinas;

    private JButton botonAceptar;

    public Vista() throws HeadlessException {
        // --- Inicialización de la ventana ---
        super("Buscaminas - Inicio");
        setSize(325,475);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // --- Creación de componentes visuales ---
        labelAltoTablero = new JLabel("Alto del tablero");
        campoAltoTablero = new JTextField(5); // Inicializo 1x1 todos los elementos visuales de la pantalla inicial.

        labelAnchoTablero = new JLabel("Ancho del tablero");
        campoAnchoTablero = new JTextField(5);

        labelCantMinas = new JLabel("Cantidad de minas");
        campoCantMinas = new JTextField(5);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setActionCommand("ACEPTAR"); // Nombre del actionCommand para que lo agarre la cadena if-else del controller.

        // --- Armado del layout ---
        setLayout(new BorderLayout()); // Tipo de layout de la pantalla de inicio.
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10)); // Crea un panel para el formulario con distribución de 1 fila y 3 columnas
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // Crea márgenes para claridad

        panelFormulario.add(labelAltoTablero); // Agrega los elementos al panel de a uno y en ORDEN.
        panelFormulario.add(campoAltoTablero);
        panelFormulario.add(labelAnchoTablero);
        panelFormulario.add(campoAnchoTablero);
        panelFormulario.add(labelCantMinas);
        panelFormulario.add(campoCantMinas);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Crea un panel para el botón de aceptar
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panelBoton.add(botonAceptar);

        add(panelFormulario, BorderLayout.CENTER); // Agrega los dos paneles creados al JFrame principal
        add(panelBoton, BorderLayout.SOUTH);

        this.setVisible(true); // Visibiliza la ventana.
    }

    // --- Métodos de la pantalla de inicio ---
    @Override
    public int getAltoTablero() {
        try {
            return Integer.parseInt(campoAltoTablero.getText()); // Toma el texto que haya escrito en el campo del alto.
        } catch (NumberFormatException e) {
            return 0; // Nunca se va a dar esta excepción porque ya checkea el botón de aceptar.
        }
    }

    @Override
    public int getAnchoTablero() {
        try{
            return Integer.parseInt(campoAnchoTablero.getText());
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    @Override
    public int getCantMinas(){
        try {
            return Integer.parseInt(campoCantMinas.getText());
        } catch (NumberFormatException e){
            return 0;
        }
    }



    // --- Métodos de la pantalla del juego ---
    @Override
    public void escribeCantMinas() {

    }

    @Override
    public void poneBandera() {

    }

    @Override
    public void setActionListener(ActionListener listener) {
        this.botonAceptar.addActionListener(listener);
    }
}
