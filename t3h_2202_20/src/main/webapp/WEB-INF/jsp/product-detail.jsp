<%@ page import="java.text.DecimalFormat" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<% DecimalFormat formatter = new DecimalFormat("###,###,###"); %>


<jsp:include page="/WEB-INF/jsp/common/head.jsp"></jsp:include>
<section id="slider"><!--slider-->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#slider-carousel" data-slide-to="1"></li>
                        <li data-target="#slider-carousel" data-slide-to="2"></li>
                    </ol>

                    <div class="item">
                            <div class="col-sm-6">
                                <h1><span>E</span> LAPTOP </h1>
                                <h2>Laptop các loại</h2>
                                <p>Đủ chủng loại laptop cho mọi nhu cầu </p>
                            </div>
                            <div class="col-sm-6">
                                <img src="/images/home/banner3.jpg"  class="girl img-responsive" width="920" height="205" alt=""/>

                            </div>
                        </div>

                    </div>

                    <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div>

            </div>
        </div>
    </div>
</section>
<!--/slider-->

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">



                            </div>
                            <div class="col-sm-7">
                                <div class="product-information"><!--/product-information-->

                                    <img src= "/image/${product.image}"  width="500" height="500" alt="" />
                                    <h2>${product.name}</h2>
                                    <p>ID: ${product.id}</p>
                                    <img src="images/product-details/rating.png" alt="">
                                    <span>
									<span><p>Giá: <fmt:formatNumber value = "${product.price}" type = "currency"/></p></span>
                                     <form action="/addCart-form" method="post" >
                                        <input  type="number" name="userId" value="${user.id}" hidden/>
                                         <input type="number" name="productId" value="${product.id}" placeholder="Your Name" hidden/ >
                                         <input type="number" name="quantity" value="1" hidden/>
                                         <button type="submit" align="center" class="btn btn-fefault cart" href="cart/${user.id}">
										<i class="fa fa-shopping-cart"></i>
										Thêm vào giỏ hàng
									</button>
                                        </form>

								</span>
                                    <p><b>Tình trạng:</b> Còn hàng</p>
                                    <p><b>Trạng thái:</b> Mới</p>
                                    <p><b>Nhãn hiệu:</b>${product.brandId}</p>
                                    <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->



                        <div class="category-tab shop-details-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li><a href="#details" data-toggle="tab">Chi tiết</a></li>
                                    <li><a href="#danhgia" data-toggle="tab">Đánh giá</a></li>
                                    <li class="active"><a href="#reviews" data-toggle="tab">Reviews (5)</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade" id="details" >
                                    <p>CPU : ${product.cpu}</p></br>
                                    <p>Memory : ${product.memory}</p></br>
                                    <p> RAM : ${product.ram}</p></br>
                                    <p> VGA : ${product.vga}</p></br>
                                    <p> Display : ${product.display}</p></br>
                                    <p> OS : ${product.os}</p></br>
                                    <p> Color : ${product.color}</p></br>
                                </div>



                                <div class="tab-pane fade" id="danhgia" >

                                    <c:out value="${product.description}" escapeXml="false"></c:out>


                                </div>


                                <div class="tab-pane fade active in" id="reviews" >
                                    <div class="col-sm-12">
                                        <c:forEach items="${review}"  var="re">
                                            <ul>
                                                <li><a href=""><i class="fa fa-user"></i>${re.name}</a></li>
                                                <li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
                                                <li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
                                            </ul>
                                            <p>${re.comment}</p>
                                        </c:forEach>
                                        <p><b>Viết Review của bạn</b></p>
                                        <form action="/review-form" method="post">
                                        <input name="idProduct" value="${product.id}" hidden>
										<span>
											<input type="text" name="name" placeholder="Your Name"/>
											<input type="email" name="email" placeholder="Email Address"/>
										</span>
                                            <textarea name="comment" ></textarea>
                                            <button type="submit" class="btn btn-primary">
                                                Submit
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div><!--/category-tab-->


                         

</section>

<jsp:include page="/WEB-INF/jsp/common/foot.jsp"></jsp:include>
