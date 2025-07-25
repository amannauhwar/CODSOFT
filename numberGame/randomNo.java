import java.util.Random;
import java.util.Scanner;

class randomNoClass {
    private final Random random = new Random();

    public int getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    } 
    
}


public class randomNo {
    public static void main(String args[]){

        randomNoClass no = new randomNoClass();

        int a = no.getRandomNumber(1, 20);
        // System.out.println(a);

        System.out.println("***********************************Welocome to the Number Game!***********************************");
        System.out.println();
        System.out.println("You have five chances. Game starts now...");

        Scanner noo = new Scanner(System.in);
        int userNo = noo.nextInt();

        int chances = 0;

        while(userNo != a){

            if (userNo < a) {
                System.out.println("The input number is too low!"); 
            }
            else if(userNo > a){
                System.out.println("The input number is too high!");
            }
            
            if(chances == 4){
                System.out.println("You have used all the five attempts!");
                break;
            }
            chances ++;
            userNo = noo.nextInt();

        }
        
        if(userNo == a){

            System.out.println("You guessed the number correctly which is " + a + " in this case.");
            System.out.println();
            System.out.println("To play the game again type (5) and hit enter.");

            int playAgain = noo.nextInt();
            
            chances = 0;
         while(playAgain == 5){

             userNo = noo.nextInt();


            if (userNo < a) {
                System.out.println("The input number is too low!"); 
            }
            else if(userNo > a){
                System.out.println("The input number is too high!");
            }
            
            if(chances == 4){
                System.out.println("You have used all the five attempts!");
                break;
            }
            chances ++;

        }
            }
        else {

            System.out.println("To play the game again type (5) and hit enter.");
            int playAgain = noo.nextInt();

            chances = 0;
         while(playAgain == 5){

            userNo = noo.nextInt();

            if (userNo < a) {
                System.out.println("The input number is too low!"); 
            }
            else if(userNo > a){
                System.out.println("The input number is too high!");
            }
            
            if(chances == 4){
                System.out.println("You have used all the five attempts!");
                break;
            }
            chances ++;

        }
            }

    }
}
