package com.spencerandbrown.midwifeclienttracker;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spencerandbrown.midwifeclienttracker.databinding.ClientDetailBinding;
import com.spencerandbrown.midwifeclienttracker.model.Client;
import com.spencerandbrown.midwifeclienttracker.model.ClientList;

/**
 * A fragment representing a single Client detail screen.
 * This fragment is either contained in a {@link ClientListActivity}
 * in two-pane mode (on tablets) or a {@link ClientDetailActivity}
 * on handsets.
 */
public class ClientDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Client mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ClientDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
           mItem = ClientList.ITEM_MAP.get(getArguments().getInt(ARG_ITEM_ID));
            //mItem = ClientList.clients.get(0);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(getResources().getString(R.string.title_client_detail));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.client_detail, container, false);

        // Show the dummy content as text in a TextView.
//        if (mItem != null) {
//            ((TextView) rootView.findViewById(R.id.client_detail)).setText(mItem.name);
//        }
        View rootView = DataBindingUtil.inflate(inflater,R.layout.client_detail,container,false).getRoot();

       ClientDetailBinding binding = DataBindingUtil.getBinding(rootView);
        binding.setClient(mItem);
        return rootView;
    }
}
