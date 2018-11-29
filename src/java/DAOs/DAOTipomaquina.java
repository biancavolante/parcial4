package DAOs;

import Entidade.Tipomaquina;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOTipomaquina extends DAOGenerico<Tipomaquina> {

    public DAOTipomaquina() {
        super(Tipomaquina.class);
    }

    public int autoIdTipomaquina() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTipomaquina) FROM Tipomaquina e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Tipomaquina> listByIdTipomaquina(int idTipo) {
        return em.createQuery("SELECT e FROM Tipomaquina e WHERE e.idTipo = :idTipo").setParameter("idTipo", idTipo).getResultList();
    }

    public List<Tipomaquina> listByNomeTipomaquina(String tipo) {
        return em.createQuery("SELECT e FROM Tipomaquina e WHERE e.tipo LIKE :tipo").setParameter("tipo", "%" + tipo + "%").getResultList();
    }

    public List<Tipomaquina> listInOrderIdTipomaquina() {
        return em.createQuery("SELECT e FROM Tipomaquina e ORDER BY e.idTipo").getResultList();
    }

    public List<Tipomaquina> listInOrderNomeTipomaquina() {
        return em.createQuery("SELECT e FROM Tipomaquina e ORDER BY e.tipo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Tipomaquina> lf;
        if (qualOrdem.equals("idTipo")) {
            lf = listInOrderIdTipomaquina();
        } else {
            lf = listInOrderNomeTipomaquina();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTipo()+ ";" + lf.get(i).getTipo()+ ";");
        }
        return ls;
    }
}

