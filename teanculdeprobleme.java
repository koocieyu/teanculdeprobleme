import java.sql.DriverPropertyInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class teanculdeprobleme {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      String sirTeanc;
      String[] randuri;
      ArrayList<ArrayList<String>> sirNumere = new ArrayList<ArrayList<String>>();
      Integer[][] teanc;
      Integer i, j;
      ArrayList<Integer>
      numerePrime = new ArrayList<Integer>(),
      numereSumaCifreEgDivizori = new ArrayList<Integer>(),
      numereMagice = new ArrayList<Integer>();

      int numerePare = 0, numereImpare = 0;

      try {
         sirTeanc = console.nextLine();
         randuri = sirTeanc.split(" [a-z]+ ");
         teanc = new Integer[randuri.length][];

         for (i = 0; i < randuri.length; i++) {
            ArrayList<String> randSeparat = new ArrayList<String>();
            String[] numereSeparateString = randuri[i].split(" ");
            teanc[i] = new Integer[numereSeparateString.length];
            for (String numarString : numereSeparateString) randSeparat.add(numarString);
            sirNumere.add(randSeparat);
         }
         
         for (i = 0; i < sirNumere.size(); i++) {
            for (j = 0; j < sirNumere.get(i).size(); j++){
               teanc[i][j] = Integer.parseInt(sirNumere.get(i).get(j)); 
            }
         }
         
         Integer numarCerinte = Integer.parseInt(console.nextLine());

         for (int nr = 1; nr <= numarCerinte; nr++) {
            String[] instructiuni = console.nextLine().split(" ");
            char operatie = instructiuni[0].charAt(0);
            Integer numar = Integer.parseInt(instructiuni[1]);
            Integer cateRanduri = Integer.parseInt(instructiuni[2]);
   
            if (cateRanduri == 0) {
               for (i = 0; i < teanc.length; i++) {
                  for (j = 0; j < teanc[i].length; j++) {
                     teanc[i][j] = calcul(operatie, teanc[i][j], numar);
                  }
               }
            }
            else if (cateRanduri > 0) {
               for (i = 0; i < cateRanduri; i++) {
                  for (j = 0; j < teanc[i].length; j++) teanc[i][j] = calcul(operatie, teanc[i][j], numar);
               }
            }
            else if (cateRanduri < 0) {
               for (i = teanc.length - 1; i >= teanc.length + cateRanduri; i--) {
                  for (j = 0; j < teanc[i].length; j++) teanc[i][j] = calcul(operatie, teanc[i][j], numar);
               }
            }
         }
   
         for (i = 0; i < teanc.length; i++) {
            for (j = 0; j < teanc[i].length; j++) {
               System.out.print(teanc[i][j] + " ");
               if (numarPrim(teanc[i][j])) numerePrime.add(teanc[i][j]);
               if (teanc[i][j] % 2 == 0) numerePare++;
               if (teanc[i][j] % 2 == 1) numereImpare++;
               if (nrDivEgSc(teanc[i][j])) numereSumaCifreEgDivizori.add(teanc[i][j]);
               if (faceParteFibonacci(teanc[i][j]) && areCelPutin2Cifre(teanc[i][j]) && primaCifraImpara(teanc[i][j])) numereMagice.add(teanc[i][j]);
            }   
            System.out.print('\n');
         }
         if (numerePrime.size() == 0) System.out.println("NU");
         else {
            for (i = 0; i < numerePrime.size(); i++) System.out.print(numerePrime.get(i) + " ");
            System.out.print("\n");
         }

         System.out.println(raportNrPareNrImpare(numerePare, numereImpare));

         if (numereSumaCifreEgDivizori.size() == 0) System.out.println("NU");
         else {
            for (i = 0; i < numereSumaCifreEgDivizori.size(); i++) System.out.print(numereSumaCifreEgDivizori.get(i) + " ");
            System.out.print("\n");
         }

         if (numereMagice.size() == 0) System.out.print("NU");
         else {
            for (i = 0; i < numereMagice.size(); i++) System.out.print(numereMagice.get(i) + " ");
         }

      }
      catch (Exception eroare) {
         System.out.println(eroare);
         eroare.printStackTrace();
      }

   }
   public static Integer calcul(char operatie, Integer numar1, Integer numar2) {
      switch (operatie) {
         case 'p': return numar1 * numar2;
         case 's': return numar1 + numar2;
         case 'd': return numar1 - numar2;
         case 'i': return numar1 / numar2;
         default: return numar1 % numar2; // modulo
      }
   }
   public static boolean numarPrim(Integer numar) {
      for (int nrPrim = 2; nrPrim <= Math.sqrt(numar); nrPrim++) {
         if (numar % nrPrim == 0) return false;
      }
      return true;
   }
   public static boolean nrDivEgSc(Integer numar) {
      Integer numarDivizori = 0;
      Integer clonaNumar = numar;
      Integer sumaCifrelor = 0;
      for (int nr = 1; nr <= numar; nr++) if (numar % nr == 0) numarDivizori++;
      while (clonaNumar != 0) {
         sumaCifrelor += clonaNumar % 10;
         clonaNumar /= 10;
      }

      return numarDivizori == sumaCifrelor;
   }
   public static boolean primaCifraImpara(Integer numar) {
      Integer clonaNumar = numar;
      while (clonaNumar > 10) clonaNumar /= 10;
      return clonaNumar % 2 == 1;
   }
   public static boolean areCelPutin2Cifre(Integer numar) {
      return numar / 10 != 0;
   }
   public static boolean faceParteFibonacci(Integer numar) {
      Integer numar1 = 1, numar2 = 1, schimb = 1;

      while (numar2 < numar) {
         schimb = numar1;
         numar1 = numar2;
         numar2 += schimb;
      }

      if (numar == numar2) return true;
      return false;
   }
   public static Integer min(Integer numar1, Integer numar2) {
      return (numar1 < numar2) ? numar1 : numar2;
   }
   public static String raportNrPareNrImpare(Integer nrPare, Integer nrImpare) {
      int clonaNP = nrPare;
      int clonaNI = nrImpare;
      int minim = min(nrPare, nrImpare);

      return nrPare / cmmdc(nrPare, nrImpare) + ":" + nrImpare / cmmdc(nrPare, nrImpare);
   }
   public static Integer cmmdc(Integer numar1, Integer numar2) {
      Integer clona1 = numar1, clona2 = numar2;
      while (clona1 != clona2) {
         if (clona1 > clona2) clona1 -= clona2;
         else clona2 -= clona1;
      }
      
      return clona1;
	}
}