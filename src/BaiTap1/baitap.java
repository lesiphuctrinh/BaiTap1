package BaiTap1;

import java.util.Scanner;

public class baitap {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		int luachon;
		do {
			System.out.println("\n\t=============MENU=============");
			System.out.println("1.Phuong trinh bac 2.");
			System.out.println("2.Giai thua.");
			System.out.println("3.So fibonacci.");
			System.out.println("4.UCLN va BCNN.");
			System.out.println("5.Liet ke tat ca cac so nguyen to nho hon n.");
			System.out.println("6.Liet ke n so nguyen to dau tien.");
			System.out.println("7.Liet ke tat ca so nguyen to co 5 chu so.");
			System.out.println("8.Tinh tong co chu so cua mot so nguyen.");
			System.out.println("9.Liet ke cac so thuan nghich co 6 chu so.");
			System.out.println("10.Liet ke cac so fibonacci.");
			System.out.println("11.Thoat.");
			System.out.println("\t===============================");
			System.out.println("Nhap lua chon: ");
			luachon = nhap.nextInt();
			switch (luachon) {
			case 1: {
				System.out.println("Nhap a, b, c: ");
				float a = nhap.nextFloat();
				float b = nhap.nextFloat();
				float c = nhap.nextFloat();
				baitap.ptb2(a, b, c);
				break;
			}
			case 2: {
				System.out.println("nhap vao n: ");
				int n = nhap.nextInt();
				long g = baitap.giaithua(n);
				System.out.printf("%d!= %d", n, g);
				break;
			}
			case 3: {
				System.out.println("nhap vao n: ");
				int n = nhap.nextInt();
				long f=baitap.fibo(n);
				System.out.printf("F[%d]= %d", n, f);
				break;
			}
			case 4: {
				System.out.println("Nhap vao hai so a, b: ");
				int a=nhap.nextInt();
				int b=nhap.nextInt();
				int nhan=a*b;
				int c=baitap.UCBC(a, b);
				System.out.println("UCLN: " + c);
				System.out.println("BCNN: " + (nhan/c));
				break;
			}
			case 5: {
				System.out.println("Nhap vao n: ");
				int n=nhap.nextInt();
				System.out.printf("Cac so nguyen to nho hon %d la: ", n);
				for(int i=2; i<n; i++) {
					if(songuyento(i))
						System.out.printf("%d ", i);
				}
				break;
			}
			case 6: {
				int dem=0, i=2;
				System.out.println("Nhap vao n: ");
				int n=nhap.nextInt();
				System.out.print("Cac so nguyen to dau tien: ");
				while(dem < n) {
					if(songuyento(i)) {
						System.out.printf("%d ", i);
						dem++;
					}
					i++;
				}
				break;
			}
			case 7: {
				System.out.print("Cac so nguyen to co 5 chu so: ");
				for(int i=10000; i<=99999; i++) {
					if(songuyento(i))
						System.out.printf("%d ", i);
				}
				break;
			}
			case 8: {
				System.out.println("Nhap vao day so nguyen: ");
				int n=nhap.nextInt();
				System.out.println("Tong cua cac chu so la: "+ tinhtong(n));
				break;
			}
			case 9: {
				System.out.print("Cac so thuan nghich co 6 chu so: ");
				for(int i=100000; i<1000000; i++) {
					if(thuannghich(i)==1) {
						System.out.printf("%d ", i);
					}
				}
				break;
			}
			case 10: {
				System.out.println("Nhap vao so tu nhien n: ");
				int n=nhap.nextInt();
				int i=1;
				System.out.print("Cac so fibonacci nho hon n va la so nguyen to: ");
				while(fibo(i) < n) {
					int f=fibo(i);
					if(songuyento(f)) {
						System.out.printf(" %d ", f);
					}
					i++;
				}
				break;
			}
			case 11: {
				break;
			}
			default:
				System.out.println("Vui long nhap lai!");
			}
		} while (luachon != 11);
	}

	// phuong trinh bac 2
	public static void ptb2(float a, float b, float c) {
		if (a == 0) {
			if (b == 0)
				System.out.println("Phuong trinh vo nghiem.");
			else
				System.out.println("Phuong trinh co mot nghiem: " + (-c / b));
		}
		float delta = b * b - 4 * a * c;
		float x1, x2;
		if (delta > 0) {
			x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
			x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("Nghiem cua phuong trinh la: " + "X1= " + x1 + "; X2= " + x2);
		} else if (delta == 0) {
			x1 = -b / (2 * a);
			System.out.println("Phuong trinh co nghiem kep la: " + "X1=X2= " + x1);
		} else
			System.out.println("Phuong trinh vo nghiem.");
	}

	// giai thua
	public static long giaithua(int n) {
		if (n == 0)
			return 1;
		return n * giaithua(n - 1);
	}

	// fibo
	public static int fibo(int n) {
		if (n < 0) {
			return -1;
		} else if (n == 0 || n == 1) {
			return n;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}
	//UCLN va BCNN
	public static int UCBC(int a, int b) {
		while(a != b) {
			if(a > b)
				a-=b;
			else
				b-=a;
		}
		return a;
	}
	// so nguyen to
	public static boolean songuyento(int n) {
		if(n < 2)
			return false;
		for(int i=2; i <=(int) Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	//tong day so
	public static long tinhtong(int n) {
		int sum=0;
		while(n > 0) {
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
	//Thuan nghich
	public static int thuannghich(int n) {
		int tam=n;
		int sum=0;
		while(n != 0) {
			int d=n%10;
			sum = sum*10+d;
			n/=10;
		}
		if(sum==tam)
			return 1;
		else
			return 0;
	}
}
