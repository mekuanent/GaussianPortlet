<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />

<p>Here are your outputs ready to download!</p>

<table style="width:100%">

<tr>
	<td>Sulfur.out</td>
	<td>Download | Delete</td>
</tr>

<tr>
	<td>Ammonia.out</td>
	<td>Download | Delete</td>
</tr>

</table>

<portlet:renderURL var="outputsURL">
    <portlet:param name="jspPage" value="/outputs.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>

<br/>

<aui:button onClick="<%=outputsURL%>" value="Refresh" />

<p><a href="<%= viewURL %>" style="float:right">&larr;Submit Tasks</a></p>
