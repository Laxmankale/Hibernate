package com.lucky.SongDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Songs")
public class SongDTO {

		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String name; 
		
		private String singerName;
		
		private String movieName;
		
		private int duration;
		
		private String lyricist;
		
}
