import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double a1, a2, res;
        ArrayList <String> history = new ArrayList<>();
        boolean isExit = false;
        System.out.println("Выберите операцию и введите её номер");
        while(!isExit){
            String command = "";
            String epoch = "";
            System.out.println("\n1. Сумма");
            System.out.println("2. Разность");
            System.out.println("3. Произведение");
            System.out.println("4. Частное");
            System.out.println("5. История операций");
            System.out.println("6. Выход\n");
            command = scanner.nextLine();
            switch(command)
            {
                case "1": 
                    System.out.println("Введите 2 числа через пробел:");
                    a1 = scanner.nextDouble();
                    a2 = scanner.nextDouble();
                    res = a1 + a2;
                    epoch += a1 + " + " + a2 + " = " + res;
                    history.add(epoch);
                    System.out.println(epoch);
                    break;
                case "2": 
                    System.out.println("Введите 2 числа через пробел:");
                    a1 = scanner.nextDouble();
                    a2 = scanner.nextDouble();
                    res = a1 - a2;
                    epoch += a1 + " - " + a2 + " = " + res;
                    history.add(epoch);
                    System.out.println(epoch);
                    break;
                case "3": 
                    System.out.println("Введите 2 числа через пробел:");
                    a1 = scanner.nextDouble();
                    a2 = scanner.nextDouble();
                    res = a1 * a2;
                    epoch += a1 + " * " + a2 + " = " + res;
                    history.add(epoch);
                    System.out.println(epoch);
                    break;
                case "4": 
                    System.out.println("Введите 2 числа через пробел:");
                    a1 = scanner.nextDouble();
                    a2 = scanner.nextDouble();
                    if(a2 == 0){
                        System.out.println("Ошибка: деление на 0");
                    }
                    else{
                        res = a1 / a2;
                        epoch += a1 + " / " + a2 + " = " + res;
                        history.add(epoch);
                        System.out.println(epoch);
                    }
                    break;
                case "5": 
                    System.out.println("\nИстория операций:");
                    showHistory(history);
                    break;
                case "6" : 
                    System.out.println("Программа завершена");   
                    isExit = true;
                    break;
                default : System.out.println("Неверный номер операции. Попробуйте снова");
                    break;
            }
        }
        scanner.close();
    }

    private static void showHistory(ArrayList <String> history) {
        int i = 1;
        if(history.size() == 0){
            System.out.println("Похоже вы ещё не выполняли никаких операций");
        }
        else{
            for (String epoch : history) {
                System.out.println(i + ": " +epoch);
                i++;
            }
        }
    }

}