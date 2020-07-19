import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение и нажмите ENTER для его вычисления");
        System.out.println("--Для просмотра истории операций введите h");
        System.out.println("--Для выхода из программы введите е");
        ArrayList <StringBuilder> parts;
        while(true){
            String s = scanner.nextLine();
            //String s = "567+(489-57)";
            s = s.replace(" ", "");
            try {
                parts = parse(s);
                calculate(parts);
            } catch (Exception e) {
                if(e.getMessage() == "History"){
                    System.out.println("\nИстория действий");
                    // showHistory();
                    continue;
                }
                else if(e.getMessage() == "Error!"){
                    System.out.println("ERROR! Некорректные данные введите снова");
                    continue;
                }
                else if(e.getMessage() == "Exit"){
                    System.out.println("Программа завершена");
                    break;
                }
            }

        }
        scanner.close();
    }

    private static void calculate(ArrayList<StringBuilder> parts) throws Exception {
        ArrayList<Integer> openRoundsIndexes = new ArrayList<>();
        ArrayList<Integer> closeRoundsIndexes = new ArrayList<>();
        for(int i=0; i < parts.size(); i++){
            if(parts.get(i).toString().equals("(")){
                openRoundsIndexes.add(i);
            }
            else if(parts.get(i).toString().equals(")")){
                closeRoundsIndexes.add(i);
            }
        }

        if(openRoundsIndexes.size() != closeRoundsIndexes.size()){
            throw new Exception("Error!");
        }

    }

    private static long action(long a1, long a2, char action) throws Exception {
        switch (action){
            case '+':
                return a1 + a2;
            case '-':
                return a1 - a2;
            case '*':
                return a1 * a2;
            case '/':
                return a1 / a2;
            default:
                throw new Exception("Error!");
        }
    }

    public static ArrayList<StringBuilder> parse(String in) throws Exception {
        StringBuilder s = new StringBuilder(in);
        ArrayList <StringBuilder> parts = new ArrayList<>();
        StringBuilder part = new StringBuilder("");
        for(int i=0; i < s.length(); i++){
            char sym = s.charAt(i);
            if(Character.isDigit(sym)){
                part.append(sym);
                if(i==s.length()-1)
                    parts.add(part);
            }
            else{
                if(part.length()!=0){
                    parts.add(part);
                    part = new StringBuilder();
                }
                switch (sym){
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '(':
                    case ')':
                              part.append(sym);
                              parts.add(part);
                              part = new StringBuilder();
                              break;
                    case 'h':
                        throw new Exception("History");
                    case 'e':
                        throw new Exception("Exit");
                    default:
                        throw new Exception("Error!");
                }
            }
        }

        return parts;
    }
}