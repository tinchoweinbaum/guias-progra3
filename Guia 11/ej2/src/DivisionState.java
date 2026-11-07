public class DivisionState implements State{
    private Calculadora calc;

    public DivisionState(Calculadora calc) {
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
        if (calc.segundoOp != 0) {
            return calc.primerOp / calc.segundoOp;
        }
        calc.setEstado(new ErrorState(calc));

        return 0;
    }

    @Override
    public void CeIngresado() {

    }
}
