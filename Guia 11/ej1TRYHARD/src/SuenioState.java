public class SuenioState implements State{
    private Mascota mascota;

    public SuenioState(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void informarNecesidad() {
        mascota.getObserver().informarNecesidad(mascota + " tiene sueño");
    }
}
