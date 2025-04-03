import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jdatepicker.impl.*;
import javax.swing.JFormattedTextField;

// Định nghĩa lớp DateLabelFormatter trước khi sử dụng
class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parse(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}

public class CustomerForm extends JFrame {
    public CustomerForm() {
        setTitle("Tạo khách hàng");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel formPanel = new JPanel(new GridLayout(6, 4, 3, 3));
        
        // Labels & Fields
        formPanel.add(new JLabel("Tên khách hàng:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);
        
        formPanel.add(new JLabel("Mã khách hàng:"));
        JTextField idField = new JTextField("Tự động");
        idField.setEditable(false);
        formPanel.add(idField);
        
        formPanel.add(new JLabel("Điện thoại 1:"));
        JTextField phone1Field = new JTextField();
        formPanel.add(phone1Field);
        
        formPanel.add(new JLabel("Điện thoại 2:"));
        JTextField phone2Field = new JTextField();
        formPanel.add(phone2Field);
        
        formPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        formPanel.add(emailField);
        
        formPanel.add(new JLabel("Sinh nhật:"));
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hôm nay");
        p.put("text.month", "Tháng");
        p.put("text.year", "Năm");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        formPanel.add(datePicker);
        
        formPanel.add(new JLabel("Giới tính:"));
        String[] genders = {"Chọn", "Nam", "Nữ", "Khác"};
        JComboBox<String> genderBox = new JComboBox<>(genders);
        formPanel.add(genderBox);
        
        formPanel.add(new JLabel("Địa chỉ:"));
        JTextField addressField = new JTextField();
        formPanel.add(addressField);
        
        formPanel.add(new JLabel("Khu vực:"));
        JTextField regionField = new JTextField();
        formPanel.add(regionField);
        
        formPanel.add(new JLabel("Phường/Xã:"));
        JTextField wardField = new JTextField();
        formPanel.add(wardField);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Lưu");
        JButton cancelButton = new JButton("Bỏ qua");
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerForm::new);
    }
}
