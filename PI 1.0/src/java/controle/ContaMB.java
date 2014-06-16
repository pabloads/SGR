/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoConta;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelo.Cardapio;
import modelo.Cliente;
import modelo.Conta;

/**
 *
 * @author Pablo Rocha
 */
@ManagedBean(name = "contaMB")
@SessionScoped
public class ContaMB {

    private Conta conta = new Conta();
    private DaoConta daoConta = new DaoConta();
    private List<Conta> listaContas = new ArrayList<Conta>();
    private Conta contaSelecionada = new Conta();
    private boolean contaExiste = false;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public DaoConta getDaoConta() {
        return daoConta;
    }

    public void setDaoConta(DaoConta daoConta) {
        this.daoConta = daoConta;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public Conta getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(Conta contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
    }

    public boolean isContaExiste() {
        return contaExiste;
    }

    public void setContaExiste(boolean contaExiste) {
        this.contaExiste = contaExiste;
    }

    public void abrirConta() {
        daoConta.abrirConta(conta);
        this.conta = null;
    }

    public List<Conta> listarContas() {
        listaContas = daoConta.listarContas();
        return listaContas;
    }

    public void fazerPedido(Cardapio valor) {
        for (Conta conta1 : listaContas) {
            if (conta1.getIdConta() == contaSelecionada.getIdConta()) {
                contaExiste = true;
            }
        }

        if (contaExiste == false) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = (HttpSession) request.getSession();
            conta.setClienteidCliente((Cliente) session.getAttribute("clienteAux"));
            conta.setValor(valor.getValor());
            Date dataAtual = new Date();
            DateFormat dateformt = new SimpleDateFormat("dd/MM/yyyy");
            dateformt.format(dataAtual);
            conta.setData(dataAtual);
            daoConta.abrirConta(conta);
        } else {
            contaSelecionada.setValor(contaSelecionada.getValor() + valor.getValor());
            Date dataAtual = new Date();
            DateFormat dateformt = new SimpleDateFormat("dd/MM/yyyy");
            dateformt.format(dataAtual);
            conta.setData(dataAtual);
            daoConta.novoPedido(contaSelecionada);
        }
    }

//    public String prepararConta(Conta conta) {
//        contaSelecionada = conta;
//        return "/view/conta.xhtml";
//    }

}
