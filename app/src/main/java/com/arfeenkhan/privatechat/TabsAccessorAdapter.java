package com.arfeenkhan.privatechat;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arfeenkhan.privatechat.fragment.All;
import com.arfeenkhan.privatechat.fragment.ChatFragment;
import com.arfeenkhan.privatechat.fragment.Contacts;

class TabsAccessorAdapter extends FragmentPagerAdapter {

    public TabsAccessorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Contacts contacts = new Contacts();
                return contacts;
            case 1:
                ChatFragment chatFragment = new ChatFragment();
                return chatFragment;
            case 2:
                All all = new All();
                return all;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Contacts";
            case 1:
                return "Chat";
            case 2:
                return "All";
            default:
                return null;
        }
    }
}
