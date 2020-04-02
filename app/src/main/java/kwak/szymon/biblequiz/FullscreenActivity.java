package kwak.szymon.biblequiz;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class FullscreenActivity extends AppCompatActivity {

    int activeQuestionNumber, totalPoints;
    QuizData quizData;
    Dialog dialog;
    PopUpWindow popUpWindow;
    Button btnA, btnB, btnC, btnD;
    TextView txtQuestion, txtQuestionNumber, txtPoints, txtTimeLeft;
    ProgressBar progressBarTimeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //ukryj TitleBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //Ukryj Notification Bar
        setContentView(R.layout.activity_fullscreen);

        //Zmiana koloru navigationBar'a
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));

        //Inicjalizacja puli pytań (10)
        //  quizData = new QuizData();
        activeQuestionNumber = 1;
        totalPoints = 0;

        //Potrzebuję do otwarcia pop_up_window
        dialog = new Dialog(this);
        popUpWindow = new PopUpWindow();

        //region findViewsById
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        txtQuestion = findViewById(R.id.txtViewQuestion);
        txtQuestionNumber = findViewById(R.id.txtViewNumber);
        txtPoints = findViewById(R.id.txtViewPoints);
        txtTimeLeft = findViewById(R.id.txtViewTimeLeft);
        progressBarTimeLeft = findViewById(R.id.progressBar);
        //endregion

        //region setOnClickListner's
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUpWindow.showPopUpWindowIfCorrect(dialog);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getAnswer(quizData.getActiveQuestion(activeQuestionNumber),'B');
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getAnswer('C');
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getAnswer('D');
            }
        });
        //endregion


    }


    void setQuestionOnScreen(QuizData quizData, int questionNumber) {
        txtQuestion.setText(quizData.getActiveQuestion(questionNumber).getQuestion());
        String qNumber = questionNumber + "//10";
        txtQuestionNumber.setText(qNumber);
        String points = totalPoints + " pkt.";
        txtPoints.setText(points);
        txtTimeLeft.setVisibility(View.INVISIBLE);
        progressBarTimeLeft.setVisibility(View.INVISIBLE);


        btnA.setText(quizData.getActiveQuestion(questionNumber).getAnswer('A'));
        btnB.setText(quizData.getActiveQuestion(questionNumber).getAnswer('B'));
        btnC.setText(quizData.getActiveQuestion(questionNumber).getAnswer('C'));
        btnD.setText(quizData.getActiveQuestion(questionNumber).getAnswer('D'));
    }

    void getAnswer(Question question, Character givenAnswer) {
        if (question.isAnswerCorrect(givenAnswer)) {
            popUpWindow.showPopUpWindowIfCorrect(dialog);
            totalPoints++;
        } else {
            popUpWindow.showPopUpWindowIfIncorrect(dialog);
        }
    }
}
