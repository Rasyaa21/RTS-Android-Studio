package com.nanda.rts_cafe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanda.rts_cafe.databinding.ActivitySignUpBinding

private lateinit var binding : ActivitySignUpBinding
class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.loginBt.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            Log.d("SignUpActivity", "Login button clicked")
            startActivity(intent)
        }
        binding.signUpBtToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            Log.d("SignUpActivity", "Login button clicked")
            startActivity(intent)
        }
    }
}