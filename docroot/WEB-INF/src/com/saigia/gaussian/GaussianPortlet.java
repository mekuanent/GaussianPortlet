package com.saigia.gaussian;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
			String fileS = uploadRequest.getFile("fileName").getAbsolutePath();

			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			String newFileS = folder + sourceFileName;



			logger.info("New file path: " + newFileS);

			
			
			InputStream in = new BufferedInputStream(uploadRequest.getFileAsStream("fileName"));
			FileInputStream fis = new FileInputStream(fileS);


			byte[] bytes_ = FileUtil.getBytes(in);
			int i = fis.read(bytes_);

			while (i != -1) {
				i = fis.read(bytes_);
			
			}
			fis.close();
			
			final byte[] fileBytes = bytes_;
			
			//sendMail();
			logger.info("UserId: " + user.getUserId());
			
			String inputFileName = user.getUserId() + sourceFileName;
			
			CreateTaskRequest ctr = new CreateTaskRequest();
			ctr.application = "3";
			ctr.arguments.add(user.getEmailAddress());
			ctr.arguments.add(inputFileName);
			
			ctr.input_files.add(new Input_files("", inputFileName, ""));
			ctr.output_files.add(new Output_files("outputs.tar.gz",""));
			
			CreateTaskResponse ctResponse = Connection.apiService.createTask(user.getUserId() + "", ctr);

			File newFile = new File(uploadRequest.getFile("fileName").getParent() + "/" + inputFileName);
			uploadRequest.getFile("fileName").renameTo(newFile);
			
			
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody requestBody = RequestBody.create(mediaType, fileBytes);
			
			
			
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
		}

		catch (IOException e1) {
			System.out.println("Error Reading The File.");
			SessionMessages.add(actionRequest, "error");
			e1.printStackTrace();
		}

	}

	public void sendMail() {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress("mekuanent@hotmail.com");
			toAddress = new InternetAddress("mekuanent@hotmail.com");
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("Task Finished");
			mailMessage.setBody("Your output is ready to download. Please use this this link, or go to the portal to download.");
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println("Send mail with Plain Text");
		} catch (AddressException e) {
			e.printStackTrace();
		} 

	} 


}
