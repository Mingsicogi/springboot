<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//업로드를 위한 함수. 매개변수는 apache.commons.fileupload.FileItem
	//파일이 없을 가능성이 있으므로 IOException
	public String processUploadFile(FileItem fileItem, String dir) throws IOException{
		
		String filename = fileItem.getName();
		long sizeInBytes = fileItem.getSize();
		
		//파일이 정상인지 확인(사이즈가 0보다 큰가?)
		if( sizeInBytes > 0 ){
			//파일 이름 : d:\\tmp\\abc.txt
			
			//마지막 \\의 인덱스를 찾고, 인덱스가 없으면 /로 찾음
			int idx = filename.lastIndexOf("\\");
			if( idx == -1 ){
				idx = filename.lastIndexOf("/");
			}
			
			//마지막 구분자 위치의 뒤에있는 모든 문자열을 filename으로 갱신 
			filename = filename.substring(idx + 1);
			
			//파일을 저장할 위치와 파일명 입력
			File uploadFile = new File(dir, filename);
			
			try{
				//실제 업로드 부분
				fileItem.write(uploadFile);
			}catch(Exception e){	}			
		}		
		//업로드된 파일의 이름을 리턴
		return filename;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	boolean isMultiPart = false;

	String fupload = application.getRealPath("/upload");
	System.out.println("파일 업로드 경로 : " + fupload);
%>
</body>
</html>