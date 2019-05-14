package com.example.Leogo.capstone2_anziday;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.Leogo.capstone2_anziday.Models.food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Bundle bundle;
    BottomNavigationView bottomNavigationView;
    public EditText edtSearchSubNav;
    private Button btnSearchSubNav;
    Fragment_DetailFood fragment_detailFood;
    Button btnBackMain;


    private Fragment_Home new_fragment_home;
    private ImageButton btnVoiceSearch;
    private SpeechRecognizer mySpeechRecognizer;
    private static final String TAG = "VoiceSearch:";
    private TextToSpeech myTTS;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearchSubNav = findViewById(R.id.edtSearchSubNav);
        btnSearchSubNav = findViewById(R.id.btnSearchSubNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Fragment_Home.newInstance()).commit();
        btnVoiceSearch = findViewById(R.id.btnVoiceSearch);
        btnVoiceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.UK);
                if (!intent.hasExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE)) {
                    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.dummy");
                }
                mySpeechRecognizer.startListening(intent);
            }
        });

        bundle = getIntent().getExtras();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        btnSearchSubNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                new_fragment_home = Fragment_Home.newInstance();
                bundle1.putString("keySearch", edtSearchSubNav.getText().toString());
                new_fragment_home.setArguments(bundle1);
                if (fragment_detailFood != null) {
                    clearStack();
                    bundle = getIntent().getExtras();
                    if (bundle != null) {
                        User objUser = bundle.getParcelable("user");
                        Bundle getUser = new Bundle();
                        getUser.putParcelable("user", objUser);
                        fragment_detailFood.setArguments(getUser);

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new_fragment_home).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new_fragment_home).commit();
                }

            }
        });
        //Nhận dữ liệu từ Login hoặc Update đổ vào Detail_Profile
        if (bundle != null) {
//            User objUser = bundle.getParcelable("user");
//            bundle.putParcelable("user",objUser);
//            fragment_detail_profile = new Fragment_Detail_Profile();
//            fragment_detail_profile.setArguments(bundle);
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment_detail_profile).commit();
        } else if (sharedPreferences.getInt("loginForCart", 0) == 1) {
            //bundle == null tức chưa login thì kiểm tra user có addCart không nếu có phải Login
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_Profile()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_Home()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(navLister);


        //initializeTextToSpeech();
        initializeSpeechRecognizer();

        btnBackMain = findViewById(R.id.btnBackMain);
        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


    }

    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(MainActivity.this, "There is no TTS engine on Your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(Locale.US);
                    speak("Hello! I'm ready.");
                }
            }
        });
    }

    private void speak(String message) {
        if (Build.VERSION.SDK_INT >= 21) {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


    private void processResult(String command) {
        command = command.toLowerCase();

        //what is your name
        //what is the time
        //open the browser

        if (command.indexOf("what") != -1) {
            if (command.indexOf("your name") != -1) {
                speak("My name is Siri.");
            } else {
                Date now = new Date();
                String time = DateUtils.formatDateTime(this, now.getTime(), DateUtils.FORMAT_SHOW_TIME);
                speak("The time now is " + time);
            }
        } else if (command.indexOf("open") != -1) {
            if (command.indexOf("browser") != -1) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(intent);
            }
        } else {
            speak("I understand your voice");
        }
    }

    private void initializeSpeechRecognizer() {
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            mySpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            mySpeechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {
                    speak("Hello! I'm on Ready For Speech.");
                }

                @Override
                public void onBeginningOfSpeech() {
                    speak("Hello! I'm on Beginning Of Speech.");
                }

                @Override
                public void onRmsChanged(float rmsdB) {
                    speak("Hello! I'm on Rms Changed." + rmsdB);
                    Log.d(TAG, "" + rmsdB);
                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {
                    String mError = "";
                    String mStatus = "Error detected";
                    switch (error) {
                        case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                            mError = " network timeout";
//                            startListening();
                            break;
                        case SpeechRecognizer.ERROR_NETWORK:
                            mError = " network";
                            //toast("Please check data bundle or network settings");
                            return;
                        case SpeechRecognizer.ERROR_AUDIO:
                            mError = " audio";
                            break;
                        case SpeechRecognizer.ERROR_SERVER:
                            mError = " server";
//                            startListening();
                            break;
                        case SpeechRecognizer.ERROR_CLIENT:
                            mError = " client";
                            break;
                        case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                            mError = " speech time out";
                            break;
                        case SpeechRecognizer.ERROR_NO_MATCH:
                            mError = " no match";
//                            startListening();

                            break;
                        case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                            mError = " recogniser busy";
                            break;
                        case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                            mError = " insufficient permissions";
                            break;

                    }
                    Log.i("error", "Error: " + error + " - " + mError);

                    Log.d("My Error:", error + "");
                    speak("Error" + error);

                }

                @Override
                public void onResults(Bundle results) {
                    speak("Hello! I'm results.");
                    List<String> result = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    if (result != null)
                        processResult(result.get(0));
                    else speak("No result");
                }

                @Override
                public void onPartialResults(Bundle partialResults) {
                    speak("Hello! I'm partialResults.");
                }

                @Override
                public void onEvent(int eventType, Bundle params) {
                    speak("Hello! I'm params.");
                }
            });
        }
    }

    public void clearStack() {
        //Here we are clearing back stack fragment entries
        int backStackEntry = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntry > 0) {
            for (int i = 0; i < backStackEntry; i++) {
                getSupportFragmentManager().popBackStackImmediate();
            }
        }

        //Here we are removing all the fragment that are shown here
        if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0) {
            for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                Fragment mFragment = getSupportFragmentManager().getFragments().get(i);
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(mFragment).commit();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void detailFood(food food) {
        if (food.getNameFood() != null && !food.getNameFood().equals("")) {

            fragment_detailFood = new Fragment_DetailFood();
            Bundle bundle1 = new Bundle();
            if(bundle!=null){
                User objUser = bundle.getParcelable("user");
                bundle1.putParcelable("objUser", objUser);
            }

            ArrayList<String> list = new ArrayList<>();
            list.add(food.getNameFood());
            list.add(food.getImage());
            list.add("Rating: " + food.getRating());
            list.add(food.getDecription());
            list.add(food.getFoodID());
            bundle1.putStringArrayList("foodDetail", list);
            fragment_detailFood.setArguments(bundle1);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment_detailFood).commit();
        } else
            Toast.makeText(this, " getNameFood() IS null", Toast.LENGTH_SHORT).show();

    }



    private BottomNavigationView.OnNavigationItemSelectedListener navLister =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = Fragment_Home.newInstance();

                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                            break;

                        case R.id.nav_suggest:
                            if (bundle != null) {
                                User objUser = bundle.getParcelable("user");
                                bundle.putParcelable("user", objUser);
                                selectedFragment = new Fragment_Suggests();
                                selectedFragment.setArguments(bundle);

                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                            } else {
                                yeuCauLogin();
                            }

                            break;
                        case R.id.nav_profile:

                            if (bundle != null) {
                                User objUser = bundle.getParcelable("user");
                                bundle.putParcelable("user", objUser);
                                selectedFragment = new Fragment_Detail_Profile();
                                selectedFragment.setArguments(bundle);

                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                            } else {
                                selectedFragment = new Fragment_Profile();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();
                            }
                            break;
                    }
                    return true;
                }
            };


    public void yeuCauLogin() {

        bottomNavigationView.setSelectedItemId(R.id.nav_profile);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_Profile()).commit();

    }

}
