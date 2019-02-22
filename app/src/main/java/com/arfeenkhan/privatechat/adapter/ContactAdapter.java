package com.arfeenkhan.privatechat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arfeenkhan.privatechat.Model.ModelContacts;
import com.arfeenkhan.privatechat.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private LayoutInflater inflater;
    private Context mContext;
    private List<ModelContacts> mListContact;

    public ContactAdapter(Context mContext, List<ModelContacts> mListContact) {
        this.mContext = mContext;
        this.mListContact = mListContact;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_contact, viewGroup, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int i) {
        TextView contaxt_name, contact_number;
        contaxt_name = holder.contact_name;
        contact_number = holder.contact_number;
        contaxt_name.setText(mListContact.get(i).getName());
        contact_number.setText(mListContact.get(i).getNumber());
    }

    @Override
    public int getItemCount() {
        return mListContact.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView contact_name, contact_number;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_name = itemView.findViewById(R.id.text_view_contact_username);
            contact_number = itemView.findViewById(R.id.number);
        }
    }
}
