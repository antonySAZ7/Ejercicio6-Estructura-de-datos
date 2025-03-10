

import java.io.*;
import java.util.*;

public class ManejoCSV{

    public List<Pokemon> leerPokemones(String archivo){
        List<Pokemon> pokemones = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String inicio = br.readLine();
            String linea;
            while((linea =  br.readLine())!=null){
                String[] columnas = linea.split(",");
                if(columnas.length >= 10){
                    String name             = columnas[0].trim();
                    String pokedexNumber    = columnas[1].trim();
                    String type1            = columnas[2].trim();
                    String type2            = columnas[3].trim();
                    String classification   = columnas[4].trim();
                    String height           = columnas[5].trim();
                    String weight           = columnas[6].trim();
                    String abilities        = columnas[7].trim();
                    String generation       = columnas[8].trim();
                    String legendaryStatus  = columnas[9].trim();
                    Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                    pokemones.add(pokemon);
                }
            }
        } catch (IOException e){
            System.out.println("Error al leer el archivo:" + e.getMessage());
        }
        return pokemones;

    }



}