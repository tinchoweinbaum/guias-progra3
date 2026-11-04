public class Caballero extends  Personaje{
    public Caballero(String nombre) {
        super(nombre, 500);
    }

    public Caballero(String nombre, Posicion pos) {
        super(nombre, 500, pos);
    }

    @Override
    public void recibeDanio(int cantidad) {
        this.vitalidad -= cantidad;
    }

    @Override
    public boolean ataca(Personaje p) {
        if(p.pos.distanciaHasta(this.getPos()) < 10){
            p.recibeDanio(10);
            return true;
        }
        return false;
    }
}
