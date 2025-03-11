import java.util.*;
// esta clase es el main, presenta la funcion del programa
public class Principal {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        // menu para eligir el tipo de map que se va a usar
        System.out.println("Bienvenido al programa de Pokemones");
        System.out.println("Por seleccione el tipo de mapa que desea utilizar");
        System.out.println("1.- HashMap");
        System.out.println("2.- TreeMap");
        System.out.println("3.- LinkedHashMap");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        Map<String, Pokemon> pokemontipoMap = MapFactory.sabertipoMap(opcion);

        ManejoCSV manejo = new ManejoCSV();
        List<Pokemon> pokemones = manejo.leerPokemones("pokemon_data_pokeapi.csv");

        for(Pokemon pokemon : pokemones){
            pokemontipoMap.put(pokemon.getName(), pokemon);
        }

        Set<Pokemon> pokemonesPropio = new LinkedHashSet<>();
        // Se usa LinkedHashSet porque:
        // 1. Evita duplicados automaticamente.
        // 2. Mantiene el orden de inserción.
        // 3. La busqueda de elementos es rapida (O(1) en promedio).


        int contador = 0;
        // menu para elegir entre las 6 opciones
        while (contador == 0){
            System.out.println("Menu de Operaciones:");
            System.out.println("1. Agregar un Pokemon a la coleccion del usuario.");
            System.out.println("2. Mostrar los datos de un Pokemon.");
            System.out.println("3. Mostrar nombre y tipo1 de la colección del usuario .");
            System.out.println("4. Mostrar nombre y tipo1 de todos los Pokemones .");
            System.out.println("5. Mostrar el nombre del Pokemon que tiene la habilidad indicada.");
            System.out.println("6. Salir.");
            System.out.print("Ingrese una opcion: ");
            int opcionMenu = scanner.nextInt();
            scanner.nextLine();


            // switch para elegir la opcion
            switch (opcionMenu) {
                case 1:
                System.out.print("Ingrese el nombre del Pokemon a agregar: ");
                String nombreNuevoPokemon = scanner.nextLine();
                if(!pokemontipoMap.containsKey(nombreNuevoPokemon)){
                    System.out.println("El Pokemon no existe en la base de datos.");
                } else {
                    Pokemon pokemonNuevo = pokemontipoMap.get(nombreNuevoPokemon);
                    if(pokemonesPropio.contains(pokemonNuevo)){
                        System.out.println("El Pokemon ya se encuentra en la coleccion del usuario.");
                    } else {
                        pokemonesPropio.add(pokemonNuevo);
                        System.out.println("Se agrego el pokemon a la coleccion del usuario.");
                    }
                    
                }
                    break;

                // case para mostrar los datos de un pokemon
                case 2: 
                System.out.print("Ingrese el nombre del pokemon que quiera ver: ");
                String buscarPokemon = scanner.nextLine();  
                if(!pokemontipoMap.containsKey(buscarPokemon)){
                    System.out.println("El Pokemon no existe en la base de datos.");
                } else {
                    System.out.println("   Datos del pokemon: ");
                    System.out.println(pokemontipoMap.get(buscarPokemon));}
                    break;
                // case para mostrar los pokemones del usuario
                case 3:
                if(pokemonesPropio.isEmpty()){
                    System.out.println("No hay Pokemones en la coleccion del usuario.");
                } else {
                    List<Pokemon> listaUsuario = new ArrayList<>(pokemonesPropio);
                    listaUsuario.sort(Comparator.comparing(Pokemon::getType1));
                    System.out.println("Esta es la colleccion del usuario ordenada por el tipo 1: ");
                    for (Pokemon pokemon : listaUsuario){
                        System.out.println("Nombre: " + pokemon.getName() + ", Tipo1: " + pokemon.getType1());
                    }
                }                    
                    break;
                // case para mostrar todos los pokemones
                case 4:
                // Complejidad de esta operacion:
                // 1. Obtener los valores del Map → O(n)
                // 2. Convertir a lista → O(n)
                // 3. Ordenar con Collections.sort() (TimSort) → O(n log n)
                // TOTAL: O(n log n)
                List<Pokemon> listaCompleta = new ArrayList<>(pokemontipoMap.values());
                listaCompleta.sort(Comparator.comparing(Pokemon::getType1));
                System.out.println("Esta es la lista completa de pokemones ordenada por el tipo 1: ");
                for (Pokemon pokemon : listaCompleta){
                    System.out.println("Nombre: " + pokemon.getName() + ", Tipo1: " + pokemon.getType1());
                }
                
                    break;
                // case para buscar por habilidad
                case 5: 
                System.out.print("Ingrese la habilidad que desea buscar: ");
                String habilidad = scanner.nextLine();
                boolean encontrado = false;
                System.out.println("Estos son los pokemones con esta habiliada: " + habilidad + " : ");
                for(Pokemon pokemon : pokemones){
                    if(pokemon.getAbilities() != null && pokemon.getAbilities().toLowerCase().contains(habilidad.toLowerCase())){
                        System.out.println(pokemon.getName());
                        encontrado = true;
                    }
                }
                if (!encontrado){
                    System.out.println("No se encontro ningun pokemon con esta habilidad: " + habilidad);
                }
                    break;
                // salir del programa
                case 6:
                    contador++;
                    System.out.println("Gracias por usar el programa, byeeeee.");
                    break;

            
                default:
                    System.out.println("Error, eliga una opcion valida");
            }

        }


    }
    
}
