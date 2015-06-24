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
	<form id="inputForm" action="${ctx}/paperTopic/update" method="post">
		<div class="easyui-panel" title="添加题目" align="center">
			<input type="hidden" name="paperTopicId" value="${paperTopic.paperTopicId}"/>
			<table cellpadding="5">
    			<tr>
					<td>试卷ID：</td>
    				<td><input id="paperId" name="paperId" type="text" class="text" value="${paperTopic.paperId}"/></td>
    			</tr>
    			<tr>
					<td>题目ID：</td>
    				<td><input id="topicId" name="topicId" type="text" class="text" value="${paperTopic.topicId}"/></td>
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
