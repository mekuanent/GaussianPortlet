package com.saigia.gaussian;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.RequestDispatcher;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit.mime.TypedFile;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.saigia.gaussian.vo.CreateTaskRequest;
import com.saigia.gaussian.vo.CreateTaskResponse;
import com.saigia.gaussian.vo.Input_files;
import com.saigia.gaussian.vo.Output_files;
import com.saigia.gaussian.vo.UploadFilesResponse;

public class GaussianPortlet extends MVCPortlet  {

	public void uploadCase(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException {
		ThemeDisplay td  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		final User user = td.getUser();


		String folder = getInitParameter("uploadFolder");
		//String realPath = getPortletContext().getRealPath("/"); 43:8888

		final Log logger = LogFactoryUtil.getLog(GaussianPortlet.class);

		logger.warn(user.getEmailAddress());
		try {

			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			System.out.println("Size: "+uploadRequest.getSize("fileName"));

			if (uploadRequest.getSize("fileName")==0) {
				SessionErrors.add(actionRequest, "error");
			}

			String sourceFileName = uploadRequest.getFileName("fileName");

			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			String newFileS = folder + sourceFileName;



			logger.info("New file path: " + newFileS);

			String inputFileName = user.getUserId() + sourceFileName;
			
			InputStream in = new BufferedInputStream(uploadRequest.getFileAsStream("fileName"));

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			File newFile = new File(uploadRequest.getFile("fileName").getParent() + "/" + inputFileName);
			String line = null;
			
			FileWriter fw = new FileWriter(newFile, true);
			BufferedWriter bw = new BufferedWriter(fw);;
			
			while((line = reader.readLine()) != null){
				
				if(!line.contains("%chk="))
					bw.write(line + "\n");
				
			}
			
			bw.close();
			
			//sendMail();
			logger.info("UserId: " + user.getUserId());
			
			
			CreateTaskRequest ctr = new CreateTaskRequest();
			ctr.application = "3";
			ctr.arguments.add(user.getEmailAddress());
			ctr.arguments.add(inputFileName);
			
			ctr.input_files.add(new Input_files("", inputFileName, ""));
			ctr.output_files.add(new Output_files("outputs.tar.gz",""));
			
			CreateTaskResponse ctResponse = Connection.apiService.createTask(user.getUserId() + "", ctr);
			
			Map<String, TypedFile> files = new HashMap<String, TypedFile>();
			
			TypedFile typedFile = new TypedFile("multipart/form-data", newFile);
			
			files.put("file[]", typedFile);
			logger.info(newFile.getAbsolutePath());
			
			
			UploadFilesResponse ufResponse = Connection.apiService.uploadFiles(ctResponse.getId(), user.getUserId() + "", files);
			
			
			logger.info("CALLER INFO: created task with id = " + ctResponse.getId());
			
			logger.info("CALLER INFO: upload task finished with status = " + ufResponse.getMessage());
			
			for(String res : ufResponse.getFiles()){
				logger.info(res);
			}
			
			logger.info("CALLER INFO: upload task finished with status = " + ufResponse.getGestatus());
			
			logger.info("CALLER INFO: upload task finished with status = " + ufResponse.getTask());
			
			

			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
					 redirectURL.setParameter("jspPage", "/confirmation.jsp");
					
			actionResponse.sendRedirect(redirectURL.toString()); 
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
			SessionMessages.add(actionRequest, "error");
		} catch (NullPointerException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
			SessionMessages.add(actionRequest, "error");
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			SessionMessages.add(actionRequest, "error");
			e1.printStackTrace();
		} catch (Exception e){
			System.out.println("General Error" + e.getMessage());
			SessionMessages.add(actionRequest, "error");
			e.printStackTrace();
		}

	}

}
