<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<meta charset="ISO-8859-1">
<title>Choice</title>

</head>
<body>
<h1>Choisis ton animal: ${ pseudo }</h1>
<h2></h2>

<form action="choice" method="post">

<label for="choice1"><img src="https://www.wanimo.com/veterinaire/images/articles/chat/chaton-diarrhee.jpg" width="100"/></label>
<input type="radio" name="typeAnimal" id="choice1" value="Chat" />

<label for="choice2"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQodZYm7zZkzdbFQ75q0APRjl6hBTk3fLtKlvQywMBuwN08CBCw" width="100"/></label>
<input type="radio" name="typeAnimal" id="choice2" value="Chien" />

<input type=submit value="J'ai choisi !"/>


</form>

</body>
</html>