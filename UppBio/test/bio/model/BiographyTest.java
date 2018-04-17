/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*; 

/*
* Тестирование класса Biography.java
* Создание и сравнение
 */
public class BiographyTest {

    public BiographyTest() {
    }

    /*
    * Тест правильности создания  класса.
    * @Test задает функцию теста.
    * assertEquals(x, y) сравнивает параметры x и y.
    * Тест пройден, если параметры равны.
     */
    @Test
    public void testCreateBiography() {

        // Создание объекта класса Biography
        Biography biography = new Biography(1, "country1", "bio1", new Date(2000, 9, 25), new Date(2011, 9, 25), 1);
        // сравнивает параметры
        assertEquals(biography.getId(), 1);
        assertEquals(biography.getCountry(), "country1");
        assertEquals(biography.getBio(), "bio1");
        assertEquals(biography.getDob(), new Date(2000, 9, 25));
        assertEquals(biography.getDod(), new Date(2011, 9, 25));
        assertEquals(biography.getId_Scientist(), 1);
    }

    /*
     *
     * Тест сравнения объектов класса Biography
     */
    @Test
    public void testEquals() {
        // Создание 3 объектов: biography1 == biography2, biography1 != biography3
        Biography biography1 = new Biography(1, "country1", "bio1", new Date(2000, 9, 25), new Date(2011, 9, 25), 1);
        Biography biography2 = new Biography(1, "country1", "bio1", new Date(2000, 9, 25), new Date(2011, 9, 25), 1);
        Biography biography3 = new Biography(2, "country2", "bio2", new Date(2001, 9, 25), new Date(2012, 9, 25), 1);
        //.equals() - функция в классе Biography переопределена
        assertTrue(biography1.equals(biography2)); // тест пройден, если biography1 == biography2;
        assertFalse(biography1.equals(biography3)); // тест пройден, если biography1 != biography3
    }

}

