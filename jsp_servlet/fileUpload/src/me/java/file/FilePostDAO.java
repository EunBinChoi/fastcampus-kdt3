package me.java.file;

import me.java.database.JDBCMgr;
import me.java.member.Member;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class FilePostDAO {

    private static FilePostDAO filePostDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private Statement stmt2 = null;
    private ResultSet rs = null;

    private static final String FILE_POST_SELECT_ALL = "select * from filePost";
    private static final String FILE_POST_SELECT = "select * from filePost where uId = ?";
    private static final String FILE_POST_INSERT = "insert into filePost(uId, title, fileInfo) values(?, ?, ?)";
    private static final String FILE_POST_DELETE = "delete filePost where uId = ?";

    private FilePostDAO() {}

    public static FilePostDAO getInstance() {
        if (filePostDAO == null) {
            filePostDAO = new FilePostDAO();
        }
        return filePostDAO;
    }


    public FilePost select(String uId) {
        FilePost filePost = null;

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(FILE_POST_SELECT);
            stmt.setString(1, uId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                String mId = rs.getString("uId");
                String title = rs.getString("title");
                String fileInfo = rs.getString("fileInfo");
                List<FileInfo> fileInfoList = parseStringToFileInfoList(fileInfo);

                filePost = new FilePost(mId, title, fileInfoList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return filePost;
    }

    public List<FilePost> selectAll() {
        List<FilePost> filePostList = new LinkedList<>();
        FilePost filePost = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(FILE_POST_SELECT_ALL);


            rs = stmt.executeQuery();
            while (rs.next()) {
                String mId = rs.getString("uId");
                String title = rs.getString("title");
                String fileInfo = rs.getString("fileInfo");
                List<FileInfo> fileInfoList = parseStringToFileInfoList(fileInfo);

                filePost = new FilePost(mId, title, fileInfoList);
                filePostList.add(filePost);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return filePostList;
    }

    public int insert(FilePost filePost) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(FILE_POST_INSERT);

            stmt.setString(1, filePost.getUserId());
            stmt.setString(2, filePost.getTitle());
            stmt.setString(3, filePost.getFiles().toString());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    public int delete(String uId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(FILE_POST_DELETE);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    public List<FileInfo> parseStringToFileInfoList(String string) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<FileInfo> fileInfoLinkedList = new LinkedList<>();
        List<String> tokens = new LinkedList<>(); // 4개가 찼다!
        String[] methods = {"setFileName", "setChangedFileName", "setFileType", "setFileLocation"};

        StringTokenizer stringTokenizer = new StringTokenizer(string, "\'");
        int count = 0;
        while (stringTokenizer.hasMoreTokens()) {
            count++;
            String str = stringTokenizer.nextToken();
            if (count % 2 == 1) continue;

            tokens.add(str);
            FileInfo fileInfo = null;
            if (tokens.size() == FileInfo.class.getDeclaredFields().length) {
                fileInfo = new FileInfo();
                for (int i = 0; i < fileInfo.getClass().getDeclaredFields().length; i++) {
                    fileInfo.getClass().getMethod(methods[i]).invoke(tokens.get(i));
                }
//                fileInfo.setFileName(tokens.get(0));
//                fileInfo.setChangedFileName(tokens.get(1));
//                fileInfo.setFileType(tokens.get(2));
//                fileInfo.setFileLocation(tokens.get(3));

                tokens.clear();
                fileInfoLinkedList.add(fileInfo);
            }
        }
        return fileInfoLinkedList;
    }

//    public static void main(String[] args) {
//        String str = "[FileInfo{fileName='Hello.java', changedFileName='352869937402583', " +
//                "fileType='application/octet-stream', " +
//                "fileLocation='../upload/352869937402583'}, " +
//                "FileInfo{fileName='Hello.java', changedFileName='352869937402583', fileType='application/octet-stream', " +
//                "fileLocation='../upload/352869937402583'}]";
//        List<FileInfo> fileInfoList = parseStringToFileInfoList(str);
//        for (int i = 0; i < fileInfoList.size(); i++) {
//            FileInfo fileInfo = fileInfoList.get(i);
//            System.out.println(fileInfo.getFileName());
//            System.out.println(fileInfo.getChangedFileName());
//            System.out.println(fileInfo.getFileType());
//            System.out.println(fileInfo.getFileLocation());
//        }
//    }
}
