package com.example.foodology;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


    public class PageAdapter extends FragmentPagerAdapter {
        private int numoftabs;
        public PageAdapter(@NonNull FragmentManager fm, int numofTabs) {
            super(fm);
            this.numoftabs=numofTabs;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Customization1();
                case 1:
                    return new nearme1();
                case 2:
                    return new myfav1();
                case 3:
                    return new myacc1();
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return numoftabs;
        }
        public int getItemPosition(Object object){
            return POSITION_NONE;
        }
    }


