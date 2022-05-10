package com.example.laboratorio1.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio1.R
import com.example.laboratorio1.databinding.ItemPeliculaBinding
import com.example.laboratorio1.model.Pelicula
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class PeliculaAdapter(
        private var peliculas: Array<Pelicula>,
        private var setOnClickListener: (Pelicula) -> Unit
    ):
    RecyclerView.Adapter<PeliculaAdapter.ViewHolder>() {

    class ViewHolder(val item: View): RecyclerView.ViewHolder(item) {
        val tvNombre = item.findViewById<TextView>(R.id.tvNombre)
        val tvGenero = item.findViewById<TextView>(R.id.tvGenero)
        val tvAnio = item.findViewById<TextView>(R.id.tvAnio)
        val imageView = item.findViewById<ImageView>(R.id.imgPelicula)
        val loadingWheel = item.findViewById<ProgressBar>(R.id.loading_wheel)

        fun bindTitular(pelicula: Pelicula) {
            tvNombre.text = pelicula.nombre
            tvGenero.text = pelicula.genero
            tvAnio.text = pelicula.anio

            loadingWheel.visibility = View.VISIBLE
            Glide.with(item.context).load(pelicula.imagen).listener(object:
                RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingWheel.visibility = View.VISIBLE
                    imageView.setImageResource(R.drawable.ic_image_not_supported_black)
                    return false
                }
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingWheel.visibility = View.VISIBLE
                    return false
                }

            }).error(R.drawable.ic_image_not_supported_black).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.bindTitular(pelicula)
        holder.item.setOnClickListener {
            setOnClickListener(pelicula)
        }
    }
    override fun getItemCount() = peliculas.size

}