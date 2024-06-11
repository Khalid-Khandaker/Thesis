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

public class SimpleFragment extends Fragment {

    Dialog charactersDialogMain, charactersDialogDescription;
    CardView charactersMainDialogCardQuestion;
    Button charactersDialogDescriptionButtonExit, charactersDialogMainButtonPronunciation, charactersDialogMainButtonDescription, charactersDialogMainButtonCancel;
    CardView fragmentSimpleCardViewA, fragmentSimpleCardViewE, fragmentSimpleCardViewI, fragmentSimpleCardViewO
            , fragmentSimpleCardViewU, fragmentSimpleCardViewü;

    TextView charactersDialogDescriptionTextView;

    /* Sets the maximum file size */
    final long ONE_MEGABYTE = 1024 * 1024;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);

        /* This function contains all the get id's for each initial characters card view */
        simpleCharactersGetId(view);

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

        fragmentSimpleCardViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentSimpleCardViewA);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentSimpleCardViewA);
                setCharactersDialogMainButtonCancel(fragmentSimpleCardViewA);
            }
        });

        fragmentSimpleCardViewE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentSimpleCardViewE);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentSimpleCardViewE);
                setCharactersDialogMainButtonCancel(fragmentSimpleCardViewE);
            }
        });

        fragmentSimpleCardViewI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentSimpleCardViewI);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentSimpleCardViewI);
                setCharactersDialogMainButtonCancel(fragmentSimpleCardViewI);
            }
        });

        fragmentSimpleCardViewO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentSimpleCardViewO);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentSimpleCardViewO);
                setCharactersDialogMainButtonCancel(fragmentSimpleCardViewO);
            }
        });

        fragmentSimpleCardViewU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentSimpleCardViewU);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentSimpleCardViewU);
                setCharactersDialogMainButtonCancel(fragmentSimpleCardViewU);
            }
        });

        fragmentSimpleCardViewü.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentSimpleCardViewü);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentSimpleCardViewü);
                setCharactersDialogMainButtonCancel(fragmentSimpleCardViewü);
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

    private void simpleCharactersGetId(View view) {
        fragmentSimpleCardViewA = (CardView) view.findViewById(R.id.fragment_simple_cardview_a);
        fragmentSimpleCardViewE = (CardView) view.findViewById(R.id.fragment_simple_cardview_e);
        fragmentSimpleCardViewI = (CardView) view.findViewById(R.id.fragment_simple_cardview_i);
        fragmentSimpleCardViewO = (CardView) view.findViewById(R.id.fragment_simple_cardview_o);
        fragmentSimpleCardViewU = (CardView) view.findViewById(R.id.fragment_simple_cardview_u);
        fragmentSimpleCardViewü = (CardView) view.findViewById(R.id.fragment_simple_cardview_ü);
    }
}