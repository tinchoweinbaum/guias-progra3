public class Guerrero extends Personaje{
    private int armadura;

    public Guerrero(String nombre, Posicion pos) {
        super(nombre, 800, pos);
        this.armadura = 100;
    }

    public Guerrero(String nombre){
        this(nombre, new Posicion (0,0));
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armaduraNueva) {
        this.armadura = Math.max(armaduraNueva, 0);
    }

    @Override
    public boolean ataca(Personaje p) {
        if(p.pos.distanciaHasta(this.getPos()) < 5){
            p.recibeDanio(10);
            return true;
        }
        return false;
    }

    @Override
    public void recibeDanio(int cantidad) {
        if(this.armadura - cantidad > 0)
            this.armadura -= cantidad;
        else{
            // mas daño que armadura
            int resto = cantidad - this.armadura;
            this.armadura = 0;
            this.vitalidad -= resto;
        }
    }

    public void abrirCofre(Cofre cofre){
        cofre.abiertoPorGuerrero(this);
    }
}
