package modelo;

public class Laberinto {
    private Celda[][] celdas;
    private int filas, columnas;

    public Laberinto(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        celdas = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda(i, j, true);
            }
        }
    }

    public void setCelda(int x, int y, boolean esTransitable) {
        celdas[x][y].setTransitable(esTransitable);
    }

    public Celda getCelda(int x, int y) {
        return celdas[x][y];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}