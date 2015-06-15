<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>意见反馈</title>
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
	<form id="inputForm" action="${ctx}/opinion/save" method="post">
		<div class="easyui-panel" title="意见反馈" align="center">
			<table>
    			<tr class="control-group">
    				<td>意见描述：</td>
    				<td><input id="opinionDesc" name="opinionDesc" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>联系方式：</td>
    				<td><input id="contactInfo" name="contactInfo" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>反馈时间：</td>
    				<td><input id="opinionTime" name="opinionTime" type="text" class="text"/></td>
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
