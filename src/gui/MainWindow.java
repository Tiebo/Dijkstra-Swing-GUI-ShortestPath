package gui;

import algo.DijkstraAlgorithm;
import database.DBUtils;
import models.Graph;
import models.Node;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MainWindow extends JPanel {

    private Graph graph;
    private GraphPanel graphPanel;
    private final DBUtils db = new DBUtils();

    public MainWindow() {
        //����Ϊ�߿򲼾�
        super.setLayout(new BorderLayout());

        setGraphPanel();
    }

    private void setGraphPanel() {
        //��ʼ����ͼ
        Subway map = new Subway();
        graph = map.setGraph();

        graphPanel = new GraphPanel(graph);

        graphPanel.setPreferredSize(new Dimension(9000, 4096));

        JPanel jPanel = new JPanel();
        jPanel.add(graphPanel);
        add(jPanel, BorderLayout.CENTER);
        jPanel.setVisible(true);
        setButtons();
    }

    private void setButtons() {
        JButton run = new JButton();
        setupIcon(run, "run");
        JButton info = new JButton();
        setupIcon(info, "info");
        final JButton map = new JButton();
        setupIcon(map, "map");
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(new Color(0xDDDDDD));
        buttonPanel.add(info);
        buttonPanel.add(run);
        buttonPanel.add(map);

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, """
                        ���в��裺
                            1.������а�ť�������г���
                            2.���������յ�
                            3.���ȷ�ϵõ����·��
                            ע�������յ㼴�ǽڵ��ϵ�����
                        ˵����
                            ����Ҳ�ĵ�ͼ�ε�ͼ����Կ���ԭ���ͼ
                        """);
            }
        });

        map.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image icon = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                            "/resources/subway.png")));
                    JOptionPane.showOptionDialog(null, null, "Subway Map", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, new ImageIcon(icon), null, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input_GetPath();
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    //setButtons
    private void setupIcon(JButton button, String img) {
        try {
            Image icon = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                    "/resources/" + img + ".png")));
            ImageIcon imageIcon = new ImageIcon(icon);
            button.setIcon(imageIcon);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //run
    private void Input_GetPath() {
        JFrame jf = new JFrame();
        jf.setBounds(500, 500, 200, 125);
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("���");
        JLabel label2 = new JLabel("�յ�");
        TextField ori = new TextField(10);
        TextField end = new TextField(10);
        JButton btn = new JButton("ȷ��");

        end.setFont(new Font(null, Font.PLAIN, 12));
        ori.setFont(new Font(null, Font.PLAIN, 12));

        jp.add(label1);
        jp.add(ori);
        jp.add(label2);
        jp.add(end);
        jp.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origin = ori.getText();
                String ToEnd = end.getText();
                int x = 0;
                int y = 0;
                try {
                    x = Integer.parseInt(origin);
                    y = Integer.parseInt(ToEnd);
                    if (x > 65 || x < 1 || y > 65 || y < 1)
                        throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    String[] options = {"ȷ��"};
                    JOptionPane.showOptionDialog(null, "����λ����Ч", "��ʾ", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }
                graph.setSource(graph.GetNodeAt(x));
                graph.setDestination(graph.GetNodeAt(y));
                jf.dispose();
                GetPath();
            }
        });
        jf.add(jp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    //run---Input_GetPath
    private void GetPath() {
        List<Node> nodes;
        int sourceID = graph.getSource().getId();
        int DestinationID = graph.getDestination().getId();
        try {
            //ȷ�����ݿ����Ƿ��Ѿ������·��
            if (db.findPath(sourceID, DestinationID)) {
                nodes = db.GetPath(graph);
                graph.setSolved(true);
            } else {
                DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
                dijkstraAlgorithm.run();
                nodes = dijkstraAlgorithm.getDestinationPath();
                //���µ����ݴ��������ݿ���
                db.addPath(nodes);
            }
            graphPanel.setPath(nodes);
        } catch (IllegalStateException ise) {
            JOptionPane.showMessageDialog(null, ise.getMessage());
        }
    }
}