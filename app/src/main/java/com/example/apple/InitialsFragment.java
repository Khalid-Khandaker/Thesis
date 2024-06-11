package com.example.apple;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
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

public class InitialsFragment extends Fragment {
    /* Usual location for getting the instance of classes */
    Dialog charactersDialogMain, charactersDialogDescription;
    Button charactersDialogMainButtonCancel,charactersDialogMainButtonPronunciation,charactersDialogMainButtonDescription, charactersDialogDescriptionButtonExit;

    CardView fragmentInitialsCardViewB, fragmentInitialsCardViewP, fragmentInitialsCardViewM, fragmentInitialsCardViewF,
            fragmentInitialsCardViewD, fragmentInitialsCardViewI, fragmentInitialsCardViewG, fragmentInitialsCardViewK
            , fragmentInitialsCardViewH, fragmentInitialsCardViewJ, fragmentInitialsCardViewQ, fragmentInitialsCardViewX
            , fragmentInitialsCardViewZH, fragmentInitialsCardViewCH, fragmentInitialsCardViewSH, fragmentInitialsCardViewR
            , fragmentInitialsCardViewZ, fragmentInitialsCardViewC, fragmentInitialsCardViewS, fragmentInitialsCardViewY
            , fragmentInitialsCardViewT;
    CardView charactersMainDialogCardQuestion;
    TextView charactersDialogDescriptionTextView;

    /* Sets the maximum file size */
    final long ONE_MEGABYTE = 1024 * 1024;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_initials, container, false);

        /* This function contains all the get id's for each initial characters card view */
        initialsCharactersGetId(view);

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
        fragmentInitialsCardViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewB);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewB);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewB);
            }
        });

        fragmentInitialsCardViewP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewP);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/p.txt", fragmentInitialsCardViewP);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewP);
            }
        });

        fragmentInitialsCardViewM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewM);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/m.txt", fragmentInitialsCardViewM);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewM);
            }
        });

        fragmentInitialsCardViewF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewF);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/f.txt", fragmentInitialsCardViewF);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewF);
            }
        });

        fragmentInitialsCardViewD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewD);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewD);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewD);
            }
        });

        fragmentInitialsCardViewI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewI);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewI);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewI);
            }
        });

        fragmentInitialsCardViewG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewG);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewG);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewG);
            }
        });

        fragmentInitialsCardViewK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewK);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewK);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewK);
            }
        });

        fragmentInitialsCardViewH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewH);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewH);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewH);
            }
        });

        fragmentInitialsCardViewJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewJ);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewJ);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewJ);
            }
        });

        fragmentInitialsCardViewQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewQ);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewQ);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewQ);
            }
        });

        fragmentInitialsCardViewQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewQ);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewQ);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewQ);
            }
        });

        fragmentInitialsCardViewX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewX);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewX);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewX);
            }
        });

        fragmentInitialsCardViewZH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewZH);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewZH);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewZH);
            }
        });

        fragmentInitialsCardViewCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewCH);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewCH);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewCH);
            }
        });

        fragmentInitialsCardViewSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewSH);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewSH);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewSH);
            }
        });

        fragmentInitialsCardViewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewR);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewR);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewR);
            }
        });

        fragmentInitialsCardViewZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewZ);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewZ);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewZ);
            }
        });

        fragmentInitialsCardViewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewC);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewC);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewC);
            }
        });

        fragmentInitialsCardViewS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewS);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewS);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewS);
            }
        });

        fragmentInitialsCardViewY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewY);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewY);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewY);
            }
        });

        fragmentInitialsCardViewT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCharactersDialogMain(fragmentInitialsCardViewT);
                setCharactersDialogPronunciation();
                setCharactersDialogDescription("Characters-Description/Initials/b.txt", fragmentInitialsCardViewT);
                setCharactersDialogMainButtonCancel(fragmentInitialsCardViewT);
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

    /* This is the function definition for all the get id's for each initial characters card view !Beware do not expand! it contains seizure triggers! */
    private void initialsCharactersGetId(View view) {
        fragmentInitialsCardViewB = (CardView) view.findViewById(R.id.fragment_initial_cardview_b);
        fragmentInitialsCardViewP = (CardView) view.findViewById(R.id.fragment_initial_cardview_p);
        fragmentInitialsCardViewM = (CardView) view.findViewById(R.id.fragment_initial_cardview_m);
        fragmentInitialsCardViewF = (CardView) view.findViewById(R.id.fragment_initial_cardview_f);
        fragmentInitialsCardViewD = (CardView) view.findViewById(R.id.fragment_initial_cardview_d);
        fragmentInitialsCardViewI = (CardView) view.findViewById(R.id.fragment_initial_cardview_i);
        fragmentInitialsCardViewG = (CardView) view.findViewById(R.id.fragment_initial_cardview_g);
        fragmentInitialsCardViewK = (CardView) view.findViewById(R.id.fragment_initial_cardview_k);
        fragmentInitialsCardViewH = (CardView) view.findViewById(R.id.fragment_initial_cardview_h);
        fragmentInitialsCardViewJ = (CardView) view.findViewById(R.id.fragment_initial_cardview_j);
        fragmentInitialsCardViewQ = (CardView) view.findViewById(R.id.fragment_initial_cardview_q);
        fragmentInitialsCardViewX = (CardView) view.findViewById(R.id.fragment_initial_cardview_x);
        fragmentInitialsCardViewR = (CardView) view.findViewById(R.id.fragment_initial_cardview_r);
        fragmentInitialsCardViewZ = (CardView) view.findViewById(R.id.fragment_initial_cardview_z);
        fragmentInitialsCardViewC = (CardView) view.findViewById(R.id.fragment_initial_cardview_c);
        fragmentInitialsCardViewS = (CardView) view.findViewById(R.id.fragment_initial_cardview_s);
        fragmentInitialsCardViewY = (CardView) view.findViewById(R.id.fragment_initial_cardview_y);
        fragmentInitialsCardViewT = (CardView) view.findViewById(R.id.fragment_initial_cardview_t);
        fragmentInitialsCardViewZH = (CardView) view.findViewById(R.id.fragment_initial_cardview_zh);
        fragmentInitialsCardViewCH = (CardView) view.findViewById(R.id.fragment_initial_cardview_ch);
        fragmentInitialsCardViewSH = (CardView) view.findViewById(R.id.fragment_initial_cardview_sh);
    }
}