public interface State {
    public void digitoIngresado(int digito);
    public void operadorIngreasdo(char operador);
    public int igualIngresado(); // No tiene que ser int, tiene que modificar la vista.
    public void CeIngresado();
}
