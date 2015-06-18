<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>添加题目</title>
	<script>
		$(document).ready(function(){
	        $('input.easyui-validatebox').validatebox("disableValidation");
	        $("#cancel").bind("click",function(){
	    		history.back();
	    	});
	        $("#save").bind("click",function(){
	        	if($('input [name=plainPassword]').val() == $('input [name=plainPassword]').val()){
			        $('input.easyui-validatebox').validatebox("enableValidation");
			        if($("#inputForm").form("validate")){
				        $('#inputForm').submit();
			        }
		        };
	    	});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/topic/update" method="post">
		<div class="easyui-panel" title="添加题目" align="center">
			<input type="hidden" name="topicId" value="${topic.topicId}"/>
			<table cellpadding="5">
    			<tr>
					<td>题目描述：</td>
    				<td><input id="topic" name="topic" type="text" class="text" value="${topic.topic}"/></td>
    			</tr>
    			<tr>
					<td>答案描述：</td>
    				<td><input id="answer" name="answer" type="text" class="text" value="${topic.answer}"/></td>
    			</tr>
    			<tr>
					<td>正确答案：</td>
    				<td><input id="rightAnswer" name="rightAnswer" type="text" class="text" value="${topic.rightAnswer}"/></td>
    			</tr>
    			<tr>
					<td>题目分值：</td>
    				<td><input id="topicScore" name="topicScore" type="text" class="text" value="${topic.topicScore}"/></td>
    			</tr>
    			<tr>
					<td>详解：</td>
    				<td><input id="analysis" name="analysis" type="text" class="text" value="${topic.analysis}"/></td>
    			</tr>
    			<tr>
					<td>难易度：</td>
    				<td><input id="difficulty" name="difficulty" type="text" class="text" value="${topic.difficulty}"/></td>
    			</tr>
    			<tr>
					<td>所属章节：</td>
    				<td><input id="chapterId" name="chapterId" type="text" class="text" value="${topic.chapterId}"/></td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
						<a id="save" href="javascript:void(0)" class="easyui-linkbutton">保存</a>
						<a id="cancel" href="javascript:void(0)" class="easyui-linkbutton">返回</a>
					</td>
    			</tr>
            </table>
        </div>
	</form>
</body>
</html>
