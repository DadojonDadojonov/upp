package bio.controllers;

import java.util.ArrayList;
import java.util.List;
import bio.model.Scientist;
import org.junit.Test;
import static org.junit.Assert.*;
import bio.model.Biography;

/*
 * Тестирование класса ScientistController.java
 */
public class ScientistControllerTest {

    public ScientistControllerTest() {
    }

    /*
     * Тест testGetAllScientists(), который должен вернуть всех ученых из БД
     */
    @Test
    public void testGetAllScientists() {

        ScientistController instance = new ScientistController(); // создание объекта ScientistController
        // Создаем лист, куда заносятся результаты функции getAllScientist(), т.е. объекты класса Scientist.java
        List<Scientist> result = instance.getAllScientists();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result != null && result.size() > 0);

    }

    /*
     * Тест getScientist(id_Scientist), который должен ученого по id из БД
     */
    @Test
    public void testGetScientist() {
        int id_Scientist = 2; // задаем любое id ученого
        ScientistController instance = new ScientistController(); // создание объекта ScientistController

        /*
         * getScientist(id_Scientist) возвращает объект Scientist по id( получает из БД
         * при помощи слоя DAL)
         */
        Scientist result = instance.getScientist(id_Scientist);
        System.out.println(result.toString()); // вывести результат
        assertTrue(result != null && result.getid_Scientist() == 2); // Тест пройден, если результат не равен null и id_Scientist() == 2
    }

    /*
     * Тест testInsertUpdateDeleteById(), который должен последовательно:
     * 1) Добавить(insert) ученого в БД;
     * 2) Обновить ученого из п.1;
     * 3) Удалить его.
     */
    @Test
    public void testInsertUpdateDeleteById() {
        ScientistController controller = new ScientistController();// создание объекта ScientistController

        /**
         * Тест insertScientist() в таблицу scientists
         */
        //Создание нового объекта Scientist 
        List<Biography>  scientistsList = new ArrayList<>(); // заглушка
        Scientist scientist = new Scientist(11, "Ломоносов Михаил Васильевич",  scientistsList);
        // Переменная INSERT показывает количество добавленных строк в таблицу scientists
        // controller.insertScientist(X) добавляет в таблицу данные объекта "X"
        int INSERT = controller.insertScientist(scientist);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);

        /**
         * Тест updateScientist в таблицу scientists
         */
        scientist = new Scientist(11, "Альберт Эйнштейн",  scientistsList);  // изменим объект        
        // Переменная UPDATE показывает количество обновленных строк в таблице scientists
        // controller.updateScientist(x) обновляет данные в таблице  scientists объектом x с id = x.getID()
        int UPDATE = controller.updateScientist(scientist);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);

        /**
         * Тест deleteScientist в таблице scientists
         */
        // Переменная DELETE показывает количество удаленных строк в таблице scientists(в данном случае либо 0, либо 1)
        // controller.deleteScientist(x) удаляет из таблицы scientists запись с id = x
        int DELETE = controller.deleteScientist(11);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);
    }

    /* Возвращает автоинкремент id в таблице scientists к 10:
     * ALTER TABLE scientists AUTO_INCREMENT = 10;
     */
}
