package com.example.implant;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.implant.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String verificationid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       mAuth=FirebaseAuth.getInstance();
       binding.otpbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(binding.phone.getText().toString().trim().isEmpty()){
                   Toast.makeText(LoginActivity.this, "Please Enter a phone number", Toast.LENGTH_SHORT).show();
               }
               else if (binding.phone.getText().toString().trim().length()!=10){
                   Toast.makeText(LoginActivity.this, "Enter 10 digit phone number", Toast.LENGTH_SHORT).show();
               }
               else{
                   otpsend();
               }
           }
       });


        binding.login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.login2.setVisibility(View.INVISIBLE);
                if(binding.otp.getText().toString().trim().isEmpty()){
                    binding.login2.setVisibility(View.VISIBLE);
                    Toast.makeText(LoginActivity.this, "OTP is not valid", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (verificationid != null) {
                        String code = binding.otp.getText().toString().trim();
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid, code);
                        FirebaseAuth.getInstance()
                                .signInWithCredential(credential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            binding.login2.setVisibility(View.INVISIBLE);
                                            Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                        } else {
                                            binding.login2.setVisibility(View.VISIBLE);
                                            Toast.makeText(LoginActivity.this, "OTP is invalid!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });

    }



    private void otpsend() {
        binding.otpbtn.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                binding.otpbtn.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.otpbtn.setVisibility(View.VISIBLE);
                verificationid=verificationId;
                Toast.makeText(LoginActivity.this, "code sent", Toast.LENGTH_SHORT).show();
            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+binding.phone.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}