/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOMaquina;
import DAOs.DAOTipomaquina;
import Entidade.Maquina;
import Entidade.Maquina;
import Entidade.Tipomaquina;
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
 * @author Bianca Volante
 */
@WebServlet(name = "CadastroMaquina", urlPatterns = {"/CadastroMaquina"})
public class CadastroMaquinaServlet extends HttpServlet {

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
            Maquina maquina = new Maquina();
            Integer id = Integer.valueOf(request.getParameter("id_maquina"));
            String nome = request.getParameter("nome_maquina");
            double valor = Double.valueOf(request.getParameter("valor_hora"));
           
            maquina.setIdMaquina(id);
            maquina.setNomeMaquina(nome);
            maquina.setValorHora(valor);
            
            DAOMaquina daoMaquina = new DAOMaquina();
            Integer tipo = new Integer(request.getParameter("tipo"));
            
            String tabela ="";
            DAOTipomaquina daoTipomaquina = new DAOTipomaquina();
            Tipomaquina d0 = daoTipomaquina.obter(tipo);
                    maquina.setTipomaquinaId(d0);
            
            daoMaquina.inserir(maquina);
              List<Maquina> lista = daoMaquina.listInOrderIdMaquina();
            for (Maquina p : lista) {
                tabela += "<tr class=\"gradeA\">"
                        + "<td>" + p.getIdMaquina()+ "</td>"
                        + "<td>" + p.getNomeMaquina() + "</td>"
                        + "<td>" + p.getValorHora()+ "</td>" 
                        + "<td>" + p.getTipomaquinaId().getTipo()+ "</td>"
                        + "</tr>";
            }
        request.getSession().setAttribute("resultado", tabela);
            response.sendRedirect(request.getContextPath() + "/paginas/maquina.jsp");
            
            
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
