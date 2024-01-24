<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                <div class="left-sidebar">
                    <h2>Thể loại</h2>
                    <div class="panel-group category-products" id="accordian"><!--category-productsr-->




                        <c:forEach items="${danhsachCategory}" var="c">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="/?categoryId=${c.id}">${c.name}</a></h4>
                                </div>
                            </div>
                        </c:forEach>


                    </div><!--/category-products-->

                    <div class="brands_products"><!--brands_products-->
                        <h2>Nhãn hiệu</h2>
                        <div class="brands-name">
                        <c:forEach items="${danhsachBrand}" var="c">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href= "/?brandId=${c.id}">${c.name}</a></li>
                             </ul>
                            </c:forEach>
                        </div>
                    </div><!--/brands_products-->

                    <div class="price-range"><!--price-range-->

                        <div class="well text-center">

                        </div>
                    </div><!--/price-range-->

                    <div class="shipping text-center"><!--shipping-->
                        <img src="/images/home/salelaptop1.jpg" height="300" width="300" alt=""/>
                    </div><!--/shipping-->

                </div>
            </div>

            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Features Items</h2>

                    <c:forEach items="${products}" var="p">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="/image/${p.image}" alt=""/>
                                        <h2>${p.price} đ</h2>
                                        <p>${p.name}</p>
                                        <a href="/product-detail/${p.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Chi tiết sản phẩm</a>

                                    </div>


                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div><!--features_items-->


                </div><!--/category-tab-->

            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/jsp/common/foot.jsp"></jsp:include>
