package main.java.ejercicios.gen;

import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import org.jgrapht.graph.SimpleWeightedGraph;

import main.java.ejercicios.data.DatosEjercicio5;
import main.java.ejercicios.solution.SolucionEjercicio5;
import us.lsi.ag.BinaryData;
import us.lsi.ag.SeqNormalData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.common.List2;
import us.lsi.common.Map2;
import us.lsi.common.Pair;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;

public class GenEjercicio5 implements SeqNormalData<SolucionEjercicio5>{

	private SimpleWeightedGraph<Ciudad, Carretera> grafo;
	
	public static GenEjercicio5 create(String linea) {
		return new GenEjercicio5(linea);
	}
	
	private GenEjercicio5(String linea) {
		DatosEjercicio5.initDatos(linea);
		grafo = DatosEjercicio5.getGrafo();
	}

	@Override
	public ChromosomeType type() {
		return ChromosomeType.PermutationSubList;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		Double goal = 0., error = 0.;
		Integer predicadoCarreteraCumplido =  0, predicadoCiudadCumplido = 0; 
		value = List.of(0,5,10,15,20,24);
		System.out.println(SolucionEjercicio5.create(value));
		Ciudad origen = DatosEjercicio5.getOrigen(), destino = DatosEjercicio5.getDestino();
		if (value.size() >= 3) {
			for (var i = 0; i < value.size()-1; i++) {
				Ciudad source = DatosEjercicio5.getCiudad(value.get(i)), target = DatosEjercicio5.getCiudad(value.get(i+1));
				if (grafo.containsEdge(source, target)) {
					Carretera carretera = grafo.getEdge(source, target);
					predicadoCarreteraCumplido += DatosEjercicio5.predicadoCarretera(carretera) ? 1: 0;
					goal += carretera.km();
				} else
					error += 1;
				if (!source.equals(origen))
					predicadoCiudadCumplido += DatosEjercicio5.predicadoCiudad(source) ? 1: 0;
			}
			error += origen != DatosEjercicio5.getCiudad(value.get(0)) ? 1: 0;
			error += destino != DatosEjercicio5.getCiudad(value.get(value.size()-1)) ? 1: 0;
		} else
			error += 1;
		error += predicadoCarreteraCumplido>0 && predicadoCiudadCumplido >0? 0: 1; 
		return error < 1 ? -goal: -1000*error;
	}

	@Override
	public SolucionEjercicio5 solucion(List<Integer> value) {
		return SolucionEjercicio5.create(value);
	}

	@Override
	public Integer itemsNumber() {
		return DatosEjercicio5.getNumCiudades();
	}
}