/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author mixplick
 */
public class DaoFuncionario {
    
    private Session sessao;
    private Transaction trans;
    
    
    public boolean cadastrarFuncionario(Funcionario funcionario){
//        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.save(funcionario);
        trans.commit();
        return true;
//        } catch (Exception e){
//            e.printStackTrace();
//        } 
//        finally{
//           sessao.close(); 
//        }
//        return false;
    }
    
    public List listarTudo(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria c = sessao.createCriteria(Funcionario.class);
        return c.list();
    }
    public boolean removerFuncionanrio(Funcionario funcionario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(funcionario);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public Funcionario buscaFuncionario(Funcionario funcionario ){
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = sessao.createCriteria(Funcionario.class);
            cr.add(Restrictions.eq("nome", funcionario.getNome() ));
            cr.add(Restrictions.eq("cpf", funcionario.getCpf()));
            return (Funcionario) cr.uniqueResult();
           
            
        }

    
}