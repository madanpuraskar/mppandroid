package org.madanpuraskar.cataloguesearch;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class MonographAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Monograph> data= Collections.emptyList();
    Monograph current;
    int currentPos=0;

    // create constructor to initialize context and data sent from MonographList
    public MonographAdapter(Context context, List<Monograph> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.catalogue_container, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Monograph current=data.get(position);
        myHolder.Title.setText(current.Title);
        myHolder.Author.setText(current.Author);
        myHolder.Publisher.setText(current.Publisher);
        myHolder.Published_Date.setText(current.Published_Date);

        // load image into imageview using glide
        Glide.with(context).load("http://madanpuraskar.org/android/bookcover/"
                + current.getImage_link())
                //.placeholder(R.drawable.ic_img_error)
                //.error(R.drawable.ic_img_error)
                .into(myHolder.BookCover);

    }


    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView MPP_SN, Title, Author, Publisher, Published_Date, Edition, Subject, ISBN;
        ImageView BookCover;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);

            Typeface kalimati = Typeface.createFromAsset(context.getAssets(), "fonts/Kalimati.ttf");
            Typeface madan = Typeface.createFromAsset(context.getAssets(), "fonts/madan.ttf");

            Title = (TextView) itemView.findViewById(R.id.textTitle);
            Title.setTypeface(kalimati);

            Author = (TextView) itemView.findViewById(R.id.textAuthor);
            Author.setTypeface(kalimati);

            Publisher = (TextView) itemView.findViewById(R.id.textPublisher);
            Publisher.setTypeface(kalimati);

            Published_Date = (TextView) itemView.findViewById(R.id.textPublishedDate);
            Published_Date.setTypeface(madan);

            BookCover = (ImageView) itemView.findViewById(R.id.imgvwBookCover);

        }

    }

}
