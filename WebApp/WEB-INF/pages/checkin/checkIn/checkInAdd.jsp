<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>记录签到</title>
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
	<form id="inputForm" action="${ctx}/checkIn/save" method="post">
		<div class="easyui-panel" title="记录签到" align="center">
			<table>
    			<tr class="control-group">
    				<td>签到时间：</td>
    				<td><input id="checkTime" name="checkTime" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>签到地点：</td>
    				<td><input id="checkAddr" name="checkAddr" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>签到类型：</td>
    				<td><input id="checkType" name="checkType" type="text" class="text"/></td>
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
