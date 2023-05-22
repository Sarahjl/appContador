package com.example.appcontador

/*author Sarah */
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appcontador.ui.theme.AppContadorTheme

class MainActivity : ComponentActivity() {

    private lateinit var minhaViewModelQueEuCrieiAgoraPouco: MinhaViewModelBemSimples

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewModelBemSimples::class.java)

        setContent {
           MainScreen(minhaViewModelQueEuCrieiAgoraPouco)
        }
    }
}

@Composable
fun MainScreen(umaViewModel: MinhaViewModelBemSimples) {
    var contadorNaView by remember {
        mutableStateOf(0)
    }
    val contadorProvinienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Column() {
        Button(onClick = {
            contadorNaView = contadorNaView + 1
            umaViewModel.incrementaContador()

        }) {
            Text(text = "INCREMENTA CONTADOR")
        }
        Text(text = "Valor do Contador Controlado Pela View = $contadorNaView")
        Text(text = "Valor do Contador Controlado Pela ViewModel = $contadorProvinienteDaMinhaModelView")
    }
}

@Preview(showBackground = true)
@Composable
fun MinhaPreview() {
    //MainScreen( )
}