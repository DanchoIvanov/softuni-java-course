package shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().equals("")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName(){
        return this.name;
    }

    public void buyProduct(Product product){
        if (product.getCost() > this.money){
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        } else {
            this.setMoney(this.money - product.getCost());
            this.products.add(product);
            System.out.printf("%s bought %s%n",this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()){
            return String.format("%s - Nothing bought", this.getName());
        } else {
            return String.format("%s - %s", this.getName(), products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
    }
}
