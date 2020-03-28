package kwak.szymon.biblequiz;

import java.util.HashMap;

public class Question {
    private String question;
    private HashMap<Character, String> answerMap;
    private Character correctAnswer;

    public Question(String question, Character correctAnswer, String[] answers) {
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
}
