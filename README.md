# DSPractical2
Steps:

1. idlj -fall Calc.idl
2. javac *.java WssCalculator/*.java
   or
  - javac CalcServer.java WssCalculator/*.java
  - javac CalcClient.java WssCalculator/*.java
3. orbd -ORBInitialPort 1050 orbd -ORBInitialHost localhost
4. java CalcServer -ORBInitialPort 1050 -ORBInitialHost localhost
5. java CalcClient -ORBInitialPort 1050 -ORBInitialHost localhost
