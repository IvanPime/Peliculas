package com.example.laboratorio1.ui.peliculas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio1.R
import com.example.laboratorio1.adapter.PeliculaAdapter
import com.example.laboratorio1.databinding.FragmentPeliculasBinding
import com.example.laboratorio1.model.Pelicula

class PeliculasFragment : Fragment() {

    private var _binding: FragmentPeliculasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var datos: Array<Pelicula>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPeliculasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recView = binding.recViewPeliculas


        val datos = arrayOf<Pelicula>(
            Pelicula(
            "The Batman","2022","Crime", "batman",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/74xTEgt7R36Fpooo50r9T25onhq.jpg"
            ),
            Pelicula(
                "Spider-Man: No Way Home","2021","Action", "spider",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            ),
            Pelicula(
                "The Outfit","2022","Thriller", "outfit",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mBUoNT1nJ2dK53PXRSUOyoPez8S.jpg"
            ),
            Pelicula(
                "Turning Red","2022","Fantasy", "turning",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qsdjk9oAKSQMWs0Vt5Pyfh6O4GZ.jpg"
            ),
            Pelicula(
                "Sonic the Hedgehog 2","2022","Science Fiction", "sonic",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg"
            ),
        )

        val adaptador = PeliculaAdapter(datos) {
            findNavController().navigate(PeliculasFragmentDirections.actionNavPeliculasToDetallePeliculaFragment(it))
        }
        recView.setHasFixedSize(true)
        recView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recView.adapter = adaptador

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}