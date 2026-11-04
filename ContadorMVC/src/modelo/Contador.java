package modelo;

public class Contador {
    private int valor = 0;

    public Contador() {}

    public void incrementar(){
        this.valor += 1;
    }

    public void decrementar(){
        if (this.valor > 0)
            this.valor -= 1;
    }

    public int getValor(){
        return this.valor;
    }
}
