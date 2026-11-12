import javax.swing.*;

public class BotonTablero extends JButton {
    private final int i;
    private final int j;

    public BotonTablero(int i, int j){
        super();
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
