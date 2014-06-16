/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Conta;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Pablo Rocha
 */
public class DaoConta {
    private Session sessao;
    private Transaction trans;

    public boolean abrirConta(Conta conta) {
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.save(conta);
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
    
    public List listarContas() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria c = sessao.createCriteria(Conta.class);
            return c.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public boolean novoPedido(Conta conta) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(conta);
        trans.commit();
        sessao.close();
        return true;

    }
}
