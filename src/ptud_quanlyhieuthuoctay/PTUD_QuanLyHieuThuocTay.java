package ptud_quanlyhieuthuoctay;

import gui.chitiettrahang;
import javax.swing.SwingUtilities;

public class PTUD_QuanLyHieuThuocTay {

    public static void main(String[] args) {
        // Khởi chạy giao diện Tổng Quan
        SwingUtilities.invokeLater(() -> {
            new chitiettrahang().setVisible(true);
        });
    }
}
