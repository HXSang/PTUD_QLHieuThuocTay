package gui.tongquan;

import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*; // Import java.util.* for Map, Arrays, etc.
import java.util.List; // Explicitly import java.util.List to resolve ambiguity

// Lớp để lưu trữ thông tin về một phần trong menu (tiêu đề và các mục con)
class MenuSection {
    private final String title; // Mark as final
    private final List<String> items; // Mark as final

    public MenuSection(String title, List<String> items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getItems() {
        return items;
    }
}

public class tongquan extends JFrame {

    // Map để lưu trữ cấu trúc menu cho từng nút
    private final Map<String, List<MenuSection>> menuStructure = new HashMap<>();
    private final Map<String, List<String>> standaloneItems = new HashMap<>();

    public tongquan() {
        // Thiết lập FlatLaf Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Long Tâm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new MigLayout("fill, insets 0", "[grow]", "[top]0[top]0[grow]"));

        // Top bar
        JPanel topBar = new JPanel(new MigLayout("insets 5", "[]10[grow]push[][]", ""));
        topBar.setBackground(Color.WHITE);

        JLabel logoLabel = new JLabel("Long Tâm");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 30));
        logoLabel.setForeground(new Color(0, 120, 215));
        topBar.add(logoLabel, "align left, gapleft 15");

        JButton userBtn = new JButton();
        FontIcon userIcon = FontIcon.of(FontAwesomeSolid.USER, 18, new Color(0, 120, 215));
        userBtn.setIcon(userIcon);
        userBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
        userBtn.setIconTextGap(0);
        userBtn.putClientProperty("FlatLaf.style", "arc: 30; background: #FFFFFF; foreground: #0078d7");
        userBtn.setFont(new Font("Arial", Font.BOLD, 14));
        userBtn.setMargin(new Insets(5, 20, 5, 20));
        topBar.add(userBtn, "gapright 10, align right");

        // Navigation bar
        JPanel navBar = new JPanel(new MigLayout("insets 5 5 5 0", "[][][][][][][]push[]", ""));
        navBar.setBackground(new Color(0, 120, 215));

        // Khởi tạo cấu trúc menu cho các nút
        initializeMenuStructure();

        // Tạo các nút và gắn menu thả xuống
        JButton overviewBtn = createNavButtonWithMenu("Tổng quan");
        JButton inventoryBtn = createNavButtonWithMenu("Hàng hóa");
        JButton ordersBtn = createNavButtonWithMenu("Đơn hàng");
        JButton customersBtn = createNavButtonWithMenu("Khách hàng");
        JButton employeesBtn = createNavButtonWithMenu("Nhân viên");
        JButton analyticsBtn = createNavButtonWithMenu("Phân tích");

        JButton sellBtn = new JButton("Bán hàng");
        FontIcon cartIcon = FontIcon.of(FontAwesomeSolid.SHOPPING_CART, 18, new Color(0, 120, 215));
        sellBtn.setIcon(cartIcon);
        sellBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
        sellBtn.setIconTextGap(10);
        sellBtn.putClientProperty("FlatLaf.style", "arc: 30; background: #FFFFFF; foreground: #0078d7");
        sellBtn.setFont(new Font("Arial", Font.BOLD, 14));
        sellBtn.setForeground(new Color(0, 120, 215));
        sellBtn.setMargin(new Insets(5, 20, 5, 20));

        navBar.add(overviewBtn, "gapright 10");
        navBar.add(inventoryBtn, "gapright 10");
        navBar.add(ordersBtn, "gapright 10");
        navBar.add(customersBtn, "gapright 10");
        navBar.add(employeesBtn, "gapright 10");
        navBar.add(analyticsBtn, "gapright 10");
        navBar.add(new JLabel(), "push, grow");
        navBar.add(sellBtn, "align right, gapright 20");

        // Filler panel
        JPanel fillerPanel = new JPanel();
        fillerPanel.setBackground(Color.WHITE);

        mainPanel.add(topBar, "growx, wrap");
        mainPanel.add(navBar, "growx, wrap");
        mainPanel.add(fillerPanel, "grow");

        add(mainPanel);
    }

    // Khởi tạo cấu trúc menu cho các nút
    private void initializeMenuStructure() {
        // Menu cho "Hàng hóa"
        menuStructure.put("Hàng hóa", Arrays.asList(
            new MenuSection("Hàng hóa", Arrays.asList("Danh sách hàng hóa")),
            new MenuSection("Kho hàng", Arrays.asList("Kiểm kho")),
            new MenuSection("Nhập hàng", Arrays.asList("Nhập hàng", "Nhà cung cấp"))
        ));

        // Menu cho "Đơn hàng"
        menuStructure.put("Đơn hàng", Arrays.asList(
            new MenuSection("", Arrays.asList("Hóa đơn", "Trả hàng"))
        ));

        // Menu cho "Khách hàng"
        menuStructure.put("Khách hàng", Arrays.asList(
            new MenuSection("", Arrays.asList("Danh sách khách hàng", "Nhóm khách hàng"))
        ));

        // Menu cho "Nhân viên"
        menuStructure.put("Nhân viên", Arrays.asList(
            new MenuSection("", Arrays.asList("Danh sách nhân viên"))
        ));

        // Menu cho "Phân tích"
        menuStructure.put("Phân tích", Arrays.asList(
            new MenuSection("", Arrays.asList("Doanh thu", "Lợi nhuận", "Hàng tồn"))
        ));

        // Menu cho "Tổng quan" (có thể để trống nếu không cần menu)
        menuStructure.put("Tổng quan", new ArrayList<>());
    }

    // Tạo nút và gắn menu thả xuống (nếu có)
    private JButton createNavButtonWithMenu(String text) {
        JButton button = createNavButton(text);

        // Kiểm tra xem nút có menu thả xuống không
        if (menuStructure.containsKey(text) && !menuStructure.get(text).isEmpty()) {
            JPopupMenu popupMenu = createPopupMenu(text);

            // Thêm MouseListener cho nút
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    popupMenu.show(button, 0, button.getHeight());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!popupMenu.getBounds().contains(e.getPoint())) {
                        popupMenu.setVisible(false);
                    }
                }
            });

            // Thêm MouseListener cho JPopupMenu
            popupMenu.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    Point p = e.getPoint();
                    if (!popupMenu.getBounds().contains(p)) {
                        popupMenu.setVisible(false);
                    }
                }
            });
        }

        return button;
    }

    // Tạo JPopupMenu dựa trên cấu trúc menu
    private JPopupMenu createPopupMenu(String buttonText) {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBackground(Color.WHITE);
        popupMenu.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 1));

        // Thêm các phần (sections) vào menu
        List<MenuSection> sections = menuStructure.get(buttonText);
        for (int i = 0; i < sections.size(); i++) {
            MenuSection section = sections.get(i);
            if (!section.getTitle().isEmpty()) {
                // Nếu có tiêu đề, tạo JMenu
                JMenu menu = new JMenu(section.getTitle());
                menu.setForeground(new Color(0, 120, 215));
                menu.setFont(new Font("Arial", Font.BOLD, 14));
                for (String item : section.getItems()) {
                    menu.add(createMenuItem(item));
                }
                popupMenu.add(menu);
            } else {
                // Nếu không có tiêu đề, thêm trực tiếp các mục
                for (String item : section.getItems()) {
                    popupMenu.add(createMenuItem(item));
                }
            }

            // Thêm mục độc lập (nếu có) và phân tách
            if (standaloneItems.containsKey(buttonText) && i == 0) {
                popupMenu.add(new JSeparator());
                for (String standaloneItem : standaloneItems.get(buttonText)) {
                    popupMenu.add(createMenuItem(standaloneItem));
                }
                popupMenu.add(new JSeparator());
            }
        }

        return popupMenu;
    }

    // Tạo nút điều hướng
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 120, 215));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setMargin(new Insets(5, 15, 5, 15));
        return button;
    }

    // Tạo JMenuItem với giao diện tùy chỉnh
    private JMenuItem createMenuItem(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setBackground(Color.WHITE);
        menuItem.setForeground(new Color(0, 120, 215));
        menuItem.setFont(new Font("Arial", Font.PLAIN, 14));
        menuItem.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return menuItem;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new tongquan().setVisible(true));
    }
}