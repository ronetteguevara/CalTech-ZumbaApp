<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.zumbaapp.servlet.db.DB, com.zumbaapp.servlet.model.Participant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Participant</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="style.css"></link>
</head>
<body class="gradient-background">
        <%
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                DB db = new DB();
                Participant participant = db.fetchParticipant(id);
                if (participant != null) {
        %>
        
    <div class="my-4 d-flex justify-content-center col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12" data-new-gr-c-s-check-loaded="14.1169.0" data-gr-ext-installed="">
	<main class="form-signin d-flex justify-content-center">
	
	
                    <form action='SaveEditedParticipants' method='post'>
                   		<div class="card" style="width: 25rem;">
                   			<img src="assets/Zumba_1.png" class="card-img-top" alt="Rohit smiling">
                   		<div class="card-body text-center">
                   		<h1 class="mt-4 mb-2 fw-normal text-center">Zumba by Rohit</h1>
						<h4 class="mb-4 fw-normal text-center">Admin Portal</h4>
						<h6 class="mb-4 fw-normal text-center">Edit Participant</h6>
						<div class="form-floating mx-4 my-4">
							<input type="hidden" name="id" value="<%= participant.id %>" class="form-control">
						</div>
						
						<div class="form-floating mx-4 my-4">
							<input type="text" name="firstName" value="<%= participant.firstName %>" class="form-control">
							<label for="floatingInput">First Name</label>
						</div>
						
						<div class="form-floating mx-4 my-4">
							<input type="text" name="lastName" value="<%= participant.lastName %>" class="form-control">
							<label for="floatingInput">Last Name</label>
						</div>
						
						<div class="form-floating mx-4 my-4">
							<input type="text" name="email" value="<%= participant.email %>" class="form-control">
							<label for="floatingInput">Email</label>
						</div>
						
						<div class="form-floating mx-4 my-4">
							<input type="text" name="phone" value="<%= participant.phone %>" class="form-control">
							<label for="floatingInput">Phone</label>
						</div>
						
						<div class="form-floating mx-4 my-4">
							<input type="text" name="zumbaClass" value="<%= participant.zumbaClass %>" class="form-control">
							<label for="floatingInput">Zumba Class</label>
						</div>
						
						<div class="mx-4 my-4">
							<button class="w-100 btn btn-lg btn-primary button" type="submit">Save</button>
						</div>
						
						<div class="my-4">
							<p style="color: #458933;"><a href="Home.jsp">Return Home</a>   |   <a href="ViewParticipants.jsp">View Classes</a></p>
						</div>
						
                    </form>
        <%
                } else {
                    out.println("<p>Participant not found.</p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p>Error: Invalid ID format.</p>");
            }
        %>
        </main>
        </div>
</body>
</html>