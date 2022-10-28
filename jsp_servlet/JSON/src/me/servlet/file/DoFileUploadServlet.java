package me.servlet.file;

import com.oreilly.servlet.MultipartRequest;
import me.java.file.CustomRenamePolicy;
import me.java.file.FileInfo;
import me.java.file.FilePost;
import me.java.file.FilePostDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "DoFileUploadServlet", value = "/DoFileUploadServlet")
public class DoFileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String userId  = "";
        if (session.getAttribute("SESSION_ID") != null) {
            userId = (String) session.getAttribute("SESSION_ID");
        }

        ///////////////////////////////// 파일 업로드 /////////////////////////////////

        ServletContext servletContext = getServletContext();
        String uploadPath = servletContext.getRealPath("."); // 현재 서버가 실행 중인 위치
        String uploadFolder = "upload";
        String fullPath = uploadPath + File.separator + uploadFolder;

        // upload 디렉토리 생성
        File dir = new File(fullPath);
        if (!dir.exists()) {
            dir.mkdir(); // make directory
        }

        String encType = "UTF-8";
        int maxSize = 5 * 1024 * 1024; // 5mb (업로드할 파일 최대 크기)


        try {
            MultipartRequest multipartRequest
                    = new MultipartRequest(request, fullPath, maxSize, encType,
                    new CustomRenamePolicy(fullPath));
//                    new DefaultFileRenamePolicy()); // a.txt, a1.txt, a2.txt


            FilePost filePost = new FilePost();

            ////////////////  type="file"이 아닌 다른 요소의 값 ////////////////////
            String title = "";
            Enumeration<?> parameterNames = multipartRequest.getParameterNames();
            if (parameterNames.hasMoreElements()) {
                String name = (String)parameterNames.nextElement();
                String value = multipartRequest.getParameter(name);
                title = value;
            }


            ////////////////// type="file"인 요소의 값 //////////////////////
            List<FileInfo> fileInfoList = new LinkedList<>();
            Enumeration<?> files = multipartRequest.getFileNames();
            if (files.hasMoreElements()) {

                String name = (String)files.nextElement();
                String filename = multipartRequest.getFilesystemName(name);
                // 서버에 저장된 file 이름 반환
                // 만약에 중복된 이름이 서버에 저장이 되어있을 경우에는 DefaultFileRenamePolicy에 의해 변경된 파일 이름 반환

                String originalFileName = multipartRequest.getOriginalFileName(name);
                // 실제 file 이름 반환
                // 만약에 중복된 이름이 서버에 저장이 되어있을 경우에는 DefaultFileRenamePolicy에 의해 변경되기 전의 원래 파일 이름 반환

                String fileType = multipartRequest.getContentType(name);
                // 파일 타입 반환

                String fileLocation = ".." + File.separator + uploadFolder + File.separator + filename;

                fileInfoList.add(new FileInfo(originalFileName, filename, fileType, fileLocation));

            }
            filePost.setUserId(userId);
            filePost.setTitle(title);
            filePost.setFiles(fileInfoList);

            FilePostDAO filePostDAO = FilePostDAO.getInstance();
            int res = filePostDAO.insert(filePost);
            if (res > 0) {
                session.setAttribute("filePost", filePost);
                response.sendRedirect("./file/fileView.jsp");
            } else {
                response.sendRedirect("./file/fileSelect.jsp");
            }
        } catch (FileNotFoundException e) {
            new RuntimeException();
        } catch (IOException e) {
            new RuntimeException();
        }

    }
}
