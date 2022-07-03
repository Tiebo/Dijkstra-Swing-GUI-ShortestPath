package gui;

import models.Edge;
import models.Graph;

import javax.swing.*;
import java.awt.*;


public class Subway extends JPanel {

    private static final Graph graph;

    static {
        graph = new Graph();
    }

    public Subway() {
    }

    /*
      @Override
      public void mouseClicked(MouseEvent e) {
          ......
          Point p = e.getPoint();
          System.out.println("graph.addNode(new Point(" + (int)p.getX() + ","
            + (int)p.getY() + "));");
       }
    */
    private void setNode() {
        graph.addNode(new Point(3984,556));
        graph.addNode(new Point(4035,555));
        graph.addNode(new Point(4104,552));
        graph.addNode(new Point(4167,578));
        graph.addNode(new Point(4243,581));
        graph.addNode(new Point(4327,582));
        graph.addNode(new Point(4541,576));
        graph.addNode(new Point(4695,582));
        graph.addNode(new Point(4644,581));
        graph.addNode(new Point(4813,580));
        graph.addNode(new Point(4921,580));
        graph.addNode(new Point(4907,700));
        graph.addNode(new Point(4811,634));
        graph.addNode(new Point(4692,636));
        graph.addNode(new Point(4610,632));
        graph.addNode(new Point(4540,636));
        graph.addNode(new Point(4248,502));
        graph.addNode(new Point(4090,274));
        graph.addNode(new Point(4097,350));
        graph.addNode(new Point(4329,427));
        graph.addNode(new Point(4179,278));
        graph.addNode(new Point(4432,478));
        graph.addNode(new Point(4435,428));
        graph.addNode(new Point(4541,424));
        graph.addNode(new Point(4647,430));
        graph.addNode(new Point(4874,462));
        graph.addNode(new Point(4802,430));
        graph.addNode(new Point(4746,425));
        graph.addNode(new Point(4919,413));
        graph.addNode(new Point(5127,585));
        graph.addNode(new Point(4651,378));
        graph.addNode(new Point(4651,304));
        graph.addNode(new Point(4651,178));
        graph.addNode(new Point(4697,139));
        graph.addNode(new Point(4762,138));
        graph.addNode(new Point(4826,136));
        graph.addNode(new Point(4588,348));
        graph.addNode(new Point(4434,338));
        graph.addNode(new Point(4439,264));
        graph.addNode(new Point(4467,195));
        graph.addNode(new Point(4545,198));
        graph.addNode(new Point(4541,123));
        graph.addNode(new Point(4251,352));
        graph.addNode(new Point(4173,433));
        graph.addNode(new Point(4438,590));
        graph.addNode(new Point(4367,536));
        graph.addNode(new Point(4543,493));
        graph.addNode(new Point(4650,494));
        graph.addNode(new Point(4541,693));
        graph.addNode(new Point(4372,693));
        graph.addNode(new Point(4327,638));
        graph.addNode(new Point(3963,180));
        graph.addNode(new Point(4170,669));
        graph.addNode(new Point(3999,667));
        graph.addNode(new Point(3913,648));
        graph.addNode(new Point(3913,567));
        graph.addNode(new Point(3909,480));
        graph.addNode(new Point(3849,583));
        graph.addNode(new Point(4250,682));
        graph.addNode(new Point(4277,723));
        graph.addNode(new Point(4820,510));
        graph.addNode(new Point(4690,705));
        graph.addNode(new Point(4447,644));
        graph.addNode(new Point(4607,685));
        graph.addNode(new Point(4173,514));
    }
    /*
    *
    * System.out.println("graph.addEdge(new Edge(graph.GetNodeAt(" + selectedNode.getId() + ")," +
             "graph.GetNodeAt(" + node.getId() +")));");
    *
    *
    */
    private void setEdge() {
        graph.addEdge(new Edge(graph.GetNodeAt(42),graph.GetNodeAt(41)));
        graph.addEdge(new Edge(graph.GetNodeAt(41),graph.GetNodeAt(40)));
        graph.addEdge(new Edge(graph.GetNodeAt(40),graph.GetNodeAt(39)));
        graph.addEdge(new Edge(graph.GetNodeAt(39),graph.GetNodeAt(38)));
        graph.addEdge(new Edge(graph.GetNodeAt(38),graph.GetNodeAt(23)));
        graph.addEdge(new Edge(graph.GetNodeAt(23),graph.GetNodeAt(22)));
        graph.addEdge(new Edge(graph.GetNodeAt(22),graph.GetNodeAt(46)));
        graph.addEdge(new Edge(graph.GetNodeAt(46),graph.GetNodeAt(6)));
        graph.addEdge(new Edge(graph.GetNodeAt(6),graph.GetNodeAt(51)));
        graph.addEdge(new Edge(graph.GetNodeAt(51),graph.GetNodeAt(50)));
        graph.addEdge(new Edge(graph.GetNodeAt(36),graph.GetNodeAt(35)));
        graph.addEdge(new Edge(graph.GetNodeAt(35),graph.GetNodeAt(34)));
        graph.addEdge(new Edge(graph.GetNodeAt(34),graph.GetNodeAt(33)));
        graph.addEdge(new Edge(graph.GetNodeAt(33),graph.GetNodeAt(32)));
        graph.addEdge(new Edge(graph.GetNodeAt(32),graph.GetNodeAt(31)));
        graph.addEdge(new Edge(graph.GetNodeAt(31),graph.GetNodeAt(25)));
        graph.addEdge(new Edge(graph.GetNodeAt(25),graph.GetNodeAt(48)));
        graph.addEdge(new Edge(graph.GetNodeAt(25),graph.GetNodeAt(24)));
        graph.addEdge(new Edge(graph.GetNodeAt(24),graph.GetNodeAt(23)));
        graph.addEdge(new Edge(graph.GetNodeAt(23),graph.GetNodeAt(20)));
        graph.addEdge(new Edge(graph.GetNodeAt(17),graph.GetNodeAt(20)));
        graph.addEdge(new Edge(graph.GetNodeAt(25),graph.GetNodeAt(28)));
        graph.addEdge(new Edge(graph.GetNodeAt(28),graph.GetNodeAt(27)));
        graph.addEdge(new Edge(graph.GetNodeAt(27),graph.GetNodeAt(26)));
        graph.addEdge(new Edge(graph.GetNodeAt(26),graph.GetNodeAt(29)));
        graph.addEdge(new Edge(graph.GetNodeAt(26),graph.GetNodeAt(11)));
        graph.addEdge(new Edge(graph.GetNodeAt(11),graph.GetNodeAt(30)));
        graph.addEdge(new Edge(graph.GetNodeAt(11),graph.GetNodeAt(12)));
        graph.addEdge(new Edge(graph.GetNodeAt(12),graph.GetNodeAt(13)));
        graph.addEdge(new Edge(graph.GetNodeAt(13),graph.GetNodeAt(10)));
        graph.addEdge(new Edge(graph.GetNodeAt(10),graph.GetNodeAt(8)));
        graph.addEdge(new Edge(graph.GetNodeAt(8),graph.GetNodeAt(48)));
        graph.addEdge(new Edge(graph.GetNodeAt(8),graph.GetNodeAt(9)));
        graph.addEdge(new Edge(graph.GetNodeAt(48),graph.GetNodeAt(9)));
        graph.addEdge(new Edge(graph.GetNodeAt(9),graph.GetNodeAt(7)));
        graph.addEdge(new Edge(graph.GetNodeAt(7),graph.GetNodeAt(45)));
        graph.addEdge(new Edge(graph.GetNodeAt(45),graph.GetNodeAt(6)));
        graph.addEdge(new Edge(graph.GetNodeAt(16),graph.GetNodeAt(7)));
        graph.addEdge(new Edge(graph.GetNodeAt(7),graph.GetNodeAt(47)));
        graph.addEdge(new Edge(graph.GetNodeAt(47),graph.GetNodeAt(24)));
        graph.addEdge(new Edge(graph.GetNodeAt(24),graph.GetNodeAt(37)));
        graph.addEdge(new Edge(graph.GetNodeAt(16),graph.GetNodeAt(15)));
        graph.addEdge(new Edge(graph.GetNodeAt(15),graph.GetNodeAt(14)));
        graph.addEdge(new Edge(graph.GetNodeAt(14),graph.GetNodeAt(13)));
        graph.addEdge(new Edge(graph.GetNodeAt(14),graph.GetNodeAt(8)));
        graph.addEdge(new Edge(graph.GetNodeAt(15),graph.GetNodeAt(9)));
        graph.addEdge(new Edge(graph.GetNodeAt(49),graph.GetNodeAt(16)));
        graph.addEdge(new Edge(graph.GetNodeAt(49),graph.GetNodeAt(50)));
        graph.addEdge(new Edge(graph.GetNodeAt(50),graph.GetNodeAt(60)));
        graph.addEdge(new Edge(graph.GetNodeAt(60),graph.GetNodeAt(59)));
        graph.addEdge(new Edge(graph.GetNodeAt(59),graph.GetNodeAt(5)));
        graph.addEdge(new Edge(graph.GetNodeAt(5),graph.GetNodeAt(6)));
        graph.addEdge(new Edge(graph.GetNodeAt(47),graph.GetNodeAt(48)));
        graph.addEdge(new Edge(graph.GetNodeAt(47),graph.GetNodeAt(22)));
        graph.addEdge(new Edge(graph.GetNodeAt(10),graph.GetNodeAt(61)));
        graph.addEdge(new Edge(graph.GetNodeAt(61),graph.GetNodeAt(26)));
        graph.addEdge(new Edge(graph.GetNodeAt(14),graph.GetNodeAt(62)));
        graph.addEdge(new Edge(graph.GetNodeAt(16),graph.GetNodeAt(63)));
        graph.addEdge(new Edge(graph.GetNodeAt(63),graph.GetNodeAt(6)));
        graph.addEdge(new Edge(graph.GetNodeAt(20),graph.GetNodeAt(43)));
        graph.addEdge(new Edge(graph.GetNodeAt(43),graph.GetNodeAt(21)));
        graph.addEdge(new Edge(graph.GetNodeAt(21),graph.GetNodeAt(18)));
        graph.addEdge(new Edge(graph.GetNodeAt(18),graph.GetNodeAt(52)));
        graph.addEdge(new Edge(graph.GetNodeAt(17),graph.GetNodeAt(44)));
        graph.addEdge(new Edge(graph.GetNodeAt(44),graph.GetNodeAt(19)));
        graph.addEdge(new Edge(graph.GetNodeAt(19),graph.GetNodeAt(18)));
        graph.addEdge(new Edge(graph.GetNodeAt(17),graph.GetNodeAt(5)));
        graph.addEdge(new Edge(graph.GetNodeAt(49),graph.GetNodeAt(64)));
        graph.addEdge(new Edge(graph.GetNodeAt(64),graph.GetNodeAt(15)));
        graph.addEdge(new Edge(graph.GetNodeAt(56),graph.GetNodeAt(1)));
        graph.addEdge(new Edge(graph.GetNodeAt(1),graph.GetNodeAt(2)));
        graph.addEdge(new Edge(graph.GetNodeAt(2),graph.GetNodeAt(3)));
        graph.addEdge(new Edge(graph.GetNodeAt(3),graph.GetNodeAt(4)));
        graph.addEdge(new Edge(graph.GetNodeAt(4),graph.GetNodeAt(5)));
        graph.addEdge(new Edge(graph.GetNodeAt(53),graph.GetNodeAt(4)));
        graph.addEdge(new Edge(graph.GetNodeAt(4),graph.GetNodeAt(65)));
        graph.addEdge(new Edge(graph.GetNodeAt(53),graph.GetNodeAt(54)));
        graph.addEdge(new Edge(graph.GetNodeAt(54),graph.GetNodeAt(55)));
        graph.addEdge(new Edge(graph.GetNodeAt(55),graph.GetNodeAt(56)));
        graph.addEdge(new Edge(graph.GetNodeAt(56),graph.GetNodeAt(58)));
        graph.addEdge(new Edge(graph.GetNodeAt(56),graph.GetNodeAt(57)));
    }

    /*
    *
    * System.out.println("graph.getEdgeAt("+hoveredEdge.getNodeOne().getId()+
         ","+hoveredEdge.getNodeTwo().getId()+").setWeight("+weight+");");
    *
    * */
    private void setWeight() {
        graph.GetEdgeAt(2,3).setWeight(10);
        graph.GetEdgeAt(1,2).setWeight(5);
        graph.GetEdgeAt(56,1).setWeight(20);
        graph.GetEdgeAt(56,1).setWeight(15);
        graph.GetEdgeAt(56,58).setWeight(15);
        graph.GetEdgeAt(56,57).setWeight(25);
        graph.GetEdgeAt(55,56).setWeight(20);
        graph.GetEdgeAt(54,55).setWeight(18);
        graph.GetEdgeAt(53,54).setWeight(30);
        graph.GetEdgeAt(53,4).setWeight(25);
        graph.GetEdgeAt(3,4).setWeight(10);
        graph.GetEdgeAt(4,65).setWeight(10);
        graph.GetEdgeAt(4,5).setWeight(15);
        graph.GetEdgeAt(17,5).setWeight(15);
        graph.GetEdgeAt(17,20).setWeight(25);
        graph.GetEdgeAt(20,43).setWeight(25);
        graph.GetEdgeAt(17,44).setWeight(25);
        graph.GetEdgeAt(44,19).setWeight(25);
        graph.GetEdgeAt(43,21).setWeight(25);
        graph.GetEdgeAt(21,18).setWeight(10);
        graph.GetEdgeAt(19,18).setWeight(10);
        graph.GetEdgeAt(18,52).setWeight(30);
        graph.GetEdgeAt(23,20).setWeight(20);
        graph.GetEdgeAt(24,23).setWeight(15);
        graph.GetEdgeAt(47,22).setWeight(18);
        graph.GetEdgeAt(59,5).setWeight(20);
        graph.GetEdgeAt(60,59).setWeight(5);
        graph.GetEdgeAt(50,60).setWeight(20);
        graph.GetEdgeAt(51,50).setWeight(10);
        graph.GetEdgeAt(6,51).setWeight(5);
        graph.GetEdgeAt(45,6).setWeight(15);
        graph.GetEdgeAt(5,6).setWeight(10);
        graph.GetEdgeAt(46,6).setWeight(15);
        graph.GetEdgeAt(22,46).setWeight(15);
        graph.GetEdgeAt(23,22).setWeight(5);
        graph.GetEdgeAt(38,23).setWeight(15);
        graph.GetEdgeAt(63,6).setWeight(19);
        graph.GetEdgeAt(49,50).setWeight(23);
        graph.GetEdgeAt(49,64).setWeight(5);
        graph.GetEdgeAt(16,63).setWeight(12);
        graph.GetEdgeAt(7,45).setWeight(16);
        graph.GetEdgeAt(47,48).setWeight(17);
        graph.GetEdgeAt(7,47).setWeight(15);
        graph.GetEdgeAt(9,7).setWeight(13);
        graph.GetEdgeAt(8,9).setWeight(5);
        graph.GetEdgeAt(48,9).setWeight(8);
        graph.GetEdgeAt(8,48).setWeight(8);
        graph.GetEdgeAt(25,48).setWeight(5);
        graph.GetEdgeAt(25,24).setWeight(17);
        graph.GetEdgeAt(24,37).setWeight(18);
        graph.GetEdgeAt(39,38).setWeight(13);
        graph.GetEdgeAt(40,39).setWeight(13);
        graph.GetEdgeAt(41,40).setWeight(13);
        graph.GetEdgeAt(42,41).setWeight(13);
        graph.GetEdgeAt(33,32).setWeight(20);
        graph.GetEdgeAt(34,33).setWeight(5);
        graph.GetEdgeAt(35,34).setWeight(5);
        graph.GetEdgeAt(36,35).setWeight(5);
        graph.GetEdgeAt(31,25).setWeight(5);
        graph.GetEdgeAt(32,31).setWeight(10);
        graph.GetEdgeAt(25,28).setWeight(10);
        graph.GetEdgeAt(28,27).setWeight(5);
        graph.GetEdgeAt(27,26).setWeight(10);
        graph.GetEdgeAt(61,26).setWeight(10);
        graph.GetEdgeAt(26,29).setWeight(10);
        graph.GetEdgeAt(26,11).setWeight(20);
        graph.GetEdgeAt(11,30).setWeight(30);
        graph.GetEdgeAt(10,8).setWeight(20);
        graph.GetEdgeAt(14,13).setWeight(18);
        graph.GetEdgeAt(12,13).setWeight(20);
        graph.GetEdgeAt(11,12).setWeight(20);
        graph.GetEdgeAt(16,7).setWeight(5);
        graph.GetEdgeAt(49,16).setWeight(5);
        graph.GetEdgeAt(15,9).setWeight(6);
        graph.GetEdgeAt(64,15).setWeight(5);
        graph.GetEdgeAt(14,8).setWeight(5);
        graph.GetEdgeAt(14,62).setWeight(5);
        graph.GetEdgeAt(47,24).setWeight(5);
        graph.GetEdgeAt(7,47).setWeight(13);
        graph.GetEdgeAt(16,15).setWeight(8);
        graph.GetEdgeAt(15,14).setWeight(8);
        graph.GetEdgeAt(10,61).setWeight(8);
        graph.GetEdgeAt(13,10).setWeight(5);
    }

    public Graph setGraph() {
        setNode();//设置节点
        setEdge();//设置边
        setWeight();//设置权重
        return graph;
    }

}
