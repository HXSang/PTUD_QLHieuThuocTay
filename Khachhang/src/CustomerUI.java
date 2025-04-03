import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerUI extends JFrame {
    public CustomerUI() {
        setTitle("Quản Lý Khách Hàng");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tiêu đề bảng
        String[] columnNames = {"Mã khách hàng", "Tên khách hàng", "Điện thoại", "Nhóm khách hàng", "Email", "Tổng bán"};
        
        // Dữ liệu mẫu
        Object[][] data = {
            {"KH000005", "Anh Giang - Kim Mã", "", "", "", ""},
            {"KH000004", "Anh Hoàng - Sài Gòn", "", "", "", ""},
            {"KH000003", "Tuấn - Hà Nội", "", "", "", ""},
            {"KH000002", "Phạm Thu Hương", "", "", "", ""},
            {"KH000001", "Nguyễn Văn Hải", "", "", "", ""}
        };

        // Tạo bảng với dữ liệu
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        // Đặt bảng vào trong ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Hiển thị giao diện
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerUI::new);
    }
}
