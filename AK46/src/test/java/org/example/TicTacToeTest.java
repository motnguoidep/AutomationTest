//package org.example;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class TicTacToeTest {
//    private TicTacToe game;
//
//    @BeforeEach
//    public void setUp() {
//        game = new TicTacToe(); // Khởi tạo trò chơi mới trước mỗi kiểm thử
//    }
//
//    // Test trường hợp X thắng theo hàng
//    @Test
//    public void testPlayerXWinsRow() {
//        String input = "1 1\n1 2\n1 3\n"; // X thắng ở hàng 1
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        assertEquals("Người chơi X thắng!", game.getGameResult()); // Kiểm tra kết quả
//    }
//
//    // Test trường hợp O thắng theo cột
//    @Test
//    public void testPlayerOWinsColumn() {
//        String input = "1 1\n2 1\n3 1\n"; // O thắng ở cột 1
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        assertEquals("Người chơi O thắng!", game.getGameResult()); // Kiểm tra kết quả
//    }
//
//    // Test trường hợp X thắng theo đường chéo
//    @Test
//    public void testPlayerXWinsDiagonal() {
//        String input = "1 1\n2 2\n3 3\n"; // X thắng ở đường chéo
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        assertEquals("Người chơi X thắng!", game.getGameResult()); // Kiểm tra kết quả
//    }
//
//    // Test trường hợp hòa
//    @Test
//    public void testDraw() {
//        String input = "1 1\n1 2\n1 3\n2 1\n2 2\n2 3\n3 1\n3 3\n3 2\n"; // Hòa
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        assertEquals("Trò chơi hòa!", game.getGameResult()); // Kiểm tra kết quả
//    }
//
//    // Test trường hợp nhập ô đã chọn
//    @Test
//    public void testInvalidMoveAlreadyChosen() {
//        String input = "1 1\n1 1\n"; // Nhập vào ô đã chọn
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        // Kiểm tra xem thông báo có được in ra không
//        assertTrue(game.getGameResult().isEmpty()); // Không kết thúc trò chơi
//    }
//
//    // Test trường hợp nhập vào vị trí không hợp lệ
//    @Test
//    public void testInvalidMoveOutOfRange() {
//        String input = "0 1\n"; // Nhập vào vị trí không hợp lệ
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        // Kiểm tra xem thông báo có được in ra không
//        assertTrue(game.getGameResult().isEmpty()); // Không kết thúc trò chơi
//    }
//
//    // Test trường hợp nhập ký tự không phải số
//    @Test
//    public void testInvalidCharacterInput() {
//        String input = "a b\n"; // Nhập vào ký tự không phải số
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        game.playGame(); // Chạy trò chơi
//        // Kiểm tra xem thông báo có được in ra không
//        assertTrue(game.getGameResult().isEmpty()); // Không kết thúc trò chơi
//    }
//
//    // Test trường hợp chuyển lượt giữa người chơi
//    @Test
//    public void testSwitchPlayer() {
//        game.switchPlayer(); // Chuyển lượt
//        assertEquals('O', game.getCurrentPlayer()); // Kiểm tra xem đã chuyển thành O chưa
//        game.switchPlayer(); // Chuyển lượt lại
//        assertEquals('X', game.getCurrentPlayer()); // Kiểm tra xem đã chuyển thành X chưa
//    }
//}
