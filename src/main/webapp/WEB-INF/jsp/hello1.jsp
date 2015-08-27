<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<style>
.hidden{display:none;}
</style>
 <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script>

var data = [{
    "bookId": 1,
        "bookName": "aa",
        "chapter": [{
        "chapterId": 1,
            "chapterName": "xx",
            "book": null
    }, {
        "chapterId": 2,
            "chapterName": "yy",
            "book": null
    }]
}, {
    "bookId": 2,
        "bookName": "bb",
        "chapter": [{
        "chapterId": 4,
            "chapterName": "pp",
            "book": null
    }, {
        "chapterId": 3,
            "chapterName": "zz",
            "book": null
    }]
}, {
    "bookId": 3,
        "bookName": "cc",
        "chapter": [{
        "chapterId": 5,
            "chapterName": "qq",
            "book": null
    }, {
        "chapterId": 6,
            "chapterName": "rr",
            "book": null
    }]
}, {
    "bookId": 4,
        "bookName": "dd",
        "chapter": [{
        "chapterId": 8,
            "chapterName": "tt",
            "book": null
    }, {
        "chapterId": 7,
            "chapterName": "ss",
            "book": null
    }]
}];
$(function () {
    if (data) {
        var len = data.length;
        var txt = "";
        if (len > 0) {
            for (var i = 0; i < len; i++) {
                if (data[i].bookId && data[i].bookName) {
                    txt += "<tr><td>" + data[i].bookId + "</td><td>" + data[i].bookName + "</td></tr>";
                }
            }
            if (txt != "") {
                $("#table1").append(txt).removeClass("hidden");
            }
        }
    }
});

</script>
</head>
<body>

<h2>Book Details</h2>

<table id="table1" align=c enter border='1.5' width='600' cellpadding='1' cellspacing='1'>
    <tr>
        <th>BookId</th>
        <th>BookName</th>
        <!-- <th>Item Details</th>   -->
    </tr>
    <tbody></tbody>
</table>

</body>
</html>