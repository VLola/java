import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static String center = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    public static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {


        while (true){
            System.out.println(ANSI_CYAN + "Задача 1: Вывести имя и фамилию посреди консоли.");
            System.out.println("Задача 2: Вывести в консоль ФИО и под ними дату рождения в \" \"");
            System.out.println("Задача 3: Принять у юзвера имя и фамилию и вывести их посреди консоли");
            System.out.println("Задача 4: Принять у пользователя его возраст и вывести сколько дней он живет ");
            System.out.println("Задача 5: Принять у пользователя полную дату рождения и вывести сколько ему дней");
            System.out.println("Задача 6: Принять у пользователя его дату рождения и вывести разницу в днях с след знаком зодиака");
            System.out.println("Задача 7: Принять у пользователя данные о рождения и вывести его знак в Китайском зодиаке");
            System.out.println("Задача 8: Принять у пользователя 7 чисел поместив их в массив и вывести разделяя через | ");
            System.out.println("Задача 9: Принять у пользователя массив на 9 числе и вывести через - только четные ячейки");
            System.out.println("Задача 10: Принять у пользователя массив на 8 ячеек и вывести все НЕ четные значения " + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Enter task number:" + ANSI_RESET);
            int number = console.nextInt();

            switch (number){
                case 1: {
                    Task_1();
                    break;
                }
                case 2: {
                    Task_2();
                    break;
                }
                case 3: {
                    Task_3();
                    break;
                }
                case 4: {
                    Task_4();
                    break;
                }
                case 5: {
                    Task_5();
                    break;
                }
                case 6: {
                    Task_6();
                    break;
                }
                case 7: {
                    Task_7();
                    break;
                }
                case 8: {
                    Task_8();
                    break;
                }
                case 9: {
                    Task_9();
                    break;
                }
                case 10: {
                    Task_10();
                    break;
                }
                default: {
                    System.out.println("Wrong number!");
                    break;
                }
            }
        }

    }
    
    public static void Task_1(){
        System.out.println(center + "Valentyn Lola");
    }
    public static void Task_2(){
        System.out.println(center + "Valentyn Lola");
        System.out.println(center + "\"17.05.1987\"");
    }
    public static void Task_3(){
        System.out.println("enter first name");
        String firstName = console.nextLine();
        System.out.println("enter last name");
        String lastName = console.nextLine();
        System.out.println(center + firstName + " " + lastName);
    }
    public static void Task_4(){
        System.out.println("Enter age:");
        int age = console.nextInt();
        System.out.println(center + "you live " + age * 365 + " days");
    }
    public static void Task_5(){
        LocalDate datanow = LocalDate.now();

        System.out.println("Введите год рождения");
        int year = console.nextInt();
        System.out.println("Введите месяц рождения");
        int month = console.nextInt();
        System.out.println("Введите день рождения");
        int day = console.nextInt();

        LocalDate data = LocalDate.of(year, month, day);
        int daysLife = 0;
        for (int i = datanow.getYear(); i >= data.getYear() ; i--){
            if(datanow.getYear() != data.getYear()){
                daysLife += datanow.getDayOfYear();
                datanow = datanow.minusDays(datanow.getDayOfYear());
            }
            else{
                var days1 = datanow.getDayOfYear();
                var days2 = data.getDayOfYear();
                daysLife += days1 - days2;
                datanow = datanow.minusDays(days1 - days2);
            }
        }
        System.out.println("You live " + daysLife +" days");

    }
    public static void Task_6(){
        System.out.println("Введите месяц рождения");
        int month = console.nextInt();
        System.out.println("Введите день рождения");
        int day = console.nextInt();

        LocalDate data = LocalDate.of(2023, month, day);
        if(month == 1 && day <= 20 || month == 12 && day >= 22){
//        Козерог 22.12 – 20.1
            Calculate(day, month, 21, 1, "Козерог", "Водолей");
        }
        else if(month == 2 && day <= 18 || month == 1 && day >= 21){
//        Водолей 21.1 – 18.2
            Calculate(day, month, 19, 2,"Водолей","Рыбы");
        }
        else if(month == 3 && day <= 20 || month == 2 && day >= 19){
//        Рыбы 19.2 – 20.3
            Calculate(day, month, 21, 3,"Рыбы","Овен");
        }
        else if(month == 4 && day <= 20 || month == 3 && day >= 21){
//        Овен 21.3 – 20.4
            Calculate(day, month, 21,4,"Овен","Телец");
        }
        else if(month == 5 && day <= 21 || month == 4 && day >= 21){
//        Телец 21.4 – 21.5
            Calculate(day, month, 22,5,"Телец","Близнецы");
        }
        else if(month == 6 && day <= 21 || month == 5 && day >= 22){
//        Близнецы 22.5 – 21.6
            Calculate(day, month, 22,6,"Близнецы","Рак");
        }
        else if(month == 7 && day <= 22 || month == 6 && day >= 22){
//        Рак 22.6 – 22.7
            Calculate(day, month, 23,7,"Рак","Лев");
        }
        else if(month == 8 && day <= 23 || month == 7 && day >= 23){
//        Лев 23.7 – 23.8
            Calculate(day, month, 24,8,"Лев","Дева");
        }
        else if(month == 9 && day <= 22 || month == 8 && day >= 24){
//        Дева 24.8 – 22.9
            Calculate(day, month, 23,9,"Дева","Весы");
        }
        else if(month == 10 && day <= 23 || month == 9 && day >= 23){
//        Весы 23.9 – 23.10
            Calculate(day, month, 24,10,"Весы","Скорпион");
        }
        else if(month == 11 && day <= 22 || month == 10 && day >= 24){
//        Скорпион 24.10 – 22.11
            Calculate(day, month, 23,11,"Скорпион","Стрелец");
        }
        else if(month == 12 && day <= 21 || month == 11 && day >= 23){
//        Стрелец 23.11 – 21.12
            Calculate(day, month, 22,12,"Стрелец","Козерог");
        }
    }

    public static void Calculate(int day, int month, int nextDay, int nextMonth, String zodiac, String nextZodiac){
        if(month == nextMonth){
            System.out.println("Ваш знак зодиака " + zodiac);
            System.out.println("Разница в днях со следующим знаком зодиака " + nextZodiac + " " + (nextDay - day) + " дней");
        }
        else{
            Calendar myCalendar = (Calendar) Calendar.getInstance().clone();
            myCalendar.set(2023, month, 1);
            int max_days = myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            int days = max_days - day + nextDay;
            System.out.println("Ваш знак зодиака " + zodiac);
            System.out.println("Разница в днях со следующим знаком зодиака " + nextZodiac + " "  + days + " дней");
        }
    }

    public static void Task_7(){
        System.out.println("Введите год рождения");
        int year = console.nextInt();

        int[][] calendar  = {
                {2020, 2008, 1996, 1984, 1972, 1960, 1948, 1936}
                , {2021, 2009, 1997, 1985, 1973, 1961, 1949, 1937}
                , {2022, 2010, 1998, 1986, 1974, 1962, 1950, 1938}
                , {2023, 2011, 1999, 1987, 1975, 1963, 1951, 1939}
                , {2024, 2012, 2000, 1988, 1976, 1964, 1952, 1940}
                , {2025, 2013, 2001, 1989, 1977, 1965, 1953, 1941}
                , {2026, 2014, 2002, 1990, 1978, 1966, 1954, 1942}
                , {2027, 2015, 2003, 1991, 1979, 1967, 1955, 1943}
                , {2028, 2016, 2004, 1992, 1980, 1968, 1956, 1944}
                , {2029, 2017, 2005, 1993, 1981, 1969, 1957, 1945}
                , {2030, 2018, 2006, 1994, 1982, 1970, 1958, 1946}
                , {2031, 2019, 2007, 1995, 1983, 1971, 1959, 1947}
        };
        String[] names = {
                "год крысы"
                , "год быка"
                , "год тигра"
                , "год кролика"
                , "год дракона"
                , "год змеи"
                , "год лошади"
                , "год козы"
                , "год обезьяны"
                , "год петуха"
                , "год собаки"
                , "год свеньи"
        };

        for(int i = 0; i < calendar.length; i++){
            Arrays.sort(calendar[i]);
            int number = Arrays.binarySearch(calendar[i], year);
            if(number >= 0){
                System.out.println("Вы рождены в "+ names[i]);
                break;
            }
        }
    }
    public static void Task_8(){
        System.out.println("Введите 7 чисел");

        int[] arr = new int[7];

        for(int i = 0; i < 7; i++){
            arr[i] = console.nextInt();
        }

        for(int i = 0; i < 7; i++) {
            if(i == 0) System.out.print(arr[i]);
            else System.out.print(" | " + arr[i]);
        }
        System.out.println();
    }
    public static void Task_9(){
        System.out.println("Введите 9 чисел");

        int[] arr = new int[9];

        for(int i = 0; i < 9; i++){
            arr[i] = console.nextInt();
        }

        for(int i = 0; i < 9; i+=2) {
            if(i == 0) System.out.print(arr[i]);
            else System.out.print(" - " + arr[i]);
        }
        System.out.println();
    }
    public static void Task_10(){
        System.out.println("Введите 8 чисел");

        int[] arr = new int[8];

        for(int i = 0; i < 8; i++){
            arr[i] = console.nextInt();
        }

        for(int i = 0; i < 8; i++) {
            if(arr[i] % 2 != 0){
                System.out.print("\t" + arr[i]);
            }
        }
        System.out.println();
    }
}