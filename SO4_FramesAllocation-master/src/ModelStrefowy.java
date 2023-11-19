import java.util.Arrays;

public class ModelStrefowy {
    public static void main(String[] args) {
        int N = 4; // liczba procesów
        int F = 16; // liczba dostępnych ramek

        int[] odwolania = {20, 15, 10, 25}; // liczba odwołań dla każdego procesu
        int[] WSS = new int[N]; // rozmiar zbioru roboczego dla każdego procesu

        int c = 2; // współczynnik określający rozmiar zbioru roboczego (c < Δt)
        int D; // liczba aktualnie potrzebnych ramek

        // Wyliczenie rozmiaru zbioru roboczego (WSS) dla każdego procesu
        for (int i = 0; i < N; i++) {
            WSS[i] = calculateWSS(odwolania[i], c);
        }

        // Przydział ramek dla procesów, dopóki liczba potrzebnych ramek (D) jest mniejsza niż dostępne ramek (F)
        while (true) {
            D = Arrays.stream(WSS).sum();

            if (D <= F) {
                break;
            } else {
                int minIndex = 0;
                int minWSS = WSS[0];

                // Wybór procesu o najmniejszym rozmiarze zbioru roboczego
                for (int i = 1; i < N; i++) {
                    if (WSS[i] < minWSS) {
                        minWSS = WSS[i];
                        minIndex = i;
                    }
                }

                int freedFrames = WSS[minIndex] - 1; // liczba zwolnionych ramek dla zatrzymanego procesu
                WSS[minIndex]--; // aktualizacja rozmiaru zbioru roboczego

                // Przydział dodatkowych ramek dla pozostałych procesów proporcjonalnie do rozmiaru zbioru roboczego
                for (int i = 0; i < N; i++) {
                    if (i != minIndex) {
                        WSS[i] += (int) Math.floor((double) WSS[i] / (D - freedFrames) * freedFrames);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println("Proces " + (i + 1) + ": " + WSS[i] + " ramek");
        }
    }

    private static int calculateWSS(int odwolania, int c) {
        return (int) Math.ceil((double) odwolania / c);
    }
}
