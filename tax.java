import java.util.Scanner;

public class tax {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    //variables
    double income;
    double workableIncome;
    double remaining;
    double due = 0;
    int minimum = 0;
    int kids = 0;
    int age = 0;

    //inputs
    System.out.println("What is your yearly salary?");
    income = scan.nextDouble();
    System.out.println("How many kids do you have?");
    kids = scan.nextInt();
    System.out.println("What is your age?");
    age = scan.nextInt();

    workableIncome = income;

    //calculations
    //taxMargins
    if (workableIncome < 10000) {
      minimum = 0;
      due = 0;
    }
    if (workableIncome < 25000) {
      minimum = 500;
      due = due + (workableIncome - 10000) / 10;
    }
    if (workableIncome < 75000) {
      minimum = 5000;
      due = due + ((workableIncome - 25000) * .2);
      workableIncome = workableIncome - (workableIncome - 25000);
      due = due + ((workableIncome - 10000) / 10);
    }
    if (workableIncome < 250000) {
      minimum = 10000;
      due = due + ((workableIncome - 75000) * .3);
      workableIncome = workableIncome - (workableIncome - 75000);
      due = due + ((workableIncome - 25000) * .2);
      workableIncome = workableIncome - (workableIncome - 25000);
      due = due + ((workableIncome - 10000) / 10);
    }
    if (workableIncome > 250000) {
      minimum = 25000;
      due = due + ((workableIncome - 250000) / 2);
      workableIncome = workableIncome - (workableIncome - 250000);
      due = due + ((workableIncome - 75000) * .3);
      workableIncome = workableIncome - (workableIncome - 75000);
      due = due + ((workableIncome - 25000) * .2);
      workableIncome = workableIncome - (workableIncome - 25000);
      due = due + ((workableIncome - 10000) / 10);
    }

    //dependants
    if (kids < 2.5) {
      due = due - 1000;
    } else {
      due = due - (1000 * (500 * (kids - 2)));
    }

    //age
    if (age <= 15) {
      due = due - (due / 2);
    } else if (age >= 16 && age <= 21) {
      due = due - (due / 4);
    } else if (age >= 64 && age <= 72) {
      due = due - (due / 3);
    } else if (age >= 73 && age <= 80) {
      due = due / 3;
    } else if (age >= 81) {
      due = 0;
    }

    //minimums
    if (due < minimum) {
      due = minimum;
    }

    //final
    remaining = income - due;

    //outputs
    System.out.println("you owe " + due + " dollars to the High Ruler Padjen (Blessed be upon him)");
  }
}
