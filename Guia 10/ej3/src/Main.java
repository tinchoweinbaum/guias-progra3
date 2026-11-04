public static void main(String[] args){
    ArrayList<Carta> cartas = new ArrayList<>();

    // Cuatro cartas que valen del 1 al 9
    for (int valor = 1; valor <= 9; valor++) {
        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta(valor));
        }
    }

    // Dieciséis cartas que valen 10
    for (int i = 0; i < 16; i++) {
        cartas.add(new Carta(10));
    }

    // 2. Crear los jugadores
    ArrayList<Jugador> jugadores = new ArrayList<>();
    Jugador j1 = new Jugador("Maria", 1);
    Jugador j2 = new Jugador("Del Potro", 2);
    Jugador j3 = new Jugador("Juan", 3);

    jugadores.add(j1);
    jugadores.add(j2);
    jugadores.add(j3);

    // 3. Crear el mazo pasándole las cartas y los jugadores
    Mazo mazo = new Mazo(cartas, jugadores, jugadores.size());

    // 4. Asignar el mazo a cada jugador (evita NullPointerException)
    for (Jugador j : jugadores) {
        j.setMazo(mazo);
    }

    // 5. Crear e iniciar los hilos
    ArrayList<Thread> hilos = new ArrayList<>();
    for (Jugador j : jugadores) {
        Thread t = new Thread(j);
        hilos.add(t);
        t.start();
    }

    // --- ESTO ES LO QUE TE FALTA ---
    // 6. Hacer que el main espere a que todos los hilos terminen
    for (Thread t : hilos) {
        try {
            t.join(); // El main se pausa aquí esperando que 't' muera
        } catch (InterruptedException e) {
            System.out.println("Main interrumpido");
        }
    }
    // -------------------------------

    Jugador ganador = Jugador.obtenerGanador(jugadores);
    System.out.println("Fin del juego. El ganador es " + ganador + " con " + ganador.getManosGanadas() + " manos ganadas");
}