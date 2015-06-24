<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>试卷详细</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<div class="easyui-panel" title="试卷详细" align="center">
		<table cellpadding="5">
			<tr>
				<td>试卷名称：</td>
				<td><input name="paperName" value="${paper.paperName}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>题目数：</td>
				<td><input name="topicCount" value="${paper.topicCount}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>总分：</td>
				<td><input name="totalScore" value="${paper.totalScore}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>组卷时间：</td>
				<td><input name="paperTime" value="${paper.paperTime}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>是否可用：</td>
				<td><input name="enabled" value="${paper.enabled}" class="easyui-validatebox textbox" disabled="disabled" /></td>
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
