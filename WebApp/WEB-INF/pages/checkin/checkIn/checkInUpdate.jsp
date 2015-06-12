<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>记录签到</title>
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
	<form id="inputForm" action="${ctx}/checkIn/update" method="post">
		<div class="easyui-panel" title="记录签到" align="center">
			<input type="hidden" name="checkId" value="${checkIn.checkId}"/>
			<table cellpadding="5">
    			<tr>
					<td>签到时间：</td>
    				<td><input id="checkTime" name="checkTime" type="text" class="text" value="${checkIn.checkTime}"/></td>
    			</tr>
    			<tr>
					<td>签到地点：</td>
    				<td><input id="checkAddr" name="checkAddr" type="text" class="text" value="${checkIn.checkAddr}"/></td>
    			</tr>
    			<tr>
					<td>签到类型：</td>
    				<td><input id="checkType" name="checkType" type="text" class="text" value="${checkIn.checkType}"/></td>
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
