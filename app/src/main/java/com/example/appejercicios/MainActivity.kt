package com.example.appejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appejercicios.ui.theme.AppEjerciciosTheme

// COLORES DEL DISEÑO MORADO

val MoradoPrincipal = Color(0xFF7B2CBF)
val MoradoOscuro = Color(0xFF5A189A)
val MoradoClaro = Color(0xFFE9D8FD)
val FondoLavanda = Color(0xFFF8F3FF)
val TextoOscuro = Color(0xFF30233D)
val Blanco = Color(0xFFFFFFFF)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppEjerciciosTheme {
                AppNavegacion()
            }
        }
    }
}

@Composable
fun AppNavegacion() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = FondoLavanda
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "bienvenida",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("bienvenida") {
                PantallaBienvenida(navController)
            }

            composable("menu") {
                PantallaMenu(navController)
            }

            composable("multiplicacion") {
                PantallaMultiplicacion(navController)
            }

            composable("rectangulo") {
                PantallaRectangulo(navController)
            }

            composable("formulario") {
                PantallaFormulario(navController)
            }
        }
    }
}


// =====================================================
// PANTALLA DE BIENVENIDA
// =====================================================

@Composable
fun PantallaBienvenida(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoLavanda)
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blanco
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "",
                    fontSize = 55.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "¡Hola!",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = MoradoPrincipal
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Mi App de Ejercicios",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoOscuro,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {
                        navController.navigate("menu")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MoradoPrincipal
                    )
                ) {
                    Text(
                        text = "Comenzar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


// =====================================================
// MENÚ DE EJERCICIOS
// =====================================================

@Composable
fun PantallaMenu(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoLavanda)
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Mis ejercicios",
            fontSize = 31.sp,
            fontWeight = FontWeight.Bold,
            color = MoradoOscuro
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Elige una actividad para comenzar",
            fontSize = 15.sp,
            color = Color(0xFF756A80)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // TABLA DE MULTIPLICAR

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blanco
            ),
            border = BorderStroke(
                1.dp,
                MoradoClaro
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {

            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "",
                    fontSize = 32.sp,
                    color = MoradoPrincipal
                )

                Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Tabla de multiplicar",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoOscuro
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Practica las multiplicaciones.",
                        fontSize = 13.sp,
                        color = Color(0xFF756A80)
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("multiplicacion")
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MoradoPrincipal
                    )
                ) {
                    Text("Abrir")
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // ÁREA RECTANGULAR

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blanco
            ),
            border = BorderStroke(
                1.dp,
                MoradoClaro
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {

            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "",
                    fontSize = 32.sp,
                    color = MoradoPrincipal
                )

                Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Área rectangular",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoOscuro
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Calcula base × altura.",
                        fontSize = 13.sp,
                        color = Color(0xFF756A80)
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("rectangulo")
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MoradoPrincipal
                    )
                ) {
                    Text("Abrir")
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // FORMULARIO

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blanco
            ),
            border = BorderStroke(
                1.dp,
                MoradoClaro
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {

            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "",
                    fontSize = 29.sp
                )

                Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Formulario",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoOscuro
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Registra tus datos personales.",
                        fontSize = 13.sp,
                        color = Color(0xFF756A80)
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("formulario")
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MoradoPrincipal
                    )
                ) {
                    Text("Abrir")
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MoradoOscuro
            )
        ) {
            Text(
                text = "← Regresar",
                fontSize = 16.sp
            )
        }
    }
}


// =====================================================
// TABLA DE MULTIPLICAR
// =====================================================

@Composable
fun PantallaMultiplicacion(navController: NavHostController) {

    var numero by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf<List<String>>(emptyList())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoLavanda)
            .padding(22.dp)
    ) {

        Text(
            text = "Tabla de multiplicar",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MoradoOscuro
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Escribe un número y genera su tabla.",
            fontSize = 14.sp,
            color = Color(0xFF756A80)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = numero,
            onValueChange = {
                numero = it
            },
            label = {
                Text("Número")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MoradoPrincipal,
                focusedLabelColor = MoradoPrincipal,
                cursorColor = MoradoPrincipal
            )
        )

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {

                val n = numero.toIntOrNull()

                if (n != null) {
                    resultado = (1..10).map {
                        "$n × $it = ${n * it}"
                    }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MoradoPrincipal
            )
        ) {
            Text(
                text = "Generar tabla",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(resultado) { linea ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Blanco
                    ),
                    border = BorderStroke(
                        1.dp,
                        MoradoClaro
                    )
                ) {

                    Text(
                        text = linea,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextoOscuro,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MoradoOscuro
            )
        ) {
            Text("← Atrás")
        }
    }
}


// =====================================================
// ÁREA DEL RECTÁNGULO
// =====================================================

@Composable
fun PantallaRectangulo(navController: NavHostController) {

    var base by remember {
        mutableStateOf("")
    }

    var altura by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoLavanda)
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Área rectangular",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MoradoOscuro
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Ingresa las medidas del rectángulo.",
            fontSize = 14.sp,
            color = Color(0xFF756A80),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(22.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blanco
            ),
            border = BorderStroke(
                1.dp,
                MoradoClaro
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                OutlinedTextField(
                    value = base,
                    onValueChange = {
                        base = it
                    },
                    label = {
                        Text("Base")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MoradoPrincipal,
                        focusedLabelColor = MoradoPrincipal,
                        cursorColor = MoradoPrincipal
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = altura,
                    onValueChange = {
                        altura = it
                    },
                    label = {
                        Text("Altura")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MoradoPrincipal,
                        focusedLabelColor = MoradoPrincipal,
                        cursorColor = MoradoPrincipal
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = {

                        val b = base.toDoubleOrNull()
                        val h = altura.toDoubleOrNull()

                        if (b != null && h != null) {
                            val area = b * h
                            resultado = "Área = $area"
                        } else {
                            resultado = "Ingrese valores válidos"
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MoradoPrincipal
                    )
                ) {
                    Text(
                        text = "Calcular área",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        if (resultado.isNotEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MoradoClaro
                )
            ) {

                Text(
                    text = resultado,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MoradoOscuro,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MoradoOscuro
            )
        ) {
            Text("← Atrás")
        }
    }
}


// =====================================================
// FORMULARIO
// =====================================================

@Composable
fun PantallaFormulario(navController: NavHostController) {

    var nombre by remember {
        mutableStateOf("")
    }

    var apellido by remember {
        mutableStateOf("")
    }

    var telefono by remember {
        mutableStateOf("")
    }

    var correo by remember {
        mutableStateOf("")
    }

    var mensaje by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoLavanda)
            .padding(22.dp)
    ) {

        Text(
            text = "Formulario de datos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MoradoOscuro
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Completa la información solicitada.",
            fontSize = 14.sp,
            color = Color(0xFF756A80)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blanco
            ),
            border = BorderStroke(
                1.dp,
                MoradoClaro
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                OutlinedTextField(
                    value = nombre,
                    onValueChange = {
                        nombre = it
                    },
                    label = {
                        Text("Nombre")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(13.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MoradoPrincipal,
                        focusedLabelColor = MoradoPrincipal,
                        cursorColor = MoradoPrincipal
                    )
                )

                Spacer(modifier = Modifier.height(11.dp))

                OutlinedTextField(
                    value = apellido,
                    onValueChange = {
                        apellido = it
                    },
                    label = {
                        Text("Apellido")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(13.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MoradoPrincipal,
                        focusedLabelColor = MoradoPrincipal,
                        cursorColor = MoradoPrincipal
                    )
                )

                Spacer(modifier = Modifier.height(11.dp))

                OutlinedTextField(
                    value = telefono,
                    onValueChange = {
                        telefono = it
                    },
                    label = {
                        Text("Teléfono")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(13.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MoradoPrincipal,
                        focusedLabelColor = MoradoPrincipal,
                        cursorColor = MoradoPrincipal
                    )
                )

                Spacer(modifier = Modifier.height(11.dp))

                OutlinedTextField(
                    value = correo,
                    onValueChange = {
                        correo = it
                    },
                    label = {
                        Text("Correo electrónico")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(13.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MoradoPrincipal,
                        focusedLabelColor = MoradoPrincipal,
                        cursorColor = MoradoPrincipal
                    )
                )

                Spacer(modifier = Modifier.height(17.dp))

                Button(
                    onClick = {

                        if (
                            nombre.isNotBlank() &&
                            apellido.isNotBlank() &&
                            telefono.isNotBlank() &&
                            correo.isNotBlank()
                        ) {

                            mensaje = "✓ Datos guardados correctamente"

                        } else {

                            mensaje = "Complete todos los campos"
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MoradoPrincipal
                    )
                ) {
                    Text(
                        text = "Guardar datos",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (mensaje.isNotEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MoradoClaro
                )
            ) {

                Text(
                    text = mensaje,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MoradoOscuro,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MoradoOscuro
            )
        ) {
            Text("Atrás")
        }
    }
}