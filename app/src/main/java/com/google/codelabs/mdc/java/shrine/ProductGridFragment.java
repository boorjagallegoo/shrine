package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.codelabs.mdc.java.shinre.R;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;

/**
 * Fragmento que muestra una cuadrícula de productos utilizando RecyclerView.
 */
public class ProductGridFragment extends Fragment {

    /**
     * Configura la creación del fragmento y habilita las opciones del menú.
     *
     * @param savedInstanceState El estado previamente guardado del fragmento.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * Crea y devuelve la vista inflada para el fragmento.
     *
     * @param inflater           El objeto LayoutInflater que se utiliza para inflar la vista.
     * @param container          El contenedor en el que se debe colocar la vista.
     * @param savedInstanceState El estado previamente guardado del fragmento.
     * @return La vista inflada.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño de este fragmento con el tema ProductGrid
        View view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false);

        // Configura la barra de herramientas
        setUpToolbar(view);

        // Configura el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        ProductCardRecyclerViewAdapter adapter = new ProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new ProductGridItemDecoration(largePadding, smallPadding));

        return view;
    }

    /**
     * Configura la barra de herramientas.
     *
     * @param view La vista que contiene la barra de herramientas.
     */
    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }

    /**
     * Infla el menú de opciones en la barra de herramientas.
     *
     * @param menu           El menú en el que se inflarán las opciones.
     * @param menuInflater   El objeto MenuInflater que se utilizará para inflar el menú.
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
