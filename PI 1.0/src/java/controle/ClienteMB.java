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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Conta;

@ManagedBean(name = "clienteMB")
@SessionScoped
public class ClienteMB {

    private Cliente cliente = new Cliente();
    private DaoCliente daoCliente = new DaoCliente();
    private List<Cliente> listaCliente = new ArrayList<Cliente>();
    private Cliente clienteSelecionado = new Cliente();
    private Cliente clienteAux = new Cliente();
    private String pesquisa;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DaoCliente getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Cliente getClienteAux() {
        return clienteAux;
    }

    public void setClienteAux(Cliente clienteAux) {
        this.clienteAux = clienteAux;
    }

    public void cadastrarCliente() {
        daoCliente.cadastrarCliente(cliente);
        this.cliente = null;
    }

    public List<Cliente> listar() {
        listaCliente = daoCliente.listarTudo();
        return listaCliente;
    }

    public void deletarCliente(Cliente c) {
        this.cliente = c;
        daoCliente.removerCliente(cliente);
    }

    public void alterarCliente() {
        daoCliente.alterarCliente(clienteSelecionado);
    }

    public List<Cliente> pesquisarClientePorNome() {

        return listaCliente;
    }

    public Cliente pesquisarClienteParaAtendimento() {
        clienteAux = null;
        clienteAux = daoCliente.pesquisarClienteParaAtendimento(pesquisa);
        return clienteAux;
    }

    public String abrirConta() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        session.setAttribute("clienteAux", this.clienteAux);
        return "/view/conta.xhtml";
    }

}
