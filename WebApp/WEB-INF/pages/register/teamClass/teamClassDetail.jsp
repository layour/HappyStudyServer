<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>班级详细</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<div class="easyui-panel" title="班级详细" align="center">
		<table cellpadding="5">
			<tr>
				<td>班级名称：</td>
				<td><input name="teamClassName" value="${teamClass.teamClassName}" class="easyui-validatebox textbox" disabled="disabled" /></td>
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
