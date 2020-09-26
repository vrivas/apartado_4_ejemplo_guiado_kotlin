package es.vrivas.apartado4_ejemploguiado_kotlin

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Propiedad que controla si estamos viendo la foto de la isla o no (que sería la del logo de la UJA)
    var seleccion_isla: Boolean = false;

    // Algunas "constantes"
    val KEY_SELECCION_ISLA: String = "SELECCION_ISLA"

    /**
     * Método inicial cuando se crea la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /**
     * Almacenamos el valor de la propiedad seleccion_isla
     * @param outState Bundle en el que se almacenan los valores que luego queremos recuperar
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean( KEY_SELECCION_ISLA, seleccion_isla)
        super.onSaveInstanceState(outState)
    }

    /**
     * Recuperamos el valor de la propiedad seleccion_isla
     * @param savedInstanceState Bundle en el que se habían almacenado los valores que luego queremos recuperar
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        seleccion_isla=savedInstanceState.getBoolean(KEY_SELECCION_ISLA)
        actualizarImagenTitulo()
    }

    /**
     * Actualiza la imagen y el título que aparecen al usuario
     */
    private fun actualizarImagenTitulo() {
        imagen.setImageResource(if (seleccion_isla) R.drawable.isla_kotlin else R.drawable.iconoheader)
        tv_titulo_imagen.setText(if (seleccion_isla) R.string.isla_kotlin else R.string.logo_uja)
    }
    /**
     * Callback de evento click del botón "CAMBIAR IMAGEN".
     * Intercambia las imágenes entre si.
     * @param v Necesario para el callback del evento click
     */
    @Suppress("UNUSED_PARAMETER")
    fun cambiar_imagen_click(v: View) {
        seleccion_isla=!seleccion_isla
        actualizarImagenTitulo()
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