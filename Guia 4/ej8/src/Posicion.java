import java.math.*;

public class Posicion {
    private double posX = 0;
    private double posY = 0;

    public Posicion(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void incrementaPos(double valorX, double valorY){
        this.posX += valorX;
        this.posY += valorY;
    }

    public double distanciaHasta(Posicion p){
        double deltaX = p.getPosX() - this.getPosX();
        double deltaY = p.getPosY() - this.getPosY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
