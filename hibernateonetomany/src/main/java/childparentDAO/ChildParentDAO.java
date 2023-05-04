package childparentDAO;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import childparentDTO.ChildDTO;
import childparentDTO.ParentDTO;

public class ChildParentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openconnection() {
		
		factory=Persistence.createEntityManagerFactory("onetMany");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	private static void closeconnectin() {
		if (factory !=null) {
			factory.close();
		}if (manager != null) {
			manager.close();
		}if (transaction.isActive()) {
			transaction.commit();
		}
	}
	public static void main(String[] args) {
		openconnection();
		transaction.begin();
		
		ChildDTO child1=new ChildDTO();
		child1.setId(1);
		child1.setName("Ram");
		child1.setAge(22);
		manager.persist(child1);
		
		ChildDTO child2=new ChildDTO();
		child2.setId(2);
		child2.setName("Sham");
		child2.setAge(25);
        manager.persist(child2);	
        
      List<ChildDTO> children= Arrays.asList(child1,child2);
        
        ParentDTO parent=new ParentDTO();
        parent.setId(1);
        parent.setName("Don");
        parent.setAge(50);
        parent.setChildren(children);
        manager.persist(parent);
		
		transaction.commit();
		closeconnectin();
	}
}
