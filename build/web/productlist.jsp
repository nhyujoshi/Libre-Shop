<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="features_items">
    <!--features_items-->
    <h2 class="title text-center">Features Items</h2>
    <c:forEach var="product" items="${products}">
        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                        <img src="/images/home/Nike.jpg" alt="" />
                        <h2>Rs. ${product.price}</h2>
                        <p>${product.name}</p>
                        <p>${product.image}</p>
                        <a href="<c:url value = "/cart?productId=${product.id}&categoryId=${product.category.id}"/>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart(${orderitems})</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach> 
</div>