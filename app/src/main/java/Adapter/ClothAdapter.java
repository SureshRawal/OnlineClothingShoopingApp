package Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import com.example.onlineclothingshoppingapp.DescriptionActivity;
import com.example.onlineclothingshoppingapp.R;


import java.util.List;

import Model.Cloth;
import de.hdodenhof.circleimageview.CircleImageView;


public class ClothAdapter extends RecyclerView.Adapter<ClothAdapter.ClothViewHolder> {
    Context mContext;
    List<Cloth> clothList;

    public ClothAdapter(Context mContext, List<Cloth> contactsList) {
        this.mContext = mContext;
        this.clothList = contactsList;
    }

    @NonNull
    @Override
    public ClothViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clothlist, viewGroup, false);
        return new ClothViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothViewHolder clothViewHolder, int i) {
        final Cloth cloth = clothList.get(i);
        clothViewHolder.imgCloth.setImageResource(cloth.getCloth_image());
        clothViewHolder.tvName.setText(cloth.getCloth_name());
        clothViewHolder.tvPrice.setText("Nrs. "+cloth.getCloth_price());

        clothViewHolder.imgCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DescriptionActivity.class);
                intent.putExtra("image",cloth.getCloth_image());
                intent.putExtra("name",cloth.getCloth_name());
                intent.putExtra("price",cloth.getCloth_price());
                intent.putExtra("desc",cloth.getCloth_description());
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return clothList.size();
    }



    public class ClothViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgCloth;
        TextView tvName, tvPrice;
        public ClothViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCloth = itemView.findViewById(R.id.imgCloth);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}