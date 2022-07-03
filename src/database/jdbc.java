package database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

    static ComboPooledDataSource dataSource;

    static{
      dataSource  = new ComboPooledDataSource("MySQL");
    }

    Connection getConnection() throws SQLException {
      return dataSource.getConnection();
    }

    void releaseResources(Connection conn, Statement stmt, ResultSet res) {
        try {
            if(conn!=null)
                conn.close();
            if(stmt!=null)
                stmt.close();
            if(res!=null)
                res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void closeData() {dataSource.close();}
}
