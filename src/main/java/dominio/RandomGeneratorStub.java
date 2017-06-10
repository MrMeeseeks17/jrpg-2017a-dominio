package dominio;

public class RandomGeneratorStub extends RandomGenerador {

	private int valor;
	private double valorD;

	public RandomGeneratorStub(final double valord) {
		this.valorD = 0.5;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public double getValorD() {
		return valorD;
	}

	public void setValorD(double valorD) {
		this.valorD = valorD;
	}

	public RandomGeneratorStub() {
		this.valorD= 0;
		this.valor = 0 ;
//		this.valor = new Random().nextInt();
//		this.valorD = new Random().nextDouble();
	}

	public RandomGeneratorStub(final double valDouble,final int valInt) {
		this.valorD =  0.49;
		this.valor = 0;
	}

	@Override
	public final double nextDouble() {
		return this.valorD;
	}

	@Override
	public int nextInt(final int val) {
		return this.valor;
	}

	public int nextInt() {
		return this.valor;
	}
	}