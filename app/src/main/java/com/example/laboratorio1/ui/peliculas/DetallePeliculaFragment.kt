package com.example.laboratorio1.ui.peliculas

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.laboratorio1.R
import com.example.laboratorio1.databinding.FragmentDetallePeliculaBinding

class DetallePeliculaFragment : Fragment() {

    private val args: DetallePeliculaFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetallePeliculaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i("DEBUG_INFO", "${args.pelicula.nombre}")

        binding = FragmentDetallePeliculaBinding.inflate(inflater)
        var view = binding.root

        var videoIdentifier = view
            .context
            .resources
            .getIdentifier(args.pelicula.video, "raw", view.context.packageName);

        binding.videoViewTrailer.setVideoURI(Uri.parse("android.resource://"
                + view.context.getPackageName()
                + "/"
                + videoIdentifier))

        binding.videoViewTrailer.start()
        return view
    }
}