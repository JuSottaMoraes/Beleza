/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
  
  public class ClientesDAO {

    public void cadastrar(Clientes c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();

        }
    }

    public List<Clientes> listar(String txtNome) {
        EntityManager em = JPAUtil.getEntityManager();
        List despesas = null;
        try {
            String textoQuery = "SELECT c FROM Clientes c "
                    + " WHERE (:nome is null OR c.nome LIKE :nome ) ";
                   
            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter("nome", txtNome.isEmpty() ? null : "%" + txtNome + "%");
            despesas = consulta.getResultList();
            
        } finally {
            JPAUtil.closeEtityManager();
        }
        return despesas;
      }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Clientes c = em.find(Clientes.class, id);
            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public Clientes obter(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public void atualizar(Clientes c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
        JPAUtil.closeEtityManager();
    }
        
    }
  }
