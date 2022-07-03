package gui;

import models.Edge;
import models.Graph;
import models.Node;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//implements MouseListener, MouseMotionListener
public class GraphPanel extends JPanel  {

    private final Graph graph;

    private java.util.List<Node> path = null;


    public GraphPanel(Graph graph) {
        this.graph = graph;
    }

    public void setPath(List<Node> path) {
        this.path = path;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        DrawUtils drawUtils = new DrawUtils(graphics2d);

        if (graph.isSolved()) {
            drawUtils.drawPath(path);
        }

        for (Edge edge : graph.getEdges()) {
            drawUtils.drawEdge(edge);
        }

        for (Node node : graph.getNodes()) {
            if (graph.isSource(node))
                drawUtils.drawSourceNode(node);
            else if (graph.isDestination(node))
                drawUtils.drawDestinationNode(node);
            else
                drawUtils.drawNode(node);
        }
    }
}
