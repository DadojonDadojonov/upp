
package jsonMappers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import bio.model.Scientist;

// аналогично классу JsonBiographyMapper

public class JsonScientistMapper {
    
     public static String toJson(Scientist scientist)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(scientist);
        } catch (IOException ex) {
            Logger.getLogger(JsonScientistMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static String toJson(List<Scientist> scientists)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(scientists);
        } catch (IOException ex) {
            Logger.getLogger(JsonScientistMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static Scientist fromJson(String json)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Scientist.class);
        } catch (IOException ex) {
            Logger.getLogger(JsonScientistMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
