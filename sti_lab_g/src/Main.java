import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isPlaying = true;
        int winner = 0;


        do{
            Player player1 = new Player("", 0);
            Player player2 = new Player("",0);
            Dice dice = new Dice(0, 1,6, 0);

            System.out.println("Hello and welcome to Simons, G DiceGame"
            + "\nPress Enter to start");
            br.read();

            System.out.println("How many players are playing, 1: One player 2: Two player?");
            int players = scanner.nextInt();
            if(players == 2) {
                System.out.print("Player1, please input your username: ");
                player1.name = scanner.next();
                System.out.print("Player2, please input your username: ");
                player2.name = scanner.next();

                System.out.print("How many rounds do you wish to be played: ");
                dice.rounds = scanner.nextInt();

                System.out.print("How many dices would you like to throw: ");
                dice.diceNumber = scanner.nextInt();


                System.out.println("Press Enter to start the rolling!!!");
                br.readLine();

                for(int i = 1; i <= dice.rounds; i++){
                    System.out.println("\nROUND: " + i);

                    for(int j = 0; j < players; j++){
                        System.out.println(player1.name + " throws\n" + player2.name + " throws also" );

                        for(int k = 0; k < dice.diceNumber; k++){
                            player1.score = random.nextInt(dice.minNumber, dice.maxNumber);
                            System.out.println(player1.name + "'s dice rolled " + player1.score);
                            player2.score = random.nextInt(dice.minNumber, dice.maxNumber);
                            System.out.println(player2.name + "'s dice rolled " + player2.score);
                            player1.sum += player1.score;
                            player2.sum += player2.score;

                        }
                    }
                }
                if (player1.sum > player2.sum){
                    winner = player1.sum - player2.sum;
                    System.out.println("SCOREBOARD\n" + player1.name + " score = " + player1.sum
                    +"\n" + player2.name + " score = " + player2.sum);
                    System.out.println(player1.name + " Won the battle with a total sum of " + player1.sum + " with a gap of " + winner);
                }
                else if (player1.sum == player2.sum) {
                    System.out.println("SCOREBOARD\n" + player1.name + " score = " + player1.sum
                            +"\n" + player2.name + " score = " + player2.sum);
                    System.out.println("It's a draw between you two!" + player1.name + " " + player1.sum + " & " + player2.name + " " + player2.sum);
                }
                else{
                    System.out.println("SCOREBOARD\n" + player1.name + " score = " + player1.sum
                            +"\n" + player2.name + " score = " + player2.sum);
                    winner = player2.sum - player1.sum;
                    System.out.println(player2.name + " Won the battle with a total sum of " + player2.sum + " with a gap of " + winner);

                }
            }
            else{
                System.out.println("Player1, please input your username: ");
                player1.name = scanner.next();

                System.out.print("How many rounds do you wish to be played: ");
                dice.rounds = scanner.nextInt();

                System.out.print("How many dices would you like to throw: ");
                dice.diceNumber = scanner.nextInt();


                System.out.println("Press Enter to start the rolling!!!");
                br.readLine();

                for(int i = 1; i <= dice.rounds; i++){
                    System.out.println("Current round " + i);

                    for(int j = 0; j < players; j++){
                        System.out.println(player1.name + "throws!");

                        for(int k = 0; k < dice.diceNumber; k++){
                            player1.score = random.nextInt(dice.minNumber, dice.maxNumber);
                            System.out.println(player1.name + " rolled " + player1.score);
                            player1.sum += player1.score;
                        }
                    }

                }
                System.out.println(player1.name +"'s" + " total score is " + player1.sum);

            }

            System.out.println("Would u like to continue to play? 1: YES 2: NO");
            if(scanner.nextInt() == 2){
                isPlaying = false;
                System.out.println("Thank you for playing");
            }



        }while(isPlaying);
    }
}
