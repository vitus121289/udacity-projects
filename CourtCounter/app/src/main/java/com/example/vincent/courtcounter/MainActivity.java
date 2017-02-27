package com.example.vincent.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method adds three to the score of team A.
     */
    public void addThreeForTeamA(View v) {
        teamAScore = teamAScore + 3;
        displayScoreForTeamA(teamAScore);
    }

    /**
     * This method adds two to the score of team A.
     */
    public void addTwoForTeamA(View v) {
        teamAScore = teamAScore + 2;
        displayScoreForTeamA(teamAScore);
    }

    /**
     * This method adds one to the score of team A.
     */
    public void addOneForTeamA(View v) {
        teamAScore = teamAScore + 1;
        displayScoreForTeamA(teamAScore);
    }

    /**
     * This method adds three to the score of Team B.
     */
    public void addThreeForTeamB(View v) {
        teamBScore = teamBScore + 3;
        displayScoreForTeamB(teamBScore);
    }

    /**
     * This method adds two to the score of team B.
     */
    public void addTwoForTeamB(View v) {
        teamBScore = teamBScore + 2;
        displayScoreForTeamB(teamBScore);
    }

    /**
     * This method adds one to the score of team B.
     */
    public void addOneForTeamB(View v) {
        teamBScore = teamBScore + 1;
        displayScoreForTeamB(teamBScore);
    }

    /**
     * This method displays the current score of team A.
     *
     * @param score is the current score of team A.
     */
    private void displayScoreForTeamA(int score) {
        TextView teamAScoreTextView = (TextView) findViewById(R.id.team_a_score_text_view);
        teamAScoreTextView.setText("" + score);
    }

    /**
     * This method displays the current score of team B.
     *
     * @param score is the current score of team B.
     */
    private void displayScoreForTeamB(int score) {
        TextView teamBScoreTextView = (TextView) findViewById(R.id.team_b_score_text_view);
        teamBScoreTextView.setText("" + score);
    }

    /**
     * This method resets the scores of team A and team B.
     */
    public void resetScores(View v) {
        teamAScore = 0;
        teamBScore = 0;
        displayScoreForTeamA(teamAScore);
        displayScoreForTeamB(teamBScore);
    }
}
