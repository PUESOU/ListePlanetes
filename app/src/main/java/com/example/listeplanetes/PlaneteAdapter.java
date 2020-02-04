package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

public class PlaneteAdapter extends BaseAdapter {
    public MainActivity mainActivity;

    @Override
    public int getCount() {
        return Data.nomPlanetes.size();
    }

    @Override
    public Object getItem(int position) {
        return Data.nomPlanetes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        //

        TextView nomPlanete = (TextView)itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox)itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner)itemView.findViewById(R.id.spinner);

        //

        nomPlanete.setText(Data.nomPlanetes.get(position));

        //


        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, Data.taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        //

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox checkBox = (CheckBox) buttonView.findViewById(R.id.checkbox);
                if(checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                }

                ViewGroup parent = ((ViewGroup)buttonView.getParent().getParent());
                int childCount = parent.getChildCount();

                for(int i = 0; i < childCount; ++i) {
                    if(!((CheckBox)parent.getChildAt(i).findViewById(R.id.checkbox)).isChecked()) {
                        ((Button)mainActivity.findViewById(R.id.verif)).setEnabled(false);
                        return;
                    }
                }

                ((Button)mainActivity.findViewById(R.id.verif)).setEnabled(true);
            }
        });

        //

        return itemView;
    }
}
