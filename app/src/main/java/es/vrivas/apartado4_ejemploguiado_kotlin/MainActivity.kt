package es.vrivas.apartado4_ejemploguiado_kotlin

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var seleccion_isla = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /**
     * Callback de evento click del botón "CAMBIAR IMAGEN".
     * Intercambia las imágenes entre si.
     * @param v Necesario para el callback del evento click
     */
    @Suppress("UNUSED_PARAMETER")
    fun cambiar_imagen_click(v: View) {
        seleccion_isla=!seleccion_isla
        imagen.setImageResource(if (seleccion_isla) R.drawable.isla_kotlin else R.drawable.iconoheader)
        tv_titulo_imagen.setText(if (seleccion_isla) R.string.isla_kotlin else R.string.logo_uja)
    }

    /**
     * Callback de evento click del botón "ESTABLECER FONDO".
     * Usa la imagen que se está viendo como fondo de pantalla.
     * @param v Necesario para el callback del evento click
     */
    @Suppress("UNUSED_PARAMETER")
    fun establecer_fondo_click(v: View) {
        val bitmap: Bitmap =
            BitmapFactory.decodeResource(resources, if (seleccion_isla) R.drawable.isla_kotlin else R.drawable.iconoheader)
        val wpm=WallpaperManager.getInstance(baseContext)
        wpm.setBitmap(bitmap)
    }
}