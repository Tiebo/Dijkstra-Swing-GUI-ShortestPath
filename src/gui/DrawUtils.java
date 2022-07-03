package gui;

import models.Edge;
import models.Node;

import java.awt.*;

public class DrawUtils {
    private final Graphics2D g;
    private static int radius = 13;

    public DrawUtils(Graphics2D graphics2D) {
        g = graphics2D;
    }
    //画出权重节点
    public void drawWeight(Edge edge) {
        //起点
        Point from = edge.getNodeOne().getCoord();
        //终点
        Point to = edge.getNodeTwo().getCoord();
        //在中点绘制权重
        int x = (from.x + to.x) / 2;
        int y = (from.y + to.y) / 2;
        int rad = radius / 2;
        //画圆（椭圆）
        g.fillOval(x - rad, y - rad, 2 * rad, 2 * rad);
        //写入权重
        drawWeightText(String.valueOf(edge.getWeight()), x, y);
    }
    //画出路径
    public void drawPath(java.util.List<Node> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            drawPath(new Edge(path.get(i), path.get(i + 1)));
        }
    }
    //画出路径
    public void drawPath(Edge edge) {
        g.setColor(new Color(0xEF0B40));
        drawBoldEdge(edge);
    }
    //画宽边
    private void drawBoldEdge(Edge edge) {
        Point from = edge.getNodeOne().getCoord();
        Point to = edge.getNodeTwo().getCoord();
        g.setStroke(new BasicStroke(13));
        g.drawLine(from.x, from.y, to.x, to.y);
    }

    public void drawEdge(Edge edge) {
        g.setColor(new Color(0x555555));
        drawBaseEdge(edge);
        drawWeight(edge);
    }
    //画底边
    private void drawBaseEdge(Edge edge) {
        Point from = edge.getNodeOne().getCoord();
        Point to = edge.getNodeTwo().getCoord();
        g.setStroke(new BasicStroke(7));
        g.drawLine(from.x, from.y, to.x, to.y);
    }
    //画起点
    public void drawSourceNode(Node node) {
        g.setColor(new Color(0x00BCD4));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius -= 5;
        g.setColor(new Color(0xB2EBF2));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius += 5;
        g.setColor(new Color(0x00BCD4));
        drawCentreText(String.valueOf(node.getId()), node.getX(), node.getY());
    }
    //画终点
    public void drawDestinationNode(Node node) {
        g.setColor(new Color(0xFFFF0101, true));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius -= 5;
        g.setColor(new Color(0xFF9292));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius += 5;
        g.setColor(new Color(0x14168A));
        drawCentreText(String.valueOf(node.getId()), node.getX(), node.getY());
    }
    //画节点
    public void drawNode(Node node) {
        radius = 13;
        g.setColor(new Color(0x555555));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius -= 5;
        g.setColor(new Color(0xFFFFFF));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius += 5;
        g.setColor(new Color(0x232325));
        radius = 15;
        drawCentreText(String.valueOf(node.getId()), node.getX(), node.getY());

    }
    //写入权重
    public void drawWeightText(String text, int x, int y) {
        g.setColor(new Color(0xFFFFFF));
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }
    //写入节点ID
    public void drawCentreText(String text, int x, int y) {
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }
}
