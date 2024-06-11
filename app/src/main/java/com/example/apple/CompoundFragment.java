package com.example.apple;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CompoundFragment extends Fragment {

    Dialog charactersDialogMain, charactersDialogDescription;
    CardView charactersMainDialogCardQuestion;
    Button charactersDialogDescriptionButtonExit, charactersDialogMainButtonPronunciation, charactersDialogMainButtonDescription, charactersDialogMainButtonCancel;
    CardView fragmentCompoundCardViewAI, fragmentCompoundCardViewEI, fragmentCompoundCardViewOU, fragmentCompoundCardViewAN
            , fragmentCompoundCardViewEN, fragmentCompoundCardViewIN, fragmentCompoundCardViewUN, fragmentCompoundCardViewüN
            , fragmentCompoundCardViewIANG, fragmentCompoundCardViewENG;

    TextView charactersDialogDescriptionTextView;

    /* Sets the maximum file size */
    final long ONE_MEGABYTE = 1024 * 1024;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compound, container, false);

        /* This function contains all the get id's for each initial characters card view */
        compoundCharactersGetId(view);

        /* Setting up the main dialog */
        charactersDialogMain = new Dialog(getContext());
        charactersDialogMain.setContentView(R.layout.characters_dialog_box);
        charactersDialogMain.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        charactersDialogMain.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.characters_dialog_box_background));
        charactersDialogMain.setCancelable(false);

        /* Setting up the card view question background inside the characters dialog main */
        charactersMainDialogCardQuestion = charactersDialogMain.findViewById(R.id.characters_dialog_box_card_view_question);
        charactersMainDialogCardQuestion.setBackgroundDrawable(getResources().getDrawable(R.drawable.characters_dialog_box_card_view_question_background));

        /* Setting up the characters dialog description */
        charactersDialogDescription = new Dialog(getContext());
        charactersDialogDescription.setContentView(R.layout.characters_dialog_description);
        charactersDialogDescription.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        charactersDialogDescription.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        charactersDialogDescription.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.characters_dialog_box_background));
        charactersDialogDescription.setCancelable(false);

        /* Setting up characters description dialog text */
        charactersDialogDescriptionTextView = charactersDialogDescription.findViewById(R.id.characters_dialog_description_string_view);

        /* Setting up characters description dialog exit button */
        charactersDialogDescriptionButtonExit = charactersDialogDescription.findViewById(R.id.characters_description_button_exit);

        /* Setting up characters main dialog box buttons */
        charactersDialogMainButtonPronunciation = charactersDialogMain.findViewById(R.id.characters_dialog_box_button_pronunciation);
        charactersDialogMainButtonDescription = charactersDialogMain.findViewById(R.id.characters_dialog_box_button_details);
        charactersDialogMainButtonCancel = charactersDialogMain.findViewById(R.id.characters_dialog_button_cancel);

        fragmentCompoundCardViewAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewAI);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewAI);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewAI);
            }
        });

        fragmentCompoundCardViewEI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewEI);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewEI);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewEI);
            }
        });

        fragmentCompoundCardViewOU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewOU);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewOU);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewOU);
            }
        });

        fragmentCompoundCardViewAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewAN);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewAN);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewAN);
            }
        });

        fragmentCompoundCardViewEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewEN);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewEN);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewEN);
            }
        });

        fragmentCompoundCardViewIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewIN);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewIN);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewIN);
            }
        });

        fragmentCompoundCardViewUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewUN);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewUN);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewUN);
            }
        });

        fragmentCompoundCardViewüN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewüN);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewüN);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewüN);
            }
        });

        fragmentCompoundCardViewIANG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewIANG);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewIANG);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewIANG);
            }
        });

        fragmentCompoundCardViewENG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentCompoundCardViewENG);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentCompoundCardViewENG);
                setCharactersDialogMainButtonCancel(fragmentCompoundCardViewENG);
            }
        });

        return view;
    }

    private void setCharactersDialogMain(CardView view) {
        view.setCardBackgroundColor(getResources().getColor(R.color.cadmium_orange));//setCharactersDialogMain
        charactersDialogMain.show();
    }

    private void setCharactersDialogPronunciation() {
        charactersDialogMainButtonPronunciation.setOnClickListener(new View.OnClickListener() {//setCharactersDialogPronunciation()
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Video Pop up",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCharactersDialogDescription(String pathString, CardView cardView) {
        charactersDialogMainButtonDescription.setOnClickListener(new View.OnClickListener() { //setCharactersDialogDescription()
            @Override
            public void onClick(View v) {
                charactersDialogDescriptionButtonExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        charactersDialogDescription.cancel();
                        cardView.setCardBackgroundColor(getResources().getColor(R.color.lavender_indigo));
                    }
                });

                charactersDialogMain.cancel();

                charactersDialogDescriptionButtonExit.setClickable(false);
                charactersDialogDescription.show();

                StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(pathString);
                storageReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        String fileContent = new String(bytes);
                        charactersDialogDescriptionTextView.setText(fileContent);

                        charactersDialogDescriptionButtonExit.setClickable(true);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("FirebaseStorage", "Failed to fetch file: " + e.getMessage());
                    }
                });
            }
        });
    }

    private void setCharactersDialogMainButtonCancel(CardView cardView) {
        charactersDialogMainButtonCancel.setOnClickListener(new View.OnClickListener() {//setCharactersDialogMainButtonCancel
            @Override
            public void onClick(View v) {
                charactersDialogMain.cancel();
                cardView.setCardBackgroundColor(getResources().getColor(R.color.lavender_indigo));
            }
        });
    }

    private void compoundCharactersGetId(View view) {
        fragmentCompoundCardViewAI = (CardView) view.findViewById(R.id.fragment_compound_cardview_ai);
        fragmentCompoundCardViewEI = (CardView) view.findViewById(R.id.fragment_compound_cardview_ei);
        fragmentCompoundCardViewOU = (CardView) view.findViewById(R.id.fragment_compound_cardview_ou);
        fragmentCompoundCardViewAN = (CardView) view.findViewById(R.id.fragment_compound_cardview_an);
        fragmentCompoundCardViewEN = (CardView) view.findViewById(R.id.fragment_compound_cardview_en);
        fragmentCompoundCardViewIN = (CardView) view.findViewById(R.id.fragment_compound_cardview_in);
        fragmentCompoundCardViewUN = (CardView) view.findViewById(R.id.fragment_compound_cardview_un);
        fragmentCompoundCardViewüN = (CardView) view.findViewById(R.id.fragment_compound_cardview_ün);
        fragmentCompoundCardViewIANG = (CardView) view.findViewById(R.id.fragment_compound_cardview_iang);
        fragmentCompoundCardViewENG = (CardView) view.findViewById(R.id.fragment_compound_cardview_eng);
    }
}