public class Calculadora {
    private State estado;
    public int primerOp;
    public int segundoOp;

    public Calculadora() {
        setEstado(new EsperandoPrimerOpState(this));
    }

    public void setEstado(State nuevoEstado){
        this.estado = nuevoEstado;
    }

    public void digitoIngresado(int digito){
        this.estado.digitoIngresado(digito);
    }

    public void operadorIngresado(char operador){
        this.estado.operadorIngreasdo(operador);
    }

    public void igualIngresado(){
        this.estado.igualIngresado();
    }

    public int ejecutarOperacion(){
        return this.estado.igualIngresado();
    }

    public void CeIngreado(){
        this.estado.CeIngresado();
    }
}
