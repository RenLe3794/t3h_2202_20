<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/backend/common/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/jsp/backend/common/nav.jsp"></jsp:include>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Danh sách tài khoản</h1>
                <p style="color: red">${message}</p>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên sản phẩm</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Thương hiệu</th>
                        <th scope="col">Thể loại</th>
                        <th scope="col">Ảnh</th>
                        <th scope="col">Xem chi tiết </th>
                        <th scope="col">Tùy chọn</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="stt" value="1"></c:set>

                        <c:forEach items="${list.data}" var="product">
                        <tr>
                            <th scope="row">${stt}</th>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.brandId}</td>
                            <td>${product.categoryId}</td>
                            <td><img src= "/image/${product.image}" alt="" width="60" height="60"/></td>
                            <td><a href="/backend/product/product-detail/${product.id}">Chi tiết</a></td>
                            <td><a href="/backend/product/edit/${product.id}">edit </a><a href= "/backend/product/delete?Id=${product.id}" > delete</a></td>
                         <c:set var="stt" value="${stt + 1}"></c:set>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

            <jsp:include page="/WEB-INF/jsp/backend/common/paging.jsp"></jsp:include>
        </div>
    </div>
</div>
</body>

