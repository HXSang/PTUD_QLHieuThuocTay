package ptud_quanlyhieuthuoctay;

import gui.tongquan.tongquan;
import javax.swing.SwingUtilities;

public class PTUD_QuanLyHieuThuocTay {

    public static void main(String[] args) {
        // Khởi chạy giao diện Tổng Quan
        SwingUtilities.invokeLater(() -> {
            new tongquan().setVisible(true);
        });
    }
}
