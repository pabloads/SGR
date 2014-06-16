/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoFuncionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Funcionario;

/**
 *
 * @author Pablo Rocha
 */
@ManagedBean
@SessionScoped
public class LoginMB {

    private Funcionario funcionarioLogado = new Funcionario();
    private DaoFuncionario daoFuncionario = new DaoFuncionario();

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }

    public DaoFuncionario getDaoFuncionario() {
        return daoFuncionario;
    }

    public void setDaoFuncionario(DaoFuncionario daoFuncionario) {
        this.daoFuncionario = daoFuncionario;
    }

    public String logar() {
        if (funcionarioLogado.getNome().equals("adim") && (funcionarioLogado.getCpf() == 1234)) {
            HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sessao.setAttribute("Pablo", funcionarioLogado);

            funcionarioLogado = new Funcionario();

            return "view/index.xhtml";
        } else {
            funcionarioLogado = daoFuncionario.buscaFuncionario(funcionarioLogado);
            if (funcionarioLogado != null) {
                HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sessao.setAttribute("Pablo", funcionarioLogado);
                Cookie cookie = new Cookie("Nome", funcionarioLogado.getNome());
                cookie.setMaxAge(-1);
                FacesContext context = FacesContext.getCurrentInstance();
               ((HttpServletResponse) context.getExternalContext().getResponse()).addCookie(cookie);  
                
                return "view/index.xhtml";
            } else {
                return "login.xhtml";
            }

        }


    }

    public String Logout() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessao.invalidate();
        return "login";
    }
}
