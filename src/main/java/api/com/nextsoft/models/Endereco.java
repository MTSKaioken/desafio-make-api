package api.com.nextsoft.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Endereco implements Serializable{

  private static final long serialVersionUID = 1L;

    private Cliente clientes;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String tipoEndereco;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    
    public Endereco() {
    }

    public Endereco(String tipoEndereco, String logradouro, Integer numero, String complemento,
            String bairro, String cidade, String estado) {
        super();
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
        result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((tipoEndereco == null) ? 0 : tipoEndereco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        } else if (!bairro.equals(other.bairro))
            return false;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        if (clientes == null) {
            if (other.clientes != null)
                return false;
        } else if (!clientes.equals(other.clientes))
            return false;
        if (complemento == null) {
            if (other.complemento != null)
                return false;
        } else if (!complemento.equals(other.complemento))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (logradouro == null) {
            if (other.logradouro != null)
                return false;
        } else if (!logradouro.equals(other.logradouro))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (tipoEndereco == null) {
            if (other.tipoEndereco != null)
                return false;
        } else if (!tipoEndereco.equals(other.tipoEndereco))
            return false;
        return true;
    }

    
}
