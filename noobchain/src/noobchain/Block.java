package noobchain;

import java.util.Date;

public class Block {
	public String hash;
	public String previoushash;
	private String data;
	private long time;
	private int nonce;
	
	
	public Block(String data, String previoushash) {
		this.data = data;
		this.previoushash = previoushash;
		this.time = new Date().getTime();
		this.hash = CalcHash();
	}

	public String CalcHash() {
		String calchash = StringUtil.applaySHA256(previoushash + data + Long.toString(time) + Integer.toString(nonce));
		return calchash;
	}
	
	public void Mining(int dificuldade) {
		String target = new String(new char[dificuldade]).replace("\0", "0");
		while(!hash.substring(0, dificuldade).equals(target)) {
			nonce++;
			hash = CalcHash();
		}
		System.out.println("Bloco minerado: "+ hash);
	}
}
