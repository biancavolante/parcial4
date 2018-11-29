<%-- 
    Document   : cadastrocliente
    Created on : 13/09/2018, 15:04:17
    Author     : Carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Volante Tratores </title>
        <link href="../Estilos/form.css" rel="stylesheet" type="text/css"/>
        
    </head>
    
    <body>
        <jsp:include page="./menu.jsp"/>

        <div>
            <h1> Cadastro de Clientes</h1> <img src="slogan.png" width=60 height=40>
            
        </div>
        <form action="${pageContext.request.contextPath}/CadastroCliente" method="post">
            <p>
                <label for="rg"> RG Cliente </label> 
                <input type="text" name="RGCliente" value="" >
                <label for="nome_cliente"> Nome do Cliente </label> 
                <input type="text" name="NomeCliente" value="" />
                <label for="endereco"> Endereco </label> 
                <input type="text" name="Endereco" value="" />
                <label for="email"> Email </label> 
                <input type="text" name="Email" value="" />
                <label for="telefone"> Telefone </label> 
                <input type="text" name="Telefone" value="" />
                <input type="submit" value="Salvar" />
            </p>
            
        </form>
    </body>
</html>