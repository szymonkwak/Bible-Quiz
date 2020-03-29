package kwak.szymon.biblequiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static kwak.szymon.biblequiz.CollectionOfQuestions.*;

public class QuizData {
    private List<Question> actualQuizQuestionList;

    //Inicjalizacja listy wszystkich pytań.
    //Jeżeli zostanie dodane pytanie do kolekcji CollectionOfQuestions to tutaj tez trzeba dodać
    private static List<Question> listOfAllQuestions;
    static {
        listOfAllQuestions = new ArrayList<>(NUMBER_OF_QUESTIONS);
        listOfAllQuestions.add(new Question(diff1, question1, corrAsnw1, answers1));
        listOfAllQuestions.add(new Question(diff2, question2, corrAsnw2, answers2));

    }

    public List<Question> getActualQuizQuestionList() {
        return actualQuizQuestionList;
    }

    public QuizData(int difficulty) {
        int i = 1;

        while (i <= 8) {
            if (listOfAllQuestions.get(i).getDifficulty() == 1) {
                actualQuizQuestionList.add(listOfAllQuestions.get(i));
                i++;
            }
        }
        while (i <= 13) {
            if (listOfAllQuestions.get(i).getDifficulty() == 2) {
                actualQuizQuestionList.add(listOfAllQuestions.get(i));
                i++;
            }
        }
        while (i <= 15) {
            if (listOfAllQuestions.get(i).getDifficulty() == 3) {
                actualQuizQuestionList.add(listOfAllQuestions.get(i));
                i++;
            }
        }


    }
}
