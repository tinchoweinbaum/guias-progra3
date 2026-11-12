public class SinNecesidadState implements State{
    private Mascota mascota;

    public SinNecesidadState(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void informarNecesidad() {}
}
