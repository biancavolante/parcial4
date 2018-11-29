<%-- 
    Document   : cadastroTipo
    Created on : 07/11/2018, 15:16:08
    Author     : Bianca Volante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Volante Tratores</title>
        <link href="../Estilos/form.css" rel="stylesheet" type="text/css"/>
        
    </head>
    
    <body>
        <jsp:include page="./menu.jsp"/>

        <div>
            <h1> Cadastro de tipos de Maquinas</h1> <img src="slogan.png" width=60 height=40>
            
        </div>
        <form action="${pageContext.request.contextPath}/CadastroTipo1" method="post">
            <p>
                <label for="id"> Id Tipo Maquina </label> 
                <input type="text" name="id" value="" >
                <label for="tipo"> Tipo Maquina</label> 
                <input type="text" name="tipo" value="" />
    
                <input type="submit" value="Salvar" />
            </p>
            
        </form>
    </body>
</html>
