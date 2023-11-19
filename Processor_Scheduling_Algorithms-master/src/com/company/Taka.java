package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Magdalena Polak on 02.03.2016.
 */
public class Taka {
/*

    public double SRTF() {
        Collections.sort(procesy, Proces.Comparators.ComparatorMomentWejscia);
        double czasCalkowityOczekiwania = 0;
        int czasZakonczeniaCalkowity = (procesy.get(0)).getDlugoscFazy();
        int iloscPrzerwan = 0;
        for (int i = 1; i < procesy.size(); i++) {
            System.out.println(procesy.get(i - 1).getMomentWejscia() + " " +
                    (procesy.get(i - 1)).getDlugoscFazy() + " " + czasZakonczeniaCalkowity + " "
                    + czasCalkowityOczekiwania + "\n");
            if (czasZakonczeniaCalkowity <= procesy.get(i).getMomentWejscia())
                czasZakonczeniaCalkowity = procesy.get(i).getMomentWejscia() + (procesy.get(i)).getDlugoscFazy();

            else if (czasZakonczeniaCalkowity > procesy.get(i).getMomentWejscia()) {
                int a = i;
                ArrayList<Proces> kolejka = new ArrayList<Proces>();


                while (a < procesy.size() && czasZakonczeniaCalkowity > (procesy.get(a)).getMomentWejscia())

                {
                    kolejka.add(procesy.get(a));
                    a++;
                }


                Collections.sort(kolejka, Proces.Comparators.ComparatorDlugoscFazy);
                System.out.println(kolejka);
                int d = i;
                for (int p = 0; p < kolejka.size(); p++) {

                    procesy.set(d, kolejka.get(p));
                    d++;
                }
                System.out.println(i + " aaa" + procesy.get(i).getMomentWejscia() + " " + procesy.get(i).getDlugoscFazy());

                if ((czasZakonczeniaCalkowity - procesy.get(i).getMomentWejscia()) >= (procesy.get(i)).getDlugoscFazy()) {
                    if (procesy.get(i).getMomentWejscia() > procesy.get(i - 1).getMomentWejscia()) {
                        czasZakonczeniaCalkowity = procesy.get(i).getMomentWejscia() + procesy.get(i).getDlugoscFazy();
                    } else {
                        czasZakonczeniaCalkowity += procesy.get(i).getDlugoscFazy();
                    }
                    //czy cos zosta�o z przerwanego procesu
                    czasCalkowityOczekiwania += procesy.get(i).getDlugoscFazy();
                    if (procesy.get(i - 1).getDlugoscFazy() - procesy.get(i).getDlugoscFazy() > 0) {
                        procesy.add(new Proces(procesy.size(), procesy.get(i - 1).getMomentWejscia(), procesy.get(i - 1).getDlugoscFazy() - procesy.get(i).getMomentWejscia()));
                        iloscPrzerwan++;
                    }
                    System.out.println(i + " blaaa " + procesy.get(i).getMomentWejscia() + " "

                            + procesy.get(i).getDlugoscFazy() + " " + procesy.get(procesy.size() - 1));
                } else if ((i + 1) != procesy.size()) {
                    System.out.println("dupa");

                    czasCalkowityOczekiwania += (czasZakonczeniaCalkowity - procesy.get(i).getMomentWejscia());
                    czasZakonczeniaCalkowity += (procesy.get(i)).getDlugoscFazy();
                }

            }

        }
        System.out.println("czaaas" + czasCalkowityOczekiwania + "\n");
        return czasCalkowityOczekiwania / (procesy.size() - iloscPrzerwan);
    }

/* while (a < procesy3.size() && czasZakonczeniaCalkowity > (procesy3.get(a)).getMomentWejscia())

                {
                    kolejka.add(procesy3.get(a));
                    a++;
                }


                Collections.sort(kolejka, Proces3.Comparators.ComparatorDlugoscFazy);
                System.out.println(kolejka);
                int d = i;
                for (int p = 0; p < kolejka.size(); p++)
                {

                    procesy3.set(d, kolejka.get(p));
                    d++;
                }

     */

      /* public double SRTF2() {
        ArrayList<Proces3> procesy3 = new ArrayList<Proces3>();
        for (int i = 0; i < procesy.size(); i++) {
            procesy3.add(new Proces3((procesy.get(i)).getNumerProcesu(),
                    (procesy.get(i)).getMomentWejscia(), (procesy.get(i)).getDlugoscFazy(), (procesy.get(i)).getDlugoscFazy()));
        }

        Collections.sort(procesy3, Proces3.Comparators.ComparatorMomentWejscia);
        double czasCalkowityOczekiwania = 0;
        int czasZakonczeniaCalkowity = 0;
        int iloscPrzerwan = 0;
        for (int i = 1; i < procesy3.size(); i++)
        {
            Collections.sort(procesy3, Proces3.Comparators.ComparatorMomentWejscia);
            System.out.println(procesy3);
            System.out.println(procesy3.get(i - 1).getMomentWejscia() + " " +
                    (procesy3.get(i - 1)).getDlugoscFazy() + " " + czasZakonczeniaCalkowity + " "
                    + czasCalkowityOczekiwania + "\n");
            if ( (czasZakonczeniaCalkowity + procesy3.get(i - 1).getCzasPozostaly()) <= procesy3.get(i).getMomentWejscia())

            {
                czasZakonczeniaCalkowity = procesy3.get(i).getMomentWejscia() + (procesy3.get(i)).getCzasPozostaly();

            }

            else  {
                int a = i;
                ArrayList<Proces3> kolejka = new ArrayList<Proces3>();

                System.out.println("pierwszy");

                System.out.println(i + " aaa" + procesy3.get(i).getMomentWejscia() + " " + procesy3.get(i).getDlugoscFazy());

                if (((czasZakonczeniaCalkowity + procesy3.get(i - 1).getCzasPozostaly()) - procesy3.get(i).getMomentWejscia()) >= (procesy3.get(i)).getCzasPozostaly()) {

                    czyCosSieWepcha(czasZakonczeniaCalkowity, czasCalkowityOczekiwania, procesy3, i, iloscPrzerwan);


                    System.out.println(i + " blaaa " + procesy3.get(i).getMomentWejscia() + " "

                            + procesy3.get(i).getDlugoscFazy() + " " + procesy3.get(procesy3.size() - 1));
                } else if ((i + 1) != procesy3.size()) {
                    System.out.println("dupa");

                    czasCalkowityOczekiwania += (czasZakonczeniaCalkowity+ (procesy3.get(i - 1)).getCzasPozostaly() - (procesy3.get(i)).getMomentWejscia());
                   // System.out.println((procesy.get(i)).getMomentWejscia());
                    //czasZakonczeniaCalkowity += (procesy3.get(i-1)).getCzasPozostaly();
                    procesy3.add(new Proces3(procesy3.size(), (procesy3.get(i-1)).getCzasPozostaly(),
                            (procesy3.get(i)).getDlugoscFazy(),(procesy3.get(i)).getCzasPozostaly()));
                    iloscPrzerwan++;
                }

            }

        }
        System.out.println("czaaas" + czasCalkowityOczekiwania + "\n");
        return czasCalkowityOczekiwania/(procesy3.size()-iloscPrzerwan);
    }
    */ /*  public void czyCosSieWepcha(int czasZakonczeniaCalkowity, double czasCalkowityOczekiwania,
                                ArrayList<Proces3> procesy3, int l, int ilosc) {

        int wejscie = (procesy.get(l)).getMomentWejscia();
        if ((czasZakonczeniaCalkowity + procesy3.get(l).getCzasPozostaly() - procesy3.get(l + 1).getMomentWejscia())
                >= (procesy3.get(l + 1)).getCzasPozostaly()) {
            {
                procesy3.get(l).setCzasPozostaly((procesy3.get(l)).getCzasPozostaly() - procesy3.get(l + 1).getCzasPozostaly());
                czasZakonczeniaCalkowity = procesy3.get(l + 1).getMomentWejscia();
                procesy3.add(new Proces3(procesy3.size(),(procesy3.get(l)).getMomentWejscia(),
                        (procesy3.get(l)).getDlugoscFazy(),(procesy3.get(l)).getCzasPozostaly() - (procesy3.get(l + 1)).getCzasPozostaly()
                        ));
                ilosc++;
                czyCosSieWepcha(czasZakonczeniaCalkowity, czasCalkowityOczekiwania, procesy3, l + 1, ilosc);
            }
        } else {
            czasZakonczeniaCalkowity += procesy3.get(l).getCzasPozostaly();

            //czy cos zosta�o z przerwanego procesu

            czasCalkowityOczekiwania += (czasZakonczeniaCalkowity - procesy3.get(l).getMomentWejscia()
                    - procesy3.get(l).getDlugoscFazy());
            procesy3.get(l).setCzasPozostaly(0);

        }
    }
    public double RR(int k) {
        int kwant = 0;
        int czasAktualny = 0;
        double calkowityCzasOczekiwania = 0;
        ArrayList<Proces> procesy4 = new ArrayList<Proces>();
        ArrayList<Proces> kolejka = new ArrayList<Proces>();
        ArrayList<Proces> pomocnicza = new ArrayList<Proces>();

        for (int i = 0; i < procesy.size(); i++) {
            procesy4.add(new Proces((procesy.get(i)).getNumerProcesu(),
                    (procesy.get(i)).getMomentWejscia(), (procesy.get(i)).getDlugoscFazy(), (procesy.get(i)).getDlugoscFazy(), 0));
        }
        Collections.sort(procesy4, Proces.Comparators.ComparatorMomentWejscia);

        do {

            for (int i = 0; i < procesy4.size(); i++)

            {
                if (czasAktualny == (procesy4.get(i)).getMomentWejscia())
                {
                     pomocnicza.add(new Proces(0, 0, 0, (procesy4.get(i)).getCzasPozostaly(), 0));
                }
            }
            if(kwant <= 0 && pomocnicza.size()!=0)
            {
                 if(kolejka.size()==0) {
                    for (int a = 0; a < pomocnicza.size(); a++)
                    {
                        kolejka.add(a, pomocnicza.get(a));
                    }
                    pomocnicza.clear();
                   }
                else
                {
                   if(kolejka.size() == 1)
                    {

                     for (int a = 0; a < pomocnicza.size(); a++)
                         {
                           kolejka.add(pomocnicza.get(a));
                         }
                        pomocnicza.clear();
                     }
                    else
                    {
                        for (int a = 0; a < pomocnicza.size(); a++)
                        {
                            kolejka.add(a+1, pomocnicza.get(a));

                        }
                        pomocnicza.clear();
                    }

                }
            }
            if(kwant <= 0 && kolejka.size() !=0)
            {
                if ((kolejka.get(0)).getCzasPozostaly() == 0) {
                    System.out.println("kwant zerowy");
                    calkowityCzasOczekiwania += (kolejka.get(0)).getCzasOczekiwania();
                    kolejka.remove(0);
                    kwant = k;

                }
                else
                {
                    kolejka.add(kolejka.get(0));
                    kolejka.remove(0);

                    if((kolejka.get(0)).getCzasPozostaly()>=k)
                    {
                        kwant = k;
                    }
                    else
                    {
                        System.out.println("mniejszy kwant");
                        kwant = (kolejka.get(0)).getCzasPozostaly();
}
                    }

            }



            if (kolejka.size() != 0) {
                System.out.println(kolejka + " " + pomocnicza);

                (kolejka.get(0)).setCzasPozostaly((kolejka.get(0)).getCzasPozostaly() - 1);
                for (int j = 1; j < kolejka.size(); j++) {
                    (kolejka.get(j)).setCzasOczekiwania((kolejka.get(j)).getCzasOczekiwania() + 1);
                }

            }
            if (pomocnicza.size() != 0) {
                for (int j = 0; j < pomocnicza.size(); j++) {
                    (pomocnicza.get(j)).setCzasOczekiwania((pomocnicza.get(j)).getCzasOczekiwania() + 1);
                }
               }
            czasAktualny++;
            kwant--;

        }
        while (czasAktualny != 1000);
        return calkowityCzasOczekiwania / procesy4.size();

    }
     /*  Procesy pr = new Procesy(50);


    }

      //  System.out.println(" Nieposortowane");
      //  pr.wyswietl();
        System.out.println(" Posortowane wg cz wejscia");
        pr.wyswietlS();
        System.out.println("\nFCFS: " + pr.FCFS());
        System.out.println("\nSJF: " + pr.SJF());
        System.out.println("\nSJF2: " + pr.SJF2());
        System.out.println("\nSRTF: " + pr.SRTF());
        System.out.println("\nRR: " + pr.RR(100));


    public Procesy() {
        // procesy = new ArrayList<Proces>();
   /*     procesy.add(new Proces(0, 0, 50, 50, 0));
        procesy.add(new Proces(1, 0, 15, 15, 0));
        procesy.add(new Proces(2, 16, 6, 6, 0));
         procesy.add(new Proces(2, 60, 10, 10, 0));
        procesy.add(new Proces(2, 61, 2, 2, 0));

        procesy = new ArrayList<Proces>();
        procesy.add(new Proces(0, 0, 10));
        procesy.add(new Proces(1, 4, 5));
        procesy.add(new Proces(2, 5, 2));
        for(int i = 0; i<liczba; i++)
        {
            Random r = new Random();

            int n = i;
            int d =  r.nextInt(100);
            int m = 1 + r.nextInt(100);
            procesy.add(new Proces(n, d, m, m, 0));
        }
    }


    public void wyswietl() {

        for (Proces p : procesy)
            System.out.print(p + "\n");

    }

    public void wyswietlS() {
        Collections.sort(procesy, Proces.Comparators.ComparatorMomentWejscia);
        for (Proces p : procesy)
            System.out.print(p + " \n");
    }

      public double SJF2(ArrayList<Proces> procesy) {
          Collections.sort(procesy, Proces.Comparators.ComparatorMomentWejscia);

          double czasCalkowityOczekiwania = 0;
          int czasZakonczeniaCalkowity = (procesy.get(0)).getDlugoscFazy();
          for (int i = 1; i < procesy.size(); i++) {
              if (czasZakonczeniaCalkowity <= procesy.get(i).getMomentWejscia())
                  czasZakonczeniaCalkowity = procesy.get(i).getMomentWejscia() + (procesy.get(i)).getDlugoscFazy();

              else if (czasZakonczeniaCalkowity > procesy.get(i).getMomentWejscia()) {
                  int a = i;
                  ArrayList<Proces> kolejka = new ArrayList<Proces>();
                  while (a < procesy.size() && czasZakonczeniaCalkowity > (procesy.get(a)).getMomentWejscia())

                  {
                      kolejka.add(procesy.get(a));
                      a++;
                  }


                  Collections.sort(kolejka, Proces.Comparators.ComparatorDlugoscFazy);
                  int d = i;
                  for (int p = 0; p < kolejka.size(); p++) {

                      procesy.set(d, kolejka.get(p));
                      d++;
                  }
                  czasCalkowityOczekiwania += (czasZakonczeniaCalkowity - procesy.get(i).getMomentWejscia());
                  czasZakonczeniaCalkowity += (procesy.get(i)).getDlugoscFazy();
              }

          }
          return czasCalkowityOczekiwania / procesy.size();
      }


}
*/
}