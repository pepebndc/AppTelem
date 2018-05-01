package es.upv.pepelauraeloy.apptelem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AsignaturaAdapter extends RecyclerView.Adapter<AsignaturaAdapter.AsignaturaViewHolder> {

    private List<Asignatura> items;

    public static class AsignaturaViewHolder extends RecyclerView.ViewHolder{
        public CardView asignaturaCardView;
        public TextView nombre;
        public TextView creditos;
        public TextView semestre;

        public AsignaturaViewHolder(View v){
            super(v);
            asignaturaCardView = (CardView) v.findViewById(R.id.asignatura_card);
            nombre = (TextView) v.findViewById(R.id.asignatura_Nombre);
            creditos = (TextView) v.findViewById(R.id.asignatura_Creditos);
            semestre = (TextView) v.findViewById(R.id.asignatura_Semestre);
        }
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    public AsignaturaAdapter (List<Asignatura> items){
        this.items = items;
    }

    public List<Asignatura> getItems(){
        return MainActivity.getAppUser().getAsignaturas();
    }

    @Override
    public AsignaturaViewHolder onCreateViewHolder (ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asignatura_card, viewGroup, false);
        return new AsignaturaViewHolder(v);
    }

    @Override
    public void onBindViewHolder (AsignaturaViewHolder viewHolder, final int i){
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.creditos.setText("Créditos: "+ items.get(i).getCreditos());
        viewHolder.semestre.setText("Semestre: "+ items.get(i).getSemestre());

        viewHolder.asignaturaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString ("curNombre", items.get(i).getNombre());
                bundle.putString ("curSemestre", ""+items.get(i).getSemestre());
                bundle.putString ("curCreditos", ""+ items.get(i).getCreditos());
                bundle.putInt ("curRama", items.get(i).getRama());
                bundle.putInt ("curEstado", items.get(i).getEstado());
                System.out.println("EStado: "+items.get(i).getEstado());
                bundle.putFloat("curNota", items.get(i).getCalificacion());
                bundle.putInt("curID", items.get(i).getID());

                Intent iconIntent = new Intent(v.getContext(), DetailAsignatura.class);
                iconIntent.putExtras(bundle);
                v.getContext().startActivity(iconIntent);
            }
        });

    }
}
