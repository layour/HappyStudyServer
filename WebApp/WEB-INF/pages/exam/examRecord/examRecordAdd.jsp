<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>添加考试记录</title>
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
	<form id="inputForm" action="${ctx}/examRecord/save" method="post">
		<div class="easyui-panel" title="添加考试记录" align="center">
			<table>
    			<tr class="control-group">
    				<td>考试得分：</td>
    				<td><input id="examScore" name="examScore" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>考试时间：</td>
    				<td><input id="examTime" name="examTime" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>用时：</td>
    				<td><input id="useTime" name="useTime" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>用户ID：</td>
    				<td><input id="userId" name="userId" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>试卷ID：</td>
    				<td><input id="paperId" name="paperId" type="text" class="text"/></td>
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
