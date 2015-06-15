<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>意见反馈</title>
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
	<form id="inputForm" action="${ctx}/opinion/update" method="post">
		<div class="easyui-panel" title="意见反馈" align="center">
			<input type="hidden" name="opinionId" value="${opinion.opinionId}"/>
			<table cellpadding="5">
    			<tr>
					<td>意见描述：</td>
    				<td><input id="opinionDesc" name="opinionDesc" type="text" class="text" value="${opinion.opinionDesc}"/></td>
    			</tr>
    			<tr>
					<td>联系方式：</td>
    				<td><input id="contactInfo" name="contactInfo" type="text" class="text" value="${opinion.contactInfo}"/></td>
    			</tr>
    			<tr>
					<td>反馈时间：</td>
    				<td><input id="opinionTime" name="opinionTime" type="text" class="text" value="${opinion.opinionTime}"/></td>
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
