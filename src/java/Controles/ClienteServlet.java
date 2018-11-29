/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCliente;

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
 * @author Jaque
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cadastroCliente"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAOCliente daoCliente = new DAOCliente();
    Cliente cliente = new Cliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.print("aui");
            int rg = 0;
            int telefone = 0;
            String nomeCliente = "";
            DAOCliente daoCliente = new DAOCliente();

            out.print("aqui");
            rg = Integer.valueOf(request.getParameter("RgCliente"));
            nomeCliente = request.getParameter("NomeCliente");
            String endereco = request.getParameter("Endereco");
            String email = request.getParameter("Email");
            telefone = Integer.valueOf(request.getParameter("Telefone"));
            out.print("aqui");

            Cliente cliente = new Cliente();
            cliente.setRg(rg);
            cliente.setNomeCliente(nomeCliente);
            cliente.setEndereco(endereco);
            cliente.setEmail(email);
            cliente.setTelefone(email);

            daoCliente.inserir(cliente);
            DAOCliente tipo = new DAOCliente();
            String tabela = "";
            List<Cliente> lista = tipo.listInOrderRg();
            for (Cliente l : lista) {
                tabela += "<tr>"
                        + "<td>" + l.getRg() + "</td>"
                        + "<td>" + l.getNomeCliente() + "</td>"
                        + "<td>" + l.getEndereco() + "</td>"
                        + "<td>" + l.getEmail() + "</td>"
                        + "<td>" + l.getTelefone() + "</td>"
                        + "</tr>";
            }
            request.getSession().setAttribute("resultado", tabela);
            response.sendRedirect(request.getContextPath() + "/paginas/cliente.jsp");
        }
    }

    private String listaClienteId() {
        DAOCliente tipo = new DAOCliente();
        String tabela = "";
        List<Cliente> lista = tipo.listInOrderRg();
        for (Cliente l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getRg() + "</td>"
                    + "<td>" + l.getNomeCliente() + "</td>"
                    + "<td>" + l.getEndereco() + "</td>"
                    + "<td>" + l.getEmail() + "</td>"
                    + "<td>" + l.getTelefone() + "</td>"
                    + "</tr>";
        }

        return tabela;
    }

    protected String listaClientesCadastrados() {
        DAOCliente tipo = new DAOCliente();
        String tabela = "";
        List<Cliente> lista = tipo.listByNomeCliente(tabela);
        for (Cliente l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getRg() + "</td>"
                    + "<td>" + l.getNomeCliente() + "</td>"
                    + "<td>" + l.getEndereco() + "</td>"
                    + "<td>" + l.getEmail() + "</td>"
                    + "<td>" + l.getTelefone() + "</td>"
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
