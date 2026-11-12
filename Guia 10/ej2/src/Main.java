public static void main(String[] args){
    Empleado empleado = new Empleado(5);
    new Thread(new Persona("Maria", 5, 1, empleado)).start();
    new Thread(new Persona("Del Potro", 4, 1, empleado)).start();
    new Thread(new Persona("Juan", 1, 1, empleado)).start();
    new Thread(new Persona("Martin", 3, 1, empleado)).start();
    new Thread(new Persona("Wachín", 2, 1, empleado)).start();
}
