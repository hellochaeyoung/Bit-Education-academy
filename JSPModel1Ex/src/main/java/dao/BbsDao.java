package dao;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BbsDao {

    private static BbsDao dao = new BbsDao(); // singleton

    private BbsDao() {

    }

    public static BbsDao getInstance() { // singleton
        return dao;
    }

    public boolean addBbs(BbsDto dto) {

        String sql = " insert into bbs(id, ref, step, depth, title, content, wdate, del, readCount) "
                + "    values(?, (select ifnull(max(ref), 0)+1 from bbs b), 0, 0, ?, ?, now(), 0, 0) ";

        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getTitle());
            psmt.setString(3, dto.getContent());


            count = psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0;
    }

    public List<BbsDto> getBbsList() {

        String sql = " select seq, id, ref, step, depth, "
                + " title, content, wdate, del, readCount "
                + " from bbs "
                + " order by ref desc, step asc";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<BbsDto> list = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/4 getBbslist success");

            psmt = conn.prepareStatement(sql);
            System.out.println("2/4 getBbslist success");

            rs = psmt.executeQuery();
            System.out.println("3/4 getBbslist success");

            while(rs.next()) {
                BbsDto dto = new BbsDto(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getInt(9),
                                        rs.getInt(10));

                list.add(dto);
                System.out.println("4/4 getBbsList success");
            }
        } catch (SQLException e) {
            System.out.println("getBbsList fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;

    }

    public List<BbsDto> getBbsSearchList(String choice, String search) {

        String sql = " select seq, id, ref, step, depth, "
                + " title, content, wdate, del, readCount "
                + " from bbs ";

        String sWord = "";
        if(choice.equals("title")) {
            sWord = " where title like '%" + search + "%' ";
        } else if(choice.equals("content")) {
            sWord = " where content like '%" + search + "%' ";
        } else if(choice.equals("writer")) {
            sWord = " where id='" + search + "' ";
        }

        sql += sWord;
        sql += " order by ref desc, step asc";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<BbsDto> list = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/4 getBbslist success");

            psmt = conn.prepareStatement(sql);
            System.out.println("2/4 getBbslist success");

            rs = psmt.executeQuery();
            System.out.println("3/4 getBbslist success");

            while(rs.next()) {
                BbsDto dto = new BbsDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));

                list.add(dto);
                System.out.println("4/4 getBbsList success");
            }
        } catch (SQLException e) {
            System.out.println("getBbsList fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;

    }

    // 페이지 처리를 위한 글의 총 수
    public int getAllBbs(String choice, String search) {

        String sql = " select count(*) from bbs ";

        String sWord = "";
        if(choice.equals("title")) {
            sWord = " where title like '%" + search + "%' ";
        } else if(choice.equals("content")) {
            sWord = " where content like '%" + search + "%' ";
        } else if(choice.equals("writer")) {
            sWord = " where id='" + search + "' ";
        }

        sql += sWord;

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        int len = 0;
        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);

            rs = psmt.executeQuery();
            if(rs.next()) {
                len = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBClose.close(conn,psmt,rs);
        }

        return len;
    }

    public List<BbsDto> getBbsPageList(String choice, String search, int pageNumber) {

        String sql = " select seq, id, ref, step, depth, "
                + "			title, content, wdate, del, readcount "
                + " from ";

        sql += "(	select row_number()over(order by ref desc, step asc) as rnum, "
                + "		seq, id, ref, step, depth, title, content, wdate, del, readcount "
                + "		from bbs";

        String sWord = "";
        if(choice.equals("title")) {
            sWord = " where title like '%" + search + "%' ";
        } else if(choice.equals("content")) {
            sWord = " where content like '%" + search + "%' ";
        } else if(choice.equals("writer")) {
            sWord = " where id='" + search + "' ";
        }
        sql = sql + sWord;

        sql = sql + " order by ref desc, step asc) a ";

        sql = sql + " where rnum between ? and ? ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        int start, end;
        start = 1 + 10 * pageNumber;
        end = 10 + 10 * pageNumber;

        List<BbsDto> list = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/4 getBbslist success");

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, start);
            psmt.setInt(2, end);
            System.out.println("2/4 getBbslist success");

            rs = psmt.executeQuery();
            System.out.println("3/4 getBbslist success");

            while(rs.next()) {
                BbsDto dto = new BbsDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));

                list.add(dto);
                System.out.println("4/4 getBbsList success");
            }
        } catch (SQLException e) {
            System.out.println("getBbsList fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;

    }

    public BbsDto getBbs(int seq) {

        String sql = "select * from bbs where seq=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        BbsDto dto = null;

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/4 getBbs success");

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);
            System.out.println("2/4 getBbs success");

            rs = psmt.executeQuery();
            System.out.println("3/4 getBbs success");

            if(rs.next()) {
                dto = new BbsDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));

                System.out.println("4/4 getBbs success");
            }
        } catch (SQLException e) {
            System.out.println("getBbs fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return dto;

    }

    public int deleteBbs(int seq) {

        String sql = "delete from bbs where seq=?";

        Connection conn = null;
        PreparedStatement psmt = null;

        int result = 0;

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/4 deleteBbs success");

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);
            System.out.println("2/4 deleteBbs success");

            result = psmt.executeUpdate();

            System.out.println("3/4 deleteBbs success");

        } catch (SQLException e) {
            System.out.println("deleteBbs fail");
            e.printStackTrace();
        } finally {
            if(psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return result;
    }

    public int updateBbs(int seq, String title, String content) {

        String sql = "update bbs set title='" + title + "' ,content='" + content +
                        "' where seq=?" ;

        Connection conn = null;
        PreparedStatement psmt = null;

        int result = 0;

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/4 updateBbs success");

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);
            System.out.println("2/4 updateBbs success");

            result = psmt.executeUpdate();

            System.out.println("3/4 updateBbs success");

        } catch (SQLException e) {
            System.out.println("updateBbs fail");
            e.printStackTrace();
        } finally {
            if(psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return result;
    }


}
