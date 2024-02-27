package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static ArrayList<String> typeOfDishes;
    static DishesData dishesData = new DishesData();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    printAllDishByType();
                    break;
                case "4":
                    return;
                case "5":
                    printAllDinner();
                    break;
                default:
                    System.out.println("Нет такой команды!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Просмотр списка блюд по типу");
        System.out.println("4 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();
        // делаем проверку на наличие уже такого названия и не пустой список
        if(!dishesData.isEmpty() && dishesData.checkDishesType(dishType) && dishesData.checkDish(dishType, dishName)){
            System.out.println("Блюдо с таким названием и типом уже добавлено в список.");
        } else {
            // добавьте новое блюдо
            dishesData.addDish(dishType, dishName);
            System.out.println("Добавил для типа " + dishType + " блюдо " + dishName );
        }
    }

    private static void printAllDishByType() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println(dishesData.printDishesByType(dishType));
    }

    private static void printAllDinner() {
        System.out.println("На текущий момент сгенерированы следующие варианты меню:");
        System.out.println(dc.limitCombination); // Дописать позже вывод списка
    }

    private static void generateDishCombo() {
        while(true) {
            typeOfDishes = new ArrayList<>(1);
            System.out.println("Начинаем конструировать обед...");
            int numberOfCombos;
            //Добавил ограничение по количеству одновременно комбинированных комбинаций через переменную limitCombination
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            numberOfCombos = scanner.nextInt();

            if (numberOfCombos < 1 || numberOfCombos > dc.limitCombination) {
                System.out.println("Вы ввел некорректное количество комбинаций.");
                System.out.println("Укажите значение в диапазоне от 1 до " + dc.limitCombination);
            } else {
                scanner.nextLine().trim();

                System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
                //scanner.nextLine();

                //реализуйте ввод типов блюд
                while (true) {
                    String nextItem = scanner.nextLine().trim();
                    if (nextItem.isEmpty()) {
                        break;
                    }
                    //Проверяем что для типа введенного блюда есть в наличии блюдо
                    if (dishesData.checkDishesType(nextItem)) {
                        typeOfDishes.add(nextItem);
                    } else {
                        System.out.println("Ты ввел невернный тип!");
                        return;
                    }
                }
            }
            for(int i = 1; i <= numberOfCombos; i++){
                System.out.println("Комбо " + i);
                for(String dishType : typeOfDishes) {
                    // сгенерируйте комбинации блюд
                    System.out.println(typeOfDishes.get(dc.generateDishCombo(dishType)));
                }

            }


        }
    }
}
