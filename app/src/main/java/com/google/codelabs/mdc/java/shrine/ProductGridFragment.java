package com.google.codelabs.mdc.java.shrine;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

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
     * Configura las opciones del menú en la barra de herramientas.
     *
     * @param savedInstanceState Estado previamente guardado de la instancia.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * Infla y configura la vista para este fragmento, incluida la barra de herramientas y el RecyclerView.
     *
     * @param inflater           El inflador que se utilizará para inflar la vista.
     * @param container          El contenedor en el que se debe colocar la vista.
     * @param savedInstanceState Estado previamente guardado de la instancia.
     * @return La vista inflada y configurada para el fragmento.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento con el tema ProductGrid
        View view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false);

        // Configurar la barra de herramientas
        setUpToolbar(view);

        // Configurar el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % 3 == 2 ? 2 : 1;
            }
        });

        // Descomente el siguiente código después de corregir el error
        /*
        ProductCardRecyclerViewAdapter adapter = new ProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        */

        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new ProductGridItemDecoration(largePadding, smallPadding));

        // Establecer el fondo de esquina cortada para API 23+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.product_grid)
                    .setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }

        return view;
    }

    /**
     * Configura la barra de herramientas con un icono de menú personalizado y una animación de clic de navegación.
     *
     * @param view La vista que contiene la barra de herramientas.
     */
    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }

        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                getContext(),
                view.findViewById(R.id.product_grid),
                new AccelerateDecelerateInterpolator(),
                getContext().getResources().getDrawable(R.drawable.shr_branded_menu), // Icono de apertura del menú
                getContext().getResources().getDrawable(R.drawable.shr_close_menu))); // Icono de cierre del menú
    }

    /**
     * Infla las opciones del menú en la barra de herramientas.
     *
     * @param menu              El menú en el que se inflarán las opciones.
     * @param menuInflater      El inflador que se utilizará para inflar las opciones del menú.
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
