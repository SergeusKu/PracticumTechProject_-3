package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.Random;
public class DinnerConstructor {
    int numberDishes = 3;
    int limitCombination = 10;
    //Объявляю двумерный список вариантов ужинов
    ArrayList<ArrayList<Integer>> dinners = new ArrayList<>(numberDishes);
    DishesData dishesByType = new DishesData();
    Random random = new Random();

    Integer generateDishCombo(String dishesTypes) {
        //Для каждого типа получаем случайное блюдо
        //dishesByType.getCountOfDishesByType(dishesTypes).size();
        return random.nextInt(5)+1;
    }

}
