<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>签到列表</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<div class="easyui-panel" title="签到列表" align="center">
		<table cellpadding="5">
			<tr>
				<td>签到时间：</td>
				<td><input name="checkTime" value="${checkIn.checkTime}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>签到地点：</td>
				<td><input name="checkAddr" value="${checkIn.checkAddr}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>签到类型：</td>
				<td><input name="checkType" value="${checkIn.checkType}" class="easyui-validatebox textbox" disabled="disabled" /></td>
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
