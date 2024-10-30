import java.util.ArrayList;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;

    public SolidIngredient(String name, double quantity) {
        this._name = name;
        this._quantity = quantity;
    }

    public String getName(){
        return this._name;
    }
    public double getQuantity(){
        return this._quantity;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;

    public LiquidIngredient(String name, double quantity){
        this._name = name;
        this._quantity = quantity;
    }

    public String getName(){
        return this._name;
    }
    public double getQuantity(){
        return this._quantity;
    }
}
class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(String name, String instructions) {
        this._name = name;
        this._instructions = instructions;
        this._ingredients = new ArrayList<T>();
    }
    private void addIngredient(T t){
        _ingredients.add(t);
    }
}