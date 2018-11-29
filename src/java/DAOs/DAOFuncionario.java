package DAOs;

import Entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOFuncionario extends DAOGenerico<Funcionario> {

    public DAOFuncionario() {
        super(Funcionario.class);
    }

    public int autoIdFuncionario() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idFuncionario) FROM Funcionario e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
    
    

    public List<Funcionario> listByRg(int Rg) {
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.Rg = :Rg").setParameter("Rg", Rg).getResultList();
    }

    public List<Funcionario> listByNomeFuncionario(String nomeFuncionario) {
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.nomeFuncionario LIKE :nomeFuncionario").setParameter("nomeFuncionario", "%" + nomeFuncionario + "%").getResultList();
    }
    public List <Funcionario> listByEndereco (String Endereco){
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.Endereco = :Endereco").setParameter("Endereco", Endereco).getResultList();
    }
     
      public List <Funcionario> listByEmail (String Email){
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.Email = :Email").setParameter("Email", Email).getResultList();
    }
      public List <Funcionario> listByTelefone (String Telefone){
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.Endereco = :Telefone").setParameter("Endereco", Telefone).getResultList();
    }

    public List<Funcionario> listInOrderRg() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.id").getResultList();
    }

    public List<Funcionario> listInOrderNomeFuncionario() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.nomeFuncionario").getResultList();
    }
    public List<Funcionario> listInOrderEndereco() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.Endereco").getResultList();
    }
    public List<Funcionario> listInOrderEmail() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.Email").getResultList();
    }
    public List<Funcionario> listInOrderTelefone() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.Telefone").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Funcionario> lf;
        if (qualOrdem.equals("Rg")) {
            lf = listInOrderRg();
        } else {
            lf = listInOrderNomeFuncionario();
        }
        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ ";" + lf.get(i).getNomeFuncionario() + ";" + lf.get(i).getEndereco()+ ";"+ lf.get(i).getEmail()+";"+ lf.get(i).getTelefone());
        }
        return ls;
 
}}

