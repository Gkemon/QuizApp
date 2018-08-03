package binary.com.quizApp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

public View bangla,english,math,GK;
public String subject;
public static int selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test_choose);

        bangla=findViewById(R.id.bangla_button);
        english=findViewById(R.id.english_button);
        math=findViewById(R.id.math_button);
        GK=findViewById(R.id.general_knowledge_button);

        bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject="bangla";
                buildDialog(MainActivity.this,subject);

            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject="english";
                buildDialog(MainActivity.this,subject);

            }
        });

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject="math";
                buildDialog(MainActivity.this,subject);

            }
        });

        GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject="gk";
                buildDialog(MainActivity.this,subject);

            }
        });



    }

    public static  void buildDialog(final Activity activity, final String subject) {

        final CharSequence[] items = new CharSequence[3];
        items[0]="১৫ মিনিট";
        items[1]="৩০ মিনিট";
        items[2]="১ ঘন্টা";
        final int itemSelected = 0;



        new AlertDialog.Builder(activity)

                .setSingleChoiceItems(items, itemSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialogInterface, int i) {
                        selectedTime=i;
                    }

                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }

                })
                .setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(activity,ModelTestActivity.class);

                        if(selectedTime==0){
                            intent.putExtra("time","15");
                        }else if(selectedTime==1){
                            intent.putExtra("time","30");
                        }
                        else {
                            intent.putExtra("time","60");
                        }

                        intent.putExtra("subject",subject);
                        activity.startActivity(intent);

                    }
                })
                .show();



    }
}
