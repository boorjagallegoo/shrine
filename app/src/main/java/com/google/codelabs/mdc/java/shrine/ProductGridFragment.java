/**
 * Un fragmento que representa la pantalla de cuadrícula de productos.
 * Muestra una cuadrícula de productos utilizando un RecyclerView.
 */
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
 * Subclase de {@link Fragment} para mostrar una cuadrícula de productos.
 */
public class ProductGridFragment extends Fragment {

    /**
     * Llamado para la creación inicial del fragmento.
     *
     * @param savedInstanceState Si el fragmento se está recreando a partir de un estado previamente guardado,
     *                           este es el estado.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * Llamado para que el fragmento instancie su interfaz de usuario.
     *
     * @param inflater           El objeto LayoutInflater que se puede usar para inflar cualquier vista en el fragmento,
     * @param container          Si no es nulo, esta es la vista principal a la que se debe adjuntar la interfaz de usuario del fragmento.
     *                           El fragmento no debe agregar la vista en sí, pero esto se puede usar para generar el LayoutParams de la vista.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado previamente guardado según se indica aquí.
     * @return Devuelve la Vista para la interfaz de usuario del fragmento, o nulo.
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

        return view;
    }

    /**
     * Configurar la barra de herramientas para el fragmento.
     *
     * @param view La vista principal del fragmento.
     */
    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }

    /**
     * Inicializar el contenido del menú de opciones estándar de la actividad.
     *
     * @param menu            El menú de opciones en el que colocas tus elementos.
     * @param menuInflater    El objeto MenuInflater que se puede usar para inflar el menú.
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
