package modelo;

import java.util.*;

public class Algoritmos {
    private Laberinto laberinto;

    public Algoritmos(Laberinto laberinto) {
        this.laberinto = laberinto;
    }

    public List<Celda> bfs(Celda inicio, Celda destino) {
        Queue<List<Celda>> cola = new LinkedList<>();
        Set<String> visitados = new HashSet<>();

        List<Celda> caminoInicial = new ArrayList<>();
        caminoInicial.add(inicio);
        cola.add(caminoInicial);
        visitados.add(inicio.getX() + "," + inicio.getY());

        while (!cola.isEmpty()) {
            List<Celda> camino = cola.poll();
            Celda actual = camino.get(camino.size() - 1);

            if (actual.equals(destino)) {
                return camino; 
            }

            for (Celda vecino : obtenerVecinos(actual)) {
                String key = vecino.getX() + "," + vecino.getY();
                if (!visitados.contains(key)) {
                    List<Celda> nuevoCamino = new ArrayList<>(camino);
                    nuevoCamino.add(vecino);
                    cola.add(nuevoCamino);
                    visitados.add(key);
                }
            }
        }
        return new ArrayList<>(); 
    }

    public List<Celda> dfs(Celda inicio, Celda destino) {
        Stack<List<Celda>> pila = new Stack<>();
        Set<String> visitados = new HashSet<>();

        List<Celda> caminoInicial = new ArrayList<>();
        caminoInicial.add(inicio);
        pila.push(caminoInicial);
        visitados.add(inicio.getX() + "," + inicio.getY());

        while (!pila.isEmpty()) {
            List<Celda> camino = pila.pop();
            Celda actual = camino.get(camino.size() - 1);

            if (actual.equals(destino)) {
                return camino;
            }

            for (Celda vecino : obtenerVecinos(actual)) {
                String key = vecino.getX() + "," + vecino.getY();
                if (!visitados.contains(key)) {
                    List<Celda> nuevoCamino = new ArrayList<>(camino);
                    nuevoCamino.add(vecino);
                    pila.push(nuevoCamino);
                    visitados.add(key);
                }
            }
        }
        return new ArrayList<>(); 
    }

    public List<Celda> bfsConCache(Celda inicio, Celda destino) {
        Map<String, List<Celda>> cache = new HashMap<>();
        return bfsConCacheHelper(inicio, destino, cache);
    }

    private List<Celda> bfsConCacheHelper(Celda inicio, Celda destino, Map<String, List<Celda>> cache) {
        String clave = inicio.getX() + "," + inicio.getY() + "->" + destino.getX() + "," + destino.getY();
        if (cache.containsKey(clave)) {
            return cache.get(clave);
        }

        List<Celda> resultado = bfs(inicio, destino);
        cache.put(clave, resultado);
        return resultado;
    }

    private List<Celda> obtenerVecinos(Celda actual) {
        List<Celda> vecinos = new ArrayList<>();
        int x = actual.getX();
        int y = actual.getY();

        if (x > 0 && laberinto.getCelda(x - 1, y).esTransitable()) 
            vecinos.add(laberinto.getCelda(x - 1, y)); // Arriba
        if (x < laberinto.getFilas() - 1 && laberinto.getCelda(x + 1, y).esTransitable()) 
            vecinos.add(laberinto.getCelda(x + 1, y)); // Abajo
        if (y > 0 && laberinto.getCelda(x, y - 1).esTransitable()) 
            vecinos.add(laberinto.getCelda(x, y - 1)); // Izquierda
        if (y < laberinto.getColumnas() - 1 && laberinto.getCelda(x, y + 1).esTransitable()) 
            vecinos.add(laberinto.getCelda(x, y + 1)); // Derecha

        return vecinos;
    }
}