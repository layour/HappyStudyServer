<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>用户查询</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#add").bind("click",function(){
				window.location.href = "${ctx}/user/toAddPage";
			});
			$("#query").bind("click",function(){
				$('#dg').datagrid('load',{
					search_phoneNo:$("#phoneNo").val(),
				});
			});
		});
		function format_manager(value,row,index){
			if (value){
				return '<a href="${ctx}/user/toUpdatePage/'+value+'">修改</a>&nbsp;&nbsp;<a href="${ctx}/user/delete/'+value+'">删除</a>';
			} else {
				return value;
			}
		}
	</script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="padding:3px;height:30px">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',border:false" style="width:200px">
       			<a id="add" href="javascript:void(0)" class="easyui-linkbutton">增加</a>
       		</div>
       		<div data-options="region:'center',border:false" align="right">
    			手机号：
    			<input id="phoneNo" name="phoneNo" type="text" class="easyui-textbox textbox" value="${param.search_phoneNo}"/>
    			<a class="easyui-linkbutton" id="query" href="javascript:void(0)">查询</a>
       		</div>
		</div>
	</div>
	<div data-options="region:'center',border:false"  style="padding:3px">
		<table id="dg" class="easyui-datagrid" title="用户查询" style="height:auto;width:auto" data-options='singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:"${ctx}/user/list?ads=" + Date.parse(new Date()),method:"get"'>
	        <thead>
	            <tr>
	                <th data-options="field:'phoneNo',width:80">手机号</th>
	                <th data-options="field:'password',width:80">密码</th>
	                <th data-options="field:'userName',width:80">用户姓名</th>
	                <th data-options="field:'sex',width:80">性别</th>
	                <th data-options="field:'idNo',width:80">身份证号</th>
	                <th data-options="field:'referrerNo',width:80">推荐人工号</th>
	                <th data-options="field:'referrerPhoneNo',width:80">推荐人手机号</th>
	                <th data-options="field:'city',width:80">城市</th>
	                <th data-options="field:'teamType',width:80">班型</th>
	                <th data-options="field:'role',width:80">角色</th>
	                <th data-options="field:'teamClassId',width:80">班级ID</th>
	                <th data-options="field:'id',width:80,formatter:format_manager">管理</th>
	            </tr>
	        </thead>
		</table>
    </div>
</body>
</html>
