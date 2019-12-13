package ukdw.com.prototypeprogmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Model.Matkul;
import ukdw.com.prototypeprogmob.R;

public class MatkulAdapter extends RecyclerView.Adapter<MatkulAdapter.ViewHolder>{

    ArrayList<Matkul> matkulArrayList;

    public MatkulAdapter(ArrayList<Matkul> matkulArrayList) {
        this.matkulArrayList = matkulArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_matkul,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKode.setText(matkulArrayList.get(position).getKode());
        holder.txtNamaMatkul.setText(matkulArrayList.get(position).getNamaMatkul());
        holder.txtHari.setText(matkulArrayList.get(position).getHari());
        holder.txtSesi.setText(matkulArrayList.get(position).getSesi());
        holder.txtSks.setText(matkulArrayList.get(position).getSks());
    }

    @Override
    public int getItemCount() { //untuk menghitung jumlah data yang ada//
        return (matkulArrayList != null) ?matkulArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKode, txtNamaMatkul, txtHari, txtSesi, txtSks;

        public ViewHolder(View view){
            super(view);
            txtKode= view.findViewById(R.id.txt_kode);
            txtNamaMatkul = view.findViewById(R.id.txt_nama_matkul);
            txtHari = view.findViewById(R.id.txt_hari);
            txtSesi = view.findViewById(R.id.txt_sesi);
            txtSks = view.findViewById(R.id.txt_sks);
        }
    }
}
