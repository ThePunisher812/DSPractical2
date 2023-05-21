import WssCalculator.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import org.omg.CORBA.*;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

import java.io.*;
import java.util.*; 

class Calcserverimpl extends CalcPOA{
	private ORB orb;
	public void setORB(ORB orb_val) { 
		orb = orb_val; 
	}

	public int calculate(int a,int b,int c){
		//ADDITION
		if(a==43)
		{
		return (b+c);
		}

		//SUBTRACTION
		else if(a==45)
		{
		return (b-c);
		}

		//MULTIPLICATION
		else if(a==42)
		{
		return (b*c);
		}

		//DIVISION
		else if(a==47)
		{
		return (b/c);
		}

		//DEFAULT
		else
		{
		return 0;
		}
	}

	//Closing the server 
	public void shutdown() {
		orb.shutdown(false);
	}
}//end of the servant class