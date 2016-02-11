<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
       <link rel="stylesheet" href="/css/bootstrap.min.css"/>         
       <script src="/js/bootstrap.min.js"></script>       
    </head>

    <body>          
        <div class="container">
        
            <h2>Members</h2>                        
            <!--Members List-->
            <form action="/index.jsp" method="post" id="memberList" role="form" >              
               
                <c:choose>
                    <c:when test="${not empty memberList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>Last name</td>
                                    <td>Address</td>
                                    <td>E-mail</td>                                 
                                </tr>
                            </thead>
                            <c:forEach var="member" items="${memberList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idMember == member.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td><a href="/?searchAction=searchByID&memberID=${member.id}">${member.id}</a></td>
                                    <td>${member.givenname}</td>
                                    <td>${member.lastName}</td>
                                    <td>${member.address}</td>
                                    <td>${member.email}</td>
                                   
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No people found
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            
            <h2>Books</h2>                   
            <!--Books List-->
            <form action="/">
    			<input type="submit" value="All Books">
			</form>
            <form action="/index.jsp" method="post" id="bookList" role="form" >              
               
                <c:choose>
                    <c:when test="${not empty bookList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Title</td>
                                    <td>Author</td>
                                    <td>ISBN</td>
                                    <td>Rented By</td>                                 
                                </tr>
                            </thead>
                            <c:forEach var="book" items="${bookList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idBook == book.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>${book.id}</td>
                                    <td>${book.title}</td>
                                    <td>${book.author}</td>
                                    <td>${book.isbn}</td>
                                    <td>${book.rentedBy}</td>
                                   
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No books found for this renter
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
           
        </div>
    </body>
</html>