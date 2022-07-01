package dao;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {

    private static MemberDao dao = new MemberDao();

    private MemberDao() {
        DBConnection.initConnection();
    }

    public static MemberDao getInstance() {
        return dao;
    }

    public boolean addMember(MemberDto dto) {

        String sql = " insert into member(id, pwd, name, email. auth) "
                    + "    values(?, ?, ?, ?, 3) ";

        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getPwd());
            psmt.setString(3, dto.getName());
            psmt.setString(4, dto.getEmail());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0;
    }
}
