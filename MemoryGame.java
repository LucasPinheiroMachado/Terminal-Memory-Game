package memory_game;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MemoryGame {

    public static void clearScreen(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static List<Integer> addSortedNumber(List<Integer> list){
        list.add((int)(Math.random() * 100));
        return list;
    }

    public static void showNumbers(List<Integer> list){
        System.out.println();
        System.out.println();
        System.out.println("Memorize os números abaixo e aperte Enter para jogar:");
        System.out.println();
        for(int number : list) {
            System.out.print(number + " ");
        }
        System.out.println("\n");
    }

    public static boolean checkResults(List<Integer> list, List<Integer> answers){
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).equals(answers.get(i))){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> makeQuestions(List<Integer> list, Scanner scanner){
        int numberPosition = 1;
        List<Integer> answers = new ArrayList<>();

        for(int listNumber : list){
            System.out.print("Adivinhe o número " + numberPosition + ": ");
            int answer = scanner.nextInt();
            scanner.nextLine();
            answers.add(answer);
            numberPosition++;
        }
        return answers;
    }

    public static void main(String[] args) {
        boolean gameOn = true;
        int points = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> answers;
        Scanner scanner = new Scanner(System.in); 

        while (gameOn) {
            list = addSortedNumber(list);
            showNumbers(list);

            scanner.nextLine();

            clearScreen();

            answers = makeQuestions(list, scanner);

            gameOn = checkResults(list, answers);

            if(gameOn){
                points++;
                System.out.println("Você acertou, está com " + points + " pontos");
            } else {
                System.out.println("Fim de jogo, você terminou com " + points + " pontos");
            }
        }

        scanner.close();
    }
}
