package com.company;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Comparator<Product> pcomp = new ProductNameComparator().thenComparing(new ProductAgeComparator());
        TreeSet<Product> product = new TreeSet(pcomp);
        product.add(new Product("Гречка", 2));
        product.add(new Product("Макароны", 5));
        product.add(new Product("Сыр", 7));
        product.add(new Product("Колбаса", 3));
        product.add(new Product("Хлеб", 1));
        product.add(new Product("Молоко", 4));
        product.add(new Product("Йогурт", 9));

        for(Product  p : product){
            System.out.println(p.getName() + " " + p.getCount());
        }

    }
    static class Product{
        private String name;
        private int count;
        public Product(String name, int count){
            this.name=name;
            this.count=count;
        }
        String getName(){return name;}
        int getCount(){return count;}
    }

    static class ProductNameComparator implements Comparator<Product> {
        public int compare(Product a, Product b){
            return a.getName().compareTo(b.getName());
        }
    }
    static class ProductAgeComparator implements Comparator<Product>{
        public int compare(Product a, Product b){
            if(a.getCount()> b.getCount())
                return 1;
            else if(a.getCount()< b.getCount())
                return -1;
            else
                return 0;
        }
    }
}