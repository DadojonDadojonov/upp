package bio.controllers;

import java.util.List;
import bio.dal.BiographyDal;
import bio.model.Biography;

/*
* Прослойка контроллер взаимодействует с DAL и API.
* Позволяет работать с полученными объктами модели Biography.java.
* Но здесь ничего не происходит.
*
*/

public class BiographyController 
{
    protected BiographyDal biographyDal; // Объявляется объект BiographyDal

    // конструктор класса
    public BiographyController() 
    {
        this.biographyDal = new BiographyDal(); // Создается переменная
    }
    
    // Обертка к функции selectAll() 
    public List<Biography> getAllBiographies()
    {
        return biographyDal.selectAll(); // вызов функции объекта BiographyDal, далее аналогично
    }
    
     // Обертка к функции selectById(id);
    public Biography getBiography(int id)
    {
        return biographyDal.selectById(id);
    }
    // Обертка к функции insert(biography);
    public int insertBiography(Biography biography)
    {
       return biographyDal.insert(biography);
    }
     // Обертка к функции update(biography);
    public int updateBiography(Biography biography)
    {
       return biographyDal.update(biography);
    }
    // Обертка к функции deleteById(id);
    public int deleteBiography(int id)
    {
       return biographyDal.deleteById(id);
    }
}
