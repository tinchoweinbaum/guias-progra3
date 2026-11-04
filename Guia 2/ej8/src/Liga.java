import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Liga {
    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;
    private static Liga _instancia = null;

    private Liga(){
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public static Liga getInstancia(){
        if (_instancia == null)
            _instancia = new Liga();
        return _instancia;
    }

    public void ordenarTabla() {
        this.equipos.sort((a, b) -> Integer.compare(b.getPuntos(), a.getPuntos()));
    }
}
