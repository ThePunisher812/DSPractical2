import WssCalculator.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import org.omg.CORBA.*;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

import java.io.*;
import java.util.*; 

public class CalcServer {
	public static void main(String args[]) {
		try{
			ORB orb=ORB.init(args,null);
			
			POA rootpoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			Calcserverimpl simpl=new Calcserverimpl();
			simpl.setORB(orb); 
			
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(simpl);
			Calc href=CalcHelper.narrow(ref);
			
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			
			NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);
			
			String name = "Calc";

			NameComponent path[]=ncRef.to_name(name);
			
			ncRef.rebind(path,href);
			System.out.println("Thee SERVER is READY");
			System.out.println("Thee SERVER is WAITING to receive the CLIENT requests");
			
			orb.run();

		} catch (Exception e){
			System.err.println("ERROR e");
			e.printStackTrace(System.out);
		}

		System.out.println("Theer Exits");

	}
}