/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Scientist {
    // поля класса - хранят данные
    private int id_Scientist;
    private String name;
    private List<Biography> biography;
    
    
    // конструктор без параметров
    public Scientist() {
    }
    
    // конструктор с 3 параметрами, т.к. у параметров полностью такие же названия, 
    // то нужно указать слово this(принадлежит этому объекту)
    public Scientist(int id_Scientist, String name, List<Biography> biography) {
        this.id_Scientist = id_Scientist;
        this.name = name; 
        this.biography = biography;
    }
    
    // конструктор с 2 параметрами, кидаем пустой ArrayList<> в биографии
    public Scientist(int id_Scientist, String name) {
        this.id_Scientist = id_Scientist;
        this.name = name; 
        biography = new ArrayList<>();
    }

    // геттеры -  функции, которые получают значение полей объекта
    public int getid_Scientist() {
        return id_Scientist;
    }

    public String getName() {
        return name;
    }
    
    public List<Biography> getBiography() {
        return biography;
    }

    //сеттеры - устанавливают значения полей объекта(через параметр)

    public void setId_Scientist(int id_Scientist) {
        this.id_Scientist = id_Scientist;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBiography(List<Biography> biography) {
        this.biography = biography;
    }

    /* переопределение метода hashCode(), который возвращает уникальное
    * битовую строку фиксированной длины объекта. Одинаковые объекты содержат равные строки
    * подробнее: https://habrahabr.ru/post/168195/
    */
    @Override //Метод, аннотированный как @Override, должен переопределять метод супер класса
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_Scientist;
        hash = 41 * hash + Objects.hashCode(this.name);
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
        final Scientist other = (Scientist) obj; 
        if (this.id_Scientist != other.id_Scientist) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }        
        
        return true;
    }

    // Переопределение метода toString() в более удобный формат
    @Override
    public String toString() {
        return "Scientist{" + "id_Scientist=" + id_Scientist + ", name=" + name + ", biography=" + biography + '}';
    }
}
