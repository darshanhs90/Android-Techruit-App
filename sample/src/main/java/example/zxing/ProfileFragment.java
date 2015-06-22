package example.zxing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import java.io.InputStream;


public  class ProfileFragment extends Fragment {
    private String toast;

    public ProfileFragment(Activity activity) {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
       WebView wv =(WebView)view.findViewById(R.id.ivQR);
        wv.getSettings().setJavaScriptEnabled(true);
       wv.loadUrl("http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=darshanhs&qzone=1&margin=0&size=300x300&center=true");


        return view;
    }




}

