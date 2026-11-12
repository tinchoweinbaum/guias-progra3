public class AburridaState implements State{
    private Mascota mascota;

    public AburridaState(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void informarNecesidad() {
        mascota.getObserver().informarNecesidad(mascota + " está aburrida/o");
    }
}
