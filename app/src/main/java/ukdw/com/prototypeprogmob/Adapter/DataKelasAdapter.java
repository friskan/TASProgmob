package ukdw.com.prototypeprogmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Model.DataKelas;
import ukdw.com.prototypeprogmob.R;

public class DataKelasAdapter extends RecyclerView.Adapter<DataKelasAdapter.ViewHolder>{

    ArrayList<DataKelas> dataKelasArrayList;

    public DataKelasAdapter(ArrayList<DataKelas> dataKelasArrayList) {
        this.dataKelasArrayList = dataKelasArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_data_kelas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKodeKelas.setText(dataKelasArrayList.get(position).getKodeKelas());
        holder.txtMatkulKelas.setText(dataKelasArrayList.get(position).getMatkulKelas());
        holder.txtHariKelas.setText(dataKelasArrayList.get(position).getHariKelas());
        holder.txtSesiKelas.setText(dataKelasArrayList.get(position).getSesiKelas());
        holder.txtDosenKelas.setText(dataKelasArrayList.get(position).getDosenKelas());
        holder.txtJumMhs.setText(dataKelasArrayList.get(position).getJumMhs());
    }

    @Override
    public int getItemCount() { //untuk menghitung jumlah data yang ada//
        return (dataKelasArrayList != null) ?dataKelasArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKodeKelas, txtMatkulKelas, txtHariKelas, txtSesiKelas, txtDosenKelas, txtJumMhs;

        public ViewHolder(View view){
            super(view);
            txtKodeKelas= view.findViewById(R.id.txt_kode_kelas);
            txtMatkulKelas = view.findViewById(R.id.txt_matkul_kelas);
            txtHariKelas = view.findViewById(R.id.txt_hari_kelas);
            txtSesiKelas = view.findViewById(R.id.txt_sesi_kelas);
            txtDosenKelas = view.findViewById(R.id.txt_dosen_kelas);
            txtJumMhs = view.findViewById(R.id.txt_jum_kelas);
        }
    }
}
