package mtech.com.ownerapp.deliverydialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import mtech.com.ownerapp.R;
import mtech.com.ownerapp.dialogoncefreq.CustomAdapter;
import mtech.com.ownerapp.dialogoncefreq.CustomFragment;
import mtech.com.ownerapp.dialogoncefreq.FeqcabFragment;

public class DeliveryTabbedDialog extends DialogFragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.delivery_tabbed_dialog,container,false);
        tabLayout = (TabLayout) rootview.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) rootview.findViewById(R.id.masterViewPager);
        DeliveryAdapter adapter = new DeliveryAdapter(getChildFragmentManager());
        adapter.addFragment("Once",DeliveryFragmentOnce.createInstance("Once"));
        adapter.addFragment("Frequent",DeliveryFragmentFrequent.createInstance("Frequent"));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return rootview;
    }
}