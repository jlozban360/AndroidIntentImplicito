package es.iesoretania.intentimplicito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.intentimplicito.databinding.ActivityAddContactBinding;

public class AddContactActivity extends AppCompatActivity {
    private ActivityAddContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityAddContactBinding.inflate( getLayoutInflater( ) );
        setContentView( binding.getRoot( ) );

        binding.buttonSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextBName.getText().toString();
                String phone = binding.editTextPhone.getText().toString();
                String email = binding.editTextTextEmailAddress.getText().toString();

                Intent intent = new Intent( Intent.ACTION_INSERT );
                intent.setType( ContactsContract.Contacts.CONTENT_TYPE );

                intent.putExtra( ContactsContract.Intents.Insert.NAME, name);
                intent.putExtra( ContactsContract.Intents.Insert.PHONE, phone);
                intent.putExtra( ContactsContract.Intents.Insert.EMAIL, email);

                startActivity(intent);
            }
        });
    }
}