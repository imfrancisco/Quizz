package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StartQuizActivity extends AppCompatActivity {
    private TextView mTextView_score, mTextView_questionCount, mTextView_countdown, mTextView_question;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2,radioButton3,radioButton4;
    private Button button_choice1, button_choice2,button_choice3,button_choice4;
    private Button button_confirm, button_exit;

    private String answer;


    private String[] questionsArr ={"What is the capital of the United States?", "What is the capital of the Ecuador?", "What is the capital of the Peru?", "What is the capital of the Italy?", "What is the capital of the Colombia"};
    private String[] answersArr ={"Washington DC", "Guayaquil", "Lima", "Rome", "Bogota"};
    private String[][] choicesArr ={
                                {"New York", "New Jersey", "California", "Washington DC"},
                                {"Quito", "Manabi", "Guayaquil","Cuenca"},
                                {"Lima", "Loreto", "Tumbes", "Junin"},
                                {"Milan","Rome","Venice","Florence"},
    };
    public Integer questionCounter=0;
    public Integer score=0;
    //private Integer totalQuestionCountInArrayList = questionsArr.length;
    Random random = new Random();

    public String getQuestions(int choiceNum){
        String question = questionsArr[choiceNum];
        return question;
    }

    public String getChoice1(int choiceNum){
        String choice = choicesArr[choiceNum][0];
        return choice;
    }

    public String getChoice2(int choiceNum){
        String choice = choicesArr[choiceNum][1];
        return choice;
    }

    public String getChoice3(int choiceNum){
        String choice = choicesArr[choiceNum][2];
        return choice;
    }

    public String getChoice4(int choiceNum){
        String choice = choicesArr[choiceNum][3];
        return choice;
    }

    public String getCorrectAnswer(int choiceNum){
        String answer = answersArr[choiceNum];
        return answer;
    }

    public Integer getSize(String[] arrQuestions){
        Integer questionArrSize = arrQuestions.length;
        return questionArrSize;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        mTextView_score = (TextView)findViewById(R.id.textView_score);
        mTextView_questionCount = (TextView)findViewById(R.id.textView_questionCount);
        mTextView_countdown = (TextView)findViewById(R.id.textView_countdown);
        mTextView_question = (TextView)findViewById(R.id.textView_question);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        //radioButton1 = (RadioButton)findViewById(R.id.radioButton_option1);
        //radioButton2 = (RadioButton)findViewById(R.id.radioButton_option2);
        //radioButton3 = (RadioButton)findViewById(R.id.radioButton_option3);
        //radioButton4 = (RadioButton)findViewById(R.id.radioButton_option4);
        //button_confirm = (Button)findViewById(R.id.button_confirm);
        button_exit = (Button)findViewById(R.id.button_exit);
        button_choice1 = (Button)findViewById(R.id.button_option1);
        button_choice2 = (Button)findViewById(R.id.button_option2);
        button_choice3 = (Button)findViewById(R.id.button_option3);
        button_choice4 = (Button)findViewById(R.id.button_option4);

        mTextView_score.setText("Score: " + score);
        updateQuestion(random.nextInt(4));

//        button_confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Integer idCheck =radioGroup.getCheckedRadioButtonId();
//                RadioButton checkedRadioButton=(RadioButton)findViewById(idCheck);
//
////                if(answersArr == getCorrectAnswer()){
////                    //nothing was checked
////                }
////                else if(answersArr[questionCounter-1]==checkedRadioButton.getText()){
////
////                }
//
//            }
//        });

        //updateQuestion(random.nextInt(totalQuestionCountInArrayList));

        button_choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button_choice1.getText().toString().equals(answer)){
                    score++;
                    mTextView_score.setText("Score: " + score);
                    updateQuestion(random.nextInt(4));
                    Toast.makeText(StartQuizActivity.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    updateQuestion(4);
                    Toast.makeText(StartQuizActivity.this,"Incorrect", Toast.LENGTH_SHORT).show();
                }
                questionCounter++;
                endQuizz();
            }
        });

        button_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button_choice2.getText().toString().equals(answer)){
                    score++;
                    mTextView_score.setText("Score: " + score);
                    updateQuestion(random.nextInt(4));
                    Toast.makeText(StartQuizActivity.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    updateQuestion(4);
                    Toast.makeText(StartQuizActivity.this,"Incorrect", Toast.LENGTH_SHORT).show();
                }
                questionCounter++;
                endQuizz();
            }
        });

        button_choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button_choice3.getText().toString().equals(answer)){
                    score++;
                    mTextView_score.setText("Score: " + score);
                    updateQuestion(random.nextInt(4));
                    Toast.makeText(StartQuizActivity.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    updateQuestion(4);
                    Toast.makeText(StartQuizActivity.this,"Incorrect", Toast.LENGTH_SHORT).show();
                }
                questionCounter++;
                endQuizz();
            }
        });

        button_choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button_choice4.getText().toString().equals(answer)){
                    score++;
                    mTextView_score.setText("Score: " + score);
                    updateQuestion(random.nextInt(4));
                    Toast.makeText(StartQuizActivity.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    updateQuestion(4);
                    Toast.makeText(StartQuizActivity.this,"Incorrect", Toast.LENGTH_SHORT).show();
                }
                questionCounter++;
                endQuizz();
            }
        });

//        radioButton_DefaultColorText = radioButton1.getTextColors();
//
//        // gets the total number of questions by getting the size of the ArrayList
//        totalQuestionCountInArrayList = questionsList.size();
//
//        // shuffles the questions, so they can be asked randomly
//        Collections.shuffle(questionsList);
//
//        QuizDatabaseHelper QuizzDbHelper = new QuizDatabaseHelper(this);
//        questionsList = QuizzDbHelper.readAllQuestions();

//        //askNextQuestion();
//        button_confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!answer){
//                    if(radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()){
//                        RadioButton radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
//                        int answerNumber = radioGroup.indexOfChild(radioButtonSelected)+1;
//
//                        if(answerNumber == currentQuestionAsked.getAnswerNum()){
//                            score++;
//                            mTextView_score.setText("Score: " + score);
//                        }
//                        showSolution();
//                    }
//                    else{
//                        Toast.makeText(StartQuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else{
//                    askNextQuestion();
//                }
//            }
//        });
 }

//    private void showSolution(){
//        radioButton1.setTextColor(Color.RED);
//        radioButton2.setTextColor(Color.RED);
//        radioButton3.setTextColor(Color.RED);
//        radioButton4.setTextColor(Color.RED);
//
//
//        if(currentQuestionAsked.getAnswerNum() == 1){
//            radioButton1.setTextColor(Color.GREEN);
//            mTextView_question.setText("Answer is Correct!");
//        }
//        else if (currentQuestionAsked.getAnswerNum() == 2){
//            radioButton2.setTextColor(Color.GREEN);
//            mTextView_question.setText("Answer is Correct!");
//        }
//        else if (currentQuestionAsked.getAnswerNum() == 3){
//            radioButton3.setTextColor(Color.GREEN);
//            mTextView_question.setText("Answer is Correct!");
//        }
//        else if (currentQuestionAsked.getAnswerNum() == 4){
//            radioButton4.setTextColor(Color.GREEN);
//            mTextView_question.setText("Answer is Correct!");
//        }
//
//        if(questionCounter < totalQuestionCountInArrayList){
//            button_confirm.setText("Next");
//        }
//        else{
//            button_confirm.setText("Finish");
//        }
//    }
//
//    private void askNextQuestion() {
//        radioButton1.setTextColor(radioButton_DefaultColorText);
//        radioButton2.setTextColor(radioButton_DefaultColorText);
//        radioButton3.setTextColor(radioButton_DefaultColorText);
//        radioButton4.setTextColor(radioButton_DefaultColorText);
//        radioGroup.clearCheck();
//
//        if(questionCounter < totalQuestionCountInArrayList){
//            currentQuestionAsked = questionsList.get(questionCounter);
//            //mTextView_question.setText(currentQuestionAsked.get);
//            //radioButton1.setText(currentQuestionAsked.getQuestion1());
//            radioButton2.setText(currentQuestionAsked.getOption2());
//            radioButton3.setText(currentQuestionAsked.getOption3());
//            radioButton4.setText(currentQuestionAsked.getOption4());
//            questionCounter++;
//            mTextView_questionCount.setText("Question: " + questionCounter + "/" + totalQuestionCountInArrayList);
//            answer = false;
//            button_confirm.setText("Confirm");
//        }
//        else{
//            finish();
//        }
//    }

    private void updateQuestion(int num) {
        mTextView_question.setText(getQuestions(num));
        radioButton1.setText(getChoice1(num));
        radioButton2.setText(getChoice2(num));
        radioButton3.setText(getChoice3(num));
        radioButton4.setText(getChoice4(num));

        answer = getCorrectAnswer(num);
    }

    public void endQuizz(){
        if(questionCounter>=5){
            Toast.makeText(this,"Game Ended", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StartQuizActivity.this, Result.class);
            startActivity(intent);
            this.finish();
        }
    }
}