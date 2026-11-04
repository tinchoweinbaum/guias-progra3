public class CofreMaldicion extends Cofre{
    public CofreMaldicion() {
        super();
    }

    @Override
    public void abiertoPorGuerrero(Guerrero g) {
        g.setArmadura(g.getArmadura() - 200);
    }

    @Override
    public void abiertoPorArquero(Arquero a) {
        a.setCantFlechas(0);
    }

    @Override
    public void abiertoPorCaballero(Caballero c) {
        c.setVitalidad( (int) (c.getVitalidad() * 0.5));
    }

    @Override
    public void abiertoPorDragon(Dragon d){
        d.setPoderFuego( (int) (d.getPoderFuego() * 0.7));
        d.setVitalidad( (int) (d.getVitalidad() * 0.8));
    }
}
