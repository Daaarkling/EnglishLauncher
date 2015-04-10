/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jan
 */
public class EnglishLessonCollection {

	private final EnglishLesson[] lessons = new EnglishLesson[31];

	public EnglishLessonCollection() {

		lessons[0] = new EnglishLesson("SCHOOL AND EDUCATION (1)", "1.ppsx", "rgb(216,176,136)");
		lessons[1] = new EnglishLesson("SCHOOL AND EDUCATION (2)", "2.ppsx", "rgb(216,176,136)");
		lessons[2] = new EnglishLesson("TRAVELLING (1)", "3.ppsx", "rgb(178,227,137)");
		lessons[3] = new EnglishLesson("TRAVELLING (2)", "4.ppsx", "rgb(178,227,137)");
		lessons[4] = new EnglishLesson("TRAVELLING (3)", "5.ppsx", "rgb(178,227,137)");
		lessons[5] = new EnglishLesson("HOME AND LIVING (1)", "6.ppsx", "rgb(242,115,175)");
		lessons[6] = new EnglishLesson("HOME AND LIVING (2)", "7.ppsx", "rgb(242,115,175)");
		lessons[7] = new EnglishLesson("HOME AND LIVING (3)", "8.ppsx", "rgb(242,115,175)");
		lessons[8] = new EnglishLesson("FAMILY (1)", "9.ppsx", "rgb(254,212,108)");
		lessons[9] = new EnglishLesson("CULTURE (1)", "10.ppsx", "rgb(81,218,255)");
		lessons[10] = new EnglishLesson("CULTURE (2)", "11.ppsx", "rgb(81,218,255)");
		lessons[11] = new EnglishLesson("CULTURE (3)", "12.ppsx", "rgb(81,218,255)");
		lessons[12] = new EnglishLesson("CULTURE (4)", "13.ppsx", "rgb(81,218,255)");
		lessons[13] = new EnglishLesson("CULTURE (5)", "14.ppsx", "rgb(81,218,255)");
		lessons[14] = new EnglishLesson("MASS MEDIA (1)", "15.ppsx", "rgb(171,185,222)");
		lessons[15] = new EnglishLesson("MASS MEDIA (2)", "16.ppsx", "rgb(171,185,222)");
		lessons[16] = new EnglishLesson("SHOPPING (1)", "17.ppsx", "rgb(216,176,136)");
		lessons[17] = new EnglishLesson("SHOPPING (2)", "18.ppsx", "rgb(216,176,136)");
		lessons[18] = new EnglishLesson("WORK AND EMPLOYMENT (1)", "19.ppsx", "rgb(178,227,137)");
		lessons[19] = new EnglishLesson("WORK AND EMPLOYMENT (2)", "20.ppsx", "rgb(178,227,137)");
		lessons[20] = new EnglishLesson("HEALTH AND DISEASES (1)", "21.ppsx", "rgb(242,115,175)");
		lessons[21] = new EnglishLesson("HEALTH AND DISEASES (2)", "22.ppsx", "rgb(242,115,175)");
		lessons[22] = new EnglishLesson("WEATHER (1)", "23.ppsx", "rgb(254,212,108)");
		lessons[23] = new EnglishLesson("WEATHER (2)", "24.ppsx", "rgb(254,212,108)");
		lessons[24] = new EnglishLesson("SPORT (1)", "25.ppsx", "rgb(81,218,255)");
		lessons[25] = new EnglishLesson("SPORT (2)", "26.ppsx", "rgb(81,218,255)");
		lessons[26] = new EnglishLesson("SPORT (3)", "27.ppsx", "rgb(81,218,255)");
		lessons[27] = new EnglishLesson("FOOD AND DRINKS (1)", "28.ppsx", "rgb(171,185,222)");
		lessons[28] = new EnglishLesson("FOOD AND DRINKS (2)", "29.ppsx", "rgb(171,185,222)");
		lessons[29] = new EnglishLesson("FOOD AND DRINKS (3)", "30.ppsx", "rgb(171,185,222)");
		
		EnglishLesson help = new EnglishLesson("NÁPOVĚDA", "help.pdf", "black");
		help.getStyleClass().add("button-extra");
		lessons[30] = help;
	}

	public EnglishLesson[] getLessons() {
		return lessons;
	}

	
	
	
	
	
	
}
