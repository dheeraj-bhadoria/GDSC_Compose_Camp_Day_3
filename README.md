# GDSC_Compose_Camp_Day_3
Create a simple SIP Calculator using Jetpack Compose. Compose Camp Day 3

SIP Calculator use to calculate how much amount<br/>you will get after investing some amount on monthly basis<br/>with the enter interest rate. 

      // Default value of monthly investment and it will used to get value
      var monthlyInvestment = remember { mutableStateOf("1000")}
      
      // Interest per year 
      var interestPerYear = remember { mutableStateOf("10")}
      
      // Total number of years 
      var totalYear = remember { mutableStateOf("10")}
      
      // Total return
      var totalReturn = remember { mutableStateOf("")}
  <img src="SIP.png" width="380" height="620"  hspace="20">
