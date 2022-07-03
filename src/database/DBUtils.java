package database;

import models.Graph;
import models.Node;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils extends jdbc {

    public boolean findPath(int ori, int end) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = dataSource.getConnection();
            String sql = "select * from path.ShortestPath where origin = ? and ToEnd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ori);
            ps.setInt(2, end);
            res = ps.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(conn, ps, res);
        }
        return false;
    }

    public void addPath(List<Node> nodes) {
        Connection conn = null;
        PreparedStatement ps = null;
        StringBuilder res = new StringBuilder();
        int ori = nodes.get(0).getId();
        int end = nodes.get(nodes.size() - 1).getId();
        try {
            for (int i = 1; i < nodes.size() - 1; i++) {
                res.append(nodes.get(i).getId()).append(".");
            }
            conn = dataSource.getConnection();
            String sql = "INSERT INTO path.shortestpath (origin, ToEnd, PassBy) VALUES (?, ?, ?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ori);
            ps.setInt(2, end);
            ps.setString(3, String.valueOf(res));
            int i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(conn, ps, null);
        }

    }

    public List<Node> GetPath(Graph graph) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(graph.getSource());
        graph.getSource().setPath(new ArrayList<>(nodes));
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = dataSource.getConnection();
            String sql = "select PassBy from path.shortestpath where origin = ? and ToEnd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, graph.getSource().getId());
            ps.setInt(2, graph.getDestination().getId());
            res = ps.executeQuery();
            int idx;
            if (res.next()) {
                String passBy = res.getString("PassBy");

                String[] split = passBy.split("\\.");

                for (String i : split) {
                    idx = Integer.parseInt(i);
                    nodes.add(graph.GetNodeAt(idx));
                    graph.GetNodeAt(idx).setPath(new ArrayList<>(nodes));
                }
            }
            nodes.add(graph.getDestination());
            graph.getDestination().setPath(nodes);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(conn,ps,res);
        }
        return  nodes;
    }

}
