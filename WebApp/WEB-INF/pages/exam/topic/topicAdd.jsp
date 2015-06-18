<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>添加题目</title>
	<script type="text/javascript">
		$(document).ready(function(){
	        $('input.easyui-validatebox').validatebox("disableValidation");
			$("#add").bind("click",function(){
		        if($('input [name=plainPassword]').val() == $('input [name=plainPassword]').val()){
	    	        $('input.easyui-validatebox').validatebox("enableValidation");
	    	        if($("#inputForm").form("validate")){
	    		        $('#inputForm').submit();
	    	        }
		        };
			});
			$("#cancel").bind("click",function(){
				history.back();
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/topic/save" method="post">
		<div class="easyui-panel" title="添加题目" align="center">
			<table>
    			<tr class="control-group">
    				<td>题目描述：</td>
    				<td><input id="topic" name="topic" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>答案描述：</td>
    				<td><input id="answer" name="answer" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>正确答案：</td>
    				<td><input id="rightAnswer" name="rightAnswer" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>题目分值：</td>
    				<td><input id="topicScore" name="topicScore" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>详解：</td>
    				<td><input id="analysis" name="analysis" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>难易度：</td>
    				<td><input id="difficulty" name="difficulty" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>所属章节：</td>
    				<td><input id="chapterId" name="chapterId" type="text" class="text"/></td>
    			</tr>
    			<tr class="form-actions">
					<td colspan="2" align="center">
						<a id="add" href="javascript:void(0)" class="easyui-linkbutton">增加</a>
						<a id="cancel" href="javascript:void(0)" class="easyui-linkbutton">返回</a>
					</td>
    			</tr>
			</table>
		</div>
	</form>
</body>
</html>
