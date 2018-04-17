package bio.dal;

import java.util.ArrayList;
import java.util.List;
import bio.model.Scientist;
import org.junit.Test;
import static org.junit.Assert.*;
import bio.model.Biography;

/*
 * Тестирование класса ScientistDal.java
 */
public class ScientistDalTest {
    
    public ScientistDalTest() {
    }
    
    /*
     * Тест SelectAll(), который должен вернуть всех ученых из БД
     */
    
    @Test
    public void testSelectAll() {
        
        ScientistDal instance = new ScientistDal(); // создание объекта ScientistDal
         // Создаем лист, куда заносятся результаты функции selectAll(), т.е. объекты класса Scientist.java
        List<Scientist> result = instance.selectAll();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result!=null && result.size()>0);

    }

    /*
     * Тест selectById(id_Scientist), который должен ученого по id из БД
     */
     @Test
    public void testSelectById() {       
        int id_Scientist = 2; // задаем любое id ученого
        ScientistDal instance = new ScientistDal(); // создание объекта ScientistDal
        
         /*
         * selectById(id_Scientist) возвращает объект Scientist по id( получает из БД и 
         * при помощи маппера scientist.xml конвертирует в объект класса Scientist)
         */
        Scientist result = instance.selectById(id_Scientist);
        System.out.println(result.toString()); // вывести результат
        assertTrue(result!=null && result.getid_Scientist()==2); // Тест пройден, если результат не равен null и id_Scientist() == 2
    }
    
    
    /*
     * Тест testInsertUpdateDeleteById(), который должен последовательно:
     * 1) Добавить(insert) ученого в БД;
     * 2) Обновить ученого из п.1;
     * 3) Удалить его.
     */
    @Test
    public void testInsertUpdateDeleteById() {        
        ScientistDal dal = new ScientistDal();// создание объекта ScientistDal
        
        /**
         * Тест Insert в таблицу scientists
         */
        //Создание нового объекта Scientist 
        List<Biography> biographyList = new ArrayList<>(); // заглушка
        Scientist scientist = new Scientist(11,"Ломоносов Михаил Васильевич", biographyList); 
        // Переменная INSERT показывает количество добавленных строк в таблицу scientists
        // dal.insert(X) добавляет в таблицу данные объекта "X"
        int INSERT =  dal.insert(scientist);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);
        
        /**
         * Тест Update в таблицу  scientists
         */
        scientist = new Scientist(11,"Альберт Эйнштейн", biographyList);  // изменим объект        
        // Переменная UPDATE показывает количество обновленных строк в таблице scientists
        // dal.update(x) обновляет данные в таблице  scientist объектом x с id = x.getID()
        int UPDATE =  dal.update(scientist);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);
        
        /**
         * Тест DeleteById в таблице scientists
         */
        // Переменная DELETE показывает количество удаленных строк в таблице scientists(в данном случае либо 0, либо 1)
        // dal.deleteById(x) удаляет из таблицы scientists запись с id = x
        int DELETE =  dal.deleteById(11);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);        
    }     
    
    /* Возвращает автоинкремент id в таблице scientists к 10:
     * ALTER TABLE scientists AUTO_INCREMENT = 10;
     */
}
