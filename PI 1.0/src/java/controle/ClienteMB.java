/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Cliente;
import dao.DaoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mixplick
 */


@ManagedBean (name = "clienteMB")
@SessionScoped
public class ClienteMB {
    
    private Cliente cliente = new Cliente();
    private DaoCliente daoCliente = new DaoCliente();
    private List<Cliente> listaCliente = new ArrayList<Cliente>();
    private Cliente clienteSelecionado = new Cliente();

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the daoCliente
     */
    public DaoCliente getDaoCliente() {
        return daoCliente;
    }

    /**
     * @param daoCliente the daoCliente to set
     */
    public void setDaoCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    /**
     * @return the listaCliente
     */
    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    /**
     * @param listaCliente the listaCliente to set
     */
    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }
    
    

   public void cadastrarCliente(){
       daoCliente.cadastrarCliente(cliente);
       this.cliente = null;
   }
    
   public List<Cliente> listar(){
       listaCliente = daoCliente.listarTudo();
       return listaCliente;
   }
   
   public void deletarCliente(Cliente c){
       this.cliente = c;
       daoCliente.removerCliente(cliente);
   }    
   
   public void alterarCliente(){
       daoCliente.alterarCliente(clienteSelecionado);
   }
}
