package dishOrder.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishApp {
    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> orderedDish = new ArrayList<>();

    public static void main(String[] args) {
        initDish();
        Scanner s = new Scanner(System.in);
        while (true) {
            showMenu();
            int num = s.nextInt();

            switch(num) {
                case 1:
                    while (true) {
                        dishMenu();
                        int id = s.nextInt();
                        if (id == 0) break;

                        Dish dish = dishList.get(id - 1);
                        System.out.println("您点了: " + dish.name);
                        orderedDish.add(dish);
                    }
                    break;
                case 2:
                    orderedDish();
                    break;
                case 3:
                    pay();
                    return; //结束整个程序
            }
        }
    }

    public static void dishMenu() {
        System.out.println("----请您点餐----");
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("----输入序号点餐，按0返回上一级----");
    }

    public static void orderedDish() {
        Scanner scan = new Scanner(System.in);

        System.out.println("----您已点的菜品----");

        for (int i = 0; i < orderedDish.size(); i++) {
            Dish dish = orderedDish.get(i);
            System.out.println(dish.name + "\t" + dish.price);
        }

    }

    public static void pay() {
        System.out.println("----正在结账----");

        double total = 0f;
        for (int i = 0; i < orderedDish.size(); i++) {
            total += orderedDish.get(i).price;
        }

        System.out.println("----您一共消费了 " + total + " 元");



    }

    public static void showMenu() {
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("----请选择编号----");
    }

    public static void initDish() {
        Dish dish1 = new Dish(1, "香辣肉丝", 29.0);
        dishList.add(dish1);
        Dish dish2 = new Dish(2, "炖王八", 59.0);
        dishList.add(dish2);
        dishList.add(new Dish(3, "家常凉菜", 21.0));
        dishList.add(new Dish(4, "地三鲜", 24.0));
        dishList.add(new Dish(5, "油焖大虾", 55.0));
    }
}
