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
<link rel="stylesheet" href="css/styleChoice.css" type="text/css" />

<title>Choice</title>
<script>

function valider (button){
	document.getElementById(button).click();
}


</script>
</head>

<body>

<header class="masthead clear">
  <div class="centered">

    <div class="site-branding">
      <h1 class="site-title">${ pseudo }, choisis ton animal:</h1>
    </div>
    <!-- .site-title -->
  </div>
  <!-- .centered -->
</header>
<!-- .masthead -->

<main class="main-area">

  <div class="centered">

    <section class="cards">

      <article class="card" onclick="valider('btn1')">
    
        <form action="choice" method="post">
        <input type="hidden" name="typeAnimal" value="Chat" />
        <input id="btn1" type="submit" style="display:none;" />
          <figure class="thumbnail">
          <img src="https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BBKI9xd.img?h=416&w=624&m=6&q=60&u=t&o=f&l=f&x=2173&y=1262" alt="meow">
          </figure>
          
          <div class="card-content">
            <h2>un petit Chat?</h2>
            
    	</div>
          <!-- .card-content -->
          </form>
      </article>
      <!-- .card -->

      <article class="card" onclick="valider('btn2')">
        <form action="choice" method="post">
        <input type="hidden" name="typeAnimal" value="Chien" />
        <input id="btn2" type="submit" style="display:none;" />
        
          <figure class="thumbnail">
            <img src="https://www.djalbemix.com/creazione_sfondi/3cani.jpg" alt="meow">
          </figure>
          <div class="card-content">
            <h2>un petit Chien?</h2>
            
          </div>
          <!-- .card-content -->
        </a>
      </article>
      <!-- .card -->
    </section>
    <!-- .cards -->

  </div>
  <!-- .centered -->
</main>



</body>
</html>