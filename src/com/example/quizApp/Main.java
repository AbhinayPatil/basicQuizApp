package com.example.quizApp;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1) JAVA TEST\n2) PYTHON TEST\n3)EXIT");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();//taking choice from the user
            if(choice==3)
                System.exit(0);

            else if(choice==1 || choice==2) {
                working w = new working(choice);
                w.work();//calling the object of class working
            }

            else
                System.out.println("Invalid choice!!!\n\n");

        }while (true);

    }
}


class working{

    int correct=0,incorrect=0,aim;
    Scanner sc = new Scanner(System.in);
    Map<model, Character> hmap = new HashMap<>();

    //constructor for referring the value passed by main function
    public working(int choice) {
        aim=choice;
    }

    public void work(){
        if(aim==1) {
            //creating objects of model class
            model q1 = new model("Which statement is true about Java?", "A. Java is a sequence-dependent programming language ", "B. Java is a code dependent programming language ", "C. Java is a platform-dependent programming language ", "D. Java is a platform-independent programming language ");
            model q2 = new model("What is the extension of java code files?", " A. .txt", "B. .pdf", "C. .sql", "D. .java");
            model q3 = new model("Who invented Java Programming? ", "A. Guido van Rossum", "B. James Gosling", "C. Dennis Ritchie", "D. Bjarne Stroustrup");
            model q4 = new model("Which one of the following is not a Java feature?", "A. Object-oriented", "B. Use of pointers", "C. Portable", "D. Dynamic and Extensible");
            model q5 = new model("Which of these cannot be used for a variable name in Java?", "A. identifier & keyword", "B. identifier", "C. Keyword", "D. none of the mentioned");

            // hashmaps for que as key and ans as value
            hmap.put(q1, 'D');
            hmap.put(q2, 'D');
            hmap.put(q3, 'B');
            hmap.put(q4, 'B');
            hmap.put(q5, 'C');
        }

        else if(aim==2){
            model q1 = new model(" What is the maximum possible length of an identifier?","A. 16","B. 32","C. 64","D. None of the above");
            model q2 = new model("Who developed the Python language?","A. Zim Den","B. Guido van Rossum","C. Wick van Rossum","D. Niene Stom");
            model q3 = new model("In which year was the Python language developed?","A. 1995","B. 1972","C. 1981","D. 1989");
            model q4 = new model("In which language is Python written?","A PHP","B. English","C. C","D. All of the above");
            model q5 = new model("Which one of the following is the correct extension of the Python file?","A. .py","B. .python","C. .p","D. None of the above");

            hmap.put(q1,'D');
            hmap.put(q2,'B');
            hmap.put(q3,'D');
            hmap.put(q4,'C');
            hmap.put(q5,'A');
        }

        //printing every question and checking ans
        for(Map.Entry<model,Character> map:hmap.entrySet()){
            System.out.println("--------------------------------------------------");
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());

            System.out.print("Enter your answer:  ");
            char ans = sc.next().charAt(0);//taking in your answer

            int check = Character.compare(ans,map.getValue());//comparing your answer with correct answer
            if(check==0){
                System.out.println("Correct answer.");
                correct++;
            }
            else{
                System.out.println("Sorry, the answer is incorrect.");
                incorrect++;
            }


        }

        //printing results
        System.out.println();
        System.out.println("_________________Results_________________");
        System.out.println("Correct answers: "+correct);
        System.out.println("Incorrect answers: "+ incorrect);
        System.out.println("Your score: "+(correct*4+incorrect*(-1)));
        System.out.println("_________________________________________");

    }
}