package modelo;

public class Celda {
    private int x, y;
    private boolean transitable;

    public Celda(int x, int y, boolean transitable) {
        this.x = x;
        this.y = y;
        this.transitable = transitable;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean esTransitable() { return transitable; }
    
    public void setTransitable(boolean transitable) {
        this.transitable = transitable;
    }
}