<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="Phân trang">
    <ul class="pagination">
        <li class="page-item <c:if test="${list.page == 1}">disabled</c:if>">
            <a class="page-link" href="/backend/${path}/list?page=${list.page - 1}&perpage=${list.perpage}">Trước</a></li>
        <c:forEach begin="${list.begin}" step="1" end="${list.page + 3}" var="num">
            <c:if test="${num > 0 && num <= list.numberPage}">
                <li class="page-item <c:if test="${list.page == num}">active</c:if>">
                    <a class="page-link " href="/backend/${path}/list?page=${num}&perpage=${list.perpage}">${num}
                    </a>
                </li>
            </c:if>
        </c:forEach>
        <li class="page-item <c:if test="${list.page == list.numberPage}">disabled</c:if>">
            <a class="page-link" href="/backend/${path}/list?page=${list.page + 1}&perpage=${list.perpage}">Sau</a></li>
    </ul>
</nav>

