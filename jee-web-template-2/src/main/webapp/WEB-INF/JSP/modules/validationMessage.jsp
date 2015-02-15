<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>

<% if(request.getAttribute("VALIDATION_MESSAGE") != null) { %>
			<tr>
				<td colspan="2" class="error">${VALIDATION_MESSAGE }</td>
			</tr>
<% } %>