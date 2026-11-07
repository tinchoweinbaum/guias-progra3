public class RestaState implements State{
    private Calculadora calc;

    public RestaState(Calculadora calc) {
        this.calc = calc;
    }

    @Override
    public void digitoIngresado(int digito) {
        calc.segundoOp = calc.segundoOp * 10 + digito;
    }

    @Override
    public void operadorIngreasdo(char operador) {
        calc.setEstado(new ErrorState(calc));
    }

    @Override
    public int igualIngresado() {
        return calc.primerOp - calc.segundoOp;
    }

    @Override
    public void CeIngresado() {
        calc.setEstado(new EsperandoPrimerOpState(calc));
    }
}
