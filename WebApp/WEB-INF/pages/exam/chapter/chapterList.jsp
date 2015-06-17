<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>查询章节</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#add").bind("click",function(){
				window.location.href = "${ctx}/chapter/toAddPage";
			});
			$("#query").bind("click",function(){
				$('#dg').datagrid('load',{
					search_chapterName:$("#chapterName").val(),
				});
			});
		});
		function format_manager(value,row,index){
			if (value){
				return '<a href="${ctx}/chapter/toUpdatePage/'+value+'">修改</a>&nbsp;&nbsp;<a href="${ctx}/chapter/delete/'+value+'">删除</a>';
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
    			章节名称：
    			<input id="chapterName" name="chapterName" type="text" class="easyui-textbox textbox" value="${param.search_chapterName}"/>
    			<a class="easyui-linkbutton" id="query" href="javascript:void(0)">查询</a>
       		</div>
		</div>
	</div>
	<div data-options="region:'center',border:false"  style="padding:3px">
		<table id="dg" class="easyui-datagrid" title="查询章节" style="height:auto;width:auto" data-options='singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:"${ctx}/chapter/list?ads=" + Date.parse(new Date()),method:"get"'>
	        <thead>
	            <tr>
	                <th data-options="field:'chapterName',width:80">章节名称</th>
	                <th data-options="field:'id',width:80,formatter:format_manager">管理</th>
	            </tr>
	        </thead>
		</table>
    </div>
</body>
</html>
