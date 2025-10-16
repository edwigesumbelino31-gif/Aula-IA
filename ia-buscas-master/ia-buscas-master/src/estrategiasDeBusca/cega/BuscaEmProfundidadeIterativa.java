package estrategiasDeBusca.cega;

import espacoDeEstados.Estado;

public class BuscaEmProfundidadeIterativa extends BuscaCega {
	
	private int limiteMaximo = 50; 
	
	@Override
	public boolean buscar() {
		for (int limite = 0; limite <= limiteMaximo; limite++) {
			BuscaEmProfundidadeLimitada buscaLimitada = 
				new BuscaEmProfundidadeLimitada(getInicio(), getObjetivo(), limite);
			
			if (buscaLimitada.buscar()) {
				this.caminhoSolucao = buscaLimitada.getCaminhoSolucao();
				this.nosVisitados = buscaLimitada.getNosVisitados();
				this.nosExpandidos = buscaLimitada.getNosExpandidos();
				System.out.println("Solução encontrada com limite = " + limite);
				return true;
			}
		}
		
		System.out.println("Solução não encontrada até o limite máximo: " + limiteMaximo);
		return false; // ← aqui estava faltando o ponto e vírgula
	}
}
