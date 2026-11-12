public class SedState implements State{
    private Mascota mascota;

    public SedState(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void informarNecesidad() {
        mascota.getObserver().informarNecesidad(mascota + " tiene sed");
    }
}
