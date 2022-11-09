package DrakeFKahve;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	static ArrayList<Urun> urunList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Options kahveOtomasyon = new Options();
		double accountBalance = 3;
		double artirPara=0;
		char karar = 'E';
		urunGir();
		while(karar=='E') {
		System.out.printf("***KAHVE OTOMASYONUNA HOŞGELDİNİZ***\nBakiyeniz : %.2f\nAlış veriş yapmak ister misiniz ? <E / H>  ",accountBalance);
		karar = scan.next().toUpperCase().charAt(0);
		menuGoster();
		Urun secilenUrun = kahveOtomasyon.select(urunList);
		while(secilenUrun.price > accountBalance) {
			artirPara = kahveOtomasyon.balance(secilenUrun.price, accountBalance, secilenUrun);
			accountBalance+=artirPara;
			if(artirPara<=0) {break;}
		}
		
		if(accountBalance<secilenUrun.price) {System.out.printf("Hiçbir ürün almadınız. Bakiyeniz %.2f" , accountBalance); break;}
		karar = kahveOtomasyon.purchase(secilenUrun.price, accountBalance, secilenUrun);
		accountBalance-=secilenUrun.price;
		}
	}
	
	public static void urunGir() {
		Urun kraker	     = new Urun("kraker" , 1,2.5);
		Urun cips	     = new Urun("cips" , 2,2.2);
		Urun cocaCola    = new Urun("cocaCola" , 3,2.2);
		Urun fanta 	     = new Urun("fanta" , 4,2.0);
		Urun su 	     = new Urun("su",5,1.0);
		Urun cay 	     = new Urun("cay" ,6,1.5);
		Urun filtreKahve = new Urun("filtreKahve" , 7,1.99);
		urunList.add(kraker);
		urunList.add(cips);
		urunList.add(cocaCola);
		urunList.add(fanta);
		urunList.add(su);
		urunList.add(cay);
		urunList.add(filtreKahve);
	}
	public static void menuGoster() {
		System.out.println("Ürün Num  Ürün Adı\tÜrün Fiyatı\t\n====================================");
		for(int i = 0; i<urunList.size();i++) {
			System.out.printf("%5d\t   %-10s\t%5.2f\n" , urunList.get(i).productNum , urunList.get(i).name , urunList.get(i).price);
		}System.out.println("");
	}

}
