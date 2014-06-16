/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import dao.DaoCardapio;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cardapio;

/**
 *
 * @author Pablo Rocha
 */
@ManagedBean (name = "cardapioMB")
@SessionScoped
public class CardapioMB {
    private Cardapio cardapio = new Cardapio();
    private DaoCardapio daoCardapio = new DaoCardapio();
    private List<Cardapio> listaCardapio = new ArrayList<Cardapio>();
    private Cardapio produtoSelecionado = new Cardapio();

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public DaoCardapio getDaoCardapio() {
        return daoCardapio;
    }

    public void setDaoCardapio(DaoCardapio daoCardapio) {
        this.daoCardapio = daoCardapio;
    }

    public List<Cardapio> getListaCardapio() {
        return listaCardapio;
    }

    public void setListaCardapio(List<Cardapio> listaCardapio) {
        this.listaCardapio = listaCardapio;
    }

    public Cardapio getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Cardapio produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    
    public void preencherCardapio(){
        try {
                if (cardapio.getValor() < 0){
                throw new ValorNegativoException(cardapio.getValor());
            } else {
                daoCardapio.preencherCardapio(cardapio);
            }
        } catch (ValorNegativoException e) {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor negativo: " + e.getValor() + "insira um valor positivo" ));
         e.printStackTrace();
        } 
    }
    
    public List<Cardapio> listarProdutosDoCardapio(){
        listaCardapio = daoCardapio.listarProdutosDoCardapio();
        return listaCardapio;
    }
    
    public void deletarProduto(Cardapio p) {
        this.cardapio = p;
        daoCardapio.deletarProduto(cardapio);
    }
    
    public void editarCardapio(){
        daoCardapio.editarCaradapio(produtoSelecionado);
    }
    
}
