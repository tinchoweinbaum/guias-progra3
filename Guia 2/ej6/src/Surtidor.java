import java.util.ArrayList;

public class Surtidor {
    private int cantGasoil;
    private int cantSuper;
    private int cantPremium;
    private ArrayList<Carga> cargas;
    final private int maxCarga = 20000;

    public Surtidor(){
        this.cantGasoil = this.maxCarga;
        this.cantSuper = this.maxCarga;
        this.cantPremium = this.maxCarga;
        this.cargas = new ArrayList<>();
    }

    public boolean extraerGasoil(int litros){ // Reescribr estos metodos para poder crear el objeto Carga antes de devoler true o false
        if (this.cantGasoil >= litros){
            this.cantGasoil -= litros;
            return true;
        }
        this.cantGasoil = 0;
        return false;
    }

    public boolean extraerSuper(int litros){
        if (this.cantSuper >= litros){
            this.cantSuper -= litros;
            return true;
        }
        this.cantSuper = 0;
        return false;
    }

    public boolean extraerPremium(int litros){
        if (this.cantPremium >= litros){
            this.cantPremium -= litros;
            return true;
        }
        this.cantPremium = 0;
        return false;
    }

    public void llenarDepositoGasoil(){
        this.cantGasoil = this.maxCarga;
    }

    public void llenarDepositoSuper(){
        this.cantSuper = this.maxCarga;
    }

    public void llenarDepositoPremium(){
        this.cantPremium = this.maxCarga;
    }

    public int getCantGasoil() {
        return cantGasoil;
    }

    public int getCantSuper() {
        return cantSuper;
    }

    public int getCantPremium() {
        return cantPremium;
    }
}
