/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author mixplick
 */
public class DaoCliente {

    private Session sessao;
    private Transaction trans;

    public boolean cadastrarCliente(Cliente cliente) {
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.save(cliente);
        trans.commit();
        sessao.close();
        return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sessao.close();
        }
        return false;
    }

    public List listarTudo() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria c = sessao.createCriteria(Cliente.class);
            return c.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public boolean removerCliente(Cliente cliente) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(cliente);
        trans.commit();
        sessao.close();
        return true;
    }

    public boolean alterarCliente(Cliente cliente) {

        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(cliente);
        trans.commit();
        sessao.close();
        return true;

    }
}
