package com.example.handairupaapp.akun

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.handairupaapp.MainActivity
import com.example.handairupaapp.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var googleSignClient : GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("761637158615-7sj6koc441i2a5rvs1vbf2tdr86dq1c4.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignClient = GoogleSignIn.getClient(this,googleSignOptions)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.googleSignBtn.setOnClickListener {
            Log.d(TAG,"onCreate: begin Google SignIn")
            val move = googleSignClient.signInIntent
            startActivityForResult(move, RC_SIGN_IN)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN){
            Log.d(TAG, "onActivityResult : Google SignIn intent result")
            val akuntask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {

                val akun = akuntask.getResult(ApiException::class.java)
                firebaseAuthWithGoogleAccount(akun)

            }catch (e: Exception){
                Log.d(TAG, "onActivityResult : ${e.message}")
            }
        }
    }

    private fun firebaseAuthWithGoogleAccount(akun: GoogleSignInAccount?) {
        Log.d(TAG,"firebaseAuthWithGoogleAccount : begin firebase auth with google account")

        val credential = GoogleAuthProvider.getCredential(akun!!.idToken,null)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult->
                Log.d(TAG,"firebaseAuthWithGoogleAccount: LoggedIn")

                val firebaseUser = firebaseAuth.currentUser
                val uid = firebaseUser!!.uid
                val email = firebaseUser!!.email

                Log.d(TAG,"firebaseAuthWithGoogleAccount: uid :$uid")
                Log.d(TAG,"firebaseAuthWithGoogleAccount: email : $email")

                if(authResult.additionalUserInfo!!.isNewUser){
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Account created...\n$email")
                    Toast.makeText(this,"Account Created horee...\n$email", Toast.LENGTH_SHORT).show()
                }
                else{
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Exiting user...\n$email")
                    Toast.makeText(this,"LoggedIn...\n$email", Toast.LENGTH_SHORT).show()

                }

                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { e->
                Log.d(TAG,"firebaseAuthWithGoogleAccount : Loggin Failed due to ${e.message}")
                Toast.makeText(this,"Loggin Failed due to\n${e.message}", Toast.LENGTH_SHORT).show()

            }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
    private companion object{
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOGLE_SIGN_IN_TAG"
    }
}