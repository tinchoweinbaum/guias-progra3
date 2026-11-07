package vista;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface IVista {
    public int getAltoTablero();
    public int getAnchoTablero();
    public int getCantMinas();
    public void escribeCantMinas();
    public void poneBandera();
    public void iniciarTablero(int alto, int ancho, MouseListener mouseListener, ActionListener actionListener);

    public void setActionListener(ActionListener listener);

    void pantallaInicial();
}
