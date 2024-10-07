package org.example;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3]; // Bảng trò chơi 3x3
    private static char currentPlayer = 'X'; // Người chơi hiện tại (X bắt đầu trước)
    private static String gameResult = ""; // Kết quả trò chơi

    // Khởi tạo bảng trống
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-'; // Đặt tất cả ô trống bằng ký tự '-'
            }
        }
        gameResult = ""; // Đặt kết quả trò chơi về trống
    }

    public static void main(String[] args) {
        initializeBoard(); // Gọi hàm khởi tạo bảng
        playGame(); // Chạy trò chơi
    }

    // Hàm chơi game
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        // Vòng lặp chơi đến khi trò chơi kết thúc
        while (!gameEnded) {
            printBoard(); // In bảng hiện tại

            // Người chơi nhập hàng và cột
            System.out.println("Người chơi " + currentPlayer + ", chọn hàng (1-3) và cột (1-3): ");
            int row = scanner.nextInt() - 1;  // Chuyển vị trí từ 1-3 sang 0-2
            int col = scanner.nextInt() - 1;

            // Kiểm tra nếu ô đó còn trống
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer; // Đặt ký tự của người chơi hiện tại vào bảng

                // Kiểm tra nếu có người thắng hoặc bảng đã đầy
                if (checkForWin()) {
                    gameResult = "Người chơi " + currentPlayer + " thắng!";
                    gameEnded = true; // Kết thúc trò chơi
                } else if (isBoardFull()) {
                    gameResult = "Trò chơi hòa!";
                    gameEnded = true; // Kết thúc trò chơi nếu bảng đầy
                } else {
                    switchPlayer(); // Chuyển lượt nếu chưa có người thắng
                }
            } else {
                System.out.println("Ô này không hợp lệ hoặc đã được chọn. Vui lòng chọn ô khác.");
            }
        }

        printBoard(); // In bảng cuối cùng
        scanner.close(); // Đóng scanner
    }

    // Hàm in bảng
    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " "); // In các ký tự trong bảng
            }
            System.out.println(); // Xuống dòng sau khi in xong một hàng
        }
    }

    // Đổi người chơi
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Chuyển giữa X và O
    }

    // Kiểm tra nếu bảng đã đầy
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // Nếu còn ô trống thì chưa đầy
                }
            }
        }
        return true; // Bảng đầy
    }

    // Kiểm tra nếu có người thắng
    private static boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    // Kiểm tra hàng
    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Có 3 ký tự giống nhau theo hàng
            }
        }
        return false;
    }

    // Kiểm tra cột
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Có 3 ký tự giống nhau theo cột
            }
        }
        return false;
    }

    // Kiểm tra đường chéo
    private static boolean checkDiagonals() {
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Có 3 ký tự giống nhau theo đường chéo trái sang phải
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Có 3 ký tự giống nhau theo đường chéo phải sang trái
        }
        return false;
    }

    // Phương thức để lấy kết quả trò chơi
    public static String getGameResult() {
        return gameResult;
    }

    // Phương thức để lấy người chơi hiện tại
    public static char getCurrentPlayer() {
        return currentPlayer;
    }
}
