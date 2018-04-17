/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.model;

import java.util.Date;
import java.util.Objects;

public class Biography {
    
    // поля класса - хранят данные
    private int id; // id биографии
    private String country;   // страна  
    private String bio; // биография
    private Date dob; // дата рождения
    private Date dod; // дата смерти
    private int id_Scientist; // id ученого
    
    // конструктор без параметров
    public Biography() {
    }
    
    // конструктор с параметрами, т.к. у параметров полностью такие же названия, 
    // то нужно указать слово this(принадлежит этому объекту)
    public Biography(int id, String country, String bio, Date dob, Date dod, int id_Scientist) {
        this.id = id;
        this.country = country;        
        this.bio =  bio;
        this.dob = dob;
        this.dod = dod;
        this.id_Scientist = id_Scientist;
    }

    // геттеры -  функции, которые получают значение полей объекта
    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getBio() {
        return bio;
    }

    public Date getDob() {
        return dob;
    }
    
    public Date getDod() {
        return dod;
    }
    
    public int getId_Scientist() {
        return id_Scientist;
    }
    
    //сеттеры - устанавливают значения полей объекта(через параметр)

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public void setDod(Date dod) {
        this.dod = dod;
    }
    
    public void setId_Scientist(int id_Scientist) {
        this.id_Scientist = id_Scientist;
    }

    /* переопределение метода hashCode(), который возвращает уникальное
    * битовую строку фиксированной длины объекта. Одинаковые объекты содержат равные строки
    * подробнее: https://habrahabr.ru/post/168195/
    */
    @Override //Метод, аннотированный как @Override, должен переопределять метод супер класса
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.country);        
        hash = 41 * hash + Objects.hashCode(this.bio);        
        hash = 41 * hash + Objects.hashCode(this.dob);
        hash = 41 * hash + Objects.hashCode(this.dod);
        hash = 41 * hash + this.id_Scientist;
        return hash;
    }

    /* переопределение метода equals(Object obj); 
    * Этот метод получает объект в качестве аргумента, выполняет сравнение 
    * и возвращает true, если два экземпляра объекта равны, 
    * и false в случае их неравенства.
    * 
    * метод equals по умолчанию сравнивает только адреса двух объектов, 
    * а не их содержимое. Чтобы сравнить содержимое двух объектов мы должны 
    * переопределить метод equals. 
    */
    @Override
    public boolean equals(Object obj) {
        // если этот объект(у которого вызвана функция) равен объекту с параметра
        if (this == obj) {
            return true;
        }
        // если переданный объект == null
        if (obj == null) {
            return false;
        }
        // если у сравниваемых объектов разные классы
        if (getClass() != obj.getClass()) {
            return false;
        }
        /* Просто сравнение всех полей у объектов
        * Переменные final не инициализируются по умолчанию, им необходимо явно присвоить 
        *значение при объявлении или в конструкторе, иначе – ошибка компиляции: 
        *(Biography) - показывает с каким классом ассоциировать переданный объект
        */
        final Biography other = (Biography) obj; 
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        if (!Objects.equals(this.dod, other.dod)) {
            return false;
        }
        if (this.id_Scientist != other.id_Scientist) {
            return false;
        }
        
        return true;
    }

    // Переопределение метода toString() в более удобный формат
    @Override
    public String toString() {
        return "Biography{" + "id=" + id + ", country=" + country + ", bio=" + bio + ", dob=" + dob + ", dod=" + dod + ", id_Scientist=" + id_Scientist + '}';
    }
    
}
