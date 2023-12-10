import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Transaksi{
    public static boolean Login(String enteredUsername, String enteredPassword){

        String Username = "Megamart";
        String Password = "MG1905";
        return Username.equals(enteredUsername) && Password.equals(enteredPassword);
    }

    public static String createCaptcha(){
        return "EAK9876";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean loginValid = false;
        boolean captchaValid = false;

        do{
            //Proses saat melakukan LOGIN
            System.out.print("Username : ");
            String username = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();
            
            //Method String Equals
            loginValid = Login(username, password);

            if(!loginValid){
                System.out.println("FAILED!! Silakan login kembali");
            }
        } while (!loginValid);

        do{
            //Verifikasi Kode CAPTCHA
            String verificationCaptcha = createCaptcha();
            System.out.println("CAPTCHA : " + verificationCaptcha);

            System.out.print("Masukkan Kode CAPTCHA : ");
            String insertCaptcha = scanner.nextLine();

            //Methos String Equals Ignore Case
            captchaValid = verificationCaptcha.equalsIgnoreCase(insertCaptcha);

            if(!captchaValid){
                System.out.println("CAPTCHA tidak valid!");
            }
        }while (!captchaValid);

                System.out.println("");
                System.out.println("LOGIN BERHASIL");
                System.out.println("");
                System.out.println("Silakan masukkan Data");
    
        try {
            System.out.print("Masukkan nomor faktur: ");
            int noFaktur = scanner.nextInt();

            System.out.print("Masukkan nama pelanggan: ");
            String namaPelanggan = scanner.next();

            System.out.print("Masukkan No. HP: ");
            String noHp = scanner.next();

            System.out.print("Masukkan alamat: ");
            String alamat = scanner.next();

            System.out.print("Masukkan nama barang: ");
            String namaBarang = scanner.next();

            System.out.print("Masukkan kode barang: ");
            String kodeBarang = scanner.next();

            System.out.print("Masukkan harga barang: ");
            double hargaBarang = scanner.nextDouble();

            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari nol");
            }

            System.out.print("Masukkan jumlah barang: ");
            int jumlahBarang = scanner.nextInt();

            Pelanggan pelanggan = new Pelanggan(namaPelanggan, noHp, alamat, kodeBarang, namaBarang, hargaBarang, jumlahBarang);
            Faktur faktur = new Faktur(noFaktur, pelanggan);
            
            //TANGGAL DAN WAKTU
            Date date = new Date();
            SimpleDateFormat hari = new SimpleDateFormat("EEEE dd-MM-yyyy");
            SimpleDateFormat jam = new SimpleDateFormat("HH:mm:ss z");


            System.out.println("\n==================================\n");
            System.out.println("           MEGA MART            ");
            System.out.println("    Jl. Sudirman no 1, Bekasi");
            System.out.println("\n==================================\n");
            System.out.println(hari.format(date));
            System.out.println(jam.format(date));
            System.out.println("No. Faktur: " + noFaktur + "\n");
            System.out.println("----------Data Pelanggan----------");
            System.out.println("Nama Pelanggan: " + namaPelanggan);
            System.out.println("No. Hp: " + noHp);
            System.out.println("Alamat: " + alamat + "\n");
            System.out.println("----------Data Pembelian----------");
            System.out.println("Nama Barang: " + namaBarang);
            System.out.println("Kode Barang: " + kodeBarang);
            System.out.println("Harga: " + hargaBarang);
            System.out.println("Jumlah Barang: " + jumlahBarang + "\n");
            System.out.println("Total Bayar : " + jumlahBarang*hargaBarang);
            System.out.println("-----------------------------------");
            System.out.println("Kasir: Athaya Clara Diva\n");
            System.out.println("           TERIMA KASIH");
            System.out.println("     SEMOGA MENJADI LANGGANAN");
            System.out.println("====================================");

            //METHOD STRING
            System.out.println("toLowerCase : " + alamat.toLowerCase());
            faktur.totalBayar();
        } catch (InputMismatchException e) {
            System.out.println("Error: Input tidak valid. " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    
    }
}
