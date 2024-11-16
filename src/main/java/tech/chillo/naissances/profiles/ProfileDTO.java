package tech.chillo.naissances.profiles;

public record ProfileDTO(
        Civility civility,
        String firstName,
        String lastName,
        String email,
        String phone,
        String password
) {
}
