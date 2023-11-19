public class PrzydzialRowny {
    public static void main(String[] args) {
        int N = 4; // liczba procesów
        int F = 16; // liczba dostępnych ramek

        int[] fi = new int[N]; // liczba ramek przydzielona każdemu procesowi

        for (int i = 0; i < N; i++) {
            fi[i] = F / N; // przydział równy
            System.out.println("Proces " + (i+1) + ": " + fi[i] + " ramek");
        }
    }
}
