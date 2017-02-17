package com.saigia.gaussian;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class GaussianPortlet extends MVCPortlet  {

	public void uploadCase(ActionRequest actionRequest,
			             ActionResponse actionRresponse) throws PortletException,
			            IOException {
			  
			         String folder = getInitParameter("uploadFolder");
			         //String realPath = getPortletContext().getRealPath("/");
			 
			         Log logger = LogFactoryUtil.getLog(GaussianPortlet.class);
			         
			        
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
			            
			            sendMail();
			        
			            SessionMessages.add(actionRequest, "success");
			 
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
