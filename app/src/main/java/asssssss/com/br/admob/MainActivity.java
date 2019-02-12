package asssssss.com.br.admob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    @Override
    //https://www.youtube.com/watch?v=J10clvXNw3E
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        //banner ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //interestial ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed()
            {
                super.onAdClosed();
                finish();
            }
        });



        }

    public void showInterestial()
    {
        if (mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
        else
        {
            Log.d ("TAG-INT", "anuncio INT não carregou ainda");
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        //show ad of app exiting
        showInterestial();
    }
}

