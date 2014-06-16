/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Funcionario;
import dao.DaoFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



@SessionScoped 
@ManagedBean(name = "funcionarioMB")
public class FuncionarioMB {
    
    private Funcionario funcionario = new Funcionario();
    private DaoFuncionario daoFuncionario= new DaoFuncionario();
    private Funcionario funcionarioSelecionado = new Funcionario();
    private List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    @ManagedProperty(value = "#{LoginMB}")
    private LoginMB loginMB = new LoginMB();
    
    
    

   
    public Funcionario getFuncionario() {
        return funcionario;
    }

   
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    public DaoFuncionario getDaoFuncionario() {
        return daoFuncionario;
    }

    
    public void setDaoFuncionario(DaoFuncionario daoFuncionario) {
        this.daoFuncionario = daoFuncionario;
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }
    
    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    
    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public void setLoginMB(LoginMB loginMB) {
        this.loginMB = loginMB;
    }

    public LoginMB getLoginMB() {
        return loginMB;
    }
    
    
    
    public void cadastrarFuncionario(){
        daoFuncionario.cadastrarFuncionario(funcionario);
        funcionario = null;
    }
    
    public List<Funcionario> listar(){
        listaFuncionario = daoFuncionario.listarTudo();
        return listaFuncionario;
    }
    public void deletarFuncionario(Funcionario f){
       this.funcionario = f;
       daoFuncionario.removerFuncionanrio(funcionario);
   }
    
   public void alterarFuncionario(){
       daoFuncionario.alterarFuncionario(funcionarioSelecionado);
       funcionarioSelecionado = null;
   }
}

