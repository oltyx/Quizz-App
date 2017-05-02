package com.example.android.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //This variable counts the number of correct answers.
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method decides if the last question check boxes are correctly checked.
     *
     * @param checkBox1 is the first Check Box java object from the last question.
     * @param checkBox2 is the second Check Box java object from the last question.
     * @param checkBox3 is the third Check Box java object from the last question.
     * @param checkBox4 is the fourth Check Box java object from the last question.
     */
    public boolean decideCheckBoxesCorectness(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4) {
        if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked() && checkBox4.isChecked())
            return true;
        return false;
    }

    /**
     * This method decides if the input text from Edit Text is correct.
     */
    public boolean decideEditTextCorrectness(EditText textField) {
        //This is the correctAnswer for question 4.
        String correctAnswer = "ERA 1101";
        if (textField.getText().toString().contains(correctAnswer))
            return true;
        return false;
    }

    /**
     * This method calculates the number of good questions for Radio Buttons questions.
     */
    public void getRadioButtonQuestion() {
        //These are RadioButton java objects for every radio button from questions.
        RadioButton radioButtonQuestion1 = (RadioButton) findViewById(R.id.correct_answer_q1);
        RadioButton radioButtonQuestion2 = (RadioButton) findViewById(R.id.correct_answer_q2);
        RadioButton radioButtonQuestion3 = (RadioButton) findViewById(R.id.correct_answer_q3);
        RadioButton radioButtonQuestion5 = (RadioButton) findViewById(R.id.correct_answer_q5);
        RadioButton radioButtonQuestion6 = (RadioButton) findViewById(R.id.correct_answer_q6);
        RadioButton radioButtonQuestion7 = (RadioButton) findViewById(R.id.correct_answer_q7);
        if (radioButtonQuestion1.isChecked())
            correctAnswers += 1;
        if (radioButtonQuestion2.isChecked())
            correctAnswers += 1;
        if (radioButtonQuestion3.isChecked())
            correctAnswers += 1;
        if (radioButtonQuestion5.isChecked())
            correctAnswers += 1;
        if (radioButtonQuestion6.isChecked())
            correctAnswers += 1;
        if (radioButtonQuestion7.isChecked())
            correctAnswers += 1;
    }

    /**
     * This method calculates the number of good questions.
     */
    public void getAllGoodQuestions() {
        //Create a Edit Text java object for Edit text from question 4.
        EditText textField = (EditText) findViewById(R.id.text_field_question_4);
        //If Edit Text from question 4 is correct correctAnswers is increased by 1.
        if (decideEditTextCorrectness(textField))
            correctAnswers += 1;
        //Creates CheckBox java objects for every check box from last question.
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_toshiba);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_hp);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_Colgate);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_Dell);
        //If Check Boxes from last question are correct, correctAnswers is increased by 1;
        if (decideCheckBoxesCorectness(checkBox1, checkBox2, checkBox3, checkBox4))
            correctAnswers += 1;
        //Get the correct answers from Radio Buttons.
        getRadioButtonQuestion();
    }

    /**
     * In case of uncompleted questions, you must complete all of them to see the final result.
     *
     * @param button is the "Result" button java object.
     */
    public void showResults(View button) {
        getAllGoodQuestions();
        makeToast();
        //All answers are equal to 0 after the toast is displayed.
        correctAnswers = 0;
    }

    /**
     * This method shows a toast with the final result of quiz.
     */
    public void makeToast() {
        Toast resultMessage = Toast.makeText(getApplicationContext(), "Your result is:" + correctAnswers + "/8", Toast.LENGTH_SHORT);
        resultMessage.show();
    }

    /**
     * This method resets the app.
     *
     * @param view is the java button object.
     */
    public void resetAll(View view) {
        correctAnswers = 0;
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}
