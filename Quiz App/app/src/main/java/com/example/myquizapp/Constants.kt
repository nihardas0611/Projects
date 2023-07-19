package com.example.myquizapp

object Constants {
    val USER_NAME:String="user_name"
    val CORRECT_ANSWER:String="correct_answer"
    val TOTAL_QUESTION:String="total_question"
    fun getQustions():ArrayList<Question>{
        var questionslist =ArrayList<Question>()

            val ques1 = Question(
                1, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
                R.drawable.af, "Afghanisthan", "Pakistan", "Iran", "Iraq",
                1)
        questionslist.add(ques1)

        val ques2 = Question(
            2, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.ar, "Afghanisthan", "Argentina", "Iran", "Iraq",
            2)
        questionslist.add(ques2)

        val ques3 = Question(
            3, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.aus, "Australia", "Argentina", "Iran", "Iraq",
            1)
        questionslist.add(ques3)

        val ques4 = Question(
            4, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.ban, "Afghanisthan", "Argentina", "Bangladesh", "Iraq",
            3)
        questionslist.add(ques4)

        val ques5 = Question(
            5, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.bra, "Afghanisthan", "Argentina", "Iran",
            "Brazil",
            4)
        questionslist.add(ques5)

        val ques6 = Question(
            6, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.can, "Afghanisthan", "Canada", "Iran",
            "Brazil",
            2)
        questionslist.add(ques6)

        val ques7 = Question(
            7, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.eng, "Afghanisthan", "Argentina", "England",
            "Brazil",
            3)
        questionslist.add(ques7)

        val ques8 = Question(
            8, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.fra, "Afghanisthan", "Argentina", "Iran",
            "France",
            4)
        questionslist.add(ques8)

        val ques9 = Question(
            9, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.ice, "Afghanisthan", "Argentina", "Iceland",
            "Brazil",
            3)
        questionslist.add(ques9)

        val ques10 = Question(
            10, "WHICH COUNTRY DOES THIS FLAG BELONG TO?",
            R.drawable.ind, "Afghanisthan", "India", "Iran",
            "Brazil",
            2)
        questionslist.add(ques10)
        return questionslist
    }
}