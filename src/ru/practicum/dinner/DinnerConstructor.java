package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.Random;
public class DinnerConstructor {
    int limitCombination = 10;
    //Объявляю двумерный список вариантов ужинов
    Random random = new Random();

    String generateDishCombo(ArrayList<String> dishesTypes) {
        //Для каждого типа получаем случайное блюдо
        int randomNumber = random.nextInt(dishesTypes.size());
        // Возвращаем случайное из полученных блюд
        return dishesTypes.get(randomNumber);
    }
}
