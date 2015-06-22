package example.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;



    public  class ScanFragment extends Fragment {
        private String toast;
        View view;
        public ScanFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            displayToast();
        }
//src="http://docs.google.com/gview?embedded=true&url=https://drive.google.com/file/d/0B4vimDEQD19fMGVEejZKQko3TDQ/view?usp=sharing"
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
             view = inflater.inflate(R.layout.fragment_scan, container, false);

            ImageButton scan = (ImageButton) view.findViewById(R.id.scan_from_fragment);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanFromFragment();
                }
            });
            return view;
        }

        public void scanFromFragment() {
            IntentIntegrator.forSupportFragment(this).initiateScan();
        }

        private void displayToast() {
            if(getActivity() != null && toast != null) {
                Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
                toast = null;
                WebView wv = (WebView)view.findViewById(R.id.pdfview);
                wv=(WebView)view.findViewById(R.id.pdfview);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.loadUrl("https://docs.google.com/viewer?url=" + "https://s3-us-west-2.amazonaws.com/hackathonutd/Resume_Haridarshan_New.pdf");
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null) {
                if(result.getContents() == null) {
                    toast = "Cancelled from fragment";
                } else {
                    toast = "Scanned from fragment: " + result.getContents();
                }

                // At this point we may or may not have a reference to the activity
                displayToast();
            }
        }
    }

