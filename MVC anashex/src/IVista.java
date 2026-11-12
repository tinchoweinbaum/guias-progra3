import java.awt.event.ActionListener;

public interface IVista {
    public void setTextoTurno(String texto);
    public void iniciaVista();
    public int mostrarDialogoFinJuego();

    public void setActionListener(ActionListener listener);
}
