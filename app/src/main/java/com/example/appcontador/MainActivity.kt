package com.example.appcontador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.appcontador.ui.theme.AppContadorTheme
import com.example.appcontador.ui.theme.Azulzinho

class MainActivity : ComponentActivity() {
    private lateinit var minhaViewModelQueEuCrieiAgoraPouco : MinhaViewModelBemSImples

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewModelBemSImples::class.java)

        setContent {
            Main(minhaViewModelQueEuCrieiAgoraPouco)
        }
    }
}

@Composable
fun Main(umaViewModel: MinhaViewModelBemSImples){

    //responsável por mostrar os números nas próximas telas
    var contadorNaView by remember {
        mutableStateOf(0)
    }

    val contadorProvenienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color =Azulzinho )
        .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Nome: Sarah Jandozza Laurindo\nRM: 22313",
            modifier = Modifier.padding( bottom = 16.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Button(onClick = {
            contadorNaView = contadorNaView + 1
            umaViewModel.incrementaContador()
            //Log.i("NOSSA_LOG", "Valor do Contador $contador")
        }) {
            Text(text = "INCREMENTAR CONTADOR")
        }
        Button(onClick = {
            contadorNaView = contadorNaView - 1
            //Log.i("NOSSA_LOG", "Valor do Contador $contador")
        }) {
            Text(text = "DECREMENTAR CONTADOR")
        }
        Text(text = "Valor do Contador Controlado pela View = $contadorNaView",
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold

        )
        Text(text = "Valor do Contador Controlado pela ViewModel = $contadorProvenienteDaMinhaModelView",
            modifier = Modifier.padding(top = 1.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}