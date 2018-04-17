package bio.dal;

import java.util.List;
import bio.model.Biography;
import org.apache.ibatis.session.SqlSession;

public class BiographyDal extends BaseDal {

    public BiographyDal() {
        // super() может использоваться в конструкторе для вызова конструктора 
        //родительского класса. Т.е. наследует создание фабрики sql-сессий
        super();
    }

    public List<Biography> selectAll() {
        // Создает и открывает sql сессию(подключение к бд) при помощи фабрики sqlSessionFactory
        SqlSession session = sqlSessionFactory.openSession();

        /* 
       * В лист<Biography> загружаются все биографии из таблицы. При помощи xml мапперов,
       * переводятся данные из сущностей БД(строка и связанные с ней строки) в данные 
       * модели Biography.java. Используются функции из того маппера biography.xml
         */
        List<Biography> list = session.selectList("biography.selectAll");
        // закрывает сессии
        session.close();
        // возвращает List<Biography> list
        return list;
    }

    /* Выбор биографии по id */
    public Biography selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Biography biography = session.selectOne("biography.selectById", id);
        session.close();
        return biography;
    }

    /* Удаления биографии по id */
    public int deleteById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("biography.deleteById", id);
        session.commit(); // принять изменение
        session.close();
        return count; // возвращает количество удаленных данных
    }

    /* Ввод биографии по передаваемому объекту */
    public int insert(Biography biography) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("biography.insert", biography);
        session.commit();
        session.close();
        return count; // возвращает количество введеных данных
    }

    /* Обновление биографии по передаваемому объекту */
    public int update(Biography biography) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("biography.update", biography);
        session.commit();
        session.close();
        return count; // возвращает количество измененных данных
    }
}
