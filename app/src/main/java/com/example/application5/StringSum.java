package com.example.application5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class StringSum extends Fragment {
    private final String STRING_KEY = "String_Result";

    private TextView resultText;


    public StringSum() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_string_sum, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resultText = view.findViewById(R.id.result_string_text);

        if (savedInstanceState != null) {
            resultText.setText(savedInstanceState.getString(STRING_KEY));
        }

        Button sumButton = view.findViewById(R.id.sum_string_button);
        TextView firstText = view.findViewById(R.id.first_string_text);
        TextView secondText = view.findViewById(R.id.second_string_text);

        sumButton.setOnClickListener (v -> {
            if (firstText.getText().length() == 0 || secondText.getText().length() == 0) {
                showSnackbar(v, getString(R.string.empty_field_err));
                return;
            }

            String firstStr =  firstText.getText().toString();
            String secondStr = secondText.getText().toString();

            String resultStr = getString(R.string.result) + firstStr + secondStr;
            resultText.setText(resultStr);

            addHistoryItem(firstStr, secondStr, resultStr);
            showSnackbar(v, resultStr);
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(STRING_KEY, resultText.getText().toString());
        super.onSaveInstanceState(outState);
    }

    private void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    private void addHistoryItem(String first, String second, String result) {
        MainActivity parent = (MainActivity) getActivity();
        parent.addToHistory(new HistoryItem(first, second, first + second, "StringSum"));
    }
}
