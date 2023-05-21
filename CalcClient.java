import WssCalculator.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import org.omg.CORBA.*;

import java.io.*;
import java.util.*;
public class CalcClient{
	static Calc cimpl;
	public static void main(String args[]){
		try{
			int dec=1;
			int i=0;
			int j=0;
			int k=0;
			int result=0;
			int x=1;
			char c='x';
			char d='y';
			char f='z';
			String abc="vas";
			
			ORB orb=ORB.init(args,null);
			
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			
			NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);
		
			String name="Calc";

			cimpl=CalcHelper.narrow(ncRef.resolve_str(name));
			System.out.println("Obtained a handle on the server object");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(x==1)
			{
			System.out.println("Enter the string:");
			abc=br.readLine();

			c=abc.charAt(0);
			d=abc.charAt(1);
			f=abc.charAt(2);

			i=(int)c;

			j=Character.getNumericValue(d);
			k=Character.getNumericValue(f);
			result=cimpl.calculate(i,j,k);
			System.out.println("The result of the operation is "+result);
			System.out.println("Enter 1 continue and 0 to exit ");
			x=Integer.parseInt(br.readLine());
			}

			System.out.println("Exiting...");
			cimpl.shutdown();

			}catch(Exception e) {
				System.out.println("ERROR+ e") ;
				e.printStackTrace(System.out);
			}
	}//end of main()

}

