package com.google.codelabs.mdc.java.shrine;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Clase de decoración personalizada para un {@link RecyclerView} vertical en {@link ProductGridFragment}.
 * Añade un pequeño margen a la izquierda de los elementos de la cuadrícula y un margen grande a la derecha.
 */
public class ProductGridItemDecoration extends RecyclerView.ItemDecoration {
    private int largePadding;
    private int smallPadding;

    /**
     * Constructor de la clase.
     *
     * @param largePadding Tamaño del margen grande a la derecha de los elementos de la cuadrícula.
     * @param smallPadding Tamaño del pequeño margen a la izquierda de los elementos de la cuadrícula.
     */
    public ProductGridItemDecoration(int largePadding, int smallPadding) {
        this.largePadding = largePadding;
        this.smallPadding = smallPadding;
    }

    /**
     * Método que establece los desplazamientos del elemento en el {@link RecyclerView}.
     *
     * @param outRect Rectángulo de salida que representa los márgenes del elemento.
     * @param view Vista del elemento en el {@link RecyclerView}.
     * @param parent {@link RecyclerView} al que pertenece el elemento.
     * @param state  Estado del {@link RecyclerView}.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = smallPadding;
        outRect.right = largePadding;
    }
}
