<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>题目详细</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<div class="easyui-panel" title="题目详细" align="center">
		<table cellpadding="5">
			<tr>
				<td>题目描述：</td>
				<td><input name="topic" value="${topic.topic}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>答案描述：</td>
				<td><input name="answer" value="${topic.answer}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>正确答案：</td>
				<td><input name="rightAnswer" value="${topic.rightAnswer}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>题目分值：</td>
				<td><input name="topicScore" value="${topic.topicScore}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>详解：</td>
				<td><input name="analysis" value="${topic.analysis}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>难易度：</td>
				<td><input name="difficulty" value="${topic.difficulty}" class="easyui-validatebox textbox" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>所属章节：</td>
				<td><input name="chapter" value="${topic.chapter}" class="easyui-validatebox textbox" disabled="disabled" /></td>
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
