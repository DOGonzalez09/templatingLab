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
    public void setName(String name){
        this._name = name;
    }
    public double getQuantity(){
        return this._quantity;
    }
    public void setQuantity(double quantity){
        this._quantity = quantity;
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
    public void setName(String name){
        this._name = name;
    }
    public double getQuantity(){
        return this._quantity;
    }
    public void setQuantity(double quantity){
        this._quantity = quantity;
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
    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public void print() {
        if(_ingredients != null) {
            System.out.println("Value: " + _ingredients);
        }
        else System.out.println("Empty");
    }
}
public class Main{
    public static void main(String args[]){

    }
}