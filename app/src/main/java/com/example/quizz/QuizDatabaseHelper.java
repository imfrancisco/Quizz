package com.example.quizz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.quizz.QuizContract.*;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;
    private static final String DATABASE_NAME = "Quizz.db";
    private static final Integer DATABASE_VERSION = 1;

    public QuizDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Initially create the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.database = db;
        final String SQL_CREATE_QUESTIONS_TABLE="CREATE TABLE " + QuestionsTable.TABLE_NAME + " ( "
                                                                + QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                                                                + QuestionsTable.COLUMN_QUESTION + " TEXT "
                                                                + QuestionsTable.COLUMN_OPTION1 + " TEXT "
                                                                + QuestionsTable.COLUMN_OPTION2 + " TEXT "
                                                                + QuestionsTable.COLUMN_OPTION3 + " TEXT "
                                                                + QuestionsTable.COLUMN_OPTION4 + " TEXT"
                                                                + QuestionsTable.COLUMN_ANSWER_NUMBER + " INTEGER" + ")";
        database.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    private void fillQuestionsTable() {
        Questions questions1 = new Questions("A is correct", "A", "B","C", "D", 1);
        addQuestion(questions1);
        Questions questions2 = new Questions("B is correct", "A", "B","C", "D", 2);
        addQuestion(questions2);
        Questions questions3 = new Questions("C is correct", "A", "B","C", "D", 3);
        addQuestion(questions3);
        Questions questions4 = new Questions("D is correct", "A", "B","C", "D", 4);
        addQuestion(questions4);
        Questions questions5 = new Questions("D is correct", "A", "B","C", "D", 4);
        addQuestion(questions5);
        Questions questions6 = new Questions("C is correct", "A", "B","C", "D", 3);
        addQuestion(questions6);
        Questions questions7 = new Questions("B is correct", "A", "B","C", "D", 2);
        addQuestion(questions7);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            database.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
            onCreate(database);
    }

    // Insert question into Database
    private void addQuestion(Questions question){
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        contentValues.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        contentValues.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        contentValues.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        contentValues.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        contentValues.put(QuestionsTable.COLUMN_ANSWER_NUMBER, question.getAnswerNum());
        database.insert(QuestionsTable.TABLE_NAME, null, contentValues);
    }

    // Read the question from Database
    public List<Questions> readAllQuestions(){
        List<Questions> questionsList = new ArrayList<>();
        database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME,null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                Questions questions = new Questions();
                questions.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                questions.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                questions.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                questions.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                questions.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                questions.setAnswerNum(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUMBER)));
                questionsList.add(questions);
            }
        }
        cursor.close();
        return questionsList;
    }
}
