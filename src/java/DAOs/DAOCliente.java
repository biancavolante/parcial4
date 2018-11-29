package DAOs;

import Entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOCliente extends DAOGenerico<Cliente> {

    public DAOCliente() {
        super(Cliente.class);
    }

    public int autoIdCliente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCliente) FROM Cliente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
    
    

    public List<Cliente> listByRg(int Rg) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.Rg = :Rg").setParameter("Rg", Rg).getResultList();
    }

    public List<Cliente> listByNomeCliente(String nomeCliente) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.nomeCliente LIKE :nomeCliente").setParameter("nomeCliente", "%" + nomeCliente + "%").getResultList();
    }
    public List <Cliente> listByEndereco (String Endereco){
        return em.createQuery("SELECT e FROM Cliente e WHERE e.Endereco = :Endereco").setParameter("Endereco", Endereco).getResultList();
    }
     
      public List <Cliente> listByEmail (String Email){
        return em.createQuery("SELECT e FROM Cliente e WHERE e.Email = :Email").setParameter("Email", Email).getResultList();
    }
      public List <Cliente> listByTelefone (String Telefone){
        return em.createQuery("SELECT e FROM Cliente e WHERE e.Endereco = :Telefone").setParameter("Endereco", Telefone).getResultList();
    }

    public List<Cliente> listInOrderRg() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.rg").getResultList();
    }

    public List<Cliente> listInOrderNomeCliente() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.nomeCliente").getResultList();
    }
    public List<Cliente> listInOrderEndereco() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.Endereco").getResultList();
    }
    public List<Cliente> listInOrderEmail() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.Email").getResultList();
    }
    public List<Cliente> listInOrderTelefone() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.Telefone").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("Rg")) {
            lf = listInOrderRg();
        } else {
            lf = listInOrderNomeCliente();
        }
        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getRg() + ";" + lf.get(i).getNomeCliente() + ";" + lf.get(i).getEndereco()+ ";"+ lf.get(i).getEmail()+";"+ lf.get(i).getTelefone());
        }
        return ls;
 
}}

