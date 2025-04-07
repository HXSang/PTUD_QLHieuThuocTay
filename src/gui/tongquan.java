package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class tongquan extends JFrame {

    public tongquan() {
        initUI();
    }

    private void initUI() {
        setTitle("Tổng quan");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo thanh menu với màu sắc đẹp mắt
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setBackground(new Color(33, 150, 243));  // Màu xanh dương dễ chịu
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

        // Thêm menu item vào các menu
        jMenu4.add(jMenuItem1);
        jMenu4.add(jMenuItem2);
        jMenu4.add(jMenuItem3);
        jMenu5.add(jMenuItem4);
        jMenu5.add(jMenuItem5);
        jMenu5.add(jMenuItem6);

        // Thêm các menu vào thanh menu
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
        mainPanel.setBackground(new Color(248, 248, 248));  // Màu nền nhẹ nhàng

        // Tạo panel kết quả bán hàng
        JPanel salesPanel = new JPanel();
        salesPanel.setBackground(Color.WHITE);
        salesPanel.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 243), 2));  // Viền cho panel

        // Tiêu đề
        JLabel titleLabel = new JLabel("KẾT QUẢ BÁN HÀNG HÔM NAY");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));  // Màu tiêu đề nổi bật
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        salesPanel.setLayout(new BorderLayout());
        salesPanel.add(titleLabel, BorderLayout.NORTH);

        // Thêm một số thông tin hiển thị tạm thời (ví dụ kết quả bán hàng)
        JTextArea salesResultText = new JTextArea("Tổng số đơn hàng: 50\nTổng doanh thu: 200 triệu VND");
        salesResultText.setFont(new Font("Arial", Font.PLAIN, 16));
        salesResultText.setEditable(false);
        salesResultText.setBackground(Color.WHITE);
        salesResultText.setForeground(Color.BLACK);
        salesResultText.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 243), 1));
        
        salesPanel.add(salesResultText, BorderLayout.CENTER);

        mainPanel.add(salesPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private JMenu createStyledMenu(String text) {
        JMenu menu = new JMenu(text);
        menu.setForeground(Color.WHITE);
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setPreferredSize(new Dimension(120, 40));
        menu.setBackground(new Color(33, 150, 243));  // Màu nền của menu
        return menu;
    }

    private JMenuItem createStyledMenuItem(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem.setPreferredSize(new Dimension(150, 30));
        menuItem.setBackground(new Color(33, 150, 243));  // Màu nền của menu item
        menuItem.setForeground(Color.WHITE);  // Màu chữ trắng
        return menuItem;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tongquan().setVisible(true);
        });
    }
}
