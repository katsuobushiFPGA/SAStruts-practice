package org.seasar.sastruts.example.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.seasar.framework.aop.annotation.Trace;
import org.seasar.sastruts.example.form.FileDownloadForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;

public class FileDownloadAction {

	@Resource
	@ActionForm
	protected FileDownloadForm fileDownloadForm;

	public ServletContext application;

    @Execute(validator = false)
	public String index() {
   	  this.fileDownloadForm.fileList = new ArrayList<String>();
      String path = application.getRealPath("/WEB-INF/work/");
      File dir = new File(path);
      String[] files = dir.list();
      for(String f : files) {
          this.fileDownloadForm.fileList.add(f);
      }
      return "index.jsp";
	}

    @Trace
    @Execute(validator=false)
	public String download() throws FileNotFoundException, IOException {
        String path = application.getRealPath("/WEB-INF/work/" + this.fileDownloadForm.selectFileName);
        String fileName =  this.fileDownloadForm.selectFileName;
        String userAgent = RequestUtil.getRequest().getHeader("USER-AGENT");
        if(userAgent.indexOf("MSIE") >= 0 && userAgent.indexOf("Opera") < 0) {
        	fileName = new String(fileName.getBytes("Windows31-J"),"ISO8859_1");
        }
        else {
        	fileName = new String(fileName.getBytes("UTF-8"),"ISO8859_1");
        }
        try {
            ResponseUtil.download(fileName,new ByteArrayInputStream(readAll(path).getBytes("Windows-31J")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(String path) throws FileNotFoundException, IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String string = reader.readLine();
            while (string != null){
                builder.append(string + System.getProperty("line.separator"));
                string = reader.readLine();
            }
        }
		return builder.toString();
    }
}
