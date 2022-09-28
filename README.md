# GDSC_Compose_Camp_Day_3
Create a simple SIP Calculator using Jetpack Compose. Compose Camp Day 3

SIP Calculator use to calculate how much amount<br/>you will get after investing some amount on monthly basis<br/>with the enter interest rate. 
  <img src="SIP.png" width="380" height="620" align="right" hspace="20">

        var monthlyInvestment = remember { mutableStateOf("1000")}
        var interestPerYear = remember { mutableStateOf("10")}
        var totalYear = remember { mutableStateOf("10")}
        var totalReturn = remember { mutableStateOf("")}
