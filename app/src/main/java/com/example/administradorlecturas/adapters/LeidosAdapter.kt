package com.example.administradorlecturas.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.administradorlecturas.data.Libro
import com.example.administradorlecturas.R
import com.example.administradorlecturas.activities.LecturaInformacionActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_leidos.view.*

//Adaptador para mostrar la información de los libro leídos
class LeidosAdapter(private var listaLecturas : ArrayList<Libro>, private var contexto : Context) : RecyclerView.Adapter<LeidosAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeidosAdapter.ViewHolder {
        //Para que cree el diseño a partir del item_view_libro
        return LeidosAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_leidos, parent, false), contexto)
    }//fin del onCreateViewHolder

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Se llama a la función bind y se pasa la lista de lecturas
        holder.bind(listaLecturas[position])
    }//fin del onBindViewHolder

    override fun getItemCount(): Int {
        //Retornamos el tamaño de la lista para decirle a la clase cuantos elemento va a tener la lista
        return listaLecturas.size
    }//fin del getItemCount

    //Se crea la clase ViewHolder
    class ViewHolder(var vista: View, var contexto : Context) : RecyclerView.ViewHolder(vista){
        fun bind(libro : Libro){
            //Se pasan los datos a los campos de la vista
            vista.textTitulo.text = libro.tituloLibro
            vista.textAutor.text = libro.autorLibro
            vista.textTipo.text = libro.tipoLibro
            vista.textPaginas.text = libro.totalPagsLibro
            Picasso.get().load(libro.urlImagenLibro).into(vista.imagenLibro)

            //Cuando se haga clic en la vista, se mandan todos los datos de la lectura
            vista.setOnClickListener {
                //Se hace el intent al LecturaInformacionActivity
                contexto.startActivity(Intent(contexto, LecturaInformacionActivity::class.java).putExtra("libro" , libro))
            }//fin del setOnClickListener
        }//fin de la función bind

    }//fin de la clase ViewHolder
}//fin de la clase