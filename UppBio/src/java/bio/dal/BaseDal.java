package bio.dal;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Класс создания sql сессий. Его наследуют все остальные файлы Dal
public class BaseDal 
{
    // переменная для создания sql фабрики. Если поле или метод класса объявлен с модификатором 
    // protected, то он доступен не только внутри самого класса, 
    // но и внутри всех классов-наследников:
    protected SqlSessionFactory sqlSessionFactory; 
    
    public BaseDal() 
    {
        /* 
         *  Класс Reader обеспечивает поддержку символьного потока чтения, 
         *  реализующий модель байтового потока ввода.
         */
        Reader reader = null;
        try 
        {
            /* 
             * Читает файл config.xml: там находятся информация для подключения к БД(логин пароль,
             * адрес подключения), использование библиотеки mysql-connector-java(т.к. mybatis 
             * не имеет своего коннектора), какие мапперы есть в проекте.
             */ 
            reader = Resources.getResourceAsReader("bio/mybatis/config.xml");
            // На основе reader'а строится Фабрика SQL-сессий
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            
            System.out.println("Успешное подключение к БД");
        } 
        catch (IOException ex) // ловит исключения(ошибки) и выводит их.
        {
            Logger.getLogger(BaseDal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        
}
