package vista;

import java.awt.event.ActionListener;

public interface IVista {
    public int getAltoTablero();
    public int getAnchoTablero();
    public int getCantMinas();
    public void escribeCantMinas();
    public void poneBandera();

    public void setActionListener(ActionListener listener);
}
