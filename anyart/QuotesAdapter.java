package com.eaarti.anyart;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {

    List<String> quotes = null;
    Context context;

    public QuotesAdapter(List<String> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder holder, int position) {
        String[] colors = {"#448AFF", "#FFC107", "009688", "#E91E63", "#FF5722"};
        String quote = quotes.get(position);
        holder.txtQuote.setText(quote);
        int color = position % colors.length;
        int intColor = Color.parseColor(colors[color]);
        holder.quoteContainer.setBackgroundColor(intColor);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuote;
        LinearLayout quoteContainer;
        public QuotesViewHolder(View itemView) {
            super(itemView);
            txtQuote = itemView.findViewById(R.id.txtQuote);
            quoteContainer = itemView.findViewById(R.id.container);


        }
    }
}
