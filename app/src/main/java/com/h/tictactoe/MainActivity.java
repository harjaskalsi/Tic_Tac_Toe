package com.h.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   int aP=0;//0 for zero
            //1 for cross
            //2 for null
    int [] state ={2,2,2,2,2,2,2,2,2};
    int [][] wins={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gamestate=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

    }
    public void playerTap(View view){
        ImageView img=(ImageView)view;
     int pressedimage=Integer.parseInt(img.getTag().toString());
     if(!gamestate)
     {
       gamereset(view);
     }
     if(state[pressedimage]==2)
     {
         state[pressedimage]=aP;
         img.setTranslationY(-1000f);
         if(aP==0)
         {  img.setImageResource(R.drawable.cross);
             aP=1;
             TextView status=findViewById(R.id.textView1);
             status.setText("O's Turn");
         }
         else{ img.setImageResource(R.drawable.zero);
             aP=0;
             TextView status=findViewById(R.id.textView1);
             status.setText("X's Turn");}
         img.animate().translationYBy(1000f).setDuration(300);
     }
     for(int[] winPos:wins ){
        if(state[winPos[0]]==state[winPos[1]] && state[winPos[1]]==state[winPos[2]] && state[winPos[0]]!=2)
        {  String winnerstr;
          gamestate=false;
            if(state[winPos[0]]==0)

                winnerstr="X has won";
            else
                winnerstr="O has won";

         TextView status=findViewById(R.id.textView1);
         status.setText(winnerstr);}
     }
    }

   public void gamereset(View view)
   {
       gamestate=true;
       aP=0;
       for(int i=0;i< state.length;i++)
       {
           state[i]=2;
       }
       ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
       TextView status=findViewById(R.id.textView1);
       status.setText("X's Turn");
   }
}