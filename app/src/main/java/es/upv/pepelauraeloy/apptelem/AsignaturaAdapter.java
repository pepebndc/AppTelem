package es.upv.pepelauraeloy.apptelem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AsignaturaAdapter extends RecyclerView.Adapter<AsignaturaAdapter.AsignaturaViewHolder> {

    private List<Asignatura> items;

    public static class AsignaturaViewHolder extends RecyclerView.ViewHolder{
        public CardView asignaturaCardView;
        public TextView nombre;
        public TextView creditos;
        public TextView semestre;
        public LinearLayout card;
        public LinearLayout side;


        public AsignaturaViewHolder(View v){
            super(v);
            asignaturaCardView = (CardView) v.findViewById(R.id.asignatura_card);
            nombre = (TextView) v.findViewById(R.id.asignatura_Nombre);
            creditos = (TextView) v.findViewById(R.id.asignatura_Creditos);
            semestre = (TextView) v.findViewById(R.id.asignatura_Semestre);
            card = (LinearLayout) v.findViewById(R.id.detail_card);
            side = (LinearLayout) v.findViewById(R.id.detail_side);
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
    public void onBindViewHolder (AsignaturaViewHolder viewHolder, final int i) {
        System.out.println("Asignatura: " + items.get(i).getNombre()+"; " + items.get(i).getRama()+"; "+ items.get(i).getEstado());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.creditos.setText("Créditos: " + items.get(i).getCreditos());
        viewHolder.semestre.setText("Semestre: " + items.get(i).getSemestre());


        //Poner colores:
        //Side: Verde aprobado, Rojo suspendido, Azul interesado
        //Tarjeta: Transparente general, 1-Rojo, 2-Verde, 3-Lila, 4-Azul
        int intRama = items.get(i).getRama();

        /*
        if(intRama==0){
            viewHolder.asignaturaCardView.setCardBackgroundColor(Color.parseColor("#ededed"));
        }
        if(intRama==1){
            viewHolder.asignaturaCardView.setBackgroundColor(Color.parseColor("#ffebee"));
        }
        if(intRama==2){
            viewHolder.asignaturaCardView.setBackgroundColor(Color.parseColor("#f1f8e9"));
        }
        if(intRama==3){
            viewHolder.asignaturaCardView.setBackgroundColor(Color.parseColor("#f3e5f5"));
        }
        if(intRama==4){
            viewHolder.asignaturaCardView.setBackgroundColor(Color.parseColor("#e1f5fe"));
        }

        System.out.println("Color de tarjeta: "+ viewHolder.asignaturaCardView.getCardBackgroundColor().toString());

        */

        //Nada = Gris
        if(items.get(i).getEstado() ==0){
            viewHolder.side.setBackgroundColor(Color.parseColor("#ededed"));
        }

        //Si interesado, color Azul
        if (items.get(i).getEstado() == 1) {
            viewHolder.side.setBackgroundColor(Color.parseColor("#2196F3"));
        }

        //Si aprobado, color Verde
        if (items.get(i).getEstado() == 2 && items.get(i).getCalificacion() >= 5) {
            viewHolder.side.setBackgroundColor(Color.parseColor("#4caf50"));
        }

        //Si suspenso, color Rojo
        if (items.get(i).getEstado() == 2 && items.get(i).getCalificacion() < 5) {
            viewHolder.side.setBackgroundColor(Color.parseColor("#f44336"));
        }



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
