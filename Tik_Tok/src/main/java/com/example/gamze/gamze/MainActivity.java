package com.example.gamze.gamze;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activPlayer=0;
    int Numberc=4;
    int NumbercY=5;
    boolean playeractiv=true;
    int[] gamzstart={2,2,2,2,2,2,2,2,2};
    int [][] rang={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{0,3,6},{2,5,8},{2,4,6},{1,4,7}};


 public void dropin(View view){
     ImageView conter = (ImageView) view;

     final TextView Nu=(TextView)findViewById(R.id.number);
     final TextView NY=(TextView)findViewById(R.id.numberY);

     int n1 = Numberc ;
     Nu.setText(String.valueOf(n1));

     int n2 = NumbercY-1 ;
     NY.setText(String.valueOf(n2));

     System.out.println(conter.getTag().toString());
        int tapconter=Integer.parseInt(conter.getTag().toString());

     if(gamzstart[tapconter] == 2 &&playeractiv) {
         gamzstart[tapconter]=activPlayer;

         if (activPlayer == 0) {
             conter.setTranslationY(-1000f);
             conter.setImageResource(R.drawable.yellow);
             conter.animate().translationYBy(1000f).rotation(360).setDuration(300);
             activPlayer = 1;

             Numberc--;
         } else {
             conter.setTranslationY(1000f);
             conter.setImageResource(R.drawable.red);
             conter.animate().translationYBy(-1000f).rotation(360).setDuration(300);
             activPlayer = 0;
             NumbercY--;
         }



         for(int[] wineerPosition:rang ){


            if(gamzstart[wineerPosition[0]]== gamzstart[wineerPosition[1]] &&
                    gamzstart[wineerPosition[1]]== gamzstart[wineerPosition[2]]&&
                    gamzstart[wineerPosition[0]] !=2) {
                playeractiv=false;
                 Numberc=4;
                NumbercY=5;
                String winner="Red";
                if(gamzstart[wineerPosition[0]]==0){
                    winner="Yellow";
                }
                TextView winnerM=(TextView) findViewById(R.id.winnerMsg);
                winnerM.setText(winner +" has won!");

                LinearLayout Layout=(LinearLayout) findViewById(R.id.playAganeLayout);
                Layout.setVisibility(View.VISIBLE);

                LinearLayout Layoute=(LinearLayout) findViewById(R.id.counterPlay);
                Layoute.setVisibility(View.INVISIBLE);
            }else
            {
                boolean gamzOver=true;
                for(int count:gamzstart){

                    if(count==2) gamzOver=false;
                }
                if(gamzOver){

                    TextView winnerM=(TextView) findViewById(R.id.winnerMsg);
                    winnerM.setText("It's a drow");
                    LinearLayout Layout=(LinearLayout) findViewById(R.id.playAganeLayout);
                    Layout.setVisibility(View.VISIBLE);


                    LinearLayout Layoute=(LinearLayout) findViewById(R.id.counterPlay);
                    Layoute.setVisibility(View.INVISIBLE);
                    Numberc=4;
                    NumbercY=5;


                }
            }

         }

     }


 }
    public void PlayAgain(View view){
        playeractiv=true;

        LinearLayout Layout=(LinearLayout) findViewById(R.id.playAganeLayout);
        Layout.setVisibility(View.INVISIBLE);

        LinearLayout Layoute=(LinearLayout) findViewById(R.id.counterPlay);
        Layoute.setVisibility(View.VISIBLE);

        activPlayer=0;
        for (int i=0;i<gamzstart.length;i++){
            gamzstart[i]=2;
        }
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridlayout);
        for (int i=0;i<gridLayout.getChildCount();i++){


            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumbercY=5;Numberc=4;
    }
}
