package vista;

import java.awt.*;
import javax.swing.*;

public class VentanaLaberinto extends JFrame {
    private JPanel panelLaberinto;
    private JButton[][] botones;
    private JButton btnBFS, btnDFS, btnNormal, btnCache, btnReset;
    private int filas = 6, columnas = 6; 

    public VentanaLaberinto() {
        setTitle("Maze Solver");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelLaberinto = new JPanel();
        panelLaberinto.setLayout(new GridLayout(filas, columnas));
        botones = new JButton[filas][columnas];
        inicializarBotones();
        add(panelLaberinto, BorderLayout.CENTER);

        JPanel panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout());

        btnBFS = new JButton("Start with BFS");
        btnDFS = new JButton("Start with DFS");
        btnNormal = new JButton("Start Normal");
        btnCache = new JButton("Start with Cache");
        btnReset = new JButton("Reset");

        panelControles.add(btnBFS);
        panelControles.add(btnDFS);
        panelControles.add(btnNormal);
        panelControles.add(btnCache);
        panelControles.add(btnReset);

        add(panelControles, BorderLayout.SOUTH);
    }

    private void inicializarBotones() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setOpaque(true);
                botones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                int x = i, y = j;

                botones[i][j].addActionListener(e -> {
                    if (botones[x][y].getBackground() == Color.WHITE) {
                        botones[x][y].setBackground(Color.BLACK); 
                    } else {
                        botones[x][y].setBackground(Color.WHITE); 
                    }
                });

                panelLaberinto.add(botones[i][j]);
            }
        }
    }

    public JButton getBtnBFS() {
        return btnBFS;
    }

    public JButton getBtnDFS() {
        return btnDFS;
    }

    public JButton getBtnNormal() {
        return btnNormal;
    }

    public JButton getBtnCache() {
        return btnCache;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton[][] getBotones() {
        return botones;
    }

    public void resetLaberinto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j].setBackground(Color.WHITE);
            }
        }
    }
}