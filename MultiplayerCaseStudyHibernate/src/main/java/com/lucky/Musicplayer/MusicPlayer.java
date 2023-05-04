package com.lucky.Musicplayer;

import java.util.Scanner;


import SongDAO.SongDAO;

public class MusicPlayer {

	private static boolean loop = true;
	private static int choice;
	private static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
	
	  musicPlayer();
   }

	

	public static void musicPlayer()  {

		while (loop) {
			System.out.println("choose the input");
			System.out.println("1. Add\n"
					+ "2. remove song \n"
					+ "3. edit song\n"
					+ "4:  play song\n"
					+ "5. Exit");
		

			choice = scanner.nextInt();
			
			switch (choice) {
			
			case 1:	System.out.println("choose the input..");
			        System.out.println("1. Add Song\n"
					+ "2. go back \n"
					+ "3. exit");
				choice=scanner.nextInt();

				switch (choice) {
				case 1:
				SongDAO.addSong();
					break;

				case 2:
					musicPlayer();
					break;
                     
				case 3 :
				System.out.println("Thank you.");
				loop = false;
				break;

			default:
				System.out.println("Invalid choice...");
				break;
			}
			break;
			
			
			case 2:
				SongDAO.deleteSong();
				break;
				
			case 3:
				SongDAO.updateSong();
				break;
				
			case 4:
				System.out.println("choose the song : ");
				SongDAO.selectSong();
				System.out.println("song is playing......");
				break;
				
			case 5: System.out.println("thank you...");
			loop=false;
			break;
		
			default:
				System.out.println("invalid choice");
				break;
			}
	}

  }
}

