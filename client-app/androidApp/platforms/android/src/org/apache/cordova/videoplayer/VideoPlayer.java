package org.apache.cordova.videoplayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.dialogs.Notification;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.netcompss.ffmpeg4android_client.Prefs;

public class VideoPlayer extends CordovaPlugin {
	protected ProgressDialog progressDialog;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";

        try {
            if (action.equals("playVideo")) {
                playVideo(args.getString(0), callbackContext);
            }
            else {
                status = PluginResult.Status.INVALID_ACTION;
            }
            callbackContext.sendPluginResult(new PluginResult(status, result));
        }
        catch (JSONException e) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        }
        catch (IOException e) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION));
        } 
    	finally {
    		progressDialog.dismiss();
    	}
        return true;
    }

    private void playVideo(String url, final CallbackContext callbackContext) throws IOException {
    	progressStart();
    	//prepareProgressDialog();
    	final URL myURL = new URL(url);
    	final CordovaInterface cordova = this.cordova;

    	Uri uri;
		try {
			uri = downloadVideo(myURL);
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(uri, "video/*");
		cordova.getActivity().startActivity(intent);
		}
		catch (IOException e) {
			 callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION));
		}
    	
    	
//    	cordova.getThreadPool().execute(new Runnable() {
//            public void run() {
//            	Uri uri;
//				try {
//					uri = downloadVideo(myURL);
//				
//        		Intent intent = new Intent(Intent.ACTION_VIEW);
//        		intent.setDataAndType(uri, "video/*");
//        		cordova.getActivity().startActivity(intent);
//				}
//				catch (IOException e) {
//					 callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION));
//				}
//            }
//    	});
//		
    }

    private Uri downloadVideo(URL url) throws IOException{
    	HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    	urlConnection.setRequestMethod("GET");
    	urlConnection.setDoOutput(true);
    	urlConnection.connect();

    	  //set the path where we want to save the file

    	  //in this case, going to save it on the root directory of the

    	  //sd card.

    	  File SDCardRoot = getOutputMediaFile();

    	  //create a new file, specifying the path, and the filename

    	  //which we want to save the file as.

    	  File video = new File(SDCardRoot,"video_to_reproduce.mp4");
    	  if (video.exists()){
    		  video.delete();
    	  }

    	  //this will be used to write the downloaded data into the file we created

    	  FileOutputStream fileOutput = new FileOutputStream(video);

    	  //this will be used in reading the data from the internet

    	  InputStream inputStream = urlConnection.getInputStream();

    	  //this is the total size of the file

    	  int totalSize = urlConnection.getContentLength();

    	  //variable to store total downloaded bytes

    	  int downloadedSize = 0;

    	  //create a buffer...

    	  byte[] buffer = new byte[1024];

    	  int bufferLength = 0; //used to store a temporary size of the buffer

    	  //now, read through the input buffer and write the contents to the file

    	  while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
    		  fileOutput.write(buffer, 0, bufferLength);
    		  downloadedSize += bufferLength;
    		  int progress=(int)(downloadedSize*100/totalSize);
    		  progressDialog.setProgress(progress);
    	  }
    	  progressDialog.setProgress(100);

    	  //close the output stream when done

    	  fileOutput.close();
    	  progressDialog.dismiss();
    	  return Uri.fromFile(video);
    }
 

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(){
    	File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "HospitalVideo");
   
    	// Create the storage directory(MyCameraVideo) if it does not exist
    	if (! mediaStorageDir.exists()){
   
    		if (! mediaStorageDir.mkdirs()){
    			Log.d("MyCameraVideo", "Failed to create directory MyCameraVideo.");
    			return null;
    		}
    	}
    	return mediaStorageDir;
	}
    
    public synchronized void progressStart() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
        final VideoPlayer notification = this;
        final CordovaInterface cordova = this.cordova;
        Runnable runnable = new Runnable() {
            public void run() {
       
                notification.progressDialog = new ProgressDialog(cordova.getActivity());
                notification.progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                notification.progressDialog.setTitle("Descargando video");
                notification.progressDialog.setMessage("Se está descargando el video del servidor. Puede tardar varios minutos dependiendo del tamaño");
                notification.progressDialog.setCancelable(true);
                notification.progressDialog.setMax(100);
                notification.progressDialog.setProgress(0);
                notification.progressDialog.setOnCancelListener(
                        new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface dialog) {
                                notification.progressDialog = null;
                            }
                        });
                notification.progressDialog.show();

            }
        };
        this.cordova.getActivity().runOnUiThread(runnable);
    }

}