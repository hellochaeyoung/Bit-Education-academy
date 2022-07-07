<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="dao.PdsDao" %>
<%@ page import="dto.PdsDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-07
  Time: 오전 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
  // 실제 파일 업로드를 처리하는 함수
  public String processUploadFile(FileItem fileItem, String newFileName, String dir) throws FileNotFoundException {

    String f = fileItem.getName();
    long sizeOfBytes = fileItem.getSize();

    String fileName = "";
    String fpost = "";

    // 업로드한 파일이 정상인 경우
    if(sizeOfBytes > 0) {
      int idx = f.lastIndexOf("\\");

      if (idx == -1) {
        idx = f.lastIndexOf("/");
      }
      fileName = f.substring(idx + 1);

      try {
        File uploadfile = new File(dir, newFileName); // 변환된 파일명

        fileItem.write(uploadfile); // 실제로 업로드 부분

      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    return fileName;
  }
%>

<%
  // tomcat(web server) 올리기 <- 실무
  String fupload = application.getRealPath("/upload");

  System.out.println("파일 업로드 경로 : " + fupload);


  // 지정 폴더에 올리기, 서버는 refresh 되는 경우 파일 유실의 위험이 있기 때문에 지정 폴더에 저장하면 유실 위험은 없다
  // String fupload = "d:\\tmp";

  int yourMaxRequestSize = 100 * 1024 * 1024;
  int yourMaxMemorySize = 100 * 1024;

  // form field에 데이터
  String id = "";
  String title = "";
  String content = "";

  // file 데이터
  String fileName = "";
  String newFileName = "";

  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
  if (isMultipart) {
    // FileItem 생성하는 class
    DiskFileItemFactory factory = new DiskFileItemFactory();

    factory.setSizeThreshold(yourMaxMemorySize);
    factory.setRepository(new File(fupload));

    ServletFileUpload upload = new ServletFileUpload(factory);
    upload.setSizeMax(yourMaxRequestSize);

    List<FileItem> items = upload.parseRequest(request);
    Iterator<FileItem> it = items.iterator();

    while(it.hasNext()) {
      FileItem item = it.next();

      if(item.isFormField()) { // id, title, content
        if(item.getFieldName().equals("id")) {
          id = item.getString("utf-8");

        } else if(item.getFieldName().equals("title")) {
          title = item.getString("utf-8");
        } else if(item.getFieldName().equals("content")) {
          content = item.getString("utf-8");
        }

      }else { // file
        if(item.getFieldName().equals("fileload")) {

          // 확장자명
          String filename = item.getName();
          int lastInNum = filename.lastIndexOf("."); // abc.txt
          String exName = filename.substring(lastInNum); // .txt

          // 새로운 파일명
          newFileName = (new Date().getTime()) + ""; // ex) 332423543
          newFileName = newFileName + exName;

          fileName = processUploadFile(item, newFileName, fupload);


        }
      }
    }
  }else {
    System.out.println("Multipart 아님");
  }

  //DB에 저장
  PdsDao dao = PdsDao.getInstance();
  boolean isS = dao.writePds(new PdsDto(id, title, content, fileName, newFileName));
  if(isS) {
    %>
    <script>
      alert('파일 업로드 성공!');
      location.href = "pdslist.jsp";
    </script>


<%
  } else {
    %>
    <script>
      alert('파일 업로드 실패');
      location.href = "pdswrite.jsp";
    </script>
<%
  }
%>
