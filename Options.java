package DrakeFKahve;
import java.util.ArrayList;
import java.util.Scanner;
public class Options {
	Scanner scan = new Scanner(System.in);
	public Urun select(ArrayList<Urun> urunList) {
		System.out.print("Ürünlerden hangisi isterseniz ürün numarasına göre seçim yapınız :");
		int secim = scan.nextInt()-1;
		while(secim<0 || secim > urunList.size()-1) {
			System.out.println("Yanlış seçim yaptınız, Lütfen tekrar deneyiniz");
			select(urunList);
		}
		return urunList.get(secim);
	}
	public double balance(double price , double accountBalance , Urun product) {
		double ekPara;
		System.out.printf("Aldığınız ürün için %.2f kadar bakiyeniz eksiktir.\nEkleme yapmak ister misiniz  <E / H>",(accountBalance - price));
		char karar = scan.next().toUpperCase().charAt(0);
		if(karar=='E') {
			System.out.print("Eklenecek parayı giriniz : ");
			ekPara = scan.nextDouble();
			price+=ekPara;
		}else {
			System.out.println("Ekleme yapmadınız iyi günler dileriz");
			ekPara = 0;
		}
		return ekPara;
	}
	public char purchase(double price , double accountBalance , Urun product) {
		char karar;
		
		System.out.printf(product.name + "Ürününü aldınız Kalan bakiyeniz %.2f dir.\nBaşka ürün olmak ister misiniz? <E / H>  ",(accountBalance-price));
		karar = scan.next().toUpperCase().charAt(0);
		if(karar == 'E') {
			System.out.println("sizleri ürün seçme ekranına yönderiyorum.");
			return karar;
		}else {
			System.out.printf("iyi günler dileriz. Para üstünüzü almayı unutmayınız -> %.2f",(accountBalance-price));
		}return karar;
	}
	
	
	
}
