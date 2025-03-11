import java.util.*;


// esta clase represta el factory en map, se encarga de crear el mapa segun la opcion que se le pase
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
