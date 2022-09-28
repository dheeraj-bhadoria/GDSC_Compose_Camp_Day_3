package com.example.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.example.ui.theme.ExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyLoginScreen()
                }
            }
        }
    }

    // For calculating the SIP return
    fun calculateReturn(monthlyAmount: Double, interestPerYear: Double, TotalYear: Double): Double{
        return monthlyAmount*Math.pow((1+interestPerYear/100),TotalYear)
    }

    @Composable
    fun MyLoginScreen() {

        // Automatically get the values from the views
        var monthlyInvestment = remember { mutableStateOf("1000")}
        var interestPerYear = remember { mutableStateOf("10")}
        var totalYear = remember { mutableStateOf("10")}
        var totalReturn = remember { mutableStateOf("")}


        // Box is like layout may
        Box (
            modifier = Modifier.background(Color.White)
        ){
            Column(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = "SIP Calculator",)
                Spacer(modifier = Modifier.height(20.dp))
                // Total monthly investment
                OutlinedTextField(
                    // initially setting the value
                    value = monthlyInvestment.value,  // 1000
                    // After making change in value we will set its value to variable
                    onValueChange = {
                        monthlyInvestment.value = it

                        if(monthlyInvestment.value.toString().length>0
                            && interestPerYear.value.toString().length>0
                            && totalYear.value.toString().length>0){

                             try{
                                 // Calculate the return and set its value to the total return variable
                                 totalReturn.value = calculateReturn(monthlyInvestment.value.toDouble(),
                                     interestPerYear.value.toDouble(),
                                     totalYear.value.toDouble()).toString()
                             }catch (ex: Exception){
                                 Toast.makeText(this@MainActivity, "Value is not valid", Toast.LENGTH_LONG).show()
                                 monthlyInvestment.value = ""
                             }

                        }else{
                            Toast.makeText(this@MainActivity, "Please enter valid values", Toast.LENGTH_LONG).show()
                        }


                    },
                    // Title
                    label = {  // Floating label top of input box
                        Text(text = "Monthly Investment")
                    },
                    // Hint/Placeholder
                    placeholder = {   // hint
                        Text(text = "Enter amount")
                    },
                    // Modifier is used to change the property of the particular compasable/View/Widget
                    modifier = Modifier.fillMaxWidth()
                )



                OutlinedTextField(
                    value = interestPerYear.value,
                    onValueChange = {
                        interestPerYear.value = it

                        if(monthlyInvestment.value.toString().length>0
                            && interestPerYear.value.toString().length>0
                            && totalYear.value.toString().length>0){

                            try{
                                // Calculate the return and set its value to the total return variable
                                totalReturn.value = calculateReturn(monthlyInvestment.value.toDouble(),
                                    interestPerYear.value.toDouble(),
                                    totalYear.value.toDouble()).toString()
                            }catch (ex: Exception){
                                Toast.makeText(this@MainActivity, "Value is not valid", Toast.LENGTH_LONG).show()
                                interestPerYear.value = ""
                            }
                        }else{
                            Toast.makeText(this@MainActivity, "Please enter valid values", Toast.LENGTH_LONG).show()
                        }


                    },
                    label = {
                        Text(text = "Interest Per Year")
                    },
                    placeholder = {
                        Text(text = "Enter Interest Percentage")
                    },
                    modifier = Modifier.fillMaxWidth()

                )


                OutlinedTextField(
                    value = totalYear.value,
                    onValueChange = {
                        totalYear.value = it

                        if(monthlyInvestment.value.toString().length>0
                            && interestPerYear.value.toString().length>0
                            && totalYear.value.toString().length>0){
                            try{
                                // Calculate the return and set its value to the total return variable
                                totalReturn.value = calculateReturn(monthlyInvestment.value.toDouble(),
                                    interestPerYear.value.toDouble(),
                                    totalYear.value.toDouble()).toString()
                            }catch (ex: Exception){
                                Toast.makeText(this@MainActivity, "Value is not valid", Toast.LENGTH_LONG).show()
                                totalYear.value = ""
                            }
                        }else{
                            Toast.makeText(this@MainActivity, "Please enter valid values", Toast.LENGTH_LONG).show()
                        }


                    },
                    label = {
                        Text(text = "Total Year")
                    },
                    placeholder = {
                        Text(text = "Enter Years")
                    },
                    modifier = Modifier.fillMaxWidth()

                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Total Return = "+totalReturn.value, color= Color.Green)
                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButton(
                    onClick = {  // onclick listner

                    },
                    modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Calculate")
                }
            }
        }


    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ExampleTheme {
            MyLoginScreen()
        }
    }
}




