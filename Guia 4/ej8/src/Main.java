
public static void main(String[] args) {
    System.out.println("=== INICIO DE LA BATALLA ÉPICA ===");

    // 1. Creamos posiciones iniciales
    Posicion posGuerrero = new Posicion(0, 0);
    Posicion posCaballero = new Posicion(3, 4); // Distancia 5 desde el origen
    Posicion posArquero = new Posicion(50, 0);

    // 2. Instanciamos los personajes
    Guerrero thor = new Guerrero("Thor", posGuerrero);
    Caballero lancelot = new Caballero("Lancelot", posCaballero);
    Arquero legolas = new Arquero("Legolas", posArquero);

    mostrarEstado(thor, lancelot, legolas);

    // 3. Prueba de ataque a distancia lejana (Arquero llega porque está a < 100 de Thor)
    System.out.println("\n--- Turno 1: Legolas dispara a Thor desde lejos ---");
    boolean disparoExitoso = legolas.ataca(thor);
    System.out.println("¿Ataque exitoso? " + disparoExitoso);
    mostrarEstado(thor, lancelot, legolas);

    // 4. Acercamos al Guerrero y al Caballero para probar combate cuerpo a cuerpo
    System.out.println("\n--- Turno 2: Lancelot se acerca y ataca a Thor ---");
    // Distancia actual entre (0,0) y (3,4) es exactamente 5.
    // El caballero requiere < 10, así que está en rango.
    boolean ataqueCaballero = lancelot.ataca(thor);
    System.out.println("¿Ataque exitoso? " + ataqueCaballero);
    mostrarEstado(thor, lancelot, legolas);

    // 5. El Guerrero contraataca (rango < 5)
    System.out.println("\n--- Turno 3: Thor contraataca a Lancelot ---");
    // Moveremos a Thor un poco para asegurarnos de estar a < 5 de Lancelot (3,4)
    thor.setPos(new Posicion(1, 1));
    boolean ataqueGuerrero = thor.ataca(lancelot);
    System.out.println("¿Ataque exitoso? " + ataqueGuerrero);
    mostrarEstado(thor, lancelot, legolas);

    // 6. Agotar las flechas del Arquero para probar su ataque cuerpo a cuerpo
    System.out.println("\n--- Turno 4: Legolas gasta sus 20 flechas ---");
    legolas.setCantFlechas(0);

    // Lo acercamos para que pueda pegar con el arco vacío (rango < 5)
    legolas.setPos(new Posicion(1, 2));
    System.out.println("Legolas se queda sin flechas y se acerca a Thor.");
    boolean ataqueSinFlechas = legolas.ataca(thor);
    System.out.println("¿Ataque cuerpo a cuerpo exitoso? " + ataqueSinFlechas);
    mostrarEstado(thor, lancelot, legolas);
}

public static void mostrarEstado(Personaje... personajes) {
    System.out.println("\nEstado actual de los personajes:");
    for (Personaje p : personajes) {
        System.out.print("- " + p.getNombre() + " (" + p.getClass().getSimpleName() + ")" +
                " | Vitalidad: " + p.getVitalidad() +
                " | Posición: (" + p.getPos().getPosX() + ", " + p.getPos().getPosY() + ")");

        if (p instanceof Guerrero) {
            System.out.print(" | Armadura: " + ((Guerrero) p).getArmadura());
        } else if (p instanceof Arquero) {
            System.out.print(" | Flechas: " + ((Arquero) p).getCantFlechas());
        }
        System.out.println();
    }
    System.out.println("--------------------------------------------------");
}
