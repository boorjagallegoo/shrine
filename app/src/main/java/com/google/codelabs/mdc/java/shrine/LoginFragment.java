package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.codelabs.mdc.java.shinre.R;

/**
 * Fragmento que representa la pantalla de inicio de sesión para Shrine.
 */
public class LoginFragment extends Fragment {

    /**
     * Llamado para crear y devolver la jerarquía de vistas asociada con el fragmento.
     *
     * @param inflater           El objeto LayoutInflater que se puede usar para inflar cualquier vista en el fragmento.
     * @param container          Si no es nulo, esta es la vista principal a la que debe adjuntarse la interfaz de usuario del fragmento.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anteriormente.
     * @return La vista para la interfaz de usuario del fragmento, o nulo.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño para este fragmento
        View view = inflater.inflate(R.layout.shr_login_fragment, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.password_edit_text);
        MaterialButton nextButton = view.findViewById(R.id.next_button);

        // Establece un error si la contraseña tiene menos de 8 caracteres.
        nextButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Este método se invocará cuando se haga clic en el botón.
             *
             * @param view La vista que se hizo clic.
             */
            @Override
            public void onClick(View view) {
                if (!isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(getString(R.string.shr_error_password));
                } else {
                    passwordTextInput.setError(null); // Limpia el error
                    ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false); // Navigate to the next Fragment
                }
            }
        });

        // Borra el error una vez que se han ingresado más de 8 caracteres.
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            /**
             * Llamado cuando se despacha una tecla de hardware a una vista.
             *
             * @param view      La vista a la que se despachó la tecla.
             * @param i         El código de la tecla física presionada.
             * @param keyEvent  El objeto KeyEvent que contiene información completa sobre el evento.
             * @return           Verdadero si el listener ha consumido el evento, falso en caso contrario.
             */
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(null); // Limpia el error
                }
                return false;
            }
        });
        return view;
    }

    /**
     * Verifica si la contraseña proporcionada es válida.
     *
     * @param text La contraseña que se va a verificar.
     * @return Verdadero si la contraseña es válida (longitud >= 8), falso en caso contrario.
     */
    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

}
