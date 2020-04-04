package kwak.szymon.biblequiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static kwak.szymon.biblequiz.CollectionOfQuestions.*;

public class QuizData {

    private List<Question> actualQuizQuestionList;
    private static List<Question> listOfAllQuestions;


    public Question getActiveQuestion(int questionNumber) {
        return actualQuizQuestionList.get(questionNumber);
    }

    //Inicjalizacja listy wszystkich pytań.
    //Jeżeli zostanie dodane pytanie do kolekcji CollectionOfQuestions to tutaj też trzeba dodać
    private void initializeListOfAllQuestions(){
        listOfAllQuestions = new ArrayList<>();
        listOfAllQuestions.add(new Question(diff1, question1, corrAsnw1, answers1));
        listOfAllQuestions.add(new Question(diff2, question2, corrAsnw2, answers2));
        listOfAllQuestions.add(new Question(diff3, question3, corrAsnw3, answers3));
        listOfAllQuestions.add(new Question(diff4, question4, corrAsnw4, answers4));
        listOfAllQuestions.add(new Question(diff5, question5, corrAsnw5, answers5));
        listOfAllQuestions.add(new Question(diff6, question6, corrAsnw6, answers6));
        listOfAllQuestions.add(new Question(diff7, question7, corrAsnw7, answers7));
        listOfAllQuestions.add(new Question(diff8, question8, corrAsnw8, answers8));
        listOfAllQuestions.add(new Question(diff9, question9, corrAsnw9, answers9));
        listOfAllQuestions.add(new Question(diff10, question10, corrAsnw10, answers10));
        listOfAllQuestions.add(new Question(diff11, question11, corrAsnw11, answers11));
    }

    private void addToList(int r) {
        actualQuizQuestionList.add(listOfAllQuestions.get(r));
        listOfAllQuestions.remove(r);
    }

    public QuizData() {
        initializeListOfAllQuestions();
        actualQuizQuestionList = new ArrayList<>();
        int i = 1;
        int r;
        Random random = new Random();

        while (i <= 5) {
            r = random.nextInt(listOfAllQuestions.size());
            if (listOfAllQuestions.get(r).getDifficulty() == 1) {
                addToList(r);
                i++;
            }
        }
        while (i <= 9) {
            r = random.nextInt(listOfAllQuestions.size());
            if (listOfAllQuestions.get(r).getDifficulty() == 2) {
                addToList(r);
                i++;
            }
        }
        while (i <= 10) {
            r = random.nextInt(listOfAllQuestions.size());
            if (listOfAllQuestions.get(r).getDifficulty() == 3) {
                addToList(r);
                i++;
            }
        }

    }
}
