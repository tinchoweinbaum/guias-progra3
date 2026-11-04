public class CofreBendicion extends Cofre{
    public CofreBendicion() {
        super();
    }

    @Override
    public void abiertoPorGuerrero(Guerrero g){
        g.setArmadura(g.getArmadura() + 200);
    }

    @Override
    public void abiertoPorArquero(Arquero a){
        a.setCantFlechas(a.getCantFlechas() + 5);
    }

    @Override
    public void abiertoPorCaballero(Caballero c){
        c.setVitalidad( (int) (c.getVitalidad() * 1.25));
    }

    @Override
    public void abiertoPorDragon(Dragon d) {
        d.setPoderFuego((int) (d.getPoderFuego() * 1.4));
        d.setVitalidad(d.getVitalidad() + 250);
    }
}
