/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;



import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;



/**
 *
 * @author juliana
 */
public class UsuarioDAO {

    public Usuario ValidaLogin(String nome, String senha) {
        
         Usuario user = null;
         
               EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", Usuario.class);
            consulta.setParameter("nome", nome);
            consulta.setParameter("senha", senha);

            if (nome.equals(consulta.getSingleResult().getNome()) && senha.equals(consulta.getSingleResult().getSenha()));{
               user = consulta.getSingleResult();
            
        }
            
   } catch (Exception e) {
            System.out.println("Erro na validação: " + e.getMessage());
   }
   return user;
   
    }
}