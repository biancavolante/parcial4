/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author a1712209
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<PedidoHasMaquina> pedidoHasMaquinaList;
    @JoinColumn(name = "rg_cliente", referencedColumnName = "rg")
    @ManyToOne(optional = false)
    private Cliente rgCliente;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public List<PedidoHasMaquina> getPedidoHasMaquinaList() {
        return pedidoHasMaquinaList;
    }

    public void setPedidoHasMaquinaList(List<PedidoHasMaquina> pedidoHasMaquinaList) {
        this.pedidoHasMaquinaList = pedidoHasMaquinaList;
    }

    public Cliente getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(Cliente rgCliente) {
        this.rgCliente = rgCliente;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
