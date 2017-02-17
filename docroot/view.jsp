<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.util.PwdGenerator"%>
<portlet:defineObjects />
<%
String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
    PortletPreferences prefs = renderRequest.getPreferences();
%>


<portlet:actionURL var="editCaseURL" name="uploadCase">
    <portlet:param name="jspPage" value="/edit.jsp" />
</portlet:actionURL>

<portlet:renderURL var="outputsURL">
    <portlet:param name="jspPage" value="/outputs.jsp" />
</portlet:renderURL>


<liferay-ui:success key="success" message="Your Task has been Submitted! You will receive an email when your 
    output is ready, Or  you can check the outputs page." />
	<liferay-ui:error key="error"
    message="Sorry, an error prevented the upload. Please try again." />
    	<liferay-ui:upload-progress
    	id="<%= uploadProgressId %>"
    	message="uploading"
        redirect="<%= editCaseURL %>"
  		/>

		<aui:form action="<%= editCaseURL %>" enctype="multipart/form-data" method="post" >
		<aui:input type="file" name="fileName" size="75"/>
		<input type="submit" value="<liferay-ui:message key="upload" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>

		</aui:form>
		
		
<p><a href="<%= outputsURL %>" style="float:right">&rarr;See Outputs</a></p>

<%-- <portlet:renderURL var="viewCaseURL">
    <portlet:param name="jspPage" value="/view2.jsp" />
</portlet:renderURL>

<aui:button onClick="<%=viewCaseURL%>" value="view Uploaded Case" /> --%>