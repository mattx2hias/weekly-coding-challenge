import java.util.stream.IntStream;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class WeekOfJune20th {

    public static int squares(int start, int end) {
        return (int)IntStream.range(start, end+1).filter(n -> pow((int)sqrt(n),2) == n).count();
    }
}
