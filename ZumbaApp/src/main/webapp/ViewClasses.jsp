<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList, com.zumbaapp.servlet.db.DB, com.zumbaapp.servlet.model.Classes" %>
<html>
<head>
    <title>All Classes</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="style.css"></link>
</head>
<body class="gradient-background justify-content-center">

        <div class="my-4 d-flex justify-content-center col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
        <div class="container-fluid mt-4 mx-5 px-4 py-4 justify-content-center" style="background-color: white; border-radius: 20px;">
        <h1 class="mb-3" style="text-align: center;">All Classes</h1>

        <%
            DB db = new DB();
            ArrayList<Classes> zumbaClasses = db.fetchAllClasses();
            db.closeConnection();       

            if (zumbaClasses != null && zumbaClasses.size() > 0) {
                out.print("<table class='table table-hover'>");
                out.print("<thead>");
                out.print("<tr>");
                out.print("<th scope='col'>ID</th>");
                out.print("<th scope='col'>Name</th>");
                out.print("<th scope='col'>Session</th>");
                out.print("<th scope='col'>Date</th>");
                out.print("<th scope='col'>Start Time</th>");
                out.print("<th scope='col'>End Time</th>");
                out.print("<th scope='col'>Location</th>");
                out.print("<th scope='col'>Actions</th>");
                out.print("</tr>");
                out.print("</thead>");
                out.print("<tbody>");
                

                for (Classes classes : zumbaClasses) {
                    out.print("<tr>");
                    out.print("<td>" + classes.id + "</td>");
                    out.print("<td>" + classes.name + "</td>");
                    out.print("<td>" + classes.session + "</td>");
                    out.print("<td>" + classes.date + "</td>");
                    out.print("<td>" + classes.startTime + "</td>");
                    out.print("<td>" + classes.endTime + "</td>");
                    out.print("<td>" + classes.location + "</td>");
                    out.print("<td><a href='DeleteClasses?id=" + classes.id + "'>Delete</a> | <a href='EditClass.jsp?id=" + classes.id + "'>Edit</a></td>");
                    out.print("</tr>");
                }
                out.print("</tbody>");
                out.print("</table>");
            } else {
                out.print("<h3>No Classes Found.</h3>");
            }
            
            out.print("</div>");
            out.print("</div>");
        %>
        <div class="container-fluid center d-flex justify-content-center col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12"">
		<a class="w-25 btn btn-primary btn-light mt-2 mb-5 mx-3" href="Home.jsp">Home</a>
		<a class="w-25 btn btn-primary btn-light mt-2 mb-5 mx-3" href="add-class.html">Add Class</a>
		</div>
		</div>
		</div>
		
</body>
</html>
