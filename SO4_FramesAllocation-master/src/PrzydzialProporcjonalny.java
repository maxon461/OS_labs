public class PrzydzialProporcjonalny {
    public static void main(String[] args) {
        int N = 4; // liczba procesów
        int F = 16; // liczba dostępnych ramek

        int[] si = {10, 20, 30, 40}; // liczba używanych stron przez każdy proces

        int S = 0; // suma liczby używanych stron przez wszystkie procesy

        for (int i = 0; i < N; i++) {
            S += si[i];
        }

        int[] fi = new int[N]; // liczba ramek przydzielona każdemu procesowi

        for (int i = 0; i < N; i++) {
            fi[i] = (si[i] * F) / S; // przydział proporcjonalny
            System.out.println("Proces " + (i+1) + ": " + fi[i] + " ramek");
        }
    }
}
