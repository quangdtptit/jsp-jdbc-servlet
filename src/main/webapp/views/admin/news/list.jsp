<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="deleteURL" value="/api-admin-new"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
		<form action='<c:url value="/admin-news" />' id="formSubmit"
			method="get">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li><i class="ace-icon fa fa-home home-icon"></i> <a
								href="#">Trang chủ</a></li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<div class="widget-box table-filter">
								<div class="widget-body">
										<div class="widget-main">
											<div class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">Tên bài viết</label>
													<div class="col-sm-9">
														<input type="text" id="title" name="title" class="form-control" value="${model.title}"/>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">Loại bài viết</label>
													<div class="col-sm-9">
														<select class="form-control" id="categoryCode" name="categoryCode">											
																<option value="">---Chọn loại bài viết---</option>
																<c:forEach var="item" items="${categorys}">
																	<option value="${item.code}">${item.name}</option>
																</c:forEach>				
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right">Lượt xem</label>
													<div class="col-sm-9">
														<input type="text" id="view" name="view" class="form-control" value="0"/>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"></label>
													<div class="col-sm-9">
														<button id="btnSearch" type="button" class="btn btn-sm btn-success">
															Tìm kiếm
															<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
														</button>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
													class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Thêm bài viết'
													href='<c:url value="/admin-news?type=edit"/>'> <span>
														<i class="fa fa-plus-circle bigger-110 purple"></i>
												</span>
												</a>
												<button id="btnDelete" type="button"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Xóa bài viết'>
													<span> <i class="fa fa-trash-o bigger-110 pink"></i>
													</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" class="check-box-element" id="checkAll"/></th>
														<th>ID</th>
														<th>Tên bài viết</th>
														<th>Mô tả ngắn</th>
														<th>Hình ảnh</th>
														<th>Nội dung</th>
														<th>Ngày khởi tạo</th>
														<th>Người khởi tạo</th>
														<th>Ngày sửa</th>
														<th>Người sửa</th>
														<th>Lượt xem</th>
														<th>Thao tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.list}">
														<tr>
															<td><input type="checkbox" class="check-box-element" id="checkbox_${item.id}" value="${item.id}"/></td>
															<td>${item.id}</td>
															<td>${item.title}</td>
															<td>${item.shortDescription}</td>
															<td>${item.thumbnail}</td>
															<td>${item.content}</td>
															<td>${item.createdDate}</td>
															<td>${item.createdBy}</td>
															<td>${item.modifiedDate}</td>
															<td>${item.modifiedBy}</td>
															<td>${item.view}</td>
															<td><c:url var="editURL" value="/admin-news">
																	<c:param name="type" value="edit" />
																	<c:param name="id" value="${item.id}" />
																</c:url> <a class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Cập nhật bài viết"
																href='${editURL}'><i class="fa fa-pencil-square-o"
																	aria-hidden="true"></i> </a></td>
														</tr>
													</c:forEach>

												</tbody>
											</table>
											<div style="text-align: center;">
												<ul class="pagination" id="pagination"></ul>
												<input type="hidden" name="type" id="type" value="list" />
												<input type="hidden" name="page" id="page" value="" /> <input
													type="hidden" name="maxPageItem" id="maxPageItem" value="" />
												<input type="hidden" name="elementSort" id="elementSort"
													value="" /> <input type="hidden" name="sortBy" id="sortBy"
													value="" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
		$(function() {
			var totalPages = ${model.totalPages};
			var currentPage = ${model.page};
			var maxPageItem = ${model.maxPageItem};
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 3,
				startPage : currentPage,
				onPageClick : function(event, page) {
					//console.info(page + ' (from options)');
					if (currentPage != page) {
						$('#sortBy').val('ASC');
						$('#elementSort').val('id');
						$('#maxPageItem').val(maxPageItem);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
		$('#btnDelete').click(function (e) {
		    e.preventDefault();
            var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            var data = {};
            data["ids"] = dataArray;
            $.ajax({
                url: '${deleteURL}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                	alert("Xóa Thành Công !!!");
                    window.location.href = "<c:url value='/admin-news?type=list&page=1&maxPageItem=3&elementSort=id&sortBy=ASC'/>";
                },
                error: function (error) {
                	alert("Xóa Thất Bại !!!");
                    window.location.href = "<c:url value='/admin-news?type=list&page=1&maxPageItem=3&elementSort=id&sortBy=ASC'/>";
                }
            });
        });
		$('#btnSearch').click(function () {
            $('#maxPageItem').val(maxPageItem);
            $('#page').val(1);
            $('#type').val('list');
            $('#formSubmit').submit();
        });
	</script>
</body>

</html>