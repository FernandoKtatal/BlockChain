package noobchain;
import java.util.ArrayList;

import com.google.gson.*;

public class NoobChain {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int dificuldade = 5;
	
	public static void main(String[] args) {
		
		blockchain.add(new Block("The first block", "0"));
		System.out.println("minerando bloco 1.....");
		blockchain.get(0).Mining(dificuldade);		
		
		blockchain.add(new Block("The second block", blockchain.get(blockchain.size()-1).CalcHash()));
		System.out.println("minerando bloco 2.....");
		blockchain.get(1).Mining(dificuldade);
		
		blockchain.add(new Block("The third block", blockchain.get(blockchain.size()-1).CalcHash()));
		System.out.println("minerando bloco 3.....");
		blockchain.get(2).Mining(dificuldade);
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJson);
		
//		Block genesis = new Block("the first block here", "0");
//		System.out.println("Hash do bloco 1: " + genesis.hash);
//		
//		Block second = new Block("Yo Im the second block mothafuca", genesis.hash);
//		System.out.println("Hash do bloco 2: "+ second.hash);
//		
//		Block third = new Block("Finally the third block bitch", second.hash);
//		System.out.println("Hash do bloco 3: " + second.hash);
	}
	
	public static Boolean isChainValid() {
		Block atual;
		Block anterior;
		
		for(int i = 0; i < blockchain.size(); i++) {
			atual = blockchain.get(i);
			anterior = blockchain.get(i-1);
			
			if(!atual.hash.equals(atual.CalcHash())) {
				System.out.println("Bloco invalido");
				return false;
			}
			if(!anterior.hash.equals(anterior.previoushash)) {
				System.out.println("Bloco Invalido");
				return false;
			}
		}
		return true;
	}

}
