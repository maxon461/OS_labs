package com.company;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Magdalena Polak on 29.02.2016.
 */
public class Proces
{
    private int numerProcesu;
    private int dlugoscFazy;
    private int momentWejscia;
    private int czasPozostaly;
    private int czasOczekiwania;


    public Proces(int numerProcesu, int momentWejscia, int dlugoscFazy, int czasPozostaly, int czasOczekiwania) {
        this.numerProcesu = numerProcesu;
        this.dlugoscFazy = dlugoscFazy;
        this.momentWejscia = momentWejscia;
        this.czasPozostaly = czasPozostaly;
        this.czasOczekiwania = 0;
    }

    public int getNumerProcesu() {
        return numerProcesu;
    }

    public int getCzasPozostaly() {
        return czasPozostaly;
    }

    public int getMomentWejscia() {
        return momentWejscia;
    }
    public int getCzasOczekiwania()
    {
        return czasOczekiwania;
    }

    public int getDlugoscFazy() {
        return dlugoscFazy;
    }

    public void setCzasOczekiwania(int czasOczekiwania) {
        this.czasOczekiwania = czasOczekiwania;
    }

    public void setCzasPozostaly(int s)
    {
        this.czasPozostaly = s;
    }

    public void setNumerProcesu(int numerProcesu) {
        this.numerProcesu = numerProcesu;
    }

    public void setDlugoscFazy(int s) {
        this.dlugoscFazy = s;
    }
    public static class Comparators {
        public static Comparator<Proces> ComparatorMomentWejscia = new Comparator<Proces>() {
            @Override
            public int compare(Proces o1, Proces o2) {
                return o1.momentWejscia - o2.momentWejscia;
            }
        };
        public static Comparator<Proces> ComparatorDlugoscFazy = new Comparator<Proces>() {
            @Override
            public int compare(Proces o1, Proces o2) {
                return o1.dlugoscFazy - o2.dlugoscFazy;
            }
        };
        public static Comparator<Proces> ComparatorCzasPozostaly = new Comparator<Proces>() {
            @Override
            public int compare(Proces o1, Proces o2) {
                return o1.czasPozostaly- o2.czasPozostaly;
            }
        };
        public static Comparator<Proces> ComparatorPriorytet = new Comparator<Proces>() {
            @Override
            public int compare(Proces o1, Proces o2) {
                return o1.numerProcesu- o2.numerProcesu;
            }
        };
        public static Comparator<Proces> ComparatorPriorytetWejscie  = new Comparator<Proces>()
        {
            @Override
            public int compare(Proces o1, Proces o2) {
                int result =o1.numerProcesu - o2.numerProcesu;
                if (result != 0) {
                    return result;
                } else
                {
                    return o1.momentWejscia - o2.momentWejscia;
                }
            }
        };




    }
    public String toString() {
        return numerProcesu + " " + momentWejscia + " " + dlugoscFazy + " " +czasPozostaly + " " + czasOczekiwania;
    }
}