<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/public/include/default.jsp" %>

<html>
<head>
	<title>题目查询</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#add").bind("click",function(){
				window.location.href = "${ctx}/topic/toAddPage";
			});
			$("#query").bind("click",function(){
				$('#dg').datagrid('load',{
					search_chapterId:$("#chapterId").val(),
				});
			});
		});
		function format_manager(value,row,index){
			if (value){
				return '<a href="${ctx}/topic/toUpdatePage/'+value+'">修改</a>&nbsp;&nbsp;<a href="${ctx}/topic/delete/'+value+'">删除</a>';
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
    			所属章节：
    			<input id="chapterId" name="chapterId" type="text" class="easyui-textbox textbox" value="${param.search_chapterId}"/>
    			<a class="easyui-linkbutton" id="query" href="javascript:void(0)">查询</a>
       		</div>
		</div>
	</div>
	<div data-options="region:'center',border:false"  style="padding:3px">
		<table id="dg" class="easyui-datagrid" title="题目查询" style="height:auto;width:auto" data-options='singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:"${ctx}/topic/list?ads=" + Date.parse(new Date()),method:"get"'>
	        <thead>
	            <tr>
	                <th data-options="field:'topic',width:80">题目描述</th>
	                <th data-options="field:'answer',width:80">答案描述</th>
	                <th data-options="field:'rightAnswer',width:80">正确答案</th>
	                <th data-options="field:'topicScore',width:80">题目分值</th>
	                <th data-options="field:'analysis',width:80">详解</th>
	                <th data-options="field:'difficulty',width:80">难易度</th>
	                <th data-options="field:'chapterId',width:80">所属章节</th>
	                <th data-options="field:'id',width:80,formatter:format_manager">管理</th>
	            </tr>
	        </thead>
		</table>
    </div>
</body>
</html>
