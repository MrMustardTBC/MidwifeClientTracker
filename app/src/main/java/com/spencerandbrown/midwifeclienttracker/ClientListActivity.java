package com.spencerandbrown.midwifeclienttracker;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.spencerandbrown.midwifeclienttracker.databinding.ActivityClientDetailBinding;
import com.spencerandbrown.midwifeclienttracker.databinding.ActivityClientListBinding;
import com.spencerandbrown.midwifeclienttracker.databinding.ClientListContentBinding;
import com.spencerandbrown.midwifeclienttracker.model.Client;
import com.spencerandbrown.midwifeclienttracker.model.ClientList;

import java.util.List;

/**
 * An activity representing a list of Clients. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ClientDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ClientListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ClientList mClientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_client_list);

        ActivityClientListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_client_list);

        // Set list items
        mClientList = new ClientList();
        binding.setClientList(mClientList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.client_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.client_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(ClientList.clients));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.BindingViewHolder> {

        private final List<Client> mValues;

        public SimpleItemRecyclerViewAdapter(List<Client> items) {
            mValues = items;
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.client_list_content, parent, false);

            return new BindingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final BindingViewHolder holder, int position) {
            final Client client =  mValues.get(position);
            holder.getBinding().setVariable(com.spencerandbrown.midwifeclienttracker.BR.client, client);
            holder.getBinding().executePendingBindings();

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putInt(ClientDetailFragment.ARG_ITEM_ID, holder.binding.getClient().id);
                        ClientDetailFragment fragment = new ClientDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.client_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ClientDetailActivity.class);
                        intent.putExtra(ClientDetailFragment.ARG_ITEM_ID, holder.binding.getClient().id);

                        context.startActivity(intent);
                    }
                }
            });
        }


        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class BindingViewHolder extends RecyclerView.ViewHolder {
            private ClientListContentBinding binding;

            public BindingViewHolder(View view) {
                super(view);
                binding = DataBindingUtil.bind(view);
            }

            public ClientListContentBinding getBinding(){
                return binding;
            }

        }
    }
}
