package Practice.MyBoard.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
    @NonNull
    private int boardIdx;
    @NonNull
    private String boardTitle;
    @NonNull
    private String boardWriter;
    @NonNull
    private String boardContent;
    @NonNull
    private LocalDate boardDate;
    @NonNull
    private int boardCount;
}
