<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<style>
#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 1px solid #31708f;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#footer {
	position: fixed;
    bottom: 0;
    width: 100%;
}

.hidden{display:none;}

</style>

 <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> 
<script>

function delete_table(){
	var table = document.getElementById("table1");
	while(table.rows.length > 0){
		table.deleteRow(0);
	}
}

function delete_table2(){
	var table = document.getElementById("table2");
	while(table.rows.length > 0){
		table.deleteRow(0);
	}
}

function getBookCall(bookId){
	 $.ajax({
	  type: "GET",
	  url: "http://localhost:8080/restApp/chapter/list/"+bookId,
	  contentType:"application/json; charset=utf-8",
	  dataType:"json",
	  success: function(data){
		  		delete_table2();
	            if(data){
	                var len = data.length;
	                var txt = "";
	                txt += "<tr><th>"+"chapterId"+"</th><th>"+"chapterName"+"</th></tr>";
	                if(len > 0){
	                    for(var i=0;i<len;i++){
	                    	if(data[i].chapterId != null && data[i].chapterName != null){
	                    		txt += "<tr><td>"+data[i].chapterId+"</td><td>"+data[i].chapterName+"</td></tr>";            		
	                        }
	                    }
	                    if(txt != ""){
	                        $("#table2").append(txt).removeClass("hidden");
	                    }
	                }
	            }
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	            alert('error: ' + textStatus + ': ' + errorThrown);
	        }
	 	});
	 	return false;
}
	
function madeAjaxCall(){
	 $.ajax({
	  type: "GET",
	  url: "http://localhost:8080/restApp/book/list",
	  contentType:"application/json; charset=utf-8",
	  dataType:"json",
	  success: function(data){
		  		delete_table();
	            if(data){
	                var len = data.length;
	                var txt = "";
	                txt += "<tr><th>"+"bookId"+"</th><th>"+"bookName"+"</th><th>"+"Chapter Details"+"</th><th>"+"Add Chapter"+"</th></tr>";   
	                if(len > 0){
	                    for(var i=0;i<len;i++){
	                    	if(data[i].bookId != null && data[i].bookName != null){                                        
	                    		/* txt += "<tr><td>"+data[i].bookId+"</td><td>"+data[i].bookName+"</td><td><a href="+ "http://localhost:8080/restApp/chapter/list/"+ data[i].bookId +">"+"Chapter details"+"</a></td></tr>";       */     		
	                    		 txt += "<tr><td>"+data[i].bookId+"</td><td>"+data[i].bookName+"</td><td><a href="+ "#"+" "+ "onclick="+"getBookCall("+ data[i].bookId + ")"+";return false;" +">"+"Chapter details"+"</a></td><td><a href="+ "http://localhost:8080/restApp/chapter/add/?id="+ data[i].bookId +">"+"add chapter"+"</a></td></tr>";                  		
	                            
	                    	}
	                    }
	                    if(txt != ""){
	                        $("#table1").append(txt).removeClass("hidden");
	                    }
	                }
	            }
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	            alert('error: ' + textStatus + ': ' + errorThrown);
	        }
	 	});
	 	return false;
}

//var x = document.getElementById("bookName").value;

function postForm(){
	var x = document.getElementById("bookName").value;
	alert($("#myForm").serialize());
	$.ajax({
		  type: "POST",
		  url: "http://localhost:8080/restApp/book/add",
		//  contentType:"application/json; charset=utf-8",
		  data: $("#myForm").serialize(),
		 // dataType:"json",
		  success: function(data){
			  		delete_table();
			  		//alert(x);
		            if(data){
		                var len = data.length;
		                var txt = "";
		                txt += "<tr><th>"+"bookId"+"</th><th>"+"bookName"+"</th><th>"+"Chapter Details"+"</th><th>"+"Add Chapter"+"</th></tr>";   
		                if(len > 0){
		                    for(var i=0;i<len;i++){
		                    	if(data[i].bookId != null && data[i].bookName != null){                                        
		                    		/* txt += "<tr><td>"+data[i].bookId+"</td><td>"+data[i].bookName+"</td><td><a href="+ "http://localhost:8080/restApp/chapter/list/"+ data[i].bookId +">"+"Chapter details"+"</a></td></tr>";       */     		
		                    		 txt += "<tr><td>"+data[i].bookId+"</td><td>"+data[i].bookName+"</td><td><a href="+ "#"+" "+ "onclick="+"getBookCall("+ data[i].bookId + ")"+";return false;" +">"+"Chapter details"+"</a></td><td><a href="+ "http://localhost:8080/restApp/chapter/add/?id="+ data[i].bookId +">"+"add chapter"+"</a></td></tr>";                  		
		                            
		                    	}
		                    }
		                    if(txt != ""){
		                        $("#table1").append(txt).removeClass("hidden");
		                    }
		                }
		            }
		        },
		        error: function(jqXHR, textStatus, errorThrown){
		            alert('error: ' + textStatus + ': ' + errorThrown);
		        }
		 	});
		 	return false;
}

$('#myLink').click(function(){ madeAjaxCall(); return false; });

$('#addbookpost').click(function(){ postForm(); return false;} );

/*
$('#bookLink').click(function(){ getBookCall(1); return false; });
*/

</script>

</head>
<body style="margin: 0px; padding: 0px; font-family: 'Trebuchet MS',verdana;">

	<c:url var="addUrl" value="/book/add" />
	<c:url var="listUrl" value="/book/list" />

<table width="100%" style="height: 100%;" cellpadding="10" cellspacing="0" border="0">
<tr>

<!-- ============ HEADER SECTION ============== -->
<td colspan="3" style="height: 100px;" bgcolor="#777d6a"><h1>Book Details</h1></td></tr>


<!-- ============ NAVIGATION BAR SECTION ============== -->
<tr><td colspan="3" valign="middle" height="50" bgcolor="#a9ae9f"><a href="#">Welcome</a></td></tr>

<tr>
<!-- ============ LEFT COLUMN (MENU) ============== -->
<td width="20%" valign="top" bgcolor="#999f8e">
 
 
<a href="http://localhost:8080/restApp/book/list">Items</a><br>

<a href="http://localhost:8080/restApp/chapter/list/1">chapter list</a><br>

<a id="myLink" href="http://localhost:8080/restApp/book/list" onClick="madeAjaxCall();return false;">Book list</a></br>

<!-- 
<a id ="addbooklink" href="http://localhost:8080/restApp/book/add" >Add Book</a>
 
<a id="bookLink" href="http://localhost:8080/restApp/chapter/list/1" onClick= "getBookCall(1);return false;">chapter list</a> 
-->
<form id="myForm">
	Book Name:<input type="text" id="bookName" name = "bookName">
	<br>
	<a id ="addbookpost" href="http://localhost:8080/restApp/book/add" onClick="postForm(); return false;" >Add Book</a>
</form>
  

</td>

<!-- ============ MIDDLE COLUMN (CONTENT) ============== -->
<td width="55%" valign="top" bgcolor="#d2d8c7">

<table id="table1" align = center border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<h2>Book Details</h2>
	<tr>
		<th>BookId</th>
		<th>BookName</th>
	    <th>Chapter details</th>
	    <th>Add chapter </th>
	</tr>
	<tbody>
	
	<!--  
	<c:forEach items="${bills}" var="bill">
		<c:url var="detailUrl" value="/record/billable?id=${bill.billableId}" />
	
			<tr>
			
				<td><c:out value ="${bill.billableId}" /></td>
				<td><c:out value="${bill.billableName}" /></td>
				<td><c:out value="${bill.billableAddress}" /></td>

				<td><a href="${detailUrl}">Item Details</a></td>

			</tr>
			</c:forEach>
	-->		
	</tbody>
</table>

<table id="table2" align = center border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<h2>Chapter Details</h2>
	<tr>
		<th>ChapterId</th>
		<th>ChapterName</th>
	</tr>
</table>

</td>

<td width="25%" valign="top" bgcolor="#999f8e">&nbsp;</td>

</tr>

<tr><td colspan="3" valign="middle" height="50" bgcolor="#a9ae9f"><a href="#"></a></td></tr>

<!-- ============ FOOTER SECTION ============== -->
<tr><td colspan="3" align="center" height="200" bgcolor="#777d6a">Copyright ©</td></tr>

</table>

</body>
</html>