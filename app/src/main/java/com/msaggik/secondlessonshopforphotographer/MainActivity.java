package com.msaggik.secondlessonshopforphotographer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создадим поля
//  Бисквитные коржи - 10 монет ( + скидка 26%)
//
//Сливки - 14 монет ( + скидка 5%)
//
//Фрукты - 3 монеты ( + скидка 12%)
//
//Орехи - 5 монет ( + скидка 55%)
//
//Ягоды - 7 монет ( нет скидки)
//
//    На счету имеется 45 монет
    private float slivki = 14; // Сливки
    private int slivkiDis = 5; // Скидка на сливки
    private float bisquitCorji = 10; // Бисквитные коржи
    private int corjDis = 26; // Скидка на коржи
    private float fructi = 3; // Фрукты
    private int fructDis = 12; // Скидка на фрукты
    private float apex = 5; // Орехи
    private int apexDis = 55; // Скидка на орехи
    private float yagodi = 7; // Ягоды без скидки

    private float account = 45; // баланс на счету

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить фото-комплект
            possibilityOut.setText("Имеется достаточно средств для покупки торта, Спасибо за покупку!");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки фото-комплекта");
            balanceOut.setText(" - ");
        }
    }

    // метод подсчёта стоимости фото-комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (slivki * (100 - slivkiDis) + bisquitCorji * (100 - corjDis)
                + fructi * (100 - fructDis) + apex * (100 - apexDis)
                + yagodi) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки фото-комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность тортик
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }
}