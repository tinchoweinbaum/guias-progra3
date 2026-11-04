public class AutomovilManual extends Automovil{
    public AutomovilManual(String patente, double velocidadMax){
        super(patente, velocidadMax);
        IO.println("Automovil manual creado");
    }

    public AutomovilManual(String patente){
        this(patente, 160);
    }

    public void acelerar(double vel){
        this.setVelocidad(this.getVelocidad() + vel);
        IO.println(this.getPatente() + " acelero hasta los " + this.getVelocidad() + "Km/h");
    }

    public void frenar(double vel){
        this.setVelocidad(this.getVelocidad() - vel);
        IO.println(this.getPatente() + " freno hasta los " + this.getVelocidad() + "Km/h");

    }
}
