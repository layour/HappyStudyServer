<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>用户添加</title>
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
	<form id="inputForm" action="${ctx}/user/save" method="post">
		<div class="easyui-panel" title="用户添加" align="center">
			<table>
    			<tr class="control-group">
    				<td>手机号：</td>
    				<td><input id="phoneNo" name="phoneNo" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>密码：</td>
    				<td><input id="password" name="password" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>用户姓名：</td>
    				<td><input id="userName" name="userName" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>性别：</td>
    				<td><input id="sex" name="sex" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>身份证号：</td>
    				<td><input id="idNo" name="idNo" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>推荐人工号：</td>
    				<td><input id="referrerNo" name="referrerNo" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>推荐人手机号：</td>
    				<td><input id="referrerPhoneNo" name="referrerPhoneNo" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>城市：</td>
    				<td><input id="city" name="city" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>班型：</td>
    				<td><input id="teamType" name="teamType" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>角色：</td>
    				<td><input id="role" name="role" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>班级ID：</td>
    				<td><input id="teamClassId" name="teamClassId" type="text" class="text"/></td>
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
