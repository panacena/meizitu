package com.zkk.meizitu.ui.welcome;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.VideoView;

import com.zkk.meizitu.R;
import com.zkk.meizitu.ui.main.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

	private VideoView welcomeVideo;
	private ImageView musicBtn;
	private boolean isVolumon = true;
	private AudioManager mAudioManager;
	private ImageView skipBtn; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.welcome_activity_layout);
	   
	    
	    welcomeVideo=(VideoView)findViewById(R.id.welcomeVideo);
	    Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome);
	    welcomeVideo.setVideoURI(localUri);
	    welcomeVideo.start();
	    welcomeVideo.requestFocus();
	    
	    
	    welcomeVideo.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer arg0) {
				// TODO Auto-generated method stub
				System.out.println("欢迎页播放完成!");
				Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	    musicBtn=(ImageView)findViewById(R.id.musicBtn);
	    musicBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(isVolumon){
					musicBtn.setImageResource(R.drawable.ic_music_off);
					turnOff();
				}else{
					musicBtn.setImageResource(R.drawable.ic_music_on);
					turnOn();
				}
			}
		});
	    
	    mAudioManager = ((AudioManager)getSystemService(Context.AUDIO_SERVICE));
	    skipBtn=(ImageView)findViewById(R.id.skipBtn);
	    skipBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	    
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	
	 private void turnOff(){
		 isVolumon=false;
		 mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,0,0);
	  }

	  private void turnOn(){
		  isVolumon=true;
		  mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,3,0);// 直接控制 音量绝对值
	  }
	
	
}
