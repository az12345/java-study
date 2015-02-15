<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>

<div class="login-form-container">
	<form action="${CONTEXT }/login.php" method="post" >
		<table>
			<tr>
				<td colspan="2" class="caption">Login</td>
			</tr>
			<jsp:include page="modules/validationMessage.jsp" />
			<tr>
				<td>Login</td>
				<td>
					<input type="text" name="username" id="username" value="" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="password" id="password" />
				</td>
			</tr>
			<tr>
				<td>Select role</td>
				<td>
					<select name="role" id="role">
						<option value="1">Administrator</option>
						<option value="2">User</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;border-top:1px solid gray;">
					<input type="submit" value="Login">
				</td>
			</tr>
		</table>
	</form>
</div>