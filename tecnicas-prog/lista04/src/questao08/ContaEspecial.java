package questao08;

	public class ContaEspecial extends ContaCorrente {
		private float limiteCredito;
	
		public ContaEspecial(int codigo, int agencia, float saldo, float limiteCredito) {
			super(codigo, agencia, saldo);
			this.limiteCredito = limiteCredito;
		}
		
		public float sacar(int quant) {
			if(quant>0) {
				if(quant<=this.getSaldo()) {
					this.saldo -= quant;
					return quant;
				}else if(quant<=this.getLimiteCredito()+this.getSaldo()) {
					this.saldo -= quant;
					return quant;
				}
			}
			return 0;
		}
	
		public float getLimiteCredito() {
			return limiteCredito;
		}
	
		public void setLimiteCredito(float limiteCredito) {
			this.limiteCredito = limiteCredito;
		}
	}
