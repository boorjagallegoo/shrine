package com.google.codelabs.mdc.java.shrine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.codelabs.mdc.java.shinre.R;
import com.google.codelabs.mdc.java.shrine.network.ImageRequester;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adaptador utilizado para mostrar una cuadrícula simple de productos.
 */
public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {

    private List<ProductEntry> productList;
    private ImageRequester imageRequester;

    /**
     * Constructor del adaptador.
     *
     * @param productList Lista de productos para mostrar en la cuadrícula.
     */
    ProductCardRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }

    /**
     * Crea y devuelve un nuevo ViewHolder.
     *
     * @param parent   El ViewGroup en el que se inflará el nuevo diseño.
     * @param viewType El tipo de vista del nuevo diseño.
     * @return Un nuevo ViewHolder que contiene la vista inflada.
     */
    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shr_product_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }

    /**
     * Llena el contenido de un ViewHolder dado en una posición específica.
     *
     * @param holder   El ViewHolder que se actualizará.
     * @param position La posición del elemento en los datos.
     */
    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        if (productList != null && position < productList.size()) {
            ProductEntry product = productList.get(position);
            holder.productTitle.setText(product.title);
            holder.productPrice.setText(product.price);
            imageRequester.setImageFromUrl(holder.productImage, product.url);
        }

    }

    /**
     * Devuelve el número total de elementos en el conjunto de datos.
     *
     * @return El número total de elementos en el conjunto de datos.
     */
    @Override
    public int getItemCount() {
        return productList.size();
    }
}