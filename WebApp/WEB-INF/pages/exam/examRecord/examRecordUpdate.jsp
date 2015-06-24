<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>添加考试记录</title>
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
	<form id="inputForm" action="${ctx}/examRecord/update" method="post">
		<div class="easyui-panel" title="添加考试记录" align="center">
			<input type="hidden" name="examRecordId" value="${examRecord.examRecordId}"/>
			<table cellpadding="5">
    			<tr>
					<td>考试得分：</td>
    				<td><input id="examScore" name="examScore" type="text" class="text" value="${examRecord.examScore}"/></td>
    			</tr>
    			<tr>
					<td>考试时间：</td>
    				<td><input id="examTime" name="examTime" type="text" class="text" value="${examRecord.examTime}"/></td>
    			</tr>
    			<tr>
					<td>用时：</td>
    				<td><input id="useTime" name="useTime" type="text" class="text" value="${examRecord.useTime}"/></td>
    			</tr>
    			<tr>
					<td>用户ID：</td>
    				<td><input id="userId" name="userId" type="text" class="text" value="${examRecord.userId}"/></td>
    			</tr>
    			<tr>
					<td>试卷ID：</td>
    				<td><input id="paperId" name="paperId" type="text" class="text" value="${examRecord.paperId}"/></td>
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
