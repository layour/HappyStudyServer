<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>添加试卷</title>
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
	<form id="inputForm" action="${ctx}/paper/update" method="post">
		<div class="easyui-panel" title="添加试卷" align="center">
			<input type="hidden" name="paperId" value="${paper.paperId}"/>
			<table cellpadding="5">
    			<tr>
					<td>试卷名称：</td>
    				<td><input id="paperName" name="paperName" type="text" class="text" value="${paper.paperName}"/></td>
    			</tr>
    			<tr>
					<td>题目数：</td>
    				<td><input id="topicCount" name="topicCount" type="text" class="text" value="${paper.topicCount}"/></td>
    			</tr>
    			<tr>
					<td>总分：</td>
    				<td><input id="totalScore" name="totalScore" type="text" class="text" value="${paper.totalScore}"/></td>
    			</tr>
    			<tr>
					<td>组卷时间：</td>
    				<td><input id="paperTime" name="paperTime" type="text" class="text" value="${paper.paperTime}"/></td>
    			</tr>
    			<tr>
					<td>是否可用：</td>
    				<td><input id="enabled" name="enabled" type="text" class="text" value="${paper.enabled}"/></td>
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
