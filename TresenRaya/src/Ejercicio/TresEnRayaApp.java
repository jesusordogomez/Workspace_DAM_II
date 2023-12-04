package Ejercicio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
public class TresEnRayaApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tres en Raya");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            TresEnRayaPanel panel = new TresEnRayaPanel();
            frame.add(panel, BorderLayout.CENTER);

            JButton restartButton = new JButton("Reiniciar");
            restartButton.addActionListener(e -> {
                panel.restartGame();
            });

            JPanel scorePanel = new JPanel();
            scorePanel.setLayout(new FlowLayout());
            JLabel userLabel = new JLabel("Usuario: 0");
            JLabel computerLabel = new JLabel("Ordenador: 0");
            scorePanel.add(userLabel);
            scorePanel.add(computerLabel);

            frame.add(restartButton, BorderLayout.SOUTH);
            frame.add(scorePanel, BorderLayout.NORTH);

            frame.setVisible(true);
        });
    }
}

