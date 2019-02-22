package com.arfeenkhan.privatechat.fragment;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arfeenkhan.privatechat.Model.ModelContacts;
import com.arfeenkhan.privatechat.R;
import com.arfeenkhan.privatechat.adapter.ContactAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Contacts extends Fragment {
    private int CONTACT_PERMISSION_CODE = 2;
    public Context mContext;
    private View v;
    private RecyclerView recyclerView;

    public Contacts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contacts, container, false);
        mContext = v.getContext();
        ContactPermission();

        recyclerView = v.findViewById(R.id.contact_recycler);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
//        recyclerView.setLayoutManager(layoutManager);
//
//        ContactAdapter adapter = new ContactAdapter(getContext(),getContacts());
//        recyclerView.setAdapter(adapter);
        return v;
    }

    private void ContactPermission() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {

        }else {
            requestContactPermission();
        }
    }

    private void requestContactPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext,Manifest.permission.READ_CONTACTS)){
            new AlertDialog.Builder(mContext)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) mContext,new String[]{Manifest.permission.READ_CONTACTS},CONTACT_PERMISSION_CODE);
                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .create().show();
        }else {
            ActivityCompat.requestPermissions((Activity) mContext,new String[]{Manifest.permission.READ_CONTACTS},CONTACT_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CONTACT_PERMISSION_CODE) {
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(mContext, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(mContext, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private List<ModelContacts> getContacts() {
        List<ModelContacts> list = new ArrayList<>();
        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        cursor.moveToFirst();
        while (cursor.moveToFirst()) {
            list.add(new ModelContacts(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));
        }
        return list;
    }

}
