<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Emotional</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
  <link rel="stylesheet" type="text/css" href="css/estilo.css" />
</head>
<body>
            <div class="nav-content hideNav hidden">
               <ul class="nav-list vcenter">
                  <li class="nav-item"><a class="item-anchor" href="Menu.jsp">Menu</a></li>
                  <li class="nav-item"><a class="item-anchor" href="${pageContext.request.contextPath}/logout.jsp">Logout</a></li>

               </ul>
            </div>
  <div class="container" >
  <div class="content"> 

      <p>Ol�, ${sessionScope.usuarioLogado.nome}, essas s�o as buscas encontradas:</p>
      <div id="buscarMusica">
        <form name="formMusica" action="buscarMusica" method="get" enctype="text/plain" autocomplete="off"> 
  <c:forEach items="${musicas}" var="musica">
   <p>${musica.titulo_musica}</p>
  <audio controls>
   
  	<source src="${musica.arquivo_musica}" type="audio/mp3">

</audio>
</c:forEach>
		  
           
          <p> 
            <input type="submit" value="Buscar Musica" name="buscarMusica"/> 
          </p>
           

        </form>
      </div>
    </div>
  </div>  
</body>
</html>