package bio.controllers;

import java.util.Date;
import java.util.List;
import bio.model.Biography;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Тестирование класса BiographyController.java
 */
public class BiographyControllerTest {

    public BiographyControllerTest() {
    }


    /*
     * Тест GetAllBiographies(), который должен вернуть все биографии из БД
     */
    @Test
    public void testGetAllBiographies() {
        BiographyController instance = new  BiographyController(); // Создаем сам объект класса BiographyController
        // Создаем лист, куда заносятся результаты функции getAllBiographies() из BiographyController, т.е. объекты класса Biography.java
        List<Biography> result = instance.getAllBiographies();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result != null && result.size() > 0);
        // Вывод для каждого элемента листа функции toString()(она в классе Biography.java).
        // в функции листа .forEach() используется лямбда выражение. Пример https://www.mkyong.com/java8/java-8-foreach-examples/
        result.forEach(x -> System.out.println(x.toString()));

    }

    /*
     * Тест getBiography(), который должен вернуть биографию по id
     */
    @Test
    public void testGetBiography() {
        int id = 1; // id биографии
        BiographyController instance = new BiographyController(); // создаем объект BiographyController
        /*
         * getBiography(id) возвращает объект Biography по id( получает от слоя BiographyDal)
         */
        Biography result = instance.getBiography(id);
        // Тест пройден, если результат не равен null и id == 1
        assertTrue(result != null && result.getId() == 1);
    }

    /*
     * Тест testInsertUpdateDeleteById(), который должен последовательно:
     * 1) Добавить(insert) биографии в БД;
     * 2) Обновить биографии из п.1;
     * 3) Удалить его.
     */
    @Test
    public void testInsertUpdateDeleteById() {        
        BiographyController controller = new BiographyController();// создание объекта BiographyController
        
        /**
         * Тест Insert в таблицу s_biography
         */
        //Создание нового объекта Biography 
       Biography biography = new Biography(
                11,
                "Российская Империя",
                "Ломоносов Михаил Васильевич (1711/1765) — русский писатель, ученый, поэт, общественный деятель. Получив всестороннее образование (в том числе и в зарубежных учебных заведениях), Ломоносов вел разнообразную исследовательскую деятельность в Российской академии наук. Именно благодаря Л. была создана химическая лаборатория, введены в систему образования новые дисциплины, открыты новые отрасли наук. Литературная деятельность Ломоносова тесно соприкасалась с научной.",
                new Date(1711, 11, 19),
                new Date(1765, 4, 15),
                11
        );
        // Переменная INSERT показывает количество добавленных строк в таблицу s_biography
        // controller.insert(X) добавляет в таблицу данные объекта "X"
        int INSERT =  controller.insertBiography(biography);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);
        
        /**
         * Тест Update в таблицу s_biography
         */
        // изменим объект      
        biography = new Biography(
                11,
                "Российская Империя",
                "Ломоносов Михаил Васильевич [8(19).11.1711, близ села Холмогоры Архангельской губернии, — 4(15).4.1765, Петербург], русский писатель и ученый, создатель русского силлаботонического стихосложения, основоположник отечественной поэтической культуры, первый русский естествоиспытатель. Сын государственного (не крепостного) крестьянина.",
                new Date(1711, 11, 19),
                new Date(1765, 4, 15),
                11
        );
        // Переменная UPDATE показывает количество обновленных строк в таблице s_biography
        // controller.update(x) обновляет данные в таблице biography объектом x с id = x.getID()
        int UPDATE =  controller.updateBiography(biography);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);
        
        /**
         * Тест DeleteById в таблице s_biography
         */
        // Переменная DELETE показывает количество удаленных строк в таблице s_biography(в данном случае либо 0, либо 1)
        // controller.deleteById(x) удаляет из таблицы s_biography запись с id = x
        int DELETE =  controller.deleteBiography(11);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);        
    }     
    
    /* Возвращает автоинкремент id в таблице s_biography к 10:
     * ALTER TABLE s_biography AUTO_INCREMENT = 10;
     */
}
