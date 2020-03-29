package kwak.szymon.biblequiz;

import java.util.HashMap;

public class Question {
    private int difficulty; //Trudność pytania 1,2 lub 3
    private String question; //Treść pytania
    private HashMap<Character, String> answerMap; // odpowiedzi
    private Character correctAnswer; //Poprawna odpowiedź: 'A' 'B' 'C' lub 'D'

    public Question(int difficulty, String question, Character correctAnswer, String[] answers) {
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        answerMap = new HashMap<>(4);
        answerMap.put('A', answers[1]);
        answerMap.put('B', answers[2]);
        answerMap.put('C', answers[3]);
        answerMap.put('D', answers[4]);
    }

    public boolean isAnswerCorrect(Character answer) {
        return answer.equals(correctAnswer);
    }

    public int getDifficulty() {
        return difficulty;
    }
}
