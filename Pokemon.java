public class Pokemon {
    private String name;
    private String pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private String height;       // Se almacena como String
    private String weight;       // Se almacena como String
    private String abilities;
    private String generation;   // Se almacena como String
    private String legendaryStatus;

    public Pokemon(String name, String pokedexNumber, String type1, String type2,
                   String classification, String height, String weight,
                   String abilities, String generation, String legendaryStatus) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    
    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    
    @Override
    public String toString() {
        return "Name: " + name + ", PokedexNumber: " + pokedexNumber +
               ", Type1: " + type1 + ", Type2: " + type2 +
               ", Classification: " + classification + 
               ", Height(m): " + height + ", Weight(kg): " + weight +
               ", Abilities: " + abilities + ", Generation: " + generation +
               ", Legendary: " + legendaryStatus;
    }
}
