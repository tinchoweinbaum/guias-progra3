public abstract class Personaje {
    String nombre;
    int vitalidad;
    Posicion pos;

    public Personaje(String nombre, int vitalidad, Posicion pos) {
        this.nombre = nombre;
        this.vitalidad = vitalidad;
        this.pos = pos;
    }

    public Personaje(String nombre, int vitalidad) {
        this(nombre, vitalidad, new Posicion(0,0));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public Posicion getPos() {
        return pos;
    }

    public void setPos(Posicion pos) {
        this.pos = pos;
    }

    public abstract boolean ataca(Personaje p);

    public abstract void recibeDanio(int cantidad);
}
