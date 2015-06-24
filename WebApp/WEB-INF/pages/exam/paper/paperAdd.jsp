<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>添加试卷</title>
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
	<form id="inputForm" action="${ctx}/paper/save" method="post">
		<div class="easyui-panel" title="添加试卷" align="center">
			<table>
    			<tr class="control-group">
    				<td>试卷名称：</td>
    				<td><input id="paperName" name="paperName" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>题目数：</td>
    				<td><input id="topicCount" name="topicCount" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>总分：</td>
    				<td><input id="totalScore" name="totalScore" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>组卷时间：</td>
    				<td><input id="paperTime" name="paperTime" type="text" class="text"/></td>
    			</tr>
    			<tr class="control-group">
    				<td>是否可用：</td>
    				<td><input id="enabled" name="enabled" type="text" class="text"/></td>
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
