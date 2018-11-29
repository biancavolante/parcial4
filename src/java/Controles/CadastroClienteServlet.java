package Controles;

import DAOs.DAOCliente;
import Entidade.Cliente;
import Entidade.Cliente;
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
 * @author a1712004
 */
@WebServlet(name = "CadastroCliente", urlPatterns = {"/CadastroCliente"})
public class CadastroClienteServlet extends HttpServlet {

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
           
            
            Integer rg = Integer.valueOf(request.getParameter("RGCliente"));
            String nome = request.getParameter("NomeCliente");
            String endereco = request.getParameter("Endereco");
            String email = request.getParameter("Email");
            String telefone = request.getParameter("Telefone");
            
            String tabela ="";
            DAOCliente daoCliente = new DAOCliente();
            Cliente produto = new Cliente();
            
            produto.setRg(rg);
            produto.setNomeCliente(nome);
            produto.setEndereco(endereco);
            produto.setEmail(email);
            produto.setTelefone(telefone);
            
            daoCliente.inserir(produto);
            List<Cliente> lista = daoCliente.listInOrderRg();
            for (Cliente p : lista) {
                tabela += "<tr class=\"gradeA\">"
                        + "<td>" + p.getRg()+ "</td>"
                        + "<td>" + p.getNomeCliente() + "</td>"
                        + "<td>" + p.getEndereco() + "</td>"
                        + "<td>" + p.getEmail() + "</td>"
                        + "<td>" + p.getTelefone() + "</td>"
                        + "</tr>";
            }
        request.getSession().setAttribute("resultado", tabela);
        response.sendRedirect(request.getContextPath() + "/paginas/cliente.jsp");
        
        rg=null;
        nome="";
        endereco="";
        telefone="";
        }
        
    }

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
    

