package com.company;

import java.util.ArrayList;
import java.util.Collections;



public class Procesy {

    public double FCFS(ArrayList<Proces> procesy)
    {
        ArrayList<Proces> procesy1 = new ArrayList<Proces>(procesy.size());
       
        for (int i = 0; i < procesy.size(); i++) {
            procesy1.add(new Proces((procesy.get(i)).getNumerProcesu(),
                    (procesy.get(i)).getMomentWejscia(), (procesy.get(i)).getDlugoscFazy(), (procesy.get(i)).getDlugoscFazy(), 0));
        }
        Collections.sort(procesy1, Proces.Comparators.ComparatorMomentWejscia);
        double czasCalkowityOczekiwania = 0;//
        int czasZakonczeniaCalkowity = (procesy1.get(0)).getDlugoscFazy();
        for (int i = 1; i < procesy1.size(); i++) {
            if (czasZakonczeniaCalkowity <= procesy1.get(i).getMomentWejscia())
                czasZakonczeniaCalkowity = procesy1.get(i).getMomentWejscia() + (procesy1.get(i)).getDlugoscFazy();

            else {
                czasCalkowityOczekiwania += (czasZakonczeniaCalkowity - procesy1.get(i).getMomentWejscia());
                czasZakonczeniaCalkowity += (procesy1.get(i)).getDlugoscFazy();
            }

        }
        return czasCalkowityOczekiwania / procesy.size();
    }



    public double SJF(ArrayList<Proces> procesy) {
        int czasAktualny = 0;
        double calkowityCzasOczekiwania = 0;
        ArrayList<Proces> procesy2 = new ArrayList<Proces>();
        ArrayList<Proces> kolejka = new ArrayList<Proces>();
        int max_wt = 0;
        for (int i = 0; i < procesy.size(); i++) {
            procesy2.add(new Proces((procesy.get(i)).getNumerProcesu(),
                    (procesy.get(i)).getMomentWejscia(), (procesy.get(i)).getDlugoscFazy(), (procesy.get(i)).getDlugoscFazy(), 0));
        }
        Collections.sort(procesy2, Proces.Comparators.ComparatorMomentWejscia);

        do {
            for (int i = 0; i < procesy2.size(); i++)

            {
                if (czasAktualny == (procesy2.get(i)).getMomentWejscia()) {

                    kolejka.add(new Proces(0, 0, 0, (procesy2.get(i)).getCzasPozostaly(), 0));
                } // adding new processes to queue when act time = arrival time


            }
            if (kolejka.size() == 0) {
                Collections.sort(kolejka, Proces.Comparators.ComparatorCzasPozostaly);
            } else if ((kolejka.get(0)).getCzasPozostaly() == 0) {
                calkowityCzasOczekiwania += (kolejka.get(0)).getCzasOczekiwania();
                if(kolejka.get(0).getCzasOczekiwania() > max_wt) {max_wt=kolejka.get(0).getCzasOczekiwania();}
                kolejka.remove(0);
                Collections.sort(kolejka, Proces.Comparators.ComparatorCzasPozostaly);

            }
            czasAktualny++;

            if (kolejka.size() != 0) {
                (kolejka.get(0)).setCzasPozostaly((kolejka.get(0)).getCzasPozostaly() - 1);
                for (int j = 1; j < kolejka.size(); j++) {
                    (kolejka.get(j)).setCzasOczekiwania((kolejka.get(j)).getCzasOczekiwania() + 1);
                }

            }
        }
        while (czasAktualny != 100000);
        System.out.println("Max waiting time: "+max_wt);
        return calkowityCzasOczekiwania / procesy2.size();

    }

    


    public double RR(int k, ArrayList<Proces> procesy)
    {
        int kwant = 0;
        int czasAktualny = 0;
        double calkowityCzasOczekiwania = 0;
        ArrayList<Proces> procesy4 = new ArrayList<Proces>();
        ArrayList<Proces> kolejka = new ArrayList<Proces>();
        
        ArrayList<Integer> wt = new ArrayList<>();
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
                     kolejka.add(new Proces(procesy4.get(i).getNumerProcesu() , (procesy4.get(i)).getMomentWejscia(), procesy4.get(i).getDlugoscFazy(), (procesy4.get(i)).getCzasPozostaly(), 0));
                }
            }

            if(kwant <= 0 && kolejka.size() !=0)
            {
                if ((kolejka.get(0)).getCzasPozostaly() == 0) {
                    int temp = czasAktualny - kolejka.get(0).getMomentWejscia() - kolejka.get(0).getDlugoscFazy() ;

                    
                    System.out.println(temp);
                    wt.add(temp);
                    

                    calkowityCzasOczekiwania += (kolejka.get(0)).getCzasOczekiwania();
                    kolejka.remove(0);
                   
                    if (kolejka.size() != 0)
                    {
                        
                        if ((kolejka.get(0)).getCzasPozostaly() >= k) {
                            kwant = k;
                        } else {
                          
                            kwant = (kolejka.get(0)).getCzasPozostaly();
                        }
                    }

                }

                else
                {
                    
                    if(kolejka.size()!=0)
                    {
                        kolejka.add(kolejka.get(0));
                        kolejka.remove(0);
                        


                    }
                    if((kolejka.get(0)).getCzasPozostaly()>=k)
                    {
                        kwant = k;
                    }
                    else {
                     
                        kwant = (kolejka.get(0)).getCzasPozostaly();
                    }
                }

            }



            if (kolejka.size() != 0) {
               
                (kolejka.get(0)).setCzasPozostaly((kolejka.get(0)).getCzasPozostaly() - 1);
                for (int j = 1; j < kolejka.size(); j++) {
                    (kolejka.get(j)).setCzasOczekiwania((kolejka.get(j)).getCzasOczekiwania() + 1);
                }

            }

            czasAktualny++;
            kwant--;

        }
        while (czasAktualny != 100000);
        int res = 0;
        for(int a : wt){
            res += a;
        }
        return res*1.f / procesy.size();

    }
}