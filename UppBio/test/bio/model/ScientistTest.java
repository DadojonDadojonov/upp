/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Тестирование класса Scientist.java
 * Создание и сравнение
 */
public class ScientistTest {
    
    public ScientistTest() {
    }
    
   /*
    * Тест правильности создания класса.
    * @Test задает функцию теста.
    * assertEquals(x, y) сравнивает параметры x и y.
    * Тест пройден, если параметры равны.
     */
    @Test
    public void testCreateScientist() {
        
            // Создание 2 объектов Biography для добавления List<Biography> в объект класса Scientist
            Biography biography1 = new Biography(1, "country1", "bio1", new Date(2000, 9, 25), new Date(2011, 9, 25), 1);
            Biography biography2 = new Biography(2, "country2", "bio2", new Date(2001, 9, 25), new Date(2017, 8, 25), 2);
            // Создание List<Biography> и добавления туда biography1, biography2
            List<Biography> biographyList = new ArrayList<>();
            biographyList.add(biography1);
            biographyList.add(biography2);
            // Создание объекта класса Scientist(1, "name", biographyList);
            Scientist scientist = new Scientist(1, "name", biographyList);
            // // сравнивает параметры
            assertEquals(scientist.getid_Scientist(), 1);
            assertEquals(scientist.getName(), "name");
            assertEquals(scientist.getBiography(), biographyList);
    }
    /**
     * Тест проверки равенства и неравенства класса Scientist 	
     */
    @Test
    public void testEquals() {

            // Создание 2 объектов Biography для добавления List<Biography> в объект класса Scientist
            Biography biography1 = new Biography(1, "country1", "bio1", new Date(2000, 9, 25), new Date(2011, 9, 25), 1);
            Biography biography2 = new Biography(2, "country2", "bio2", new Date(2001, 9, 25), new Date(2017, 8, 25), 2);
            // Создание List<Biography> и добавления туда biography1, biography2
            List<Biography> biographyiList = new ArrayList<>();
            biographyiList.add(biography1);
            biographyiList.add(biography2);

            // Создание 3 объектов класса Scientist
            Scientist scientist1 = new Scientist(1, "name1", biographyiList);
            Scientist scientist2 = new Scientist(1, "name1", biographyiList);
            Scientist scientist3 = new Scientist(1, "name2", biographyiList);
            
            // Сравнение объектов scientist1, scientist2, scientist3
            assertTrue(scientist1.equals(scientist2)); // тест пройден, если scientist1 == scientist2;
            assertFalse(scientist1.equals(scientist3)); // тест пройден, если scientist1 == scientist3;
    }  
    
}

