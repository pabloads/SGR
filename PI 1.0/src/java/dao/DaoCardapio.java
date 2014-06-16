/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Cardapio;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Pablo Rocha
 */
public class DaoCardapio {
    private Session sessao;
    private Transaction trans;

    public boolean preencherCardapio(Cardapio cardapio) {
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.save(cardapio);
        trans.commit();
        return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sessao.close();
        }
        return false;
    }
    
    public List listarProdutosDoCardapio() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria c = sessao.createCriteria(Cardapio.class);
            return c.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public boolean deletarProduto(Cardapio cardapio) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(cardapio);
        trans.commit();
        sessao.close();
        return true;
    }

    public boolean editarCaradapio(Cardapio cardapio) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(cardapio);
        trans.commit();
        sessao.close();
        return true;
    }
}
