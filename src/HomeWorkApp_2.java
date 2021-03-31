//Дисциплина: Java.Уровень 1
//Домашнее задание №: 2 "Java.Основные конструкции"
//Студент: Алексей Пирогов
//Дата: 31.03.2021

import java.util.Scanner;

public class HomeWorkApp_2 {

    public static void main(String[] args) {

        String infoMessage = "Введите любое целое число интервале (-∞;+∞):";

        System.out.println("Задача 1.Проверка суммы вводимых вводимых целых чисел на принадлежность интервалу [10;20]:");
        compareSumWithInterval(inputNum(infoMessage), inputNum(infoMessage));

        System.out.println("Задача 2.Проверка вводимого числа на принадлежность множеству (-∞;0) U [0;+∞)");
        testPositiveOrNegative(inputNum(infoMessage));

        System.out.println("Задача 3.Проверка вводимого числа на принадлежность множеству отрицательных целых чисел (-∞;0)");
        testNegativeNum(inputNum(infoMessage));

        infoMessage = "Введите любое целое положительно число для указания количества повторений цикла:";
        System.out.println("Задача 4.Иллюстрация работы цикла for, while и do...while для повторения вводимой строки заданное количество раз");
        repeatString(inputString("Введите любую строку, окончанием ввода считается нажатие клавиши Enter:"), inputNum(infoMessage));
        pressAnyKey();

        System.out.println("Задача 5.Определение номера года на принадлежность множеству високосных годов");
        infoMessage = "Введите год - любое положительное число отличное от 0, но не более 6 знаков, ибо тормозит:";
        leapYear(inputNum(infoMessage));
    }

    //Ex.1 Проверка суммы двух чисел на принадлежность интервалу [10;20]
    public static boolean compareSumWithInterval(int varFirstNum, int varSecondNum) {
        boolean result;
        if (((varFirstNum + varSecondNum) >= 10) && ((varFirstNum + varSecondNum) <= 20)) {
            result = true;
            System.out.println("Сумма: " + (varFirstNum + varSecondNum) + " - принадлежит интервалу [10;20]. Result = " + result);
        } else {
            result = false;
            System.out.println("Сумма: " + (varFirstNum + varSecondNum) + " - НЕ принадлежит интервалу [10;20]. Result = " + result);
        }
        pressAnyKey();
        return result;
    }

    //Ex.2 Проверка целого числа на принадлежность множеству положительных или отрицательных чисел
    public static boolean testPositiveOrNegative(int varUnknown) {
        boolean result;

        if (varUnknown >= 0) {
            result = true;
            System.out.println("Число: " + varUnknown + " - принадлежит множеству [0;+∞). Result = " + result);
        } else {
            result = false;
            System.out.println("Число: " + varUnknown + " - принадлежит множеству (-∞;0). Result = " + result);
        }

        pressAnyKey();
        return result;
    }

    //Ex.3 Проверка целого числа на принадлежность множеству отрицательных чисел
    public static boolean testNegativeNum(int varUnknown) {
        boolean result;

        if (varUnknown < 0) {
            result = true;
            System.out.println("Число: " + varUnknown + " - принадлежит множеству (-∞;0). Result = " + result);
        } else {
            result = false;
            System.out.println("Число: " + varUnknown + " - НЕ принадлежит множеству (-∞;0). Result = " + result);
        }

        pressAnyKey();
        return result;
    }

    //Ex.4 Повтор вывода строки заданное число раз
    public static void repeatString(String varString, int varRepeat) {

        System.out.println("\n--- Пример работы цикла for ---");
        for (int i = 0; i <= varRepeat - 1; i++) {
            System.out.println(varString + "\t " + i + "-ая итерация цикла for");
        }

        System.out.println("\n--- Пример работы цикла while ---");
        int i = 0;    //инициализация счётчика для while
        while (i < varRepeat) {
            System.out.println(varString + "\t " + i + "-ая итерация цикла while");
            i++;
        }

        System.out.println("\n--- Пример работы цикла do...while ---");
        i = 0;      //инициализация счётчика для do...while
        do {
            System.out.println(varString + "\t " + i + "-ая итерация цикла do...while");
            i++;
        }
        while (i < varRepeat);
    }

    //Ex.5(*) Високосный год
    public static boolean leapYear(int numYear)
    {
        boolean result = false;
        String otherYear = "";  //Переменная для вывода строки с предыдущими годами
        int divisor = 1; //Делитель для подсчёта количества значений и столбцов в выходных данных

        if (numYear > 0) //год не может быть отрицательным... Хотя там в истории творилась дикая дичь!
        {
            if ((numYear % 4) == 0) //деление по модулю четыре и проверка остатка от деления на равенство нулю
            {
                if (((numYear % 100) != 0) && ((numYear % 400) != 0) || ((numYear % 100) == 0) && ((numYear % 400) == 0))
                {
                    System.out.println(numYear + " - год високосный! Перечень предыдущих високосных годов на основании математического подсчёта:");
                    result = true;
                }
                else
                {
                    System.out.println(numYear + " - невисокосный год! Перечень предыдущих високосных годов на основании математического подсчёта:");
                }
            }
            else
            {
                System.out.println(numYear + " - невисокосный год! Перечень предыдущих високосных годов на основании математического подсчёта:");
            }

            //Подсчёт количества предыдущих високосных годов
            for (int perevYear = 1; perevYear <= numYear; perevYear++)
            {
                if ((perevYear % 4) == 0)
                {
                    if (((perevYear % 100) != 0) && ((perevYear % 400) != 0) || ((perevYear % 100) == 0) && ((perevYear % 400) == 0))
                    {
                        //Разделение выводимых данных на столбцы и формирование строки
                        if ((divisor % 20) == 0)
                        {
                            otherYear += (perevYear + "\n"); //формирование строки путем конкатенации подстрок вида: <год> + \n
                            divisor++; //инкремент переенной отвечающей за количество подстрок/элементов множества вискокосных лет
                        }
                        else
                        {
                            //Форматированный вывод перечня предыдущих високосных лет
                            if (perevYear < 1000)
                            {
                                otherYear += (perevYear + "\t\t");
                            }
                            else
                            {
                                otherYear += (perevYear + "\t");
                            }
                            divisor++;
                        }
                    }
                }
            }
            System.out.println(otherYear);
            System.out.println("\nОбщее количество високосных лет: " + (--divisor) + ".");
        }
        else
        {
            if (numYear == 0)
            {
                System.out.println("Кхм ... \nСсылка на статью про нулевой год: https://ru.wikipedia.org/wiki/0_%D0%B3%D0%BE%D0%B4"+".");
            }
            else
            {
                System.out.println("Где-то в параллельной вселенной время идёт вспять, наверное, но это не точно!\nА пока можно прочитать про нулевой год: https://ru.wikipedia.org/wiki/0_%D0%B3%D0%BE%D0%B4"+".");
            }
        }
        return result;
    }

    //Заглушка для ожидания перехода к следующему шагу
    public static void pressAnyKey()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Нажмите любую кнопку для пеехода к следующему шагу...");
        in.nextLine();
    }

    //Функция для ввода числовых данных
    public static int inputNum(String infoMessage)
    {
        Scanner in = new Scanner(System.in);
        System.out.print(infoMessage);
        return in.nextInt();
    }

    //Функция для ввода строковых данных
    public static String inputString(String infoMessage) {
        Scanner in = new Scanner(System.in);
        System.out.print(infoMessage);
        return in.nextLine();
    }
}
