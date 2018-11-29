<%-- 
    Document   : cadastrocliente
    Created on : 13/09/2018, 15:04:17
    Author     : Carol
--%>

<%@page import="Entidade.Tipomaquina"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOTipomaquina"%>
<%
    DAOTipomaquina daoTipomaquina = new DAOTipomaquina();
    List<Tipomaquina> tipo = daoTipomaquina.listInOrderIdTipomaquina();

%>
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
            <h1> Cadastro de Maquinas</h1> <img src="slogan.png" width=60 height=40>

        </div>
        <form action="${pageContext.request.contextPath}/CadastroMaquina" method="POST">
            <p>
                <select name="tipo">
                    <%                                for (int i = 0; i < tipo.size(); i++) {
                        System.out.println(" lista de ids ==== "+tipo.get(i).getIdTipo() + "  lista de nomes === "+tipo.get(i).getTipo());
                    %>
                    <option value="<%=tipo.get(i).getIdTipo()%>"><%=tipo.get(i).getTipo()%></option>
                    <%
                        }
                    %>
                </select>
                <label for="id_maquina"> Id Maquina </label> 
                <input type="text" name="id_maquina" value="" >
                <label for="nome_maquina"> Nome da Maquina</label> 
                <input type="text" name="nome_maquina" value="" />
                <label for="valor_hora"> Valor Hora</label> 
                <input type="text" name="valor_hora" value="" />

                <input type="submit" value="Salvar" />
            </p>



        </form>
    </body>
</html>