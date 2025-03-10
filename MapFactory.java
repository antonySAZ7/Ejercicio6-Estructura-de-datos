import java.util.*;

public class MapFactory {


    public static Map<String, Pokemon> sabertipoMap(int opcion){
        switch (opcion) {
            case 1:
                return new HashMap<>();
                
            case 2:
                return new TreeMap<>();
            
            case 3:
                return new LinkedHashMap<>();
        
            default:
                System.out.println("Error, la opcion no es valida");
                return null;
                
        }
    }
    
}
