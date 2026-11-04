package vehiculos;

public class Acoplado {
    double tara;
    double cargaMaxima;
    boolean refrigerado;
    int numeroAcoplado;
    boolean enUso;

    public Acoplado(double tara, double cargaMaxima, boolean refrigerado, int numeroAcoplado, boolean enUso) {
        this.tara = tara;
        this.cargaMaxima = cargaMaxima;
        this.refrigerado = refrigerado;
        this.numeroAcoplado = numeroAcoplado;
        this.enUso = enUso;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public int getNumeroAcoplado() {
        return numeroAcoplado;
    }

    public void setNumeroAcoplado(int numeroAcoplado) {
        this.numeroAcoplado = numeroAcoplado;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }
}
