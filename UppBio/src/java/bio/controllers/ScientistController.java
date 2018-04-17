package bio.controllers;

import java.util.List;
import bio.dal.ScientistDal;
import bio.model.Scientist;

/*
* Прослойка контроллер взаимодействует с DAL и API.
* Позволяет работать с полученными объктами модели Scientist.java.
* Смотри BiographyController!
*
*/
public class ScientistController 
{
    protected ScientistDal scientistDal;

    public ScientistController () 
    {
        this.scientistDal = new ScientistDal();
    }
    
    public List<Scientist> getAllScientists()
    {
        return scientistDal.selectAll();
    }
    
    public Scientist getScientist(int id)
    {
        return scientistDal.selectById(id);
    }
    
    public int insertScientist(Scientist scientist)
    {
       return scientistDal.insert(scientist);
    }
    
    public int updateScientist(Scientist scientist)
    {
       return scientistDal.update(scientist);
    }
    
    public int deleteScientist(int id)
    {
       return scientistDal.deleteById(id);
    }
}
