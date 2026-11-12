import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame implements IVista{
    private JPanel panelTablero;
    private JLabel textoTurno;
    private BotonTablero[][] matrizTableroVista = new BotonTablero[3][3];

    public final static int CRUZ = Modelo.CRUZ;
    public final static int CIRCULO = Modelo.CIRCULO;

    public Vista() throws HeadlessException {
        super("Ta-Te-Ti");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(325, 475);
        setLocationRelativeTo(null);

        this.iniciaVista();
    }

    @Override
    public void iniciaVista() {
        getContentPane().removeAll();


        // El layout principal de la ventana
        setLayout(new BorderLayout());

        // 1. Centramos el texto y le damos un poco de margen para que se vea mejor
        this.textoTurno = new JLabel("Turno de X", SwingConstants.CENTER);
        this.textoTurno.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        // 2. Usamos GridLayout(3, 3) para forzar una grilla perfecta
        this.panelTablero = new JPanel();
        this.panelTablero.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                BotonTablero botonTablero = new BotonTablero(i,j);
                botonTablero.setActionCommand("CLICK_TABLERO");
                this.matrizTableroVista[i][j] = botonTablero;
                panelTablero.add(botonTablero);
            }
        }

        // 4. Asignamos la posición en el BorderLayout
        add(textoTurno, BorderLayout.NORTH);    // Manda el texto a la parte superior
        add(panelTablero, BorderLayout.CENTER); // Hace que el tablero ocupe todo el espacio restante

        // Deja de funcionar al reiniciarse porque se pierde el ActionListener de los botones.
        // En vez de llamar a iniciaVista cuando se reinicia tiene que haber un método de reiniciar vista y modelo limpiamente a la vez.

        repaint();
        revalidate();
        setVisible(true);
    }

    @Override
    public int mostrarDialogoFinJuego() {
        // Devuelve 0 si elige "Sí", 1 si elige "No"
        return JOptionPane.showConfirmDialog(this, "Fin del juego, ¿Reiniciar?", "Fin de la partida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    }

    @Override
    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.matrizTableroVista[i][j].addActionListener(listener); // Hago que el controller sea listener de todos los botones de la matriz
            }
        }
    }

    @Override
    public void setTextoTurno(String texto){
        this.textoTurno.setText(texto);
    }
}
