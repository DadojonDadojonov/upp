/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dal;

import java.util.List;
import bio.model.Scientist;
import org.apache.ibatis.session.SqlSession;

public class ScientistDal extends BaseDal {

    /* 
        <класс наследуется от BaseDal, получая возможность создавать sql сессии>
        Сам класс преобразует данные из БД в объекты класса(модели) при помощи мапперов и библиотеки mybatis(my batis использует чужой connector к БД mysql-connector-java-5.1.23-bin.jar)
        Мапперы - (как шаблоны) показывают каким образом переводить сущности(связанные строки) из БД в объекты модели.
        А прослойка DAL уже преобразует, используя мапперы.
    */
    
    public ScientistDal() {
        // super() может использоваться в конструкторе для вызова конструктора 
        // родительского класса. Т.е. наследует создание фабрики sql-сессий
        super();
    }

    public List<Scientist> selectAll() {
        // Создает и открывает sql сессию(подключение к бд) при помощи фабрики sqlSessionFactory
        SqlSession session = sqlSessionFactory.openSession();
        /* 
         * В лист<Scientist> загружаются все ученые из таблицы. При помощи xml мапперов,
         * переводятся данные из сущностей БД(строка и связанные с ней строки) в данные 
         * модели Scientist.java. Используются функции из того маппера scientist.xml
         */
        List<Scientist> list = session.selectList("scientist.selectAll");
        session.close(); // закрывает sql сессию
        return list;
    }

    /* Выбор ученого по id */
    public Scientist selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Scientist scientist = session.selectOne("scientist.selectById", id);
        session.close();
        return scientist;
    }

    /* Удаление ученого по id */
    public int deleteById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("scientist.deleteById", id);
        session.commit(); // фиксация изменения в БД
        session.close();
        return count;
    }

    /* Ввод ученого по передаваемому объекту */
    public int insert(Scientist scientist) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("scientist.insert", scientist);
        session.commit();
        session.close();
        return count;
    }

    /* Обновление ученого по передаваемому объекту */
    public int update(Scientist scientist) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("scientist.update", scientist);
        session.commit();
        session.close();
        return count;
    }
}
