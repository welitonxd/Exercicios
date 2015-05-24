package br.welitonads.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdEstado", nullable = false)
    private Integer IdEstado;
    @Column(name = "NomeEstado", length = 40, nullable = false)
    private String nomeEstado;
    
    @OneToMany (mappedBy = "estado",fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoEstado")
    private List<Endereco> enderecos;

    public Estado() {
    }

    public Integer getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(Integer IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.IdEstado != null ? this.IdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (this.IdEstado != other.IdEstado && (this.IdEstado == null || !this.IdEstado.equals(other.IdEstado))) {
            return false;
        }
        return true;
    }
    
}
