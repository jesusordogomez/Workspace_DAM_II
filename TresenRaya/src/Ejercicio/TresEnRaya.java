package Ejercicio;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class TresEnRayaPanel extends JPanel {
    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;
    private int userWins;
    private int computerWins;
    private JLabel userLabel;
    private JLabel computerLabel;

    public TresEnRayaPanel() {
        setLayout(new GridLayout(3, 3));
        initializeBoard();
    }

    private void initializeBoard() {
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        userWins = 0;
        computerWins = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j] = button;
                button.addActionListener(new ButtonClickListener(i, j));
                add(button);
            }
        }

        userLabel = new JLabel("Usuario: " + userWins);
        computerLabel = new JLabel("Ordenador: " + computerWins);
    }

    public void restartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                board[i][j] = 0;
            }
        }
        currentPlayer = 'X';
        gameEnded = false;
    }

    private void makeMove(int row, int col) {
        if (!gameEnded && board[row][col] == 0) {
            board[row][col] = currentPlayer;
            buttons[row][col].setText(Character.toString(currentPlayer));

            if (checkWinner()) {
                JOptionPane.showMessageDialog(this, "¡Jugador " + currentPlayer + " ha ganado!");
                updateScore();
                gameEnded = true;
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(this, "Empate");
                gameEnded = true;
            } else {
                switchPlayer();
                makeMoveAI();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private void makeMoveAI() {
        if (!gameEnded && currentPlayer == 'O') {
            int[] bestMove = getBestMove();
            makeMove(bestMove[0], bestMove[1]);
        }
    }

    private int[] getBestMove() {
        int[] bestMove = minimax(2, 'O');
        return new int[]{bestMove[1], bestMove[2]};
    }

    private int[] minimax(int depth, char player) {
        int[] bestMove = new int[]{(player == 'X') ? Integer.MIN_VALUE : Integer.MAX_VALUE, -1, -1};

        if (depth == 0 || checkWinner()) {
            int score = evaluateBoard();
            return new int[]{score, -1, -1};
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = player;
                    int score = minimax(depth - 1, (player == 'X') ? 'O' : 'X')[0];
                    board[i][j] = 0;  // Undo the move

                    if ((player == 'X' && score > bestMove[0]) || (player == 'O' && score < bestMove[0])) {
                        bestMove[0] = score;
                        bestMove[1] = i;
                        bestMove[2] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private int evaluateBoard() {
        int score = 0;
        score += evaluateLine(0, 0, 0, 1, 0, 2); // Rows
        score += evaluateLine(1, 0, 1, 1, 1, 2);
        score += evaluateLine(2, 0, 2, 1, 2, 2);
        score += evaluateLine(0, 0, 1, 0, 2, 0); // Columns
        score += evaluateLine(0, 1, 1, 1, 2, 1);
        score += evaluateLine(0, 2, 1, 2, 2, 2);
        score += evaluateLine(0, 0, 1, 1, 2, 2); // Diagonals
        score += evaluateLine(0, 2, 1, 1, 2, 0);
        return score;
    }

    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
        int score = 0;

        // First cell
        if (board[row1][col1] == 'X') {
            score = 1;
        } else if (board[row1][col1] == 'O') {
            score = -1;
        }

        // Second cell
        if (board[row2][col2] == 'X') {
            if (score == 1) {
                score = 10;
            } else if (score == -1) {
                return 0;
            } else {
                score = 1;
            }
        } else if (board[row2][col2] == 'O') {
            if (score == -1) {
                score = -10;
            } else if (score == 1) {
                return 0;
            } else {
                score = -1;
            }
        }

        // Third cell
        if (board[row3][col3] == 'X') {
            if (score > 0) {
                score *= 10;
            } else if (score < 0) {
                return 0;
            } else {
                score = 1;
            }
        } else if (board[row3][col3] == 'O') {
            if (score < 0) {
                score *= 10;
            } else if (score > 0) {
                return 0;
            } else {
                score = -1;
            }
        }

        return score;
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true; // Check rows
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true; // Check columns
            }
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true; // Check diagonals
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true; // Check diagonals
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false; // There is an empty cell
                }
            }
        }
        return true; // Board is full
    }

    private void updateScore() {
        if (currentPlayer == 'X') {
            userWins++;
        } else {
            computerWins++;
        }

        userLabel.setText("Usuario: " + userWins);
        computerLabel.setText("Ordenador: " + computerWins);

        checkForWinner();
    }

    private void checkForWinner() {
        if (userWins == 3) {
            JOptionPane.showMessageDialog(this, "¡Usuario ha ganado 3 veces!");
            restartGame();
        } else if (computerWins == 3) {
            JOptionPane.showMessageDialog(this, "¡Ordenador ha ganado 3 veces!");
            restartGame();
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            makeMove(row, col);
        }
    }
}