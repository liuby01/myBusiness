<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>目录</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

  </head>
  <body>
  	<div class = "container">
  		<!-- 导航栏 -->
  		<div class = "row">
  			<ul class="nav nav-tabs">
  				<li role="presentation" class="active"><a href="#">目录</a></li>
  				<li role="presentation"><a href="${pageContext.request.contextPath}/goods/list">商品</a></li>
			</ul>
  		</div>
  		
  		<!-- 标题栏 -->
  		<div class = "row">
  			<div class = "col-md-12">
  				<h1>电子商务<small>目录明细</small></h1>
  			</div>
  		</div>
  		
  		<!-- 功能栏 -->
  		<div class = "row">
  		
  			<!-- 新增按钮 -->
 			<div class = "col-md-8">
				<button type="button" class="btn btn-primary btn-default" data-toggle="modal" data-target="#addModal">
  					<span class="glyphicon glyphicon-plus" aria-hidden="true">新增</span>
  				</button>
 			</div>

			<!-- 增加模态框 -->
			<form class="form-horizontal" action="<%=request.getContextPath()%>/catalogue/add">
				<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  					<div class="modal-dialog" role="document">
    					<div class="modal-content">
      						<div class="modal-header">
        						<h4 class="modal-title" id="myModalLabel">增加目录</h4>
      						</div>
      						<div class="modal-body row">
      							<label class="col-sm-2 control-label">名字</label>
    							<div class="col-sm-10">
      								<input type="text" style="width:300px" class="form-control" name="caname" placeholder="目录名字">
    							</div>
      							
      							<label class="col-sm-2 control-label">描述</label>
    							<div class="col-sm-10">
      								<input type="text" style="width:300px" class="form-control" name="cadescribe" placeholder="目录描述">
    							</div>
      						</div>
      						<div class="modal-footer">
        						<button type="submit" class="btn btn-success" >增加</button>
        						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      						</div>
    					</div>
  					</div>
				</div>
			</form>
			
			<!-- 搜索栏 -->
  			<div class = "col-md-4">
  				<form class = "form-inline" action="<%=request.getContextPath()%>/catalogue/search" method="post">
  					<div class = "form-group">
    					<input type="search" class="form-control" name="caname"  placeholder="目录搜索">
  					</div>
  					<button type="submit" class="btn btn-success btn-default">
  						<span class="glyphicon glyphicon-search" aria-hidden="true">搜索</span>
  					</button>
  				</form>
  			</div>
  		</div>
  		
  		<!-- 列表栏 -->
  		<div class = "row">
  			<table class="table table-hover">
  				<thead>
  					<tr>
  						<th>#</th>
  						<th>名字</th>
  						<th>商品种数</th>
  						<th>描述</th>
  						<th>操作</th>
  					</tr>
  				</thead>
  				
  				<tbody>
  				<c:forEach items="${calist}" var="ca">
  					<tr>
                		<td>${ca.caid}</td>
                    	<td>${ca.caname}</td>
                    	<td>${ca.gotype}</td>
                    	<td>${ca.cadescribe}</td>
                    	<td>
                    		<button class="btn btn-info" data-toggle="modal" data-target="#editModal">
                    			<span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</span>
                    		</button>
                    		<a class="btn btn-danger" href="/SSM/catalogue/del?caid=${ca.caid}">
                    			<span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
                    		</a>
                    	</td>
                 	</tr>
                 	
                 	<!-- 修改模态框 -->
					<form class="form-horizontal" action="<%=request.getContextPath()%>/catalogue/edit">
						<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  							<div class="modal-dialog" role="document">
    							<div class="modal-content">
      								<div class="modal-header">
        								<h4 class="modal-title" id="myModalLabel">修改目录</h4>
      								</div>
      								<div class="modal-body row">
      									
    									<label class="col-sm-2 control-label">ID</label>
    									<div class="col-sm-10">
    										<input class="form-control" type="text" style="width:200px" name="caid" value="${ca.caid}" readonly>
    									</div>
    										
    									<label for="caname" class="col-sm-2 control-label">名字</label>
    									<div class="col-sm-10">
      										<input type="text" style="width:200px" class="form-control" id="caname" name="caname" placeholder="${ca.caname}">
    									</div> 
    										
    									<label for="cadescribe" class="col-sm-2 control-label">描述</label>
    									<div class="col-sm-10">
      										<input type="text" style="width:200px" class="form-control" id="cadescribe" name="cadescribe" placeholder="${ca.cadescribe}">
    									</div>
  										
      								</div>
      								<div class="modal-footer">
        								<button type="submit" class="btn btn-success">修改</button>
        								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      								</div>
    							</div>
  							</div>
						</div>
					</form>
            	</c:forEach>
  				</tbody>
  				
  				
  				
  			</table>
  		</div>
  		
  		<!-- 分页栏 -->
  		<div class = "row">
  		
  			<!-- 信息栏 -->
  			<div class = "col-md-6" style = "margin-top:30px">
  				当前<span class="badge">${pageInfo.pageNum}</span>页,共<span class="badge">${pageInfo.pages}</span>页，总<span class="badge">${pageInfo.total}</span>记录。
  			</div>
  			
  			<!-- 控制栏 -->
  			<div class = "col-md-3 col-md-offset-3">
				<nav aria-label="Page navigation">
  					<ul class="pagination">
  						<li>
  							<c:if test="${pageInfo.isFirstPage==true}">
  								<li	class="active">
  									<a>首页<span class="sr-only">(current)</span></a>
  								</li>
  								<li class="disabled">
      								<span>
        								<span aria-hidden="true">&laquo;</span>
      								</span>
    							</li>
  							</c:if>
							<c:if test="${pageInfo.isFirstPage==false}">
								<a href="/SSM/catalogue/list?page=${pageInfo.navigateFirstPage}">首页</a>
							</c:if>
  						</li>
  						
    					<li>
    						<c:if test="${pageInfo.hasPreviousPage==true}">
      							<a href="/SSM/catalogue/list?page=${pageInfo.prePage}" aria-label="Previous">
      								<span aria-hidden="true">&laquo;</span>
      							</a>
      						</c:if>
      						<c:if test="${pageInfo.hasPreviousPage==false}"></c:if>
    					</li>
    					
    					<li>
    						<c:if test="${pageInfo.hasNextPage==true}">
      							<a href="/SSM/catalogue/list?page=${pageInfo.nextPage}" aria-label="Next">
        							<span aria-hidden="true">&raquo;</span>
      							</a>
      						</c:if>
      						<c:if test="${pageInfo.hasNextPage==false}"></c:if>
    					</li>
    					
    					<li>
  							<c:if test="${pageInfo.isLastPage==true}">
  								<li class="disabled">
      								<span>
        								<span aria-hidden="true">&raquo;</span>
      								</span>
    							</li>
  								<li	class="active">
  									<a>末页<span class="sr-only">(current)</span></a>
  								</li>
  							</c:if>
							<c:if test="${pageInfo.isLastPage==false}">
								<a href="/SSM/catalogue/list?page=${pageInfo.navigateLastPage}">末页</a>
							</c:if>
  						</li>
  					</ul>
				</nav>
  			</div>
  		</div>
  	</div>
  	
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>