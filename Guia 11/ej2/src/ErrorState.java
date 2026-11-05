public class ErrorState implements State{
    private Calculadora calc;

    public ErrorState(Calculadora calc) {
        this.calc = calc;
    }

    @Override
    public void digitoIngresado(int digitoIngresado) {
        // No hace nada
    }

    @Override
    public void operadorIngreasdo(char operador) {
        // No hace nada
    }

    @Override
    public int igualIngresado() {
        // No hace nada
        return 0;
    }

    @Override
    public void CeIngresado() {
        calc.setEstado(new EsperandoPrimerOpState(calc));
    }
}
