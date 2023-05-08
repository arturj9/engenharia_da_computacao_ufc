package questao08;

public class ContaCorrente {
	protected int codigo;
	protected int agencia;
	protected float saldo;
	
	public ContaCorrente(int codigo, int agencia, float saldo) {
		super();
		this.codigo = codigo;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public float sacar(float quant) {
		if(quant<=0&&quant>this.getSaldo())
			return 0;
		
		this.saldo = this.getSaldo() - quant;
		return quant;
		
	}
	
	public float getSaldo() {
		return this.saldo;
	}
}
