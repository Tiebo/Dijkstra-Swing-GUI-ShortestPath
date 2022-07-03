import gui.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //����UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame jf= new JFrame();
        //���ñ���
        jf.setTitle("Shortest Path");
        //�رշ�ʽ
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setSize(new Dimension(1500, 900));
        jf.add(new MainWindow());
        jf.setVisible(true);
    }
}
