package kwak.szymon.biblequiz;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class FullscreenActivity extends AppCompatActivity {

    QuizData quizData;
    Button btnA, btnB, btnC, btnD;
    TextView txtQuestion, txtQuestionNumber, txtPoints, txtTimeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //ukryj TitleBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //Ukryj Notification Bar
        setContentView(R.layout.activity_fullscreen);

        //Zmiana koloru navigationBar'a
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));

        //Inicjalizacja puli pytań (10)
        quizData = new QuizData();

        //region findViewsById
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        txtQuestion = findViewById(R.id.txtViewQuestion);
        txtQuestionNumber = findViewById(R.id.txtViewNumber);
        txtPoints = findViewById(R.id.txtViewPoints);
        txtTimeLeft = findViewById(R.id.txtViewTimeLeft);
        //endregion

        //region setOnClickListner's
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer('A');
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer('B');
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer('C');
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer('D');
            }
        });
        //endregion


    }

    void setQuestionOnScreen(QuizData quizData, int questionNumber) {
        txtQuestion.setText(quizData.getQuizQuestionList().get(questionNumber).getQuestion());
        String qNumber = questionNumber + "//10";
        txtQuestionNumber.setText(qNumber);
//        txtPoints = ;
        txtTimeLeft.setVisibility(View.INVISIBLE);

        btnA.setText(quizData.getQuizQuestionList().get(questionNumber).getAnswer('A'));
        btnB.setText(quizData.getQuizQuestionList().get(questionNumber).getAnswer('B'));
        btnC.setText(quizData.getQuizQuestionList().get(questionNumber).getAnswer('C'));
        btnD.setText(quizData.getQuizQuestionList().get(questionNumber).getAnswer('D'));
    }

    void getAnswer(Character givenAnswer) {
        computePoints(givenAnswer);
        showSummary(givenAnswer);
    }

    private int computePoints(Question question, Character givenAnswer) {
        int result = 0;
        if (question.isAnswerCorrect(givenAnswer)) {
            result = 1;
        }
        return result;
    }
}
