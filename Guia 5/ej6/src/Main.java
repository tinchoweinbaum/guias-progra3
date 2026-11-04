public static void main(String[] args) {
    System.out.println("=== PRUEBA DE DRAGONES Y COMBINACIÓN DE GEMAS ===");

    // 1. Probando al nuevo Dragón y su ataque devastador
    System.out.println("\n--- 1. Probando al Dragón ---");
    Dragon ignis = new Dragon("Ignis el Terrible", new Posicion(10, 10));
    Guerrero thor = new Guerrero("Thor", new Posicion(15, 15)); // A distancia 5 (en rango)

    System.out.println("Vitalidad inicial de Thor: " + thor.getVitalidad() + " | Armadura: " + thor.getArmadura());

    // El dragón ataca a Thor
    boolean ataqueDragon = ignis.ataca(thor);
    System.out.println("¿El Dragón atacó con éxito? " + ataqueDragon);
    System.out.println("Vitalidad de Thor tras el aliento de fuego: " + thor.getVitalidad() + " | Armadura de Thor: " + thor.getArmadura());

    // Probamos recibir daño el dragón (su método recibeDanio divide la cantidad entre 2)
    System.out.println("\nIgnis recibe 100 puntos de daño bruto:");
    ignis.recibeDanio(100);
    System.out.println("Nueva vitalidad del Dragón (100 / 2 = 50): " + ignis.getVitalidad());


    // 2. Probando el Sistema de Gemas Elementales
    System.out.println("\n--- 2. Probando Combinaciones de Gemas ---");

    Gema rubi = new Rubi();
    Gema zafiro = new Zafiro();
    Gema esmeralda = new Esmeralda();
    Gema diamante = new Diamante();

    // Ejemplos de combinaciones cruzadas utilizando doble despacho (Visitor)
    // Nota: Asumiendo que el método de combinación recibe otra gema, ej: gema1.combinarCon(gema2)
    // o llamando directamente a los métodos específicos de combinación:

    System.out.println("Combinando Rubí con Zafiro: " + rubi.combinadoConZafiro()); // Debería dar "Erupcion volcanica"
    System.out.println("Combinando Zafiro con Esmeralda: " + zafiro.combinadoConEsmeralda()); // Debería dar "Huracan"
    System.out.println("Combinando Esmeralda con Diamante: " + esmeralda.combinadoConDiamante()); // Debería dar "Vientos venenosos"
    System.out.println("Combinando Diamante con Diamante: " + diamante.combinadoConDiamante()); // Debería dar "Congelamiento"
    System.out.println("Combinando Rubí con Rubí: " + rubi.combinadoConRubi()); // Debería dar "Lluvia de fuego"
}