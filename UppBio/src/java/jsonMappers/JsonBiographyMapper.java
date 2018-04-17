
package jsonMappers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper; //подрубается библиотека jackson
import bio.model.Biography;

/*Класс позволяет достаточно просто преобразовывать JSON в модель Biography.java и наоборот*/
// Используется в сервлетах

public class JsonBiographyMapper {
    
    // в json 1 объект ( на вход получает объект Biography)
     public static String toJson(Biography biography)   {
        try {
            ObjectMapper mapper = new ObjectMapper(); // создается объект ObjectMapper( они из библиотеки jackson/занимается самим преобразованием строки в объект)
            return mapper.writeValueAsString(biography); // возвращает строку json, созданную из объекта модели
        } 
        catch (IOException ex) // или возвращает исключение(ловит ошибку и выводит ее)
        {
            Logger.getLogger(JsonBiographyMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     // в json лист объектов ( на вход получает лист объектов Biography)
     public static String toJson(List<Biography> biographies)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(biographies);
        } catch (IOException ex) {
            Logger.getLogger(JsonBiographyMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     // из json'a в объект (на вход получает строку json)
     public static Biography fromJson(String json)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Biography.class); // читает json строку и преобразовывает ее в объект класса Biography
        } catch (IOException ex) {
            Logger.getLogger(JsonBiographyMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
