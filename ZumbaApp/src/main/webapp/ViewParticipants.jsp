<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList, com.zumbaapp.servlet.db.DB, com.zumbaapp.servlet.model.Participant" %>
<html>
<head>
    <title>All Participants</title>
    <link rel="stylesheet" href="css/bootstrap.css"></link>
	<link rel="stylesheet" href="style.css"></link>
</head>
<body class="gradient-background justify-content-center">

        <div class="my-4 d-flex justify-content-center col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
        <div class="container-fluid mt-4 mx-5 px-4 py-4 justify-content-center" style="background-color: white; border-radius: 20px;">
        <h1 class="mb-3" style="text-align: center;">All Participants</h1>

        <%
            DB db = new DB();
            ArrayList<Participant> zumbaParticipants = db.fetchAllParticipants();
            db.closeConnection();

            if (zumbaParticipants != null && zumbaParticipants.size() > 0) {
                out.print("<table class='table table-hover'>");
                out.print("<thead>");
                out.print("<tr>");
                out.print("<th scope='col'>ID</th>");
                out.print("<th scope='col'>First Name</th>");
                out.print("<th scope='col'>Last Name</th>");
                out.print("<th scope='col'>Email</th>");
                out.print("<th scope='col'>Phone Number</th>");
                out.print("<th scope='col'>Zumba Class</th>");
                out.print("<th scope='col'>Actions</th>");
                out.print("</tr>");
                out.print("</thead>");
                out.print("<tbody>");

                for (Participant participant : zumbaParticipants) {
                    out.print("<tr>");
                    out.print("<td>" + participant.id + "</td>");
                    out.print("<td>" + participant.firstName + "</td>");
                    out.print("<td>" + participant.lastName + "</td>");
                    out.print("<td>" + participant.email + "</td>");
                    out.print("<td>" + participant.phone + "</td>");
                    out.print("<td>" + participant.zumbaClass + "</td>");
                    out.print("<td><a href='DeleteParticipants?id=" + participant.id + "'>Delete</a> | <a href='EditParticipant.jsp?id=" + participant.id + "'>Edit</a></td>");
                    out.print("</tr>");
                }
                out.print("</tbody>");
                out.print("</table>");
            } else {
                out.print("<h3>No Participants Found.</h3>");
            }
            
            out.print("</div>");
            out.print("</div>");
        %>
        <div class="container-fluid center d-flex justify-content-center col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12"">
		<a class="w-25 btn btn-primary btn-light mt-2 mb-5 mx-3" href="Home.jsp">Home</a>
		<a class="w-25 btn btn-primary btn-light mt-2 mb-5 mx-3" href="add-participant.html">Add Participant</a>
		</div>
		</div>
		</div>
		
</body>
</html>
