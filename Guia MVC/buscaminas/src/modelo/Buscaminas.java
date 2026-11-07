package modelo;

import java.util.Arrays;

public class Buscaminas {
    private static final int MINA = -1;
    private static final int CLICKEADO = 1;
    private static final int FLAGEADO = 2;

    private int altoTablero;
    private int anchoTablero;
    private int cantMinas;

    // Dos matrices para no pisar el -1 con el 2
    private int[][] matriz;       // Guarda las minas (-1) y vacíos (0)
    private int[][] matrizEstado; // Guarda clicks (1), banderas (2) y tapados (0)

    public Buscaminas(int altoTablero, int anchoTablero, int cantMinas) throws ParametroInvalidoException {
        if (altoTablero <= 0 || anchoTablero <= 0 || cantMinas > altoTablero * anchoTablero)
            throw new ParametroInvalidoException("Los parámetros ingresados son inválidos");

        this.altoTablero = altoTablero;
        this.anchoTablero = anchoTablero;
        this.cantMinas = cantMinas;
        this.matriz = new int[altoTablero][anchoTablero];
        this.matrizEstado = new int[altoTablero][anchoTablero];
    }

    public void initMatriz(int cantMinas) throws FueraTableroException {
        for (int[] fila : matriz) Arrays.fill(fila, 0);
        for (int[] fila : matrizEstado) Arrays.fill(fila, 0);

        int minasColocadas = 0;
        while (minasColocadas < cantMinas) {
            int randomI = (int) (Math.random() * this.altoTablero);
            int randomJ = (int) (Math.random() * this.anchoTablero);

            if (!isMina(randomI, randomJ)) {
                this.matriz[randomI][randomJ] = MINA;
                minasColocadas++;
            }
        }
    }

    public int getMinasAdyacentes(int i, int j) throws FueraTableroException {
        if (!coordsValidas(i, j))
            throw new FueraTableroException("Coordenadas Inválidas: " + i + j);

        int minasAdy = 0;
        for (int fila = i - 1; fila <= i + 1; fila++) {
            for (int columna = j - 1; columna <= j + 1; columna++) {
                if (coordsValidas(fila, columna) && isMina(fila, columna) && !(fila == i && columna == j)) {
                    minasAdy++;
                }
            }
        }
        return minasAdy;
    }

    public void clickCasilla(int i, int j) throws FueraTableroException {
        if (!coordsValidas(i, j)) return;

        if (this.matrizEstado[i][j] == 0) {
            this.matrizEstado[i][j] = CLICKEADO;

            if (isMina(i, j)) {
                // fin del juego
            }
        }
    }

    public void flagearCasilla(int i, int j) throws FueraTableroException {
        if (!coordsValidas(i, j))
            throw new FueraTableroException("Coordenadas Inválidas: " + i + j);

        if (this.matrizEstado[i][j] == 0) {
            this.matrizEstado[i][j] = FLAGEADO;
        } else if (this.matrizEstado[i][j] == FLAGEADO) {
            this.matrizEstado[i][j] = 0; // Permite sacar la bandera
        }
    }

    public boolean isMina(int i, int j) throws FueraTableroException {
        if (!coordsValidas(i, j))
            throw new FueraTableroException("Coordenadas Inválidas: " + i + j);
        return this.matriz[i][j] == MINA;
    }

    public boolean isFlagged(int i, int j) throws FueraTableroException {
        if (!coordsValidas(i, j))
            throw new FueraTableroException("Coordenadas Inválidas: " + i + j);
        return this.matrizEstado[i][j] == FLAGEADO;
    }

    public boolean isClicked(int i, int j) throws FueraTableroException {
        if (!coordsValidas(i, j))
            throw new FueraTableroException("Coordenadas Inválidas: " + i + j);
        return this.matrizEstado[i][j] == CLICKEADO;
    }

    public boolean coordsValidas(int i, int j) {
        return i >= 0 && i < this.altoTablero && j >= 0 && j < this.anchoTablero;
    }
}