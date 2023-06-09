import org.junit.Test;
import utils.DbHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
    @Test
    public void demo(){
        DbHelp dbHelp = new DbHelp();
        String projectId = "tt";
        String projectName = "yy";

        try {
            Connection conn = dbHelp.getConnection();
            String sql = "insert into t_project(projectId,projectName) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,projectId);
            ps.setString(2,projectName);
            System.out.println(ps.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
