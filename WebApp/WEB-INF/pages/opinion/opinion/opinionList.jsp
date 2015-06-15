<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>意见反馈</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#add").bind("click",function(){
				window.location.href = "${ctx}/opinion/toAddPage";
			});
			$("#query").bind("click",function(){
				$('#dg').datagrid('load',{
					search_userId:$("#userId").val(),
				});
			});
		});
		function format_manager(value,row,index){
			if (value){
				return '<a href="${ctx}/opinion/toUpdatePage/'+value+'">修改</a>&nbsp;&nbsp;<a href="${ctx}/opinion/delete/'+value+'">删除</a>';
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
    			用户ID：
    			<input id="userId" name="userId" type="text" class="easyui-textbox textbox" value="${param.search_userId}"/>
    			<a class="easyui-linkbutton" id="query" href="javascript:void(0)">查询</a>
       		</div>
		</div>
	</div>
	<div data-options="region:'center',border:false"  style="padding:3px">
		<table id="dg" class="easyui-datagrid" title="意见反馈" style="height:auto;width:auto" data-options='singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:"${ctx}/opinion/list?ads=" + Date.parse(new Date()),method:"get"'>
	        <thead>
	            <tr>
	                <th data-options="field:'opinionDesc',width:80">意见描述</th>
	                <th data-options="field:'contactInfo',width:80">联系方式</th>
	                <th data-options="field:'opinionTime',width:80">反馈时间</th>
	                <th data-options="field:'id',width:80,formatter:format_manager">管理</th>
	            </tr>
	        </thead>
		</table>
    </div>
</body>
</html>
