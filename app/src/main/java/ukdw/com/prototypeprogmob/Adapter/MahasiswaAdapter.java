package ukdw.com.prototypeprogmob.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Model.Mahasiswa;
import ukdw.com.prototypeprogmob.R;
import com.squareup.picasso.Picasso;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>{

    ArrayList<Mahasiswa> mahasiswaArrayList;
    private Context context;

    public MahasiswaAdapter(ArrayList<Mahasiswa> mahasiswaArrayList) { this.mahasiswaArrayList = mahasiswaArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_mahasiswa,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNim.setText(mahasiswaArrayList.get(position).getNim());
        holder.txtNamaMhs.setText(mahasiswaArrayList.get(position).getNamaMhs());
        holder.txtEmailMhs.setText(mahasiswaArrayList.get(position).getEmailMhs());
        holder.txtAlamatMhs.setText(mahasiswaArrayList.get(position).getAlamatMhs());
        holder.imgFotoMhs.getLayoutParams().width = 200;
        holder.imgFotoMhs.getLayoutParams().height = 200;
        if(mahasiswaArrayList.get(position).getFotoMhs() != null) {
            Picasso.with(this.context)
                    .load("https://kpsi.fti.ukdw.ac.id/progmob/" + mahasiswaArrayList.get(position).getFotoMhs())
                    .into(holder.imgFotoMhs);
        }
    }


    @Override
    public int getItemCount() { //untuk menghitung jumlah data yang ada//
        return (mahasiswaArrayList != null) ?mahasiswaArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener{
        private TextView txtNim, txtNamaMhs, txtEmailMhs, txtAlamatMhs;
        private ImageButton imgFotoMhs;

        public ViewHolder(View view){
            super(view);
            txtNim= view.findViewById(R.id.txt_nim);
            txtNamaMhs = view.findViewById(R.id.txt_nama_mhs);
            txtEmailMhs = view.findViewById(R.id.txt_email_mhs);
            txtAlamatMhs = view.findViewById(R.id.txt_alamat_mhs);
            imgFotoMhs = view.findViewById(R.id.imgFotoMhs);
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
