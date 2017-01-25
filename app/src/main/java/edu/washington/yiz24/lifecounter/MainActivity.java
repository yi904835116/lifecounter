package edu.washington.yiz24.lifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.attr.button;
import static android.R.attr.onClick;
import static edu.washington.yiz24.lifecounter.R.styleable.View;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int[] scores;
    private TextView[] scoreList;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.result);
        MyListener listener = new MyListener();

        scores = new int[4];
        for(int i = 0; i< 4; i++){
            scores[i] = 20;
        }

        findViewById(R.id.p1PlusOne).setOnClickListener(listener);
        findViewById(R.id.p1MinusOne).setOnClickListener(listener);
        findViewById(R.id.p1PlusFive).setOnClickListener(listener);
        findViewById(R.id.p1MinusFive).setOnClickListener(listener);

        findViewById(R.id.p2PlusOne).setOnClickListener(listener);
        findViewById(R.id.p2MinusOne).setOnClickListener(listener);
        findViewById(R.id.p2PlusFive).setOnClickListener(listener);
        findViewById(R.id.p2MinusFive).setOnClickListener(listener);

        findViewById(R.id.p3PlusOne).setOnClickListener(listener);
        findViewById(R.id.p3MinusOne).setOnClickListener(listener);
        findViewById(R.id.p3PlusFive).setOnClickListener(listener);
        findViewById(R.id.p3MinusFive).setOnClickListener(listener);

        findViewById(R.id.p4PlusOne).setOnClickListener(listener);
        findViewById(R.id.p4MinusOne).setOnClickListener(listener);
        findViewById(R.id.p4PlusFive).setOnClickListener(listener);
        findViewById(R.id.p4MinusFive).setOnClickListener(listener);

        scoreList = new TextView[4];
        scoreList[0] = (TextView) findViewById(R.id.p1Score);
        scoreList[1] = (TextView) findViewById(R.id.p2Score);
        scoreList[2] = (TextView) findViewById(R.id.p3Score);
        scoreList[3] = (TextView) findViewById(R.id.p4Score);

    }


    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            int type = Integer.parseInt((String) v.getTag());
            TextView score = scoreList[type];

            if(button.getText().equals("+")){
                scores[type] += 1;
            }else if(button.getText().equals("+5")){
                scores[type] += 5;
            }else if(button.getText().equals("-")){
                scores[type] -= 1;
            }else{
                scores[type] -= 5;
            }
            score.setText("" + scores[type]);

            if(scores[type] <= 0){
                result.setText("Player " + (type + 1) + " LOSES!");
            }else{
                result.setText("");
            }
        }
    }

}


