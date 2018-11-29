package Controles;

import DAOs.DAOCliente;
import DAOs.DAOFuncionario;
import DAOs.DAOPedido;
import Entidade.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a1712004
 */
@WebServlet(name = "CadastroPedido", urlPatterns = {"/CadastroPedido"})
public class CadastroPedidoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroPedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Integer idPedido = Integer.valueOf(request.getParameter("IdPedido"));
            //String data = request.getParameter("DataPedido");
            Integer funcionarioId = Integer.valueOf(request.getParameter("funcionarioId"));
            Integer clienteRg = Integer.valueOf(request.getParameter("clienteId"));
           
            DAOCliente daoCliente = new DAOCliente();
            DAOFuncionario daoFuncionario = new DAOFuncionario();
            
            DAOPedido daoPedido = new DAOPedido();
            Pedido pedido = new Pedido();
            
            pedido.setIdPedido(idPedido);
            pedido.setRgCliente(daoCliente.obter(clienteRg));
            pedido.setIdFuncionario(daoFuncionario.obter(funcionarioId));
            //pedido.setDataPedido(dataPedido);
            
            daoPedido.inserir(pedido);
        }
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