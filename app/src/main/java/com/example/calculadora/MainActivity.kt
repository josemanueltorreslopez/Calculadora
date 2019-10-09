@file:Suppress("PLUGIN_WARNING")

package com.example.calculadora

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var resultado: Double = 0.0
    var operacion: Char = ' '
    var memoria: Double= 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {//Cunado el layaout cambia a pantalla vertical
                quitarOperaciones()
        }
        if(resources.configuration.orientation != Configuration.ORIENTATION_PORTRAIT){//Cunado el layaout cambia pantalla lateral
            webView1.loadUrl("https://google.com")
            webView1.webViewClient = object: WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }

            }
            editTextBuscador.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    //Perform Code
                    leerUrl()
                    return@OnKeyListener true
                }
                false
            })
            webView1.loadUrl("https://www.google.co.in/")
        }


    }

    fun cuenta(v: View){
        when(v.id){
            but1.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but1.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but2.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but2.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but3.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but3.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but4.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but4.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but5.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but5.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but6.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but6.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but7.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but7.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but8.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but8.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but9.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but9.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
            but0.id -> {
                txtVCalculadora.setText(txtVCalculadora.text.toString() + but0.text)
                if(!butSuma.isClickable==true) {
                    activarOperaciones()
                }
            }
        }
    }

    fun operaciones(v: View){
        when(v.id){
            butMulti.id -> {
                ponerNumeros()
                quitarOperaciones()
                caracter()
                operacion = '+'
            }
            butResta.id -> {
                ponerNumeros()
                quitarOperaciones()
                caracter()
                operacion = '-'
            }
            butDividir.id -> {
                ponerNumeros()
                quitarOperaciones()
                caracter()
                operacion = '/'
            }
            butSuma.id -> {
                ponerNumeros()
                quitarOperaciones()
                caracter()
                operacion = '*'
            }

            butIgual.id -> {
                if(txtVCalculadora.text.toString().isEmpty()){
                    txtVCalculadora.setText(resultado.toString())
                }
                caracter()
                quitarNumeros()
                operacion = ' '

                txtVCalculadora.setText(resultado.toString())
            }
            butBorrar.id -> {
                resultado = 0.0
                quitarOperaciones()
                ponerNumeros()
                txtVCalculadora.setText("")

            }
            butMMas.id -> {
                if(!txtVCalculadora.text.toString().isEmpty()) {
                    memoria = memoria + txtVCalculadora.text.toString().toDouble()
                }
            }
            butMMostrar.id -> {
                txtVCalculadora.setText(memoria.toString())
                quitarNumeros()
                activarOperaciones()
            }
            butMBorrar.id -> {
                memoria = 0.0
                txtVCalculadora.setText(memoria.toString())
            }
            butMMenos.id -> {
                if(!txtVCalculadora.text.toString().isEmpty()) {
                    memoria = memoria - txtVCalculadora.text.toString().toDouble()
                }
            }
        }

    }

    fun caracter(){
        when(operacion){
            '+' -> {
                resultado += txtVCalculadora.text.toString().toDouble()
                txtVCalculadora.setText("")
            }
            '-' ->{
                resultado -= txtVCalculadora.text.toString().toDouble()
                txtVCalculadora.setText("")
            }
            '*' -> {
                resultado *= txtVCalculadora.text.toString().toDouble()
                txtVCalculadora.setText("")
            }
            '/' -> {
                resultado /= txtVCalculadora.text.toString().toDouble()
                txtVCalculadora.setText("")
            }
            ' ' ->{
                resultado  = txtVCalculadora.text.toString().toDouble()
                txtVCalculadora.setText("")
            }
        }
    }

    fun quitarNumeros(){
        but0.isClickable = false
        but1.isClickable = false
        but2.isClickable = false
        but3.isClickable = false
        but4.isClickable = false
        but5.isClickable = false
        but6.isClickable = false
        but7.isClickable = false
        but8.isClickable = false
        but9.isClickable = false
    }

    fun ponerNumeros(){
        but0.isClickable = true
        but1.isClickable = true
        but2.isClickable = true
        but3.isClickable = true
        but4.isClickable = true
        but5.isClickable = true
        but6.isClickable = true
        but7.isClickable = true
        but8.isClickable = true
        but9.isClickable = true
    }

    fun quitarOperaciones(){
        butSuma.isClickable = false
        butResta.isClickable = false
        butDividir.isClickable = false
        butMulti.isClickable = false
    }

    fun activarOperaciones(){
        butSuma.isClickable = true
        butResta.isClickable = true
        butDividir.isClickable = true
        butMulti.isClickable = true
    }

    fun leerUrl(){
        if(editTextBuscador.text.toString().startsWith("https://")){
            if(editTextBuscador.text.toString().endsWith(".com")||editTextBuscador.text.toString().endsWith(".es")){
                webView1.loadUrl(editTextBuscador.text.toString())
            }else{
                webView1.loadUrl("www.google.com/search?q=" + editTextBuscador.text.toString() + "&oq=" + editTextBuscador.text.toString() + "aqs=chrome.0.0l3j69i60l3.655j0j7&sourceid=chrome&ie=UTF-8")
            }
        } else
            if(editTextBuscador.text.toString().endsWith(".com")||editTextBuscador.text.toString().endsWith(".es")){
            webView1.loadUrl("https://" + editTextBuscador.text.toString())
        }else{
            webView1.loadUrl("https://www.google.com/search?q=" + editTextBuscador.text.toString() + "&oq=" + editTextBuscador.text.toString() + "aqs=chrome.0.0l3j69i60l3.655j0j7&sourceid=chrome&ie=UTF-8")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("resultadoActual", resultado)
        outState.putDouble("memoriaActual", memoria)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            resultado = savedInstanceState.getDouble("resultadoActual")
            memoria = savedInstanceState.getDouble("memoriaActual")
        }
    }

    fun go(v: View){
        leerUrl()

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
