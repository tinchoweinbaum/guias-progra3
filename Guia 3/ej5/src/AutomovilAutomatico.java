public class AutomovilAutomatico extends Automovil{
    AutomovilAutomatico(String patente, double velMax){
        super(patente, velMax);
        IO.println("Automovil automatico creado.");
    }

    AutomovilAutomatico(String patente){
        this(patente, 160);
    }

    private void actualizarMarcha(){
        double velAct = this.getVelocidad();

        if (velAct == 0)
            this.setMarcha(0);
        else if (velAct > 0 && velAct <= 10)
            this.setMarcha(1);
        else if (velAct > 10 && velAct <= 35)
            this.setMarcha(2);
        else if (velAct > 35 && velAct <= 50)
            this.setMarcha(3);
        else if (velAct > 50 && velAct <= 90)
            this.setMarcha(4);
        else
            this.setMarcha(5);

        IO.println("Marcha de " + this.getPatente() +": " + this.getMarcha());
    }

    // No tiene senitido tener dos metodos distintos para acelerar/frenar pero es lo que pide la consigna
    public void acelerar(double vel){
        this.setVelocidad(this.getVelocidad() + vel);
        IO.println(this.getPatente() + " acelero hasta los " + this.getVelocidad() + "Km/h");

        this.actualizarMarcha();
    }

    public void frenar(double vel){
        this.setVelocidad(this.getVelocidad() - vel);
        IO.println(this.getPatente() + " freno hasta los " + this.getVelocidad() + "Km/h");

        this.actualizarMarcha();
    }


}
