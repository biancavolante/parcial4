package DAOs;

import Entidade.Pedido;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOPedido extends DAOGenerico<Pedido> {

    public DAOPedido() {
        super(Pedido.class);
    }

    public int autoIdPedido() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idPedido) FROM Pedido e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
    
    

    public List<Pedido> listById(int Id) {
        return em.createQuery("SELECT e FROM Pedido e WHERE e.Id = :Id").setParameter("Id", Id).getResultList();
    }

    public List<Pedido> listByDataPedido(String DataPedido) {
        return em.createQuery("SELECT e FROM Pedido e WHERE e.DataPedido LIKE :DataPedido").setParameter("DataPedido", "%" + DataPedido + "%").getResultList();
    }
    public List <Pedido> listByRgCliente (String RgCliente){
        return em.createQuery("SELECT e FROM Pedido e WHERE e.RgCliente = :RgCliente").setParameter("RgCliente", RgCliente).getResultList();
    }
     
      public List <Pedido> listByidFuncionario (String idFuncionario){
        return em.createQuery("SELECT e FROM Pedido e WHERE e.idFuncionario = :idFuncionario").setParameter("idFuncionario", idFuncionario).getResultList();
    }
      

    public List<Pedido> listInOrderId() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.Id").getResultList();
    }

    public List<Pedido> listInOrderDataPedido() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.DataPedido").getResultList();
    }
    public List<Pedido> listInOrderRgCliente() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.RgCliente").getResultList();
    }
    public List<Pedido> listInOrderidFuncionario() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.idFuncionario").getResultList();
    }
    public List<Pedido> listInOrderiD() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.Id").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pedido> lf;
        if (qualOrdem.equals("Id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderDataPedido();
        }
        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdPedido()+ ";" + ";" + lf.get(i).getRgCliente()+ ";" +lf.get(i).getIdFuncionario());
        }
        return ls;
 
}}

