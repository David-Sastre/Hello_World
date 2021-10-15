package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    public static final String EXTRA_MESSAGE = "com.example.hello_world.MESSAGE";
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.nuevaAct);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Información","Método onCreate");
        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
    }
    /*Primer Ejercicio*/
    /*@Override
    protected void onStart() {
        super.onStart();
        Log.i("Inicio", "Esto Empieza");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop", "Método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "Método onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause", "Método onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Resume", "Método onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Restart", "Método onRestart");
    }
    */
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "ConfirmadoUnToque:" + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "dosToques:" + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "EventoDosToques:" + event.toString());
        return true;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"Presionar: " + event.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "OnShowPress:" + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp:" + event.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent event, MotionEvent event1, float v, float v1) {
        Log.d(DEBUG_TAG, "onScroll:" + event.toString() + event1.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress:" + event.toString());


    }

    @Override
    public boolean onFling(MotionEvent event, MotionEvent event1, float v, float v1) {
        Log.d(DEBUG_TAG, "onScroll:" + event.toString() + event1.toString());
        return true;
    }
}