<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>用户详细</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<div class="easyui-panel" title="用户详细" align="center">
		<table cellpadding="5">
			<tr>
				<td>手机号：</td>
				<td><input name="phoneNo" value="${user.phoneNo}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="password" value="${user.password}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>用户姓名：</td>
				<td><input name="userName" value="${user.userName}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input name="sex" value="${user.sex}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input name="idNo" value="${user.idNo}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>推荐人工号：</td>
				<td><input name="referrerNo" value="${user.referrerNo}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>推荐人手机号：</td>
				<td><input name="referrerPhoneNo" value="${user.referrerPhoneNo}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>城市：</td>
				<td><input name="city" value="${user.city}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>班型：</td>
				<td><input name="teamType" value="${user.teamType}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><input name="role" value="${user.role}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>班级ID：</td>
				<td><input name="teamClass" value="${user.teamClass}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
        	<tr>
				<td colspan="2" align="center">
					<a id="cancel" href="javascript:void(0)" class="easyui-linkbutton">&nbsp;&nbsp;返回&nbsp;&nbsp;</a>
				</td>
			</tr>
        </table>
	</div>
</body>
</html>
