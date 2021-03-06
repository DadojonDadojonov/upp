package bio.dal;

import java.util.Date;
import java.util.List;
import bio.model.Biography;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Тестирование класса BiographyDal.java
 */
public class BiographyDalTest {

    public BiographyDalTest() {
    }


    /*
     * Тест SelectAll(), который должен вернуть все биографии из БД
     */
    @Test
    public void testSelectAll() {
        BiographyDal instance = new BiographyDal(); // Создаем сам объект класса Dal
        // Создаем лист, куда заносятся результаты функции selectAll(), т.е. объекты класса Biography.java
        List<Biography> result = instance.selectAll();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result != null && result.size() > 0);
        // Вывод для каждого элемента листа функции toString()(она в классе Biography.java).
        // в функции листа .forEach() используется лямбда выражение. Пример https://www.mkyong.com/java8/java-8-foreach-examples/
        result.forEach(x -> System.out.println(x.toString()));

    }

    /*
     * Тест SelectById(), который должен вернуть биографию по id
     */
    @Test
    public void testSelectById() {
        int id = 1; // id сбиографии
        BiographyDal instance = new BiographyDal(); // создаем объект BiographyDal
        /*
         * selectById(id) возвращает объект Biography по id( получает из БД и 
         * при помощи маппера biography.xml конвертирует в объект класса Biography)
         */
        Biography result = instance.selectById(id);
        // Тест пройден, если результат не равен null и id == 1
        assertTrue(result != null && result.getId() == 1);
    }

    /*
     * Тест testInsertUpdateDeleteById(), который должен последовательно:
     * 1) Добавить(insert) биографию в БД;
     * 2) Обновить биографию из п.1;
     * 3) Удалить ее.
     */
    @Test
    public void testInsertUpdateDeleteById() {
        BiographyDal dal = new BiographyDal();// создание объекта BiographyDal

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
        // dal.insert(X) добавляет в таблицу данные объекта "X"
        int INSERT = dal.insert(biography);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);

        /**
         * Тест Update в таблицу s_biography
         */
        // изменим объект (тут поменяли bio)
        biography = new Biography(
                11,
                "Российская Империя",
                "Ломоносов Михаил Васильевич [8(19).11.1711, близ села Холмогоры Архангельской губернии, — 4(15).4.1765, Петербург], русский писатель и ученый, создатель русского силлаботонического стихосложения, основоположник отечественной поэтической культуры, первый русский естествоиспытатель. Сын государственного (не крепостного) крестьянина.",
                new Date(1711, 11, 19),
                new Date(1765, 4, 15),
                11
        );
        // Переменная UPDATE показывает количество обновленных строк в таблице s_biography
        // dal.update(x) обновляет данные в таблице s_biography объектом x с id = x.getID()
        int UPDATE = dal.update(biography);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);

        /**
         * Тест DeleteById в таблице s_biography
         */
        // Переменная DELETE показывает количество удаленных строк в таблице s_biography(в данном случае либо 0, либо 1)
        // dal.deleteById(x) удаляет из таблицы s_biography запись с id = x
        int DELETE = dal.deleteById(11);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);
    }

    /* Возвращает автоинкремент id в таблице s_biography к 10:
     * ALTER TABLE s_biography AUTO_INCREMENT = 10;
     */
}
