import java.util.*;

 class game {
    static int number,lb,hb,inputNumber,noOfguess;


    game() {
        boolean b = true;
        while (b) {
            try {
                System.out.println("Enter the lower bound\n");
                Scanner sc = new Scanner(System.in);
                lb = sc.nextInt();
                System.out.println("Enter the higher bound\n");
                hb = sc.nextInt();
                Random ran = new Random();

                number = ran.nextInt(lb, hb);
                b=false;
            } catch (Exception e) {
                System.out.println("Please choose a valid bound");
            }
        }
    }

    static void takeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between " +lb+" to "+hb);
            inputNumber = sc.nextInt();
    }

    static boolean isCorrectNumber() {
        noOfguess--;
        if (noOfguess==0){
            System.out.println("you are failed to guess the number in 10 attempt and your score is zero");
            return true;
        }
        else if (inputNumber == number) {
            System.out.println("you are  right  score " + noOfguess*10);
            return true;

        } else if (inputNumber > number) {
            System.out.println("too high...");

        } else if (number > inputNumber) {
            System.out.println("too low...");
        }
        return false;
    }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        boolean c = true;
        while (c) {
            noOfguess=11;
            game ga = new game();
            boolean b = false;
            while (!b) {
                ga.takeUserInput();
                b = game.isCorrectNumber();
            }
            System.out.println("Do you want to play more ?\n"+"yes or no");
            String s=sc.nextLine();
            String yes="yes";
            if (yes.equalsIgnoreCase(s))
            {
                c=true;
            }
            else {
                c=false;

            }
        }
       System.out.println("Thank You.");
    }
}
