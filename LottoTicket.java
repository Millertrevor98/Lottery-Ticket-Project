import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoTicket {
    private static final int NUM_NUMBERS = 6;
    private static final int NUM_BALLS = 99;
    private static final Random random = new Random();
    private final int[] numbers;

    private LottoTicket(final int[] numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket generateTicket() {
        final int[] numbers = new int[NUM_NUMBERS];
        final List<Integer> ballPool = IntStream.range(1, 1 + NUM_BALLS)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        for (int i = 0; i < NUM_NUMBERS; i++) {
            final int draw = random.nextInt(NUM_BALLS - i);
            numbers[i] = ballPool.remove(draw);
        }
        Arrays.sort(numbers);
        return new LottoTicket(numbers);
    }

    public int[] getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LottoTicket{ ");
        sb.append("numbers=").append(Arrays.toString(numbers));
        sb.append('}');
        return sb.toString();
    }

    public static void main(final String... args) {
        System.out.println(LottoTicket.generateTicket());
        System.out.println(LottoTicket.generateTicket());
        System.out.println(LottoTicket.generateTicket());
    }
}