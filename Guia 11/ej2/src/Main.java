import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora (Patrón State) ---");
        System.out.println("Ingrese su operación carácter por carácter o todo junto (ej: 12+5=).");
        System.out.println("Ingrese 's' para salir.");

        while (true) {
            System.out.print("> ");
            String linea = scanner.nextLine();

            // Condición de salida
            if (linea.trim().equalsIgnoreCase("s")) {
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            // Procesamos los caracteres ingresados de a uno
            for (char c : linea.toCharArray()) {
                // Ignorar espacios en blanco
                if (c == ' ') continue;

                if (Character.isDigit(c)) {
                    calc.digitoIngresado(Character.getNumericValue(c));
                }
                else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    calc.operadorIngresado(c);
                }
                else if (c == '=') {
                    int resultado = calc.ejecutarOperacion();
                    System.out.println("Resultado: " + resultado);

                    // Opcional: Reiniciar la calculadora para una nueva operación
                    calc.setEstado(new EsperandoPrimerOpState(calc));2
                }
                else if (c == 'c' || c == 'C') {
                    // Para soportar el borrado total
                    calc = new Calculadora();
                    System.out.println("Calculadora reiniciada (CE).");
                }
                else {
                    System.out.println("Carácter no reconocido: " + c);
                }
            }
        }

        scanner.close();
    }
}