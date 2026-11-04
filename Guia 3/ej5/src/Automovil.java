public abstract class Automovil {
    private String patente;
    private double velocidad;
    private double velocidadMax;
    private int marcha;

    Automovil(String patente, double velocidadMax){
        this.patente = patente;
        this.velocidadMax = velocidadMax;
        this.velocidad = 0;
        this.marcha = 0;
    }

    Automovil(String patente){
        this(patente, 160);
    }

    public String getPatente(){
        return this.patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public int getMarcha() {
        return marcha;
    }

    protected void setMarcha(int marcha){
        if (marcha > -1 || marcha < 5)
            this.marcha = marcha;
    }

    protected void setVelocidad(double velFinal){
        if (velFinal < 0 || velFinal > this.velocidadMax) {
            System.out.println("Valor invalido de velocidad: " + velFinal);
            return;
        }
        this.velocidad = velFinal;
    }

    public abstract void acelerar(double vel);

    public abstract void frenar(double vel);
}
