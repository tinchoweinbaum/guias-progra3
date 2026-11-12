public class Modelo {
    public final static int CRUZ = 1;
    public final static int CIRCULO = -1;
    private int[][] matrizTablero = new int[3][3]; // Matriz de 3x3, Java la inicializa en 0 cuando la crea.
    private int turnoAct = CRUZ;

    public Modelo() {

    }

    public void poneSimbolo(int i, int j,int simbolo){
        if (!esPosicionValida(i,j))
            return;
        matrizTablero[i][j] = simbolo;
    }


    public boolean esPosicionValida(int i, int j) {
        return (i >= 0 && i < 3) && (j >= 0 && j < 3);
    }

    public boolean checkVictoria(int simbolo) {
        // 1. Filas y Columnas
        for (int i = 0; i < 3; i++) {
            if (matrizTablero[i][0] == simbolo && matrizTablero[i][1] == simbolo && matrizTablero[i][2] == simbolo)
                return true; // Fila i completa
            if (matrizTablero[0][i] == simbolo && matrizTablero[1][i] == simbolo && matrizTablero[2][i] == simbolo)
                return true; // Columna i completa
        }

        // 2. Diagonal principal (0,0 -> 2,2)
        if (matrizTablero[0][0] == simbolo && matrizTablero[1][1] == simbolo && matrizTablero[2][2] == simbolo)
            return true;

        // 3. Diagonal secundaria (0,2 -> 2,0)
        if (matrizTablero[0][2] == simbolo && matrizTablero[1][1] == simbolo && matrizTablero[2][0] == simbolo)
            return true;

        return false;
    }

    public boolean checkEmpate() {
        // Si alguien ya ganó, no es empate
        if (checkVictoria(CRUZ) || checkVictoria(CIRCULO)) {
            return false;
        }

        // Si queda al menos una casilla vacía (0), todavía no hay empate
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizTablero[i][j] == 0) return false;
            }
        }

        return true; // Tablero lleno sin ganador
    }

    public int getTurnoAct() {
        return turnoAct;
    }

    public void cambiaTurno(){
        turnoAct = (turnoAct == CRUZ) ? CIRCULO : CRUZ;
    }
}
