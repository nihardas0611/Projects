package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mcurrentposition: Int=1
    private var mQuestionList:ArrayList<Question> = ArrayList()
    private var mSelectedQuestion:Int=0
    private var musername:String?=null
    private var correct_answer=0
    private var total_answer=0

    private var tvquestion:TextView?=null
    private var ivimage:ImageView?=null
    private var progressbar:ProgressBar?=null
    private var tvprogress:TextView?=null

    private var optionone:TextView?=null
    private var optiontwo:TextView?=null
    private var optionthree:TextView?=null
    private var optionfour:TextView?=null
    private var btnsubmit:Button?=null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        musername=intent.getStringExtra(Constants.USER_NAME)
        tvquestion=findViewById(R.id.tv_question)
        ivimage=findViewById(R.id.ir_image)
        progressbar=findViewById(R.id.progressBar)
        tvprogress=findViewById(R.id.tv_progress)
        optionfour=findViewById(R.id.tv_option_four)
        optionone=findViewById(R.id.tv_option_one)
        optionthree=findViewById(R.id.tv_option_three)
        optiontwo=findViewById(R.id.tv_option_two)
        btnsubmit=findViewById(R.id.btn_submit)

        mQuestionList = Constants.getQustions()

        setQuestion()
        
        optionone?.setOnClickListener{
            onClick(it)
        }
        optiontwo?.setOnClickListener(this)
        optionthree?.setOnClickListener(this)
        optionfour?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

    }
    private fun setQuestion() {
        defaultoptionsview()
        //mcurrentposition = 1
        val questions: Question = mQuestionList!![mcurrentposition - 1]
        tvquestion?.text = questions.question
        ivimage?.setImageResource(questions.image)
        progressbar?.progress = mcurrentposition
        tvprogress?.text = "$mcurrentposition/${progressbar?.max}"
        optionone?.text = questions.option1
        optiontwo?.text = questions.option2
        optionthree?.text = questions.option3
        optionfour?.text = questions.option4
        if(mcurrentposition == mQuestionList!!.size)
        {
            btnsubmit?.text="FINISH"
        }else{
            btnsubmit?.text="NEXT"
        }
    }

    private fun defaultoptionsview(){
        val options = ArrayList<TextView>()
        optionone?.let{
            options.add(0,it)
        }
        optiontwo?.let{
            options.add(1,it)
        }
        optionthree?.let{
            options.add(2,it)
        }
        optionfour?.let{
            options.add(3,it)
        }
        for(option in options)
        {
            option.setTextColor(Color.parseColor("#FF0000"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.background_colour_text
            )
        }
    }

    private fun selectedoptionview(tv:TextView,optionnum:Int){
        defaultoptionsview()
        mSelectedQuestion=optionnum
        tv.setTextColor(Color.parseColor("#3636A3"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.ic_back
        )
    }


    override fun onClick(view: View?) {
       when(view?.id)
       {
           R.id.tv_option_one->{
               optionone?.let {
                   selectedoptionview(it,1)
               }
           }
           R.id.tv_option_two->{
               optiontwo?.let {
                   selectedoptionview(it,2)
               }
           }
           R.id.tv_option_three->{
               optionthree?.let {
                   selectedoptionview(it,3)
               }
           }
           R.id.tv_option_four->{
               optionfour?.let {
                   selectedoptionview(it,4)
               }
           }
           R.id.btn_submit->{
               btnsubmit?.let {
                   if(mSelectedQuestion==0){
                       mcurrentposition++
                       if(mcurrentposition<=mQuestionList!!.size)
                           setQuestion()

                           else{
                               val intent = Intent(this, ResultActivity::class.java)
                               //startActivity(Intent(this,ResultActivity::class.java))
                               intent.putExtra(Constants.USER_NAME,musername)
                               intent.putExtra(Constants.TOTAL_QUESTION,mQuestionList?.size)
                               intent.putExtra(Constants.CORRECT_ANSWER,correct_answer)
                               Toast.makeText(this,"You made it to end",Toast.LENGTH_LONG).show()
                                startActivity(intent)
                               finish()
                           }

                       }

                   else{
                       val ques= mQuestionList!![mcurrentposition-1]
                       if(ques.correct!=mSelectedQuestion)
                       {
                            answerView(mSelectedQuestion,R.drawable.wrong)
                       }else{
                           correct_answer++
                       }
                       answerView(ques.correct,R.drawable.correct)

                   }
                   if(mcurrentposition==mQuestionList!!.size)
                       btnsubmit?.text="FINISH"
                   else
                       btnsubmit?.text="GO TO NEXT QUESTION"
                   mSelectedQuestion=0
               }
           }
       }
    }
    private fun answerView(answer:Int,Drawableview:Int)
    {
        when(answer) {
            1 -> {
                optionone?.background = ContextCompat.getDrawable(
                    this,
                    Drawableview
                )
            }
            2 -> {
                optiontwo?.background = ContextCompat.getDrawable(
                    this,
                    Drawableview
                )
            }
            3 -> {
                optionthree?.background = ContextCompat.getDrawable(
                    this,
                    Drawableview
                )
            }
            4 -> {
                optionfour?.background = ContextCompat.getDrawable(
                    this,
                    Drawableview
                )
            }
        }
    }
}