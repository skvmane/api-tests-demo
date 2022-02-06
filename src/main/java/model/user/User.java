package model.user;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class User {
    @EqualsAndHashCode.Exclude
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String status;
}

