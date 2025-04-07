package br.com.etecia.agenda_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TelaSecundariaAgendaFragment extends Fragment {

    MaterialDatePicker<Long> datepiker;
    Button btn_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tela_secundaria_agenda_layout, container, false);

        //instanciando o datepiker
        datepiker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecione a data").build();

        //apresentaçoes XML + Java
        btn_date = view.findViewById(R.id.btnData);

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mostra o seletor de datas na tela
                datepiker.show(getChildFragmentManager(),"date");
            }
        });
        datepiker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                //formata a data selecionada
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String data_formatada = format.format(new Date(selection));

                Toast.makeText(getContext(), data_formatada, Toast.LENGTH_SHORT).show();
                btn_date.setText(data_formatada);

            }
        });




        return view;
    }
}