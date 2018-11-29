<%-- 
    Document   : cadastrocliente
    Created on : 13/09/2018, 15:04:17
    Author     : Carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidade.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOCliente"%>
<%@page import="Entidade.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOFuncionario"%>
<%
    DAOCliente daoCliente = new DAOCliente();
    List<Cliente> cliente = daoCliente.listInOrderRg();
    
    DAOFuncionario daoFuncionario = new DAOFuncionario();
    List<Funcionario> funcionario = daoFuncionario.listInOrderRg();

%>
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
            <h1> Cadastro de Pedidos</h1> <img src="slogan.png" width=60 height=40>
            
        </div>
        <form action="${pageContext.request.contextPath}/CadastroPedido" method="POST">
            <p>
                <label for="id_pedido"> ID Pedido </label> 
                <input type="text" name="id_pedido" value="" >
                
                <label for="rg_cliente"> Nome Cliente </label> 
                <select name="cliente">
                    <%                                for (int i = 0; i < cliente.size(); i++) {
                        System.out.println(" lista de ids ==== "+cliente.get(i).getRg()+ "  lista de nomes === "+cliente.get(i).getNomeCliente());
                    %>
                    <option value="<%=cliente.get(i).getRg()%>"><%=cliente.get(i).getNomeCliente()%></option>
                    <%
                        }
                    %>
                </select>
                 <label for="rg_funcionario"> Nome Funcionario </label> 
                <select name="funcionario">
                    <%                                for (int i = 0; i < funcionario.size(); i++) {
                        System.out.println(" lista de ids ==== "+funcionario.get(i).getId()+ "  lista de nomes === "+funcionario.get(i).getNomeFuncionario());
                    %>
                    <option value="<%=funcionario.get(i).getId()%>"><%=funcionario.get(i).getNomeFuncionario()%></option>
                    <%
                        }
                    %>
                </select>
                
                
               
                <input type="submit" value="Salvar" />
            </p>
            
        </form>
    </body>
</html>