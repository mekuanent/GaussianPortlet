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

<!-- /my-jobs -->

<portlet:renderURL var="outputsURL">
    <portlet:param name="jspPage" value="/confirmation.jsp" />
</portlet:renderURL>

<table style="
    display: table;
    border-collapse: separate;
    border-spacing: 25px;
    border-color: gray;">
  <tr>
    <td><img src="<%= request.getContextPath()%>/image/gaussian.gif" /></td>
    <td><b>Gaussian Software is an electronic structure package capable of predicting many
properties of atoms, molecules, and reactive systems utilizing ab initio, density functional theory, semi-empirical,
molecular mechanics, and hybrid methods [Benjamin J. Lynch].</b>
<br>Upload your file using the link below and click submit. You should get an email when the task finishes.
You can check your output by using the "<a href="<%= outputsURL %>">&rarr;See Outputs</a>" link.
</td>
  </tr>
</table>



<liferay-ui:success key="success" message="Your Task has been Submitted! You will receive an email when your 
    output is ready, Or  you can check the outputs page." />
	<liferay-ui:error key="error"
    message="Sorry, an error prevented the upload. Please try again." />
    	<liferay-ui:upload-progress
    	id="<%= uploadProgressId %>"
    	message="uploading"
        redirect="<%= editCaseURL %>"
  		/>

		<aui:form style="position:relative; left: 20%;" action="<%= editCaseURL %>" enctype="multipart/form-data" method="post" >
		<aui:input type="file" name="fileName" size="75"/>
		<input type="submit" value="<liferay-ui:message key="submit" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>

		</aui:form>
		
		
<p><a href="/my-jobs" style="float:right">&rarr;See Outputs</a></p>

<%-- <portlet:renderURL var="viewCaseURL">
    <portlet:param name="jspPage" value="/view2.jsp" />
</portlet:renderURL>

<aui:button onClick="<%=viewCaseURL%>" value="view Uploaded Case" /> --%>