package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.codelabs.mdc.java.shinre.R;

/**
 * Actividad principal que hospeda fragmentos y permite la navegación entre ellos.
 */
public class MainActivity extends AppCompatActivity implements NavigationHost {

    /**
     * Se llama cuando se crea la actividad.
     *
     * @param savedInstanceState Si no es nulo, esta actividad está siendo reconstruida a partir de un estado guardado anteriormente.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shr_main_activity);

        // Si no hay un estado guardado, agrega el fragmento de inicio de sesión.
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }
    }

    /**
     * Navega hacia el fragmento dado.
     *
     * @param fragment       Fragmento al que se va a navegar.
     * @param addToBackstack Indica si el fragmento actual debe agregarse a la pila de retroceso.
     */
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        // Si se debe agregar a la pila de retroceso, agrega el fragmento actual a la pila.
        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        // Realiza la transacción.
        transaction.commit();
    }
}
