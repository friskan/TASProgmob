package ukdw.com.prototypeprogmob.Adapter;

import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.net.URL;

import ukdw.com.prototypeprogmob.R;
import ukdw.com.prototypeprogmob.Model.Dosen;
import com.squareup.picasso.Picasso;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder>{

    ArrayList<Dosen> dosenArrayList;
    private Context context;

    public DosenAdapter(ArrayList<Dosen> dosenArrayList) {
        this.dosenArrayList = dosenArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_dosen,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) { //untuk input data
        holder.txtNidn.setText(dosenArrayList.get(position).getNidn());
        holder.txtNama.setText(dosenArrayList.get(position).getNama());
        holder.txtGelar.setText(dosenArrayList.get(position).getGelar());
        holder.txtEmail.setText(dosenArrayList.get(position).getEmail());
        holder.txtAlamat.setText(dosenArrayList.get(position).getAlamat());
        holder.imgFoto.getLayoutParams().width = 200;
        holder.imgFoto.getLayoutParams().height = 200;
        if(dosenArrayList.get(position).getFoto() != null) {
            Picasso.with(this.context)
                    .load("https://kpsi.fti.ukdw.ac.id/progmob/" + dosenArrayList.get(position).getFoto())
                    .into(holder.imgFoto);
        }
    }

    @Override
    public int getItemCount() { //untuk menghitung jumlah data yang ada//
        return (dosenArrayList != null) ?dosenArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener{

        private TextView txtNidn, txtNama, txtGelar, txtEmail, txtAlamat;
        private ImageButton imgFoto;

        public ViewHolder(View view) {
            super(view);
            txtNidn = view.findViewById(R.id.txt_kode_kelas);
            txtNama = view.findViewById(R.id.txt_matkul_kelas);
            txtGelar = view.findViewById(R.id.txt_hari_kelas);
            txtEmail = view.findViewById(R.id.txt_sesi_kelas);
            txtAlamat = view.findViewById(R.id.txt_dosen_kelas);
            imgFoto = view.findViewById(R.id.imgButtonCrudDosen);
            view.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Pilih Aksi");
            menu.add(this.getAdapterPosition(), v.getId(),0,"Ubah Data Dosen");
            menu.add(this.getAdapterPosition(), v.getId(),0,"Hapus Data Dosen");
        }
    }
}
