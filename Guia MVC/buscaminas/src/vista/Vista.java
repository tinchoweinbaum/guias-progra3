package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Vista extends JFrame implements IVista {
    // --- Elementos de la pantalla de inicio ---
    private JTextField campoAltoTablero;
    private JLabel labelAltoTablero;
    private JTextField campoAnchoTablero;
    private JLabel labelAnchoTablero;
    private JTextField campoCantMinas;
    private JLabel labelCantMinas;
    private JButton botonAceptar;

    private ActionListener listenerControlador; // Referencia al objeto controlador, cuando el controlador se crea, se pasa como listener de la vista.

    public Vista() throws HeadlessException {
        super("Buscaminas - Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Llamamos al método que arma la pantalla para no duplicar código
        pantallaInicial();

        this.setVisible(true);
    }

    public void pantallaInicial() {
        Container lienzo = this.getContentPane();
        lienzo.removeAll();

        // 1. Restauramos el tamaño original de la pantalla de inicio
        setSize(325, 475);
        setLocationRelativeTo(null);
        setTitle("Buscaminas - Inicio");

        // 2. Creación de componentes visuales
        labelAltoTablero = new JLabel("Alto del tablero");
        campoAltoTablero = new JTextField(5);

        labelAnchoTablero = new JLabel("Ancho del tablero");
        campoAnchoTablero = new JTextField(5);

        labelCantMinas = new JLabel("Cantidad de minas");
        campoCantMinas = new JTextField(5);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setActionCommand("ACEPTAR");

        // RECONEXIÓN CLAVE: Si el controlador ya nos había dado su listener, se lo volvemos a poner al botón nuevo
        if (this.listenerControlador != null) {
            botonAceptar.addActionListener(this.listenerControlador);
        }

        // 3. Armado del layout
        setLayout(new BorderLayout());
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        panelFormulario.add(labelAltoTablero);
        panelFormulario.add(campoAltoTablero);
        panelFormulario.add(labelAnchoTablero);
        panelFormulario.add(campoAnchoTablero);
        panelFormulario.add(labelCantMinas);
        panelFormulario.add(campoCantMinas);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panelBoton.add(botonAceptar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        // 4. Forzamos el redibujado
        lienzo.revalidate();
        lienzo.repaint();
    }

    @Override
    public void iniciarTablero(int alto, int ancho, MouseListener mouseListener, ActionListener actionListener) {
        Container lienzo = this.getContentPane();
        lienzo.removeAll();

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Creo el panel de los botones
        JButton botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setActionCommand("REINICIAR");
        botonReiniciar.addActionListener(actionListener); // El controlador ahora es listener del boton de reiniciar.
        panelBotones.add(botonReiniciar);

        JPanel panelJuego = new JPanel(new GridLayout(alto, ancho));
        for (int i = 0; i < alto; i++){
            for (int j = 0; j < ancho; j++){
                BotonCasilla botonCasilla = new BotonCasilla(i, j);
                botonCasilla.addMouseListener(mouseListener);
                panelJuego.add(botonCasilla);
            }
        }

        lienzo.setLayout(new BorderLayout());
        lienzo.add(panelBotones, BorderLayout.NORTH);
        lienzo.add(panelJuego, BorderLayout.CENTER);

        this.setSize(ancho * 45, (alto * 45) + 50);
        this.setLocationRelativeTo(null);
        setTitle("Buscaminas");

        lienzo.revalidate();
        lienzo.repaint();
    }

    @Override
    public void setActionListener(ActionListener listener) {
        this.listenerControlador = listener; // Guardamos el listener en la variable de clase
        this.botonAceptar.addActionListener(listener); // El listener ahora escucha al boton de aceptar
    }

    @Override
    public int getAltoTablero() {
        try { return Integer.parseInt(campoAltoTablero.getText()); }
        catch (NumberFormatException e) { return 0; }
    }

    @Override
    public int getAnchoTablero() {
        try { return Integer.parseInt(campoAnchoTablero.getText()); }
        catch (NumberFormatException e) { return 0; }
    }

    @Override
    public int getCantMinas() {
        try { return Integer.parseInt(campoCantMinas.getText()); }
        catch (NumberFormatException e) { return 0; }
    }

    @Override
    public void escribeCantMinas() {}

    @Override
    public void poneBandera() {}
}