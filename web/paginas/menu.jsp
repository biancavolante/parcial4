<%-- 
    Document   : menu
    Created on : 05/10/2018, 09:52:35
    Author     : a1711938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="../Estilos/menu.css" rel="stylesheet" type="text/css"/>
<ul>
    <li><a class="active" href="${pageContext.request.contextPath}/paginas/paginaInicial.jsp">Home</a></li>

    <li><a href="${pageContext.request.contextPath}/paginas/cadastroCliente.jsp"> CADASTRO CLIENTE</a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/cadastroFuncionario.jsp" > CADASTRO FUNCIONARIO</a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/cadastroMaquina.jsp" >CADASTRO MÁQUINAS</a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/cadastroTipo.jsp" >CADASTRO TIPO DE MAQUINA</a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/cadastroPedido.jsp" >CADASTRO PEDIDOS</a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/cliente.jsp" > CLIENTES </a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/funcionario.jsp" >FUNCIONARIOS</a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/maquina.jsp" > MAQUINAS </a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/tipomaquina.jsp" >TIPOS MAQUINAS  </a></li>
    <li><a href="${pageContext.request.contextPath}/paginas/pedido.jsp"> PEDIDOS </a></li>
   
</ul>




