package org.example;

import java.util.Scanner;

public class CaroGame {
    private final char[][] board;
    private final int size = 15; // Kích thước bảng
    private char currentPlayer;

    public CaroGame() {
        board = new char[size][size];
        currentPlayer = 'X'; // Người chơi bắt đầu là 'X'
    }

    public void startGame() {
        while (true) {
            printBoard();
            playerMove();
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }

    private void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == '\0' ? "." : board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '\0';
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i][j + 1] == currentPlayer &&
                        board[i][j + 2] == currentPlayer &&
                        board[i][j + 3] == currentPlayer &&
                        board[i][j + 4] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= size - 5; i++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j] == currentPlayer &&
                        board[i + 2][j] == currentPlayer &&
                        board[i + 3][j] == currentPlayer &&
                        board[i + 4][j] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        // Kiểm tra đường chéo từ trái trên sang phải dưới
        for (int i = 0; i <= size - 5; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j + 1] == currentPlayer &&
                        board[i + 2][j + 2] == currentPlayer &&
                        board[i + 3][j + 3] == currentPlayer &&
                        board[i + 4][j + 4] == currentPlayer) {
                    return true;
                }
            }
        }
        // Kiểm tra đường chéo từ phải trên sang trái dưới
        for (int i = 0; i <= size - 5; i++) {
            for (int j = 4; j < size; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j - 1] == currentPlayer &&
                        board[i + 2][j - 2] == currentPlayer &&
                        board[i + 3][j - 3] == currentPlayer &&
                        board[i + 4][j - 4] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CaroGame game = new CaroGame();
        game.startGame();
    }
}