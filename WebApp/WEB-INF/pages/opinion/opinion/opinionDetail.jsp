<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>意见反馈</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<div class="easyui-panel" title="意见反馈" align="center">
		<table cellpadding="5">
			<tr>
				<td>意见描述：</td>
				<td><input name="opinionDesc" value="${opinion.opinionDesc}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>联系方式：</td>
				<td><input name="contactInfo" value="${opinion.contactInfo}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>反馈时间：</td>
				<td><input name="opinionTime" value="${opinion.opinionTime}" class="easyui-validatebox textbox" disabled="disabled" /></td>
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
