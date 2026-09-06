package com.proyectoapp.mycar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AlquilerActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etFormaPago, etCantidadDias;
    private TextView tvPrecioDia, tvTotalCalculado;
    private Button btnConfirmar, btnCancelar;
    private String precioDia;

    private String nombreAuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquiler);

        etNombre          = findViewById(R.id.etNombre);
        etApellido        = findViewById(R.id.etApellido);
        etFormaPago       = findViewById(R.id.etFormaPago);
        etCantidadDias    = findViewById(R.id.etCantidadDias);
        tvPrecioDia       = findViewById(R.id.tvPrecioDia);
        tvTotalCalculado  = findViewById(R.id.tvTotalCalculado);
        btnConfirmar      = findViewById(R.id.btnConfirmar);
        btnCancelar       = findViewById(R.id.btnCancelar);

        // Recibir datos del auto
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            precioDia = bundle.getString("precio_dia");
            nombreAuto = bundle.getString("nombre"); // Recibimos el nombre del auto
            tvPrecioDia.setText("$" + precioDia + " USD / Día");
        }

        // Calcular total en tiempo real mientras escribe los días
        etCantidadDias.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String diasStr = s.toString().trim();
                if (!diasStr.isEmpty()) {
                    try {
                        int dias = Integer.parseInt(diasStr);
                        double precio = Double.parseDouble(precioDia);
                        double total = dias * precio;
                        tvTotalCalculado.setText("Total: $" + total + " USD");
                    } catch (NumberFormatException e) {
                        tvTotalCalculado.setText("Total: $0 USD");
                    }
                } else {
                    tvTotalCalculado.setText("Total: $0 USD");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Cancelar
        btnCancelar.setOnClickListener(v -> finish());

        // Confirmar
        btnConfirmar.setOnClickListener(v -> {
            String nombre      = etNombre.getText().toString().trim();
            String apellido    = etApellido.getText().toString().trim();
            String formaPago   = etFormaPago.getText().toString().trim();
            String diasStr     = etCantidadDias.getText().toString().trim();

            // Control de Campos Vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || formaPago.isEmpty() || diasStr.isEmpty()) {
                Toast.makeText(this, "⚠️ Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Control de caracteres en Nombre y Apellido (Solo letras y espacios)
            // El patrón "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$" valida letras del abecedario y tildes
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                etNombre.setError("El nombre solo debe contener letras");
                return;
            }
            if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                etApellido.setError("El apellido solo debe contener letras");
                return;
            }

            // Control de Formas de Pago Aceptadas
            String pagoMinuscula = formaPago.toLowerCase();
            if (!pagoMinuscula.equals("efectivo") && !pagoMinuscula.equals("tarjeta") && !pagoMinuscula.equals("transferencia")) {
                etFormaPago.setError("Métodos válidos: Efectivo, Tarjeta o Transferencia");
                Toast.makeText(this, "Forma de pago no válida.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Control Numérico Avanzado para los Días
            try {
                int dias = Integer.parseInt(diasStr);

                if (dias <= 0) {
                    etCantidadDias.setError("La cantidad debe ser mayor a 0");
                    Toast.makeText(this, "⚠️ Ingrese un número de días válido.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (dias > 365) {
                    etCantidadDias.setError("El límite máximo de alquiler es de 365 días");
                    Toast.makeText(this, "⚠️ Excede el tiempo límite de reserva.", Toast.LENGTH_SHORT).show();
                    return;
                }

            } catch (NumberFormatException e) {
                etCantidadDias.setError("Ingrese un número entero válido");
                Toast.makeText(this, "⚠️ Formato de días incorrecto.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Si pasó todos los controles, enviamos de manera segura a ResumenActivity
            Intent intent = new Intent(AlquilerActivity.this, ResumenActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("apellido", apellido);
            intent.putExtra("forma_pago", formaPago);
            intent.putExtra("dias", diasStr);
            intent.putExtra("precio_dia", precioDia);
            intent.putExtra("auto", nombreAuto);

            startActivity(intent);
            finish();
        });
    }
}