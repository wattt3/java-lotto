package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.constant.LottoRank;

public class LottoView {

    private static final int LOTTO_PRICE = 1_000;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<LottoRank> LOTTO_RANKS = List.of(LottoRank.FOURTH, LottoRank.THIRD,
        LottoRank.SECOND, LottoRank.FIRST);
    private static final String COMMA_DELIMITER = ",";

    public static Integer enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoNumber = Integer.parseInt(SCANNER.nextLine()) / LOTTO_PRICE;
        System.out.println(lottoNumber + "개를 구매했습니다.");
        return lottoNumber;
    }

    public static void outputLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public static Lotto enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return new Lotto(Arrays.stream(SCANNER.nextLine().split(COMMA_DELIMITER))
            .map(String::trim)
            .mapToInt(Integer::valueOf)
            .boxed()
            .collect(Collectors.toList()));
    }

    public static void outputLottoStatistics(Map<LottoRank, Long> lottoStatistics) {
        LOTTO_RANKS.forEach(
            lottoRank -> System.out.printf("%d개 일치 (%d원)- %d개%n",
                lottoRank.getHitNumber(), lottoRank.getWinningAmount(),
                lottoStatistics.getOrDefault(lottoRank, 0L))
        );
    }

    public static void outputRate(double rate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", rate);
    }
}
