package kwak.szymon.biblequiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PopUpWindow {

    Button btnConfirm;
    TextView txtSummary;

    @SuppressLint("SetTextI18n")
    public void showPopUpWindowIfCorrect(final Dialog dialog) {
        preparePopUp(dialog);
        txtSummary.setText("Dokładnie tak! \n To jest właściwa odpowiedź!");
        btnConfirm.setText("Ok! Dawaj kolejne");
        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void showPopUpWindowIfIncorrect(final Dialog dialog) {
        preparePopUp(dialog);
        txtSummary.setText("Niestety nie \n Może następnym razem pójdzie Ci lepiej?");
        btnConfirm.setText("Nie poddaję się, następne proszę");
        dialog.show();
    }

    private void preparePopUp(final Dialog dialog) {
        dialog.setContentView(R.layout.pop_up_window);
        btnConfirm = dialog.findViewById(R.id.btnConfirm);
        txtSummary = dialog.findViewById(R.id.txtSummary);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}
