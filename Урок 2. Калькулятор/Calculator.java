import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение и нажмите ENTER для его вычисления");
        boolean isNotExit = true;
        while(isNotExit){
            String s = scanner.nextLine();
            s = s.replace(" ", "");
            try {
                parse(s);
            } catch (Exception e) {
                System.out.println("ERROR! Некорректные данные введите снова");
                continue;
            } 
            
        }
    }

    public static void name() {
        StringBuilder s = new StringBuilder("567+(489-57)");
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
                    System.out.println("Показываем историю запросов");
                    break;
                    default:
                    System.out.println("Выбрасываем эксепшен");
                }
            }
        }
    }
}