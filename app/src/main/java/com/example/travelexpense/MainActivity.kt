package com.example.travelexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.travelexpense.databinding.ActivityMainBinding


/** FUNÇÃO RESPONSAVEL POR FAZER A CRIAÇÃO DE DA ACTIVITY**/
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //PARA RETIRAR A BARRA DO NOME DO APLICATIVO
        supportActionBar?.hide()

        // Inflar o layout usando View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Configurar a view da atividade
        setContentView(binding.root)

        // Adicionar um listener de clique ao botão
        binding.buttonCalculate.setOnClickListener { calculate() }
    }

    /** EVENTO DE CLICK **/
    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    //VALIDAÇOES DE DADOS
    private fun isValid(): Boolean {

        return (binding.editDistance.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }


    private fun calculate() {
        if (isValid()) {

            val distance = binding.editDistance.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()

            val value = (distance * price) / autonomy
            binding.textValue.text = "${"%.2f".format(value)}"
        } else {
            Toast.makeText(this, R.string.validation, Toast.LENGTH_SHORT).show()
        }
    }
}