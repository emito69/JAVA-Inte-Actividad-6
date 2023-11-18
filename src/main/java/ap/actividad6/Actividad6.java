

package ap.actividad6;

import javax.persistence.EntityManager;
import persistencia.EntityManagerUtil;


public class Actividad6 {

    public static void main(String[] args) {
        
        EntityManager manager = EntityManagerUtil.getEntityManager();
        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
    }
}
