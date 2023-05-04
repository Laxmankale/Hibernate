package SongDAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucky.SongDTO.SongDTO;

public class SongDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager maneger;
	private static EntityTransaction transaction;
	private static Query query;
	private static String Query;
	private static Scanner scanner=new Scanner(System.in);
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("Song");
		maneger=factory.createEntityManager();
		transaction=maneger.getTransaction();		
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}if (maneger != null) {
			maneger.close();
		}if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void addSong() {
		openConnection();
		transaction.begin();
		
		SongDTO song1=new SongDTO();
		song1.setName("Taki_Taki");
		song1.setMovieName("Album");
		song1.setSingerName("DjSnake");
		song1.setLyricist("taki_taki....");
		song1.setDuration(5);
		maneger.persist(song1);
		
		
		SongDTO song2=new SongDTO();
		song2.setName("abc");
		song2.setMovieName("lkj");
		song2.setSingerName("lkjh");
		song2.setLyricist("lkj....");
		song2.setDuration(4);
		maneger.persist(song2);
		
		SongDTO song3=new SongDTO();
		song3.setName("Believer");
		song3.setMovieName("Music_video");
		song3.setSingerName("abc");
		song3.setLyricist("Believer....");
		song3.setDuration(6);
		maneger.persist(song3);
		
		transaction.commit();
		closeConnection();
	}
	
	public static void selectSong() {
		openConnection();
		transaction.begin();
		
		Query="from SongDTO";
		
		query=maneger.createQuery(Query);
		
		List<SongDTO> result=query.getResultList();
		for (SongDTO songDTO : result) {
			System.out.println(songDTO);	
		}
		transaction.commit();
		closeConnection();
	}	
	public static void updateSong() {
		openConnection();
		transaction.begin();
	
		Query="update SongDTO set duration=10 where id=5";
		
		query=maneger.createQuery(Query);
		int result=query.executeUpdate();
		System.out.println(result+ " rows affected");
		
		transaction.commit();
		closeConnection();
	
	}
	
	public static void deleteSong() {
		openConnection();
		transaction.begin();
		 Query="delete from SongDTO where id=6";
		query=maneger.createQuery(Query);
		
		int result=query.executeUpdate();
		System.out.println(result+ " rows affected");
		
		transaction.commit();
		closeConnection();
	
	}
}
