package com.google.codelabs.mdc.java.shrine;

import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.google.codelabs.mdc.java.shinre.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ViewHolder que representa un elemento en la cuadrícula de productos.
 */
public class ProductCardViewHolder extends RecyclerView.ViewHolder {

    /** ImageView para mostrar la imagen del producto. */
    public NetworkImageView productImage;

    /** TextView para mostrar el título del producto. */
    public TextView productTitle;

    /** TextView para mostrar el precio del producto. */
    public TextView productPrice;

    /**
     * Constructor del ViewHolder.
     *
     * @param itemView La vista inflada que representa un elemento en la cuadrícula de productos.
     */
    public ProductCardViewHolder(@NonNull View itemView) {
        super(itemView);
        // Inicializa las vistas mediante la búsqueda de los elementos de la vista inflada por su ID
        productImage = itemView.findViewById(R.id.product_image);
        productTitle = itemView.findViewById(R.id.product_title);
        productPrice = itemView.findViewById(R.id.product_price);
    }
}
