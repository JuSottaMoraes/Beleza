/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package beleza.belezasalao;

import persistencia.Clientes;
import persistencia.ClientesDAO;

/**
 *
 * @author juliana
 */
public class BelezaSalao {

    public static void main(String[] args) {
       
        
        ClientesDAO clientesDao = new ClientesDAO();

       Clientes c = new  Clientes();
        
        /*c.setNome("Pedro");
        c.setTelefone("123456789");
        c.setCPF("11223344556");
        c.setEmail("pe@");
        c.setEndereco("R dos Lirios");

       clientesDao.cadastrar(c);*/
        
        
        /* EntityManagerFactory fabricaEntidade = Persistence.createEntityManagerFactory("BelezaSalao-PU");
           EntityManager manager = fabricaEntidade.createEntityManager(); */
  

        /*manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();*/

        /*manager.close();
        fabricaEntidade.close();*/

    
    }
}
