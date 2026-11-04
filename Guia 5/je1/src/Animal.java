public abstract class Animal implements EmisorDeSonido{
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void emiteSonido();
}
