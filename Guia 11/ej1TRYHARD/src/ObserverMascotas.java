import java.util.ArrayList;

public class ObserverMascotas {
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public ObserverMascotas() {
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void agregarMascota(Mascota m){
        this.mascotas.add(m);
    }

    public void informarNecesidad(String strNecesidad){
        System.out.println(strNecesidad);
    }
}
