import java.util.Arrays;
public class SterowanieCzestosciaBledowStrony {
    public static void main(String[] args) {
        int N = 4; // liczba procesów
        int F = 16; // liczba dostępnych ramek

        int[] si = {10, 20, 30, 40}; // liczba używanych stron przez każdy proces

        int[] ei = {4, 5, 6, 7}; // liczba błędów strony generowanych przez każdy proces

        int l = 3; // dolny próg częstości błędów strony
        int u = 5; // górny próg częstości błędów strony

        int[] fi = new int[N]; // liczba ramek przydzielona każdemu procesowi

        for (int i = 0; i < N; i++) {
            fi[i] = (si[i] * F) / Arrays.stream(si).sum(); // przydział początkowy proporcjonalny
        }

        for (int i = 0; i < N; i++) {
            int ppf = ei[i]; // obliczenie PPF dla każdego procesu

            if (ppf > u) {
                fi[i]++; // przydział dodatkowej ramki, jeśli PPF przekroczy próg górny
            } else if (ppf < l && fi[i] > 0) {
                fi[i]--; // zwolnienie jednej ramki, jeśli PPF spadnie poniżej progu dolnego
            }

            System.out.println("Proces " + (i+1) + ": " + fi[i] + " ramek");
        }
    }
}
