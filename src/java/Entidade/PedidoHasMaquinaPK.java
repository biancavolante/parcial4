/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author a1712209
 */
@Embeddable
public class PedidoHasMaquinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "id_maquina")
    private int idMaquina;

    public PedidoHasMaquinaPK() {
    }

    public PedidoHasMaquinaPK(int idPedido, int idMaquina) {
        this.idPedido = idPedido;
        this.idMaquina = idMaquina;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idMaquina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoHasMaquinaPK)) {
            return false;
        }
        PedidoHasMaquinaPK other = (PedidoHasMaquinaPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idMaquina != other.idMaquina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.PedidoHasMaquinaPK[ idPedido=" + idPedido + ", idMaquina=" + idMaquina + " ]";
    }
    
}
