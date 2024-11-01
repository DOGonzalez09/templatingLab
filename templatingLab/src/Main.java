import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _solidQnty;

    public SolidIngredient(String name, double quantity) {
        this._name = name;
        this._solidQnty = quantity;
    }

    public String getName(){return this._name;}
    public double getQuantity(){
        return this._solidQnty;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _liquidQnty;

    public LiquidIngredient(String name, double quantity){
        this._name = name;
        this._liquidQnty = quantity;
    }

    public String getName(){
        return this._name;
    }
    public double getQuantity(){
        return this._liquidQnty;
    }
}
//Extends is used with T to only allow classes that Implement an interface
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
            System.out.println("Recipe: " + _name);
            System.out.println("Instructions: " + _instructions);
            System.out.println("Ingredients: ");
            for(T t: _ingredients){
                System.out.println(t.getName() + ": " + t.getQuantity());
            }
        }
        else System.out.println("Empty");
    }
}

public class Main{
    public static int menu(Scanner s){
        int i = s.nextInt();
        return i;
    }
    public static void addIng(Recipe<Ingredient> r ,Scanner s){
        System.out.println("is this Liquid(l) or Solid(s)");
        try{

        }catch (Exception e){
            System.out.println("No");
        }
        char type = s.nextLine().charAt(0);
        System.out.println("Enter Ingredient Name");
        String name = s.nextLine();
        System.out.println("Enter Quantity");
        double quant = Double.parseDouble(s.nextLine());
        Ingredient ingredient;
        if (type == 's'){
            ingredient = new SolidIngredient(name,quant);
        }
        else{
            ingredient = new LiquidIngredient(name,quant);
        }
        r.addIngredient(ingredient);
    }
    public static void main(String args[]){
        Recipe<Ingredient> recipe = null;
        String n, i;

        Scanner key = new Scanner(System.in);

        System.out.println("Enter Name of Recipe"); n = key.nextLine();
        System.out.println("Enter Instructions of Recipe"); i = key.nextLine();

        System.out.println("1 to add Ingredient\n2 to print\n3 to exit");
        int choice = 0;
        recipe = new Recipe<>(n,i);
        try{
            choice  = Integer.valueOf(key.nextLine());
        }
        catch (Exception e){
            System.out.println("NO");
        }

        while(choice != 3){
            switch (choice) {
                case 1 -> addIng(recipe,key);
                case 2 -> recipe.print();
                default -> System.out.println("Invalid");
            }
            choice = key.nextInt();

        }
    }
}