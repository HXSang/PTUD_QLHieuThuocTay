package Gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Gui_TrangChu extends JFrame {
    public Gui_TrangChu() {
        initUI();
    }

    private void initUI() {
        setTitle("Trang Chủ");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Đã sửa lỗi chính tả từ MAXIMIZED_BOTH
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo thanh menu
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setBackground(new Color(0, 102, 204));
        jMenuBar.setPreferredSize(new Dimension(getWidth(), 60));

        // Tạo các menu
        JMenu jMenu3 = createStyledMenu("Tổng quan");
        JMenu jMenu4 = createStyledMenu("Hàng hóa");
        JMenu jMenu5 = createStyledMenu("Đơn hàng");
        JMenu jMenu7 = createStyledMenu("Khách hàng");
        JMenu jMenu8 = createStyledMenu("Nhân viên");
        JMenu jMenu9 = createStyledMenu("Phân tích");

        // Tạo các menu item
        JMenuItem jMenuItem1 = createStyledMenuItem("Danh mục");
        JMenuItem jMenuItem2 = createStyledMenuItem("Thiết lập giá");
        JMenuItem jMenuItem3 = createStyledMenuItem("Kiểm kho");
        JMenuItem jMenuItem4 = createStyledMenuItem("Hóa đơn");
        JMenuItem jMenuItem5 = createStyledMenuItem("Trả hàng");
        JMenuItem jMenuItem6 = createStyledMenuItem("Nhập hàng");

        jMenu4.add(jMenuItem1);
        jMenu4.add(jMenuItem2);
        jMenu4.add(jMenuItem3);
        jMenu5.add(jMenuItem4);
        jMenu5.add(jMenuItem5);
        jMenu5.add(jMenuItem6);

        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu4);
        jMenuBar.add(jMenu5);
        jMenuBar.add(jMenu7);
        jMenuBar.add(jMenu8);
        jMenuBar.add(jMenu9);

        setJMenuBar(jMenuBar);

        // Tạo panel chính với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Tạo panel kết quả bán hàng 
        JPanel salesPanel = new JPanel();
        salesPanel.setBackground(Color.WHITE);
        
        // Tiêu đề
        JLabel titleLabel = new JLabel("KẾT QUẢ BÁN HÀNG HÔM NAY");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        
        salesPanel.add(titleLabel);
        
        mainPanel.add(salesPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private JMenu createStyledMenu(String text) {
        JMenu menu = new JMenu(text);
        menu.setForeground(Color.WHITE);
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setPreferredSize(new Dimension(120, 40));
        return menu;
    }

    private JMenuItem createStyledMenuItem(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem.setPreferredSize(new Dimension(150, 30));
        return menuItem;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gui_TrangChu().setVisible(true);
        });
    }
}