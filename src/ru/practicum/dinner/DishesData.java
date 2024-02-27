package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;

//Создал отдельный класс для сохранения блюд добавленных пользователем
public class DishesData {
    HashMap<String, ArrayList<String>> dishesByType;
    DishesData(){
        dishesByType = new HashMap<>();
    }

    //Добавляю метод для добавления пользователем блюда
    void addDish(String typeOfDish, String dishName) {
        //Выполняем проверку на наличие введенного типа блюда
        if (dishesByType.containsKey(typeOfDish)) {
            ArrayList<String> dishes = dishesByType.get(typeOfDish);
            dishes.add(dishName);

        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByType.put(typeOfDish, dishes);
        }
    }
    // Проверяем наличие дубля блюда
    Boolean checkDish(String typeOfDish, String dishName) {
        return dishesByType.get(typeOfDish).contains(dishName);
    }

    // Метод для получения блюда по типу
    ArrayList<String> printDishesByType(String typeOfDish){
        ArrayList<String> dishesList = new ArrayList<>();
        for (String dishes : dishesByType.get(typeOfDish)) {
            dishesList.add(dishes);
        }
        return dishesList;
    }


    // Метод для получения количества блюд в категории
    ArrayList<String> getCountOfDishesByType(String typeOfDish){
        return dishesByType.get(typeOfDish);
    }

    Boolean checkDishesType(String typeOfDish){

        //Выполняем проверку на наличие введенного типа блюда
        return dishesByType.containsKey(typeOfDish);
    }

    Boolean isEmpty(){
        return dishesByType.isEmpty();
    }

}
