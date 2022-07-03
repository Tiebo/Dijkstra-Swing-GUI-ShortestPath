import gui.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //设置UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame jf= new JFrame();
        //设置标题
        jf.setTitle("Shortest Path");
        //关闭方式
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setSize(new Dimension(1500, 900));
        jf.add(new MainWindow());
        jf.setVisible(true);
    }
}
