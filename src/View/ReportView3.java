package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import View.RoundedPanel;

import View.RoundedButton;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.text.Normalizer;

public class ReportView3 extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton addButton, deleteButton, editButton;

    public ReportView3() {
        // Thiết lập tiêu đề và kích thước cửa sổ
        setTitle("Đào tạo và phát triển");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa cửa sổ

        // Tạo mô hình bảng và dữ liệu
        String[] columnNames = {"Tháng", "Tổng số nhân viên", "Nhân viên mới", "Nhân viên đã nghỉ"};
        Object[][] data = {
        		
        };
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // Tạo bảng cuộn để bảng có thể cuộn được
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo các nút thêm, xóa, sửa với màu và icon đã chỉnh kích thước
        RoundedButton addButton = new RoundedButton("Xuất file", 15);
        addButton.setBackground(new Color(244, 67, 54)); // Màu đỏ
        ImageIcon addIcon = getResizedIcon("D:/WorkSpace/Java/qlns/src/icons/add_icon.png", 10, 10); //Lay icon resize
        addButton.setIcon(addIcon);
        addButton.setPreferredSize(new Dimension(60, 25)); // Đặt kích thước cố định cho nút
        addButton.setBorder(new LineBorder(Color.BLACK, 2));
        addButton.setContentAreaFilled(false); // Tắt phần nền của nút (tùy chọn)

        RoundedButton deleteButton = new RoundedButton("Lưu", 15);
        deleteButton.setBackground(new Color (68, 183, 254)); // Màu xanh
        ImageIcon delIcon = getResizedIcon("D:/WorkSpace/Java/qlns/src/icons/edit_icon.png", 10, 10); //Lay icon resize
        deleteButton.setIcon(delIcon);
        deleteButton.setPreferredSize(new Dimension(60, 25)); // Đặt kích thước cố định cho nút
        deleteButton.setBorder(new LineBorder(Color.BLACK, 2));
        deleteButton.setContentAreaFilled(false); // Tắt phần nền của nút (tùy chọn)

        Image TimKiemIcon = new ImageIcon(
                        new File("hrm/src/main/resources/img/search.png").getAbsolutePath())
                        .getImage()
                        .getScaledInstance(20, 20, Image.SCALE_SMOOTH);
     
        
        // Bố trí các nút trong một hộp ngang với căn phải
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Căn phải
        buttonPanel.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Từ");
        buttonPanel.add(lblNewLabel);
        
        JComboBox comboBox = new JComboBox();
        buttonPanel.add(comboBox);
        
        JLabel lblNewLabel_1 = new JLabel("Đến");
        buttonPanel.add(lblNewLabel_1);
        
        JComboBox comboBox_1 = new JComboBox();
        buttonPanel.add(comboBox_1);
        
        JLabel lblNewLabel_2 = new JLabel("Năm");
        buttonPanel.add(lblNewLabel_2);
        
        JComboBox comboBox_2 = new JComboBox();
        buttonPanel.add(comboBox_2);
        
        //Thanh tim kiem
        
                
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.setPreferredSize(new Dimension(800, 35)); // Đặt chiều cao cố định

        // Bố trí bố cục chính
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH); // Đặt các nút ở phía dưới và căn phải
        getContentPane().add(scrollPane, BorderLayout.CENTER); // Đặt bảng ở trung tâm
        
        
    }

    // Hàm sử dụng ClassLoader để tải và thay đổi kích thước icon
 // Hàm sử dụng ClassLoader để tải và thay đổi kích thước icon
    public static ImageIcon getResizedIcon(String imagePath, int width, int height) {
        // Đọc ảnh từ đường dẫn
        ImageIcon icon = new ImageIcon(imagePath);
        
        // Lấy đối tượng Image từ ImageIcon
        Image image = icon.getImage();

        // Điều chỉnh kích thước ảnh
        Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        
        // Tạo và trả về ImageIcon mới với kích thước đã điều chỉnh
        return new ImageIcon(resizedImage);
    }

    
    public static void main(String[] args) {
        // Tạo và hiển thị giao diện
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	ReportView3 view = new ReportView3();
                view.setVisible(true);
            }
        });
    }
}

