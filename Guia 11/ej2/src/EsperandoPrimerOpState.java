public class EsperandoPrimerOpState implements State{
    private Calculadora calc;

    public EsperandoPrimerOpState(Calculadora calc) {
        this.calc = calc;
        calc.primerOp = 0;
        calc.segundoOp = 0;
    }

    @Override
    public void digitoIngresado(int digito) {
        calc.primerOp = calc.primerOp * 10 + digito;
    }

    @Override
    public void operadorIngreasdo(char operador) {
        switch (operador){
            case '+':
                calc.setEstado(new SumaState(calc));
                break;
            case '*':
                calc.setEstado(new ProductoState(calc));
                break;
            case '-':
                calc.setEstado(new RestaState(calc));
                break;
            case '/':
                calc.setEstado(new DivisionState(calc));
                break;
        }
    }

    @Override
    public int igualIngresado() {
        return calc.primerOp;
    }

    @Override
    public void CeIngresado() {
        calc.setEstado(new EsperandoPrimerOpState(calc));
    }
}
