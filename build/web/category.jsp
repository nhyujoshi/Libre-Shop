<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Category</h2>
        <div class="panel-group category-products" id="accordian">
            <c:forEach var="category" items="${categories}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a href = "<c:url value = "/product?id=${category.id}"/>"><c:out value="${category.name}"/></a>
                        </h4>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="shipping text-center">
        <img src="images/home/shipping.jpg" alt=""/>
    </div>
</div>
