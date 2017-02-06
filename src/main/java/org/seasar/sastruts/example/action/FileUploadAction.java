package org.seasar.sastruts.example.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.seasar.framework.aop.annotation.Trace;
import org.seasar.framework.exception.IORuntimeException;
import org.seasar.sastruts.example.form.FileUploadForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.upload.S2MultipartRequestHandler;
import org.seasar.struts.util.ActionMessagesUtil;

public class FileUploadAction {

	@Resource
	@ActionForm
	protected FileUploadForm fileUploadForm;

	public HttpServletRequest request;

	public ServletContext application;

    @Trace
    @Execute(validator = false)
	public String index() {
    	SizeLimitExceededException e = (SizeLimitExceededException) request
                .getAttribute(S2MultipartRequestHandler.SIZE_EXCEPTION_KEY);
            if (e != null) {
                ActionMessages errors = new ActionMessages();
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "errors.upload.size",
                    new Object[] { e.getPermittedSize(), e.getActualSize() }));
                ActionMessagesUtil.addErrors(request, errors);
            }
      return "index.jsp";
	}

    @Trace
    @Execute(validator=true,input="index.jsp")
	public String upload() throws Throwable, IOException {
    	ActionMessages messages = new ActionMessages();
    	upload(fileUploadForm.file,messages);
    	ActionMessagesUtil.addMessages(request, messages);
		return "index.jsp";
	}
    protected void upload(FormFile file, ActionMessages messages) {
        if (file.getFileSize() == 0) {
            return;
        }
        String path = application.getRealPath("/WEB-INF/work/"
            + file.getFileName());
        System.out.println(path);
        try {
            OutputStream out = new BufferedOutputStream(new FileOutputStream(
                path));
            try {
                out.write(file.getFileData(), 0, file.getFileSize());
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
            "messages.upload.complete",
            new Object[] { path }));
    }
}
