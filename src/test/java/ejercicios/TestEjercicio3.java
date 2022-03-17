package test.java.ejercicios;

import main.java.ejercicios.data.DatosEjercicio3;
import main.java.ejercicios.solution.SolucionEjercicio3;
import test.java.tools.ple.TestPLEFile;

public class TestEjercicio3 {

	private static String data_path = "data/PI5Ej3DatosEntrada",out_path_ple = "out/ple/ejercicio3.txt",
			lsi_path = "models/lsi/ejercicio3.lsi", gurobi_path = "models/gurobi/ejercicio3.lp",
			out_path_gen = "out/gen/ejercicio3.txt";
	
	
	public static void main(String[] args) {
		String[] data = {data_path+1+".txt", data_path+1+".txt", data_path+1+".txt"};
		
		TestPLEFile.of(out_path_ple,lsi_path,gurobi_path,
				DatosEjercicio3::initDatos,SolucionEjercicio3::print,
				DatosEjercicio3.class).test(data);
		// TestGENFile.of(out_path_gen, 1000, 1000, GenEjercicio3::create).test(data);
	}
}