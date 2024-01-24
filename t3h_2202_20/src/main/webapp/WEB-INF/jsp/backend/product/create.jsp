<%@page pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/jsp/backend/common/head.jsp"></jsp:include>


<body>
<jsp:include page="/WEB-INF/jsp/backend/common/nav.jsp"></jsp:include>

<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Tạo mới sản phẩm</h1>
                <p style="color: red">${message}</p>
                <form action="/backend/product/create-form" method="post" id="product-form">
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Tên sản phẩm</label>
                                <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Giá</label>
                                <input type="number" name="price" class="form-control" id="exampleInputPassword1">
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Mô tả</label>
                                <textarea class="form-control" name="description" id="description" rows="4">${product.description}</textarea>
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="fileUploadId" class="form-label">Tải ảnh</label>
                                <input type="file"  class="form-control" id="fileUploadId" aria-describedby="emailHelp">
                            </div>
                        </div>
                        <div class="col-6">
                            <img id="outputImage" width="100px"></img>
                            <div class="mb-3">
                                <input hidden type="text" name="image" class="form-control" id="fileUploadName">
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Thương hiệu</label>
                                <select name="brandId" class="form-select" aria-label="Default select example">
                                    <option value="1">lenovo</option>
                                    <option value="2">dell</option>
                                    <option value="3">hp</option>
                                    <option value="4">asus</option>
                                    <option value="5">msi</option>
                                    <option value="6">MacBook</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-9">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Thể loại</label>
                                <select name="categoryId" class="form-select" aria-label="Default select example">
                                    <option value="1">Mỏng nhẹ</option>
                                    <option value="2">Doanh nhân</option>
                                    <option value="3">Văn phòng</option>
                                    <option value="4">Sinh viên</option>
                                    <option value="5">Gaming</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <h2>Thông số sản phẩm</h2>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">CPU</label>
                        <input type="text" name="cpu" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Memory</label>
                        <input type="text" name="memory" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">HDD</label>
                        <input type="text" name="hdd" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">VGA</label>
                        <input type="text" name="vga" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">DISPLAY</label>
                        <input type="text" name="display" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Wireless/label>
                        <input type="text" name="wieless" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">LAN</label>
                        <input type="text" name="lan" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Baterry</label>
                        <input type="text" name="baterry" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">OS</label>
                        <input type="text" name="os" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Weight/label>
                        <input type="text" name="weight" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Color</label>
                        <input type="text" name="color" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Tạo mới</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script>

    $(document).ready(function () {// sẽ chay sau khi web tải xong html và css
        $("#product-form").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 6,

                }
            },
            messages: {
                name: {
                    required: "Vui lòng nhập trường tên sản phẩm",
                    minlength: jQuery.validator.format("Tên sản phẩm nhập ít nhất {0} ký tự")
                }
            }
        });

        // $ <-> viết tắt Jquery
        // # lấy phần có id
        // . lấy phần tử class  $(".btn-primary")
        $("#fileUploadId").on("change",function (event) {

            var file = $(this)[0].files[0];// lấy file
            var reader = new FileReader();
            reader.onload = function(){
                var output = document.getElementById('outputImage');
                output.src = reader.result;
            };
            reader.readAsDataURL(file);
            var formData = new FormData();

            // add assoc key values, this will be posts values
            formData.append("file", file, file.name);
            formData.append("upload_file", true);

            $.ajax({// gọi api từ client (trình duyệt)
                type: "POST",
                enctype: 'multipart/form-data',
                url: "/backend/product/upload",
                data: formData,
                processData: false, //prevent jQuery from automatically transforming the data into a query string
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $('#fileUploadName').val(data);
                    alert("upload thành công")

                },
                error: function (e) {
                    alert("upload thất bại")

                }
            });

        });

    });

</script>
