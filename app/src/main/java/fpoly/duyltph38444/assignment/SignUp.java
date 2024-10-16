package fpoly.duyltph38444.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import fpoly.duyltph38444.assignmentand103.R;

public class SignUp extends AppCompatActivity {
Button btnSignUp;
TextView tvLogin;
     EditText etEmail, etPassword,edRepass;
     FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnSignUp=findViewById(R.id.btnSignUp);
        tvLogin=findViewById(R.id.tvLogin);
        etEmail = findViewById(R.id.edEmail);
        etPassword = findViewById(R.id.edPass);
        edRepass=findViewById(R.id.edRePass);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String Repass = edRepass.getText().toString();
                if (email.isEmpty() || password.isEmpty()||Repass.isEmpty()) {
                    Toast.makeText(SignUp.this, "Vui lòng nhập email and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(Repass)) {
                    Toast.makeText(SignUp.this, "Mật khẩu và xác nhận mật khẩu không khớp. Vui lòng nhập lại.", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign up success, update UI with the signed-in user's information
                                    Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignUp.this, Login.class);
                                    startActivity(intent);

                                } else {
                                    // If sign up fails, display a message to the user.
                                    Log.w("SignUp", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
    }
}