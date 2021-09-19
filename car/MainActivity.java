package com.example.car;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ImageButton up,down,left,right;
    Button btnurl;
    Animation animation,animation1,animation2,animation3;
//    ConstraintLayout layout;
    EditText url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up=findViewById(R.id.button);
        left=findViewById(R.id.button2);
        right=findViewById(R.id.button3);
        down =findViewById(R.id.button4);
        url=findViewById(R.id.url);
        btnurl=findViewById(R.id.btnurl);

            animation= AnimationUtils.loadAnimation(this,R.anim.bounce);
        animation1= AnimationUtils.loadAnimation(this,R.anim.bounce);
        animation2= AnimationUtils.loadAnimation(this,R.anim.bounce);
        animation3= AnimationUtils.loadAnimation(this,R.anim.bounce);

        btnurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url.getText();

            }
        });

        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference().child("users");
                        myRef.child("up").setValue(1);
                        up.startAnimation(animation);




                        return true;
                    case MotionEvent.ACTION_UP:
                        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                        DatabaseReference myRef1 = database1.getReference().child("users");
                        myRef1.child("up").setValue(0);
                        up.startAnimation(animation);
                        
                        return true;
                }
                return false;
            }
        });

        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference().child("users");
                        myRef.child("down").setValue(1);
                        down.startAnimation(animation1);
                        return true;
                        
                    case MotionEvent.ACTION_UP:
                        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                        DatabaseReference myRef1 = database1.getReference().child("users");
                        myRef1.child("down").setValue(0);
                        down.startAnimation(animation1);

                        return true;
                }
                return false;
            }
        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference().child("users");
                        myRef.child("left").setValue(1);
                        left.startAnimation(animation2);
                        return true;
                        
                    case MotionEvent.ACTION_UP:
                        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                        DatabaseReference myRef1 = database1.getReference().child("users");
                        myRef1.child("left").setValue(0);
                        left.startAnimation(animation2);
                        return true;
                }
                return false;
            }
        });
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference().child("users");
                        myRef.child("right").setValue(1);
                        right.startAnimation(animation3);
                        return true;
                    case MotionEvent.ACTION_UP:
                        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                        DatabaseReference myRef1 = database1.getReference().child("users");
                        myRef1.child("right").setValue(0);
                        right.startAnimation(animation3);
                        return true;
                }
                return false;
            }
        });






    }
}