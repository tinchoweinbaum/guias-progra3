public class HambreState implements State{
    private Mascota mascota;

    public HambreState(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void informarNecesidad() {
        mascota.getObserver().informarNecesidad(mascota + " tiene hambre");
    }
}
