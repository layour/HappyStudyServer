<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>用户添加</title>
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
	<form id="inputForm" action="${ctx}/user/update" method="post">
		<div class="easyui-panel" title="用户添加" align="center">
			<input type="hidden" name="userId" value="${user.userId}"/>
			<table cellpadding="5">
    			<tr>
					<td>手机号：</td>
    				<td><input id="phoneNo" name="phoneNo" type="text" class="text" value="${user.phoneNo}"/></td>
    			</tr>
    			<tr>
					<td>密码：</td>
    				<td><input id="password" name="password" type="text" class="text" value="${user.password}"/></td>
    			</tr>
    			<tr>
					<td>用户姓名：</td>
    				<td><input id="userName" name="userName" type="text" class="text" value="${user.userName}"/></td>
    			</tr>
    			<tr>
					<td>性别：</td>
    				<td><input id="sex" name="sex" type="text" class="text" value="${user.sex}"/></td>
    			</tr>
    			<tr>
					<td>身份证号：</td>
    				<td><input id="idNo" name="idNo" type="text" class="text" value="${user.idNo}"/></td>
    			</tr>
    			<tr>
					<td>推荐人工号：</td>
    				<td><input id="referrerNo" name="referrerNo" type="text" class="text" value="${user.referrerNo}"/></td>
    			</tr>
    			<tr>
					<td>推荐人手机号：</td>
    				<td><input id="referrerPhoneNo" name="referrerPhoneNo" type="text" class="text" value="${user.referrerPhoneNo}"/></td>
    			</tr>
    			<tr>
					<td>城市：</td>
    				<td><input id="city" name="city" type="text" class="text" value="${user.city}"/></td>
    			</tr>
    			<tr>
					<td>班型：</td>
    				<td><input id="teamType" name="teamType" type="text" class="text" value="${user.teamType}"/></td>
    			</tr>
    			<tr>
					<td>角色：</td>
    				<td><input id="role" name="role" type="text" class="text" value="${user.role}"/></td>
    			</tr>
    			<tr>
					<td>班级ID：</td>
    				<td><input id="teamClass" name="teamClass" type="text" class="text" value="${user.teamClass}"/></td>
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
