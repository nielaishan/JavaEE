package com.N.entity;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class FileUploadServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response, String path) throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String newName = null;
		String extName = null;
		try {
			List<FileItem> list = upload.parseRequest(new ServletRequestContext(request));

			for (int i = 0; i < list.size(); ++i) {
				FileItem item = list.get(i);
				String filename = item.getName();
				extName = filename.substring(filename.lastIndexOf("."));
				newName = UUID.randomUUID().toString();
				String rootPath = request.getSession().getServletContext()
						.getRealPath(path);
				String newPath = rootPath + "/" + newName + extName;
				item.write(new File(newPath));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newName+extName;
	}
}