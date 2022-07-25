//Task1
// Создайте метод, который будет принимать число
// в десятичной системе счисления, а возвращать в двоичной.

//Task2
//Обычно, когда вы что-то покупаете, вас спрашивают, верны ли номер вашей
// кредитной карты, номер телефона или ответ на ваш самый секретный вопрос.
// Однако, поскольку кто-то может заглянуть вам через плечо, вы не хотите,
// чтобы это отображалось на вашем экране. Вместо этого мы маскируем его.
//Ваша задача — написать функцию maskify, которая заменяет все символы,
// кроме последних четырех, на '#'.

//Task3
//Метод который вибирает в четном массиве единственное
// нечетное число и наоборот, в нечетном четное.

//Task4
// Напишите функцию , persistenceкоторая принимает положительный параметр
//,а возвращает его мультипликативное постоянство, то есть количество раз,
// которое вы должны умножить на цифры , пока не получите одну цифру.
//
//Например (Ввод --> Вывод) :
//
//39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
//999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
//4 --> 0 (because 4 is already a one-digit number)

//Task5
//Напишите функцию, которая принимает строку фигурных скобок и определяет,
// допустим ли порядок фигурных скобок. Он должен возвращаться true, если
// строка действительна и false недействительна.
//Все входные строки будут непустыми и будут состоять только из круглых,
// квадратных и фигурных скобок: ()[]{}.

//Task6
//Завершите функцию scramble(str1, str2), которая возвращает,
// trueесли часть str1символов можно переставить, чтобы они
// соответствовали str2, в противном случае возвращает false.





package com.company;
import java.math.BigInteger;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1");
        countBits(100);

        System.out.println("Task2");
        maskify("123545654546");

        System.out.println("Task3");
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        find(exampleTest1);
        find(exampleTest2);

        System.out.println("Task4");
        persistence(39);
        persistence(999);
        persistence(4);

        System.out.println("Task5");
        System.out.println(isValid("()"));
        System.out.println(isValid("[(])"));

        System.out.println("Task6");
        System.out.println(scramble("rkqodlw","world"));
        System.out.println(scramble("cedewaraaossoqqyt","codewars"));
        System.out.println(scramble("scriptjavx","javascript"));

    }

//Task1
    public static BigInteger countBits(int n) {
        String str = ""; //Создаем пуустую строку, которую будем заполнять цифрами 1 и 0
        for (int i = n; i >= 0; i = i / 2) {
            if (i == 1) {
                str += i;
                break;
            } else if (i == 0) {
                str += i;
                break;
            } else {
                str += i % 2;
            }
        }
        String rev = new StringBuilder(str).reverse().toString();//отзеркаливаем строку
        System.out.println("str = " + rev);
        BigInteger r = BigInteger.valueOf(Integer.valueOf(rev));//преобразим строку в число
        System.out.println("r = " + r);
        return r;
    }

   //Task2
    public static String maskify(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 4; i++) {
            charArray[i] = '#';
        }
        String s = new String(charArray);
        System.out.println(s);
        return new String(charArray);
    }

    //Task3
    static int find(int[] integers) {
        int even = 0;
        int evenInt = 0;
        int odd = 0;
        int oddInt = 0;

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                even++;
                evenInt = integers[i];
            } else if (integers[i] % 2 != 0) {
                odd++;
                oddInt = integers[i];
            }
        }
        if (even > odd) {
            System.out.println("N = " + oddInt);
            return oddInt;
        } else {
            System.out.println("N = " + evenInt);
            return evenInt;
        }
    }

  //Task4

    public static int persistence(long n) {
        int count = 0;
        while (true) {
            String s = "" + n;
            if (s.length() == 1) {
                System.out.println("Count = " + count);
                return count;
            } else {
                char[] arrChar = s.toCharArray();
                int[] arrInt = new int[s.length()];
                int c = 1;
                for (int i = 0; i < s.length(); i++) {
                    arrInt[i] = Character.getNumericValue(arrChar[i]);
                    c = c * arrInt[i];
                }
                n = c;
                count++;
            }
        }
    }


//Task5
    public static boolean isValid(String braces) {
        Map<Character, Character> brac = new HashMap<>();
        brac.put('}', '{');
        brac.put(']', '[');
        brac.put(')', '(');
        char[] arrCh = braces.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (Character c : arrCh) {
            if (brac.containsValue(c)) stack.push(c);
            else if (brac.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brac.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

//Task6

    public static boolean scramble(String str1, String str2) {
        char[] charStr1 = str1.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < charStr1.length; i++) {
            list.add(charStr1[i]);                 }
        char[] charStr2 = str2.toCharArray();
        LinkedList<Character> list2 = new LinkedList<>();
        for (int i = 0; i < charStr2.length; i++) {
            list2.add(charStr2[i]);
        }
        for (Character c : list2) {
            if (!list.contains(c) || list2.isEmpty()) {
                return false;
            } else if (list.contains(c)) {
                list.remove(c);
            }
        }
        return true;
    }
}



