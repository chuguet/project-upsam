package com.example.hello;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import com.netcompss.ffmpeg4android_client.BaseWizard;
import com.netcompss.ffmpeg4android_client.FileUtils;
import com.netcompss.ffmpeg4android_client.Prefs;
import com.netcompss.ffmpeg4android_client.TranscodeBackground;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class DemoClient extends BaseWizard {
	

	
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      
	      // if you want to change the default work location (/sdcard/videokit/) use the uncomment the below method.
	      // It must be defined before calling the copyLicenseAndDemoFilesFromAssetsToSDIfNeeded method,
	      // in order for this method to copy the assets to the correct location.
	      //setWorkingFolder("/sdcard/videokit3/");
	      
	      // this will copy the license file and the demo video file.
	      // to the videokit work folder location.
	      // without the license file the library will not work.
	      //copyLicenseAndDemoFilesFromAssetsToSDIfNeeded();

	     // setContentView(R.layout.ffmpeg_demo_client);
	      
	      Bundle b = getIntent().getExtras();
	      compress(b.getString("fullPath"));
	}
	
	public void compress(String fullPath){
		fullPath = fullPath.replace("file:/mnt", "");
		String outputFullPath = fullPath.replace(".mp4", "_out.mp4");
			//String commandStr = "ffmpeg -y -i /sdcard/videokit/in.mp4 -strict experimental -vf transpose=1 -s 160x120 -r 30 -aspect 4:3 -ab 48000 -ac 2 -ar 22050 -b 2097k /sdcard/videokit/out.mp4";
		String commandStr = "ffmpeg -y -i " + fullPath + " -strict experimental -vf transpose=1 -s 160x120 -r 30 -aspect 4:3 -ab 48000 -ac 2 -ar 22050 -b 2097k " + outputFullPath;
				
					//Log.i(Prefs.TAG, "Overriding the command with hard coded command");
					//commandStr = "ffmpeg -y -i /sdcard/videokit/in.mp4 -strict experimental -vf transpose=1 -s 160x120 -r 30 -aspect 4:3 -ab 48000 -ac 2 -ar 22050 -b 2097k /sdcard/videokit/vid_trans.mp4";
					
					//commandStr = "ffmpeg -y -i /sdcard/videokit/in.mp4 -strict experimental -s 160x120 -r 5 -aspect 4:3 -ab 48000 -ac 2 -ar 22050 -b 2097k -vcodec mpeg4 /sdcard/videokit/out.mp4";
					
					//increase video speed
					//String[] complexCommand = {"ffmpeg","-y" ,"-i", "/sdcard/videokit/in.mp4","-strict","experimental", "-an", "-filter:v", "setpts=0.5*PTS", "-b", "2097k","-r","60", "-vcodec", "mpeg4", "/sdcard/videokit/out.mp4"};
					
					// increase video and audio speed
					//String[] complexCommand = {"ffmpeg","-y" ,"-i", "/sdcard/videokit/in.mp4","-strict","experimental", "-filter_complex", "[0:v]setpts=0.5*PTS[v];[0:a]atempo=2.0[a]","-map","[v]","-map","[a]", "-b", "2097k","-r","60", "-vcodec", "mpeg4", "/sdcard/videokit/out.mp4"};
					
					// complex command should be used in cases sub-commands and embedded commands (for example quotations inside a command).
					//String[] complexCommand = {"ffmpeg","-y" ,"-i", "/sdcard/videokit/sample.mp4","-strict","experimental", "-vf", "crop=iw/2:ih:0:0,split[tmp],pad=2*iw[left]; [tmp]hflip[right]; [left][right] overlay=W/2", "-vb", "20M", "-r", "23.956", "/sdcard/videokit/out.mp4"};
					
									
					////////////////////////////////////////////////////////////////////////////////
					////// commands to needed to run the transcoding, only
					////// the setCommand and runTranscoding are mandatory.
					////// All the other commands are optional
					setCommand(commandStr);
					//setCommandComplex(complexCommand);

					///optional////
					setOutputFilePath(outputFullPath);
					setProgressDialogTitle("Exporting As MP4 Video");
					setProgressDialogMessage("Depends on your video size, it can take a few minutes");
					//setNotificationIcon(R.drawable.icon2);
					setNotificationMessage("Demo is running...");
					setNotificationTitle("Demo Client");
					setNotificationfinishedMessageTitle("Demo Transcoding finished");
					setNotificationfinishedMessageDesc("Click to play demo");
					setNotificationStoppedMessage("Demo Transcoding stopped");
					///////////////

					Log.i(Prefs.TAG, "ffmpeg4android library version: " + Prefs.getLibraryVersionName());
					runTranscoing();
		
    
	}

}
