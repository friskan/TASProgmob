package ukdw.com.prototypeprogmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Model.Krs;
import ukdw.com.prototypeprogmob.R;

public class KrsAdapter extends RecyclerView.Adapter<KrsAdapter.ViewHolder>{

    ArrayList<Krs> krsArrayList;

    public KrsAdapter(ArrayList<Krs> krsArrayList) {
        this.krsArrayList = krsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_krs,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKodeKrs.setText(krsArrayList.get(position).getKode_matkul());
        holder.txtMatkulKrs.setText(krsArrayList.get(position).getMatkul());
        holder.txtDosenKrs.setText(krsArrayList.get(position).getDosen());
    }

    @Override
    public int getItemCount() { //untuk menghitung jumlah data yang ada//
        return (krsArrayList != null) ?krsArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKodeKrs, txtMatkulKrs, txtDosenKrs;

        public ViewHolder(View view){
            super(view);
            txtKodeKrs= view.findViewById(R.id.txt_kode_krs);
            txtMatkulKrs = view.findViewById(R.id.txt_matkul_krs);
            txtDosenKrs = view.findViewById(R.id.txt_dosen_krs);
        }
    }
}
