package Controles;

import DAOs.DAOCliente;
import DAOs.DAOPedido;

import Entidade.Pedido;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaque
 */
@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedidoLista"})
public class PedidoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAOPedido daoPedido = new DAOPedido();
    Pedido pedido = new Pedido();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int IdPedido = 0;
        int FuncionarioId = 0;
        String clienteRg = "";
        String dataPedido = "";
        DAOPedido daoPedido = new DAOPedido();
        DAOCliente daoCliente = new DAOCliente();
        try (PrintWriter out = response.getWriter()) {
            IdPedido = Integer.parseInt(request.getParameter("IdPedido"));
            dataPedido = request.getParameter("dataPedido");
            FuncionarioId = Integer.parseInt(request.getParameter("FuncionarioId"));
            clienteRg = request.getParameter("ClienteRg");

            Pedido pedido = new Pedido();
            pedido.setIdPedido(IdPedido);
            pedido.setRgCliente(daoCliente.obter(Integer.valueOf(clienteRg)));

            daoPedido.inserir(pedido);

            response.sendRedirect(request.getContextPath() + "/Paginas/pedidoLista.jsp");
        }
    }

    protected String listaPedidoIdPedido(String IdPedido) {
        DAOPedido tipo = new DAOPedido();
        String tabela = "";
        List<Pedido> lista = tipo.listById(0);
        for (Pedido l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdPedido() + "</td>"
                    + "<td>" + l.getRgCliente()+ "</td>"
                    + "<td>" + l.getIdFuncionario()+ "</td>"
                    + "</tr>";
        }

        return tabela;
    }

    protected String listaPedidosCadastrados() {
        DAOPedido tipo = new DAOPedido();
        String tabela = "";
        List<Pedido> lista = tipo.listByDataPedido(tabela);
        for (Pedido l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdPedido() + "</td>"
                    + "<td>" + l.getRgCliente()+ "</td>"
                    + "<td>" + l.getIdFuncionario()+ "</td>"
                    + "</tr>";
        }

        return tabela;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("teste doget");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("teste dopost");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
